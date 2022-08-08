package com.virgin.money.di.modules

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.virgin.money.di.scopes.FragmentKey
import com.virgin.money.di.factory.FragmentInjectionFactory
import com.virgin.money.ui.room.RoomFragment
import com.virgin.money.ui.people.PeopleFragment
import com.virgin.money.ui.people.PeopleDetailsFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
@Module
abstract class MainBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(PeopleFragment::class)
    abstract fun bindPeopleFragment(fragment: PeopleFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(PeopleDetailsFragment::class)
    abstract fun bindPeopleDetailsFragment(fragment: PeopleDetailsFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(RoomFragment::class)
    abstract fun bindRoomFragment(fragment: RoomFragment): Fragment

    @Binds
    abstract fun bindFragmentFactory(factory: FragmentInjectionFactory): FragmentFactory
}
