package com.virgin.money.di.modules

import com.virgin.money.ui.room.RoomFragment
import com.virgin.money.ui.main.MainActivity
import com.virgin.money.ui.people.PeopleFragment
import com.virgin.money.ui.people.PeopleDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule : BaseActivityModule<MainActivity>() {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): PeopleFragment

    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): RoomFragment

    @ContributesAndroidInjector
    abstract fun contributeNotificationsFragment(): PeopleDetailsFragment
}
