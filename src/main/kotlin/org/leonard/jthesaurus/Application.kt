package org.leonard.jthesaurus

import com.formdev.flatlaf.FlatDarkLaf
import com.formdev.flatlaf.FlatLaf
import org.leonard.jthesaurus.view.HomeView
import java.awt.Toolkit
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.UIManager

object Application : JFrame() {

    fun Double.vw(): Int = (Application.size.width * this).toInt()
    fun Double.vh(): Int = (Application.size.height * this).toInt()

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
        setLookAndFeel(FlatDarkLaf())

        isVisible = true
    }

    private fun setLookAndFeel(laf: FlatLaf) {
        try {
            UIManager.setLookAndFeel(laf)
            SwingUtilities.updateComponentTreeUI(Application)
        } catch(e: Exception) {
            System.err.println("Failed to set look and feel: ${laf.name}")
        }
    }
}