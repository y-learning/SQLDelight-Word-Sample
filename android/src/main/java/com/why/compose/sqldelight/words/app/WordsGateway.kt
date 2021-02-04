package com.why.compose.sqldelight.words.app

import kotlinx.coroutines.flow.Flow

interface WordsGateway {
    val alphabetizedWords: Flow<List<String>>

    suspend fun save(word: String)

    suspend fun deleteAll()
}
