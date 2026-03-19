package com.rudy.kmpstarterproductionlite

import android.app.Application
import com.rudy.kmpstarterproductionlite.database.DatabaseFactory
import com.rudy.kmpstarterproductionlite.di.sharedModules
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Napier.base(DebugAntilog())

        startKoin {
            androidContext(this@MainApplication)
            modules(
                module {
                    single { DatabaseFactory(this@MainApplication) }
                },
                *sharedModules.toTypedArray()
            )
        }
    }
}
