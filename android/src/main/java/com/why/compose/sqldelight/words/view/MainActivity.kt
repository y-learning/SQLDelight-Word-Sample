package com.why.compose.sqldelight.words.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.setContent
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.why.compose.sqldelight.words.WordsDb
import com.why.compose.sqldelight.words.theme.TemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val driver: SqlDriver =
            AndroidSqliteDriver(WordsDb.Schema, this, "test.db")

        super.onCreate(savedInstanceState)

        setContent {
            TemplateTheme {
                Greeting("Android ${Build.VERSION.SDK_INT}")
            }
        }
    }
}
