package fr.yohem.menugui.menu.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MenuItem {
    private ItemStack itemStack;
    private ItemMeta meta;

    public MenuItem(ItemStack itemStack, ItemMeta meta){
        this.itemStack = itemStack;
        this.meta = meta;
    }
    public MenuItem(ItemStack itemStack){
        this(itemStack, itemStack.getItemMeta());
    }
    public MenuItem(Material material){
        this.itemStack = new ItemStack(material);
        this.meta = itemStack.getItemMeta();
    }

    public MenuItem(MenuItem menuItem){
        this(menuItem.getItemInMenu(),menuItem.getMeta());
    }

    public MenuItem setLore(List<String> lore){
        meta.setLore(lore);
        return this;
    }

    public MenuItem setName(String name){
        meta.setDisplayName(name);
        return this;

    }
    public MenuItem setVariance(byte bt){
        itemStack.setItemMeta(meta);
        itemStack = new ItemStack(itemStack.getType(), 1, (short) 14, bt);
        return this;
    }

    public ItemStack getItemInMenu() {
        ItemStack i = itemStack.clone();
        i.setItemMeta(meta);
        return i;
    }

    public ItemMeta getMeta() {
        return meta;
    }
}
