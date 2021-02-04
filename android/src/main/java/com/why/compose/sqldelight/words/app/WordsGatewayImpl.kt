package com.why.compose.sqldelight.words.app

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import comwhycomposesqldelightwords.WordsQueries
import kotlinx.coroutines.flow.Flow

class WordsGatewayImpl(private val dao: WordsQueries) : WordsGateway {

    override val alphabetizedWords: Flow<List<String>> = dao
        .getAlphabetizedWords(mapper = { _, word -> word })
        .asFlow()
        .mapToList()

    override suspend fun save(word: String) {
        dao.insert(word)
    }

    override suspend fun deleteAll() {
        dao.deleteAllWords()
    }
}