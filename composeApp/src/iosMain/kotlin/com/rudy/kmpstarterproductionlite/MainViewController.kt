package com.rudy.kmpstarterproductionlite

import androidx.compose.ui.window.ComposeUIViewController
import com.rudy.kmpstarterproductionlite.database.DatabaseFactory
import com.rudy.kmpstarterproductionlite.di.sharedModules
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun MainViewController() = ComposeUIViewController {
    App()
}

fun initKoin() {
    Napier.base(DebugAntilog())

    startKoin {
        modules(
            module {
                single { DatabaseFactory() }
            },
            *sharedModules.toTypedArray()
        )
    }
}
