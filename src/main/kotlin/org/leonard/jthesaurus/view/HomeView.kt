package org.leonard.jthesaurus.view

import org.leonard.jthesaurus.Application
import org.leonard.jthesaurus.Application.vh
import org.leonard.jthesaurus.Application.vw
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SpringLayout
import javax.swing.SpringLayout.EAST
import javax.swing.SpringLayout.WEST

object HomeView: JPanel() {
    private val layout: SpringLayout
    private val searchField: JTextField
    private val searchButton: JButton

    init {
        this.preferredSize = Application.size
        this.layout = SpringLayout()
        this.setLayout(layout)

        /* TextField */
        this.searchField = JTextField()
        this.searchField.preferredSize = Dimension(320, 40)
        this.searchField.maximumSize = this.searchField.preferredSize

        /* Search Button */
        this.searchButton = JButton("Search")
        this.searchButton.preferredSize = Dimension(80, 40)
        this.searchButton.maximumSize = this.searchButton.preferredSize

        /* TextField Layout */
        this.layout.putConstraint(WEST, searchField, 0.3.vw(), WEST, this)
        /*this.layout.putConstraint(EAST, searchField, (-0.05).vw(), WEST, searchButton)*/
        this.layout.putConstraint(SpringLayout.NORTH, searchField, 0.465.vh(), SpringLayout.NORTH, this)
        this.layout.putConstraint(SpringLayout.SOUTH, searchField, (-0.465).vh(), SpringLayout.SOUTH, this)

        this.layout.putConstraint(WEST, searchButton, 0.005.vw(), EAST, searchField)
        this.layout.putConstraint(EAST, searchButton, (-0.3).vw(), EAST, this)
        this.layout.putConstraint(SpringLayout.NORTH, searchButton, 0.465.vh(), SpringLayout.NORTH, this)
        this.layout.putConstraint(SpringLayout.SOUTH, searchButton, (-0.465).vh(), SpringLayout.SOUTH, this)

        /* TextField Finalization */
        this.add(this.searchField)
        this.add(this.searchButton)
    }
}