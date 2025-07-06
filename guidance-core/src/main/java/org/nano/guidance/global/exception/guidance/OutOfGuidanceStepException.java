package org.nano.guidance.global.exception.guidance;

import org.bukkit.command.CommandSender;
import org.nano.guidance.global.exception.commoin.ExceptionPrinter;

public class OutOfGuidanceStepException extends ExceptionPrinter {
    public OutOfGuidanceStepException(CommandSender sender, String message){
        super.print(sender,message);
    }
}
