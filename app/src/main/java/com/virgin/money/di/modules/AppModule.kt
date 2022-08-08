package com.virgin.money.di.modules

import android.content.Context
import com.virgin.money.application.VirginMoneyApp
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: VirginMoneyApp): Context
}
