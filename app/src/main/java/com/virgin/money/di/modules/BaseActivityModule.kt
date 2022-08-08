package com.virgin.money.di.modules

import android.app.Activity
import com.virgin.money.ui.base.BaseActivity
import dagger.Binds
import dagger.Module

@Module
abstract class BaseActivityModule<ACTIVITY : BaseActivity> {

    @Binds
    abstract fun bindBaseActivity(activity: ACTIVITY): Activity
}
