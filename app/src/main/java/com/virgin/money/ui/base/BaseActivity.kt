package com.virgin.money.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        initActivity()
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        initActivity()
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    protected open fun initActivity() {
        AndroidInjection.inject(this)
        supportFragmentManager.fragmentFactory = fragmentFactory
    }
}