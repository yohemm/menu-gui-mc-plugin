package fr.yohem.menugui;

import fr.yohem.menugui.menu.MenuInventory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListerner implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        System.out.println(event.getEventName());
        for (MenuInventory menuInventory : MenuGui.getMenuInventories()){
            if (menuInventory.getInventory().getName().equals(event.getInventory().getName())){
                menuInventory.onClick(event);
            }
        }
    }
}
