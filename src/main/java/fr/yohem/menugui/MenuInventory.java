package fr.yohem.menugui;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuInventory {
    Inventory inventory;
    String name;
    int size;
    List<MenuItem> items;

    public MenuInventory(Inventory inventory, String name, List<MenuItem> items) {
        this.inventory = inventory;
        this.name = name;
        this.items = items;
    }
    public MenuInventory(Inventory inventory, String name) {
        this.inventory = inventory;
        this.name = name;
        items = new ArrayList<>();
    }
    public MenuInventory(String name) {
        this.inventory = Bukkit.getServer().createInventory(null, 54, name);
        this.name = name;
        items = new ArrayList<>();
    }

    public void setItem(MenuItem item, int position) {
        items.set(position, item);
    }
    public void setSize(int size){
        this.size = size;
        inventory.setMaxStackSize(size);
    }

    public void onClick(Player player, ItemStack element){
        for (MenuItem item: items)
            if (item.getItemInMenu().equals(element) && item instanceof MenuItem){
                ((Button) item).getAction().run();
            }
    }

}
