package com.virgin.money.di.modules

import com.virgin.money.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainModule::class, MainBindingModule::class])
    abstract fun contributeHomeActivity(): MainActivity
}
