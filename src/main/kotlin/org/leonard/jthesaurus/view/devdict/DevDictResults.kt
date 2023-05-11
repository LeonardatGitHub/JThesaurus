package org.leonard.jthesaurus.view.devdict

import org.leonard.jthesaurus.model.devdict.DevDictWord
import org.leonard.jthesaurus.util.FontLoader.comfortaa
import javax.swing.JLabel
import javax.swing.JPanel

class DevDictResults(private var results: Array<DevDictWord>): JPanel() {
    init {
        if(results.isNotEmpty()) {
            load()
        }
    }

    fun update(results: Array<DevDictWord>) {
        this.results = results
        load()
        revalidate()
    }

    private fun load() {
        this.removeAll()
        for(result in results) {
            add(JLabel(result.word).apply {
                font = comfortaa(20)
            })
        }
    }
}