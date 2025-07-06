package org.nano.guidance.global.exception.player;

import org.bukkit.command.CommandSender;
import org.nano.guidance.global.exception.commoin.ExceptionPrinter;

public class PlayerNotFoundException extends ExceptionPrinter {
    public PlayerNotFoundException(CommandSender sender, String message) {
        super.print(sender,message);
    }
}
