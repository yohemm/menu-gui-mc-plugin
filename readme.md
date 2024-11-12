
# Menu Gui

<!-- ![Project Banner](path/to/banner/image)  -->

## Overview

Menu Gui is an mincraft's plugin for programming/developpers. The plugin's aim is to simplified the utilisation of inventories for menu.

## Table of Conxtents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Installation
### Prerequisites
List any prerequisites or dependencies required for the project.
**JAVA**
**JDK**

### Steps


1. Clone the repository
```git
git clone https://github.com/yohemm/menu-gui-mc-plugin.git
```

2. Compile & runthe project
```sh
javac main
java main.java
```

---

## Usage

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

---

## Features
Highlight the main features or functionalities of the project. Consider including bullet points, lists, or descriptions.
- Feature 1: Create inventory menu
- Feature 2: Create button in menu
- Feature 3: Create a transition between menus

---

## Technologies Used
List the technologies, frameworks, or libraries used in this project.
- [Java](https://www.java.com/fr/)
- [JDK](https://www.oracle.com/fr/java/technologies/downloads/)
---

## Configuration
Provide any configuration instructions necessary to set up or customize the project. Examples include environment variables or configuration files.

No configuration is required.


---

## Contributing
* **Yohem** - *Initial work* - [Yohemm](https://github.com/yohemm)

---

## License
This project is licensed under the [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).

---

## Contact
For questions or feedback, please reach out:
- GitHub Issues: [Create an Issue](https://github.com/yohemm/menu-gui-mc-plugin/issues)

---
