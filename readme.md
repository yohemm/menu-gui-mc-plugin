# MENU GUI
Menu Gui is an mincraft's plugin for programming/developpers.
The plugin's aim is to simplified the utilisation of inventories for menu.

## Utilisation
---
### Install dependancies

---
### simple utilisation in programming
#### initialise new MenuInventoy
```java
MenuIventory m= new MenuInventory("name", 54);//initialisation
hdv.addMenuInventory(MenuInventory);//add in MenuGui's EventHandler  
```
#### add simple item in menu
```java
MenuItem  i= new MenuItem(Material);//initialisation
m.setItem(i, 1);//add in MenuGui's EventHandler  
```
#### add button in menu
```java
Button b = new Button(Material.STONE, (e) -> {
    System.out.println((Player) e.getWhoClicked().getName()+" use menu GUI");
})
m.setItem(b, 1);//add in MenuGui's EventHandler  
```
#### player open menu
```java
MenuIventory m= new MenuInventory("name", 54);//initialisation
m.open(player)
```
#### Manage Event 
Ho you nothing to do!
Naturaly a item can't be recup.
If you want to change this you juste have to change the item in button
```java
Button b = new Button(Material.STONE, (inventoryClickEvent) -> {
    System.out.println((Player) inventoryClickEvent.getWhoClicked().getName()+" use menu GUI");
})
```
the params in lamdba it's just the InventoryClickEvent object of the action effectued for click on this button.

---
### Utilisation with menu on sereals inventories
Initialisation of frist menu
```java
MenuInventory navMenu = new MenuInventory("frist menu",54);
hdv.addMenuInventory(MenuInventory);//add in MenuGui's EventHandler  
```
Initialisation of second menu
```java
MenuInventory second = new MenuInventory("second menu",54);
hdv.addMenuInventory(MenuInventory);//add in MenuGui's EventHandler  
```
Add button on first menu for transtion between menus.
"(Player)" it's all true because this is verifed before.

```java 
Button b = new Button(Material.APPLE, (inventoryClickEvent) -> {
    shopAgri.open((Player) e.getWhoClicked());
})
m.setItem(b, 1);//add in MenuGui's EventHandler  
```
