package com.egorov.fond.myapplication.di

import com.egorov.fond.myapplication.entity.ClassesView
import com.egorov.fond.myapplication.entity.HomeView
import com.egorov.fond.myapplication.intent.ClassesViewModel
import com.egorov.fond.myapplication.intent.HomeViewModel
import com.egorov.fond.myapplication.model.test.TestMVI
import com.egorov.fond.myapplication.view.fragment.HomeFragment
import com.egorov.fond.myapplication.view.viewmodel.BaseViewModel
import com.egorov.fond.myapplication.view.viewmodel.IModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

const val NAME_HOME = "Home"
const val NAME_CLASSES = "Classes"

fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(appMoule, homeModule, classesModule))
}

val appMoule = module {
    single { router(get()) }
    single { navigationHolder(get()) }
    single { cicerone() }
    single { MainThread() }
    single<IModel> { TestMVI() }
}

val homeModule = module {
    single<BaseViewModel<HomeView>>(named(NAME_HOME)) { HomeViewModel(get(),get()) }
}
val classesModule = module {
    single<BaseViewModel<ClassesView>>(named(NAME_CLASSES)) { ClassesViewModel(get(),get()) }
}

private fun MainThread() = AndroidSchedulers.mainThread()
fun cicerone(): Cicerone<Router>  =  Cicerone.create()
fun navigationHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder
fun router(cicerone: Cicerone<Router>)= cicerone.router
