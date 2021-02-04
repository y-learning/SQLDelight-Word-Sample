package com.why.compose.sqldelight.words.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.why.compose.sqldelight.words.app.WordsGatewayImpl
import com.why.compose.sqldelight.words.theme.TemplateTheme
import com.why.compose.sqldelight.words.viewmodels.MainViewModel
import comwhycomposesqldelightwords.WordsQueries

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val wordsQueries = (application as MyApplication).wordsQueries
            val mainViewModel = viewModel<MainViewModel>(
                factory = MainViewModelFactory(wordsQueries)
            )

            TemplateTheme {
                Home(mainViewModel)
            }
        }
    }

    class MainViewModelFactory(private val queries: WordsQueries) : Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (!modelClass.isAssignableFrom(MainViewModel::class.java))
                throw IllegalArgumentException("Unknown ViewModel class")

            return MainViewModel(WordsGatewayImpl(queries)) as T
        }
    }
}
