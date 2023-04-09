package fr.yohem.menugui;

import fr.yohem.menugui.menu.MenuInventory;
import fr.yohem.menugui.menu.item.MenuItem;
import fr.yohem.menugui.menu.item.button.Button;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MenuGui extends JavaPlugin {

    private static List<MenuInventory> menuInventories;

    public static void addMenuInventory(MenuInventory menuInventory){
        menuInventories.add(menuInventory);
    }

    public static List<MenuInventory> getMenuInventories() {
        return new ArrayList<>(menuInventories);
    }

    public static void remMenuInventory(MenuInventory menuInventory){
        menuInventories.remove(menuInventory);
    }

    @Override
    public void onEnable() {
        menuInventories = new ArrayList<>();


        Button.ButtonEventHandler q =  (e) -> {
            Player player = (Player) e.getWhoClicked();
            player.teleport(new Location(player.getWorld(), 0,0,0));
        };
        MenuInventory menuInventory = new MenuInventory("1er menu");
        MenuInventory menuInventory2 = new MenuInventory("2eme menu");
        menuInventory2.setBackground(new MenuItem(Material.STAINED_GLASS_PANE));
        menuInventory.setItem(new Button(Material.APPLE, (e) -> {
            MenuGui.getMenuInventories().get(1).open((Player)e.getWhoClicked());
        }),1);
        menuInventory2.setItem(new Button(Material.ANVIL, q),4);

        MenuInventory shopBlock = new MenuInventory("Shop block",54);
        MenuInventory shopAgri = new MenuInventory("Shop agriculture",54);
        MenuInventory shopMinerais = new MenuInventory("Shop minerais",54);
        MenuInventory shopLoots = new MenuInventory("Shop loot",54);
        MenuInventory shopDivers = new MenuInventory("Shop divers",54);
        MenuInventory shopIndex = new MenuInventory("Shop categorie",9);
        shopIndex.setItem( new Button(Material.STONE, (e) -> {
            shopBlock.open((Player) e.getWhoClicked());
        }),0);
        shopIndex.setItem( new Button(Material.WHEAT, (e) -> {
            shopAgri.open((Player) e.getWhoClicked());
        }),2);
        shopIndex.setItem( new Button(Material.DIAMOND_ORE, (e) -> {
            shopMinerais.open((Player) e.getWhoClicked());
        }),4);
        shopIndex.setItem( new Button(Material.BONE, (e) -> {
            shopLoots.open((Player) e.getWhoClicked());
        }),6);
        shopIndex.setItem( new Button(Material.NETHER_STAR, (e) -> {
            shopDivers.open((Player) e.getWhoClicked());
        }),8);




        menuInventories.addAll(Arrays.asList(menuInventory, menuInventory2, shopIndex,shopBlock,shopAgri,shopDivers,shopLoots,shopMinerais));
        getCommand("test").setExecutor(new MenuCommandExecutor());
        getCommand("shop").setExecutor(new MenuCommandExecutor());
        getServer().getPluginManager().registerEvents(new MenuListerner(), this);

        System.out.println("MenuGui Enable");

    }

    @Override
    public void onDisable() {
        System.out.println("MenuGui Disable");
        // Plugin shutdown logic
    }
}
