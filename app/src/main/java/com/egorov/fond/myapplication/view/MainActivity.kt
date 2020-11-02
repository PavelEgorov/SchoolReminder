package com.egorov.fond.myapplication.view

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.egorov.fond.myapplication.R
import com.egorov.fond.myapplication.di.injectDependencies
import com.egorovsoft.vkconnector.navigation.Screens
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class MainActivity : AppCompatActivity() {
    private val navigatorHolder: NavigatorHolder by inject()
    private val router: Router by inject()

    private val navigator = SupportAppNavigator(this, R.id.fragment)
    private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.item_home -> {
                router.navigateTo(Screens.HomeScreen())
                true
            }
            R.id.item_classes -> {
                router.navigateTo(Screens.ClassesScreen())
                true
            }
            else -> false
        }
    }

    init {
        injectDependencies()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_navigation.setOnNavigationItemSelectedListener(navigationListener)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
        router.navigateTo(Screens.HomeScreen())
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}