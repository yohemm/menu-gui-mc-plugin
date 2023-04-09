package fr.yohem.menugui.menu.item.button;

import fr.yohem.menugui.menu.item.MenuItem;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Button extends MenuItem {
    @FunctionalInterface
    public interface ButtonEventHandler {
        void run(InventoryClickEvent e);
    }
    private ButtonEventHandler action;

    public Button(ItemStack itemStack, ItemMeta meta, ButtonEventHandler onInteract) {
        super(itemStack, meta);
        action = onInteract;
    }

    public Button(ItemStack itemStack, ButtonEventHandler action) {
        super(itemStack);
        this.action = action;
    }

    public Button(Material material, ButtonEventHandler action) {
        super(material);
        this.action = action;
    }

    public Button(MenuItem menuItem, ButtonEventHandler action) {
        super(menuItem);
        this.action = action;
    }

    public ButtonEventHandler getAction() {
        return action;
    }
    public void executeAction(InventoryClickEvent event) {
        action.run(event);
    }

    public void setAction(ButtonEventHandler action) {
        this.action = action;

    }
}
