package fr.yohem.menugui.menu;


import fr.yohem.menugui.menu.item.button.Button;
import fr.yohem.menugui.menu.item.MenuItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MenuInventory {
    private MenuItem background;
    String name;
    int size;
    MenuItem[] items;
    public MenuInventory(String name, int size) {
        setName(name);
        this.size = size;
        items = new MenuItem[size];
    }

    public MenuInventory(String name) {
        this(name, 54);
    }
    public MenuInventory(String name, int size, List<MenuItem> items) {
        this(name, size);
        setItems(items);
    }

    public void setItem(MenuItem item, int position) {
        items[position] = item;
    }
    public void setItems(List<MenuItem> items) {
        for (int i = 0; i < (items.size()<this.items.length?items.size():this.items.length); i++) {
            if (items.get(i)!=null){
                setItem(items.get(i), i);
            }

        }
    }

    public void onClick(InventoryClickEvent event){
        ItemStack elementClicked = event.getCurrentItem();
        if (elementClicked != null)
            for (MenuItem itemMenu: items)
                if (itemMenu!=null && itemMenu.getItemInMenu().equals(elementClicked) && itemMenu instanceof Button){
                    ((Button) itemMenu).executeAction(event);
                }
        event.setCancelled(true);
    }

    public Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(null, size, name);
        for (int i = 0; i < (Math.min(size, items.length)); i++) {
            if (items[i] != null){
                inv.setItem(i, items[i].getItemInMenu());
            } else if (background != null) {
                inv.setItem(i, background.getItemInMenu());
            }
        }
        return inv;
    }

    public void setName(String name) {
        this.name = "§8"+name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void changeAllItems(MenuItem[] items) {
        this.items = items;
    }

    public MenuItem getBackground() {
        return background;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public MenuItem[] getItems() {
        return items;
    }

    public void open(Player player){
        player.openInventory(getInventory());
    }

    public void setBackground(MenuItem item){
        background = item;
    }

    @Override
    public String toString() {
        return "MenuInventory{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
