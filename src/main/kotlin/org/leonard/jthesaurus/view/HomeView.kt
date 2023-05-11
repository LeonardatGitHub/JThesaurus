package org.leonard.jthesaurus.view

import com.formdev.flatlaf.util.Animator.TimingTarget
import com.formdev.flatlaf.util.Animator
import org.leonard.jthesaurus.Application
import org.leonard.jthesaurus.Application.vh
import org.leonard.jthesaurus.Application.vw
import org.leonard.jthesaurus.util.FontLoader.comfortaa
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SpringLayout
import javax.swing.SpringLayout.*

object HomeView: JPanel(), TimingTarget {
    private val inlineMargin = 0.2

    private val layout: SpringLayout

    private val animator: Animator

    private val searchField: JTextField
    private val searchButton: JButton
    private val definitions: DefinitionView

    init {
        this.preferredSize = Application.size
        this.layout = SpringLayout()
        this.setLayout(layout)

        this.animator = Animator(800, this)

        /* TextField */
        this.searchField = JTextField()
        this.searchField.preferredSize = Dimension(520, 40)
        this.searchField.maximumSize = this.searchField.preferredSize
        this.searchField.font = comfortaa(20)

        /* Search Button */
        this.searchButton = JButton("\uD83D\uDD0E")
        this.searchButton.preferredSize = Dimension(80, 40)
        this.searchButton.maximumSize = this.searchButton.preferredSize
        this.searchButton.font = this.searchButton.font.deriveFont(16f)
        this.searchButton.addActionListener {
            animator.start()
        }

        /* Definition View */
        this.definitions = DefinitionView()
        this.definitions.preferredSize = Dimension(610, 0)
        this.definitions.maximumSize = this.definitions.preferredSize

        /* TextField Layout */
        this.layout.putConstraint(WEST, searchField, inlineMargin.vw(), WEST, this)
        this.layout.putConstraint(NORTH, searchField, 0.465.vh(), NORTH, this)
//        this.layout.putConstraint(SOUTH, searchField, (-0.465).vh(), SOUTH, this)

        /* Search Button Layout */
        this.layout.putConstraint(WEST, searchButton, 0.005.vw(), EAST, searchField)
        this.layout.putConstraint(EAST, searchButton, (-inlineMargin).vw(), EAST, this)
        this.layout.putConstraint(NORTH, searchButton, 0, NORTH, searchField)
        this.layout.putConstraint(SOUTH, searchButton, 0, SOUTH, searchField)

        /* Definition View */
        this.layout.putConstraint(WEST, definitions, 0, WEST, searchField)
        this.layout.putConstraint(EAST, definitions, 0, EAST, searchButton)
        this.layout.putConstraint(NORTH, definitions, 0.005.vh(), SOUTH, searchField)
        this.layout.putConstraint(SOUTH, definitions, 0, NORTH, definitions)

        /* TextField Finalization */
        this.add(this.searchField)
        this.add(this.searchButton)
        this.add(this.definitions)
    }

    override fun timingEvent(fraction: Float) {
        definitions.preferredSize = Dimension(410, (fraction * 0.6).vh())
        definitions.maximumSize = definitions.preferredSize

        this.layout.putConstraint(NORTH, searchField, (0.465 - fraction * 0.3).vh(), NORTH, this)
        this.layout.putConstraint(SOUTH, definitions, (fraction * 0.6).vh(), NORTH, definitions)

        this.revalidate()
    }
}