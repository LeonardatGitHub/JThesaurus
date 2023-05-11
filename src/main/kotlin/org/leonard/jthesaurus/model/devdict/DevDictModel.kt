package org.leonard.jthesaurus.model.devdict

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.net.URL

data class DevDictWord(
    var word: String,
    var phonetic: String,
    var phonetics: List<DevDictPhonetic>,
    var origin: String?,
    var meanings: List<DevDictMeaning>,
    var license: DevDictLicense,
    var source: List<String>
)

data class DevDictPhonetic(
    var text: String,
    var audio: String?,
    var sourceUrl: String?,
    var license: DevDictLicense?
)

data class DevDictMeaning(
    var partOfSpeech: String,
    var definitions: List<DevDictDefinition>,
    var synonyms: List<String> = listOf(),
    var antonyms: List<String> = listOf()
)

data class DevDictDefinition(
    var definition: String,
    var example: String?,
    var synonyms: List<String> = listOf(),
    var antonyms: List<String> = listOf()
)

data class DevDictLicense(
    var name: String,
    var url: String
)

@Suppress("UNCHECKED_CAST")
fun load(word: String): List<DevDictWord> {
    return jacksonObjectMapper().readValue(
        URL("https://api.dictionaryapi.dev/api/v2/entries/en/$word"),
        List::class.java
    ) as List<DevDictWord>
}