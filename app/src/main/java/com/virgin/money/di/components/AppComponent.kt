package com.virgin.money.di.components

import com.virgin.money.application.VirginMoneyApp
import com.virgin.money.di.modules.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        VirginMoneyApiModule::class,
        AppModule::class,
        DataModule::class,
        ActivityModule::class,
        ViewModelModule::class]
)
interface AppComponent : AndroidInjector<VirginMoneyApp> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<VirginMoneyApp>
}
