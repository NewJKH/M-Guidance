package org.nano.guidance.util.message.factory

import net.kyori.adventure.text.Component
import org.nano.guidance.util.message.color.ColorUtil

object MessageBuilder {

    private lateinit var message: StringBuilder

    fun prefix(prefix:String) : MessageBuilder{
        message.insert(0, prefix)
        return this
    }

    fun add(text: String) : MessageBuilder{
        message.append(text)
        return this
    }

    fun build(): Component{
        return ColorUtil.format(message.toString())
    }
}