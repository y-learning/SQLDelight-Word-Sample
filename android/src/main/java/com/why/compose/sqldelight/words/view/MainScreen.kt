package com.why.compose.sqldelight.words.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.why.compose.sqldelight.words.theme.TemplateTheme
import com.why.compose.sqldelight.words.view.designtime.WordsGatewayMock
import com.why.compose.sqldelight.words.viewmodels.MainViewModel

@Composable
private fun WordInputField(mainViewModel: MainViewModel) {
    OutlinedTextField(
        value = mainViewModel.wordToSave,
        placeholder = { Text(text = "...") },
        singleLine = true,
        onValueChange = { mainViewModel.updateWordToSave(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun Home(mainViewModel: MainViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "SQLDelight Words Sample",
                        style = MaterialTheme.typography.subtitle1
                    )
                },
                actions = {
                    IconButton(onClick = {
                        mainViewModel.clearAllWords()
                    }) {
                        Icon(imageVector = Icons.Filled.Delete)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                mainViewModel.saveWord()
            }) {
                Icon(imageVector = Icons.Filled.Add)
            }
        }
    ) {
        Surface {
            val list by mainViewModel.words.collectAsState(listOf("Fruit"))
            Column {
                WordInputField(mainViewModel)
                LazyColumn {
                    items(list) { word ->
                        ListItem {
                            Text(text = word)
                        }
                    }
                }
            }
        }
    }
}

private val mockMainVm = MainViewModel(WordsGatewayMock())

@Composable
@Preview
fun HomePreview() {
    TemplateTheme {
        Home(mockMainVm)
    }
}

@Composable
@Preview
fun HomeDarkPreview() {
    TemplateTheme(isDarkTheme = true) {
        Home(mockMainVm)
    }
}
