package com.why.compose.sqldelight.words.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.why.compose.sqldelight.words.app.WordsGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val wordsGateway: WordsGateway) : ViewModel() {

    var wordToSave: String by mutableStateOf("")
        private set

    val words: Flow<List<String>> = wordsGateway.alphabetizedWords

    private fun clearWordToSave() {
        wordToSave = ""
    }

    fun saveWord() = viewModelScope.launch {
        if (wordToSave.isNotBlank() && wordToSave.isNotEmpty())
            wordsGateway.save(wordToSave)

        clearWordToSave()
    }

    fun updateWordToSave(word: String) {
        if (wordToSave.isNotBlank() || wordToSave.isEmpty())
            wordToSave = word
    }

    fun clearAllWords() = viewModelScope.launch {
        wordsGateway.deleteAll()
    }
}
