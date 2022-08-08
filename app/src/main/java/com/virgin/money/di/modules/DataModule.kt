package com.virgin.money.di.modules

import androidx.lifecycle.MutableLiveData
import com.virgin.money.data.models.People
import com.virgin.money.data.models.Room
import com.virgin.money.data.states.Result
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providePeopleListMutableLiveData() = MutableLiveData<Result<List<People>>>()

    @Provides
    fun providePeopleMutableLiveData() = MutableLiveData<People>()

    @Provides
    fun provideRoomListMutableLiveData() = MutableLiveData<Result<List<Room>>>()

    @Provides
    fun provideBooleanMutableLiveData() = MutableLiveData<Boolean>()

    @Provides
    fun provideIntegerMutableLiveData() = MutableLiveData<Int>()
}
