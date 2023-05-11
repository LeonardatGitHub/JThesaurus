package org.leonard.jthesaurus

import org.leonard.jthesaurus.view.HomeView
import java.awt.Toolkit
import javax.swing.JFrame

object Application : JFrame() {
    @JvmStatic
    fun main(args: Array<String>) {
        title = "JThesaurus"
        size = Toolkit.getDefaultToolkit().screenSize.also {
            it.width = (it.width * 0.4).toInt()
            it.height = (it.height * 0.75).toInt()
        }
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)

        add(HomeView)

        isVisible = true
    }
}