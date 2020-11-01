package com.egorovsoft.vkconnector.navigation

import androidx.fragment.app.Fragment
import com.egorov.fond.myapplication.view.fragment.ClassesFragment
import com.egorov.fond.myapplication.view.fragment.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class HomeScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment = HomeFragment.newInstance()
    }

    class ClassesScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment = ClassesFragment.newInstance()
    }
}