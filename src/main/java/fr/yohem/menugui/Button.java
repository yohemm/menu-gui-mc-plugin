package fr.yohem.menugui;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Button extends MenuItem{
    private Runnable action;

    public Button(ItemStack itemStack, ItemMeta meta, Runnable onInteract) {
        super(itemStack, meta);
        action = onInteract;
    }

    public Button(ItemStack itemStack, Runnable action) {
        super(itemStack);
        this.action = action;
    }

    public Button(Material material, Runnable action) {
        super(material);
        this.action = action;
    }

    public Button(MenuItem menuItem, Runnable action) {
        super(menuItem);
        this.action = action;
    }

    public Runnable getAction() {
        return action;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }
}
