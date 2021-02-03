object Plugins {
    object Ktlint {
        const val version = "9.4.1"
        const val id = "org.jlleitschuh.gradle.ktlint"
    }

    object SQLDelight {
        const val plugin =
            "${Libs.SQLDelight.id}:gradle-plugin:${Libs.SQLDelight.version}"
    }
}
