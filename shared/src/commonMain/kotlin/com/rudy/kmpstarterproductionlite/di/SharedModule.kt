package com.rudy.kmpstarterproductionlite.di

import com.rudy.kmpstarterproductionlite.data.local.dao.ItemDao
import com.rudy.kmpstarterproductionlite.data.remote.ItemApi
import com.rudy.kmpstarterproductionlite.data.repository.ItemRepositoryImpl
import com.rudy.kmpstarterproductionlite.database.DatabaseFactory
import com.rudy.kmpstarterproductionlite.database.getDatabaseBuilder
import com.rudy.kmpstarterproductionlite.domain.repository.ItemRepository
import com.rudy.kmpstarterproductionlite.domain.usecase.GetItemsUseCase
import com.rudy.kmpstarterproductionlite.network.createHttpClient
import com.rudy.kmpstarterproductionlite.presentation.items.ItemsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient() }
    single { ItemApi(get()) }
}

val databaseModule = module {
    single { getDatabaseBuilder(get<DatabaseFactory>()) }
    single<ItemDao> { get<com.rudy.kmpstarterproductionlite.database.AppDatabase>().itemDao() }
}

val repositoryModule = module {
    single<ItemRepository> { ItemRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { GetItemsUseCase(get()) }
}

val viewModelModule = module {
    viewModel { ItemsViewModel(get()) }
}

val sharedModules = listOf(
    networkModule,
    databaseModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)
