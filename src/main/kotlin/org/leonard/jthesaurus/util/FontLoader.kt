package org.leonard.jthesaurus.util

import java.awt.Font

object FontLoader {
    private val cache = mutableMapOf<Pair<String, Int>, Font>()

    operator fun get(name: String, size: Int): Font {
        return cache.computeIfAbsent(name to size) {
            val stream = javaClass.classLoader.getResourceAsStream("fonts/$name.ttf")
                ?: try {
                    return@computeIfAbsent Font(name, Font.PLAIN, size)
                } catch(e: Exception) {
                    error("Font $name not found")
                }

            stream.use {
                Font.createFont(Font.TRUETYPE_FONT, it).deriveFont(size.toFloat())
            }
        }
    }

    fun comfortaa(size: Int) = get("Comfortaa-Regular", size)
}