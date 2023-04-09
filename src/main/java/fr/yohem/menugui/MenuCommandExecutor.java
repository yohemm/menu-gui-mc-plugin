package fr.yohem.menugui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getLabel()){
            case "test":
                if (sender instanceof Player){
                    Player player = (Player) sender;
                    MenuGui.getMenuInventories().get(0).open(player);
                    return true;
                }
                break;
            case "shop":
                System.out.println("aka47");
                if (sender instanceof Player){
                    Player player = (Player) sender;
                    System.out.println("op");
                    MenuGui.getMenuInventories().get(2).open(player);
                    return true;
                }
                break;

        }
        return false;
    }
}
