package com.example.novoteste.di

import com.example.novoteste.database.Database
import com.example.novoteste.viewmodel.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val database = module {
    single {
        Database.getInstance(get())
    }
}

val dao = module {
    factory {
        get<Database>().dao()
    }
}

val viewModel = module {
    viewModel { ViewModel(get()) }
}

val appModules = listOf(
    database,
    dao,
    viewModel,
)
