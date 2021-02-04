package com.why.compose.sqldelight.words.view.designtime

import com.why.compose.sqldelight.words.app.WordsGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class WordsGatewayMock : WordsGateway {
    override val alphabetizedWords: Flow<List<String>> = flowOf()

    override suspend fun save(word: String) {}

    override suspend fun deleteAll() {}
}