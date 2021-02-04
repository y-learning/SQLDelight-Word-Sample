package com.why.compose.sqldelight.words.view

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.why.compose.sqldelight.words.WordsDb

class MyApplication : Application() {
    private val database by lazy {
        val driver: SqlDriver =
            AndroidSqliteDriver(WordsDb.Schema, this, "words.db")

        WordsDb(driver)
    }

    val wordsQueries by lazy { database.wordsQueries }
}
