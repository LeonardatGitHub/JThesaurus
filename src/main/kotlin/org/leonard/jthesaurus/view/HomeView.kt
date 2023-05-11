package org.leonard.jthesaurus.view

import org.leonard.jthesaurus.Application
import org.leonard.jthesaurus.Application.vh
import org.leonard.jthesaurus.Application.vw
import java.awt.Dimension
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SpringLayout
import javax.swing.SpringLayout.EAST
import javax.swing.SpringLayout.WEST

object HomeView: JPanel() {
    private val layout: SpringLayout
    private val searchField: JTextField

    init {
        this.preferredSize = Application.size
        this.layout = SpringLayout()
        this.setLayout(layout)

        /* TextField */
        this.searchField = JTextField()
        this.searchField.preferredSize = Dimension(320, 40)
        this.searchField.maximumSize = this.searchField.preferredSize

        /* TextField Layout */
        this.layout.putConstraint(WEST, searchField, 0.3.vw(), WEST, this)
        this.layout.putConstraint(EAST, searchField, (-0.3).vw(), EAST, this)
        this.layout.putConstraint(SpringLayout.NORTH, searchField, 0.465.vh(), SpringLayout.NORTH, this)
        this.layout.putConstraint(SpringLayout.SOUTH, searchField, (-0.465).vh(), SpringLayout.SOUTH, this)

        /* TextField Finalization */
        this.add(this.searchField)
    }
}