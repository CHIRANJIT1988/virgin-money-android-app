package com.virgin.money.application

import com.virgin.money.coroutines.CoroutineDispatcherWrapper
import com.virgin.money.di.components.AppComponent
import com.virgin.money.di.components.DaggerAppComponent
import com.virgin.money.ui.utils.ImageUtils
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VirginMoneyApp: DaggerApplication() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch(CoroutineDispatcherWrapper.IO) {
            initImageUtils()
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this).also { appComponent = it as AppComponent }
    }

    private fun initImageUtils() {
        ImageUtils.init(this) // Important! we need this Singleton to the Application
    }
}
