package org.nano.guidance.global.exception.commoin;

import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.nano.guidance.util.message.factory.MessageBuilder;

public class ExceptionPrinter extends RuntimeException {
    protected void print(CommandSender sender, String message){
        Component component = MessageBuilder.INSTANCE
                .prefix("&6) 길라잡이")
                .add(message)
                .build();


        sender.sendMessage(component);
    }
}
