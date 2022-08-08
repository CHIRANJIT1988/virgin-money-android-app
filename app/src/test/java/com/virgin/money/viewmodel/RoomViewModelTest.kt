package com.virgin.money.viewmodel

import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.mock
import com.virgin.money.helpers.CoroutinesDispatcherRule
import com.virgin.money.helpers.MockVirginMoneyApi
import com.virgin.money.data.usecases.RoomUseCase
import com.virgin.money.ui.room.RoomViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RoomViewModelTest {
    @get:Rule
    val coroutinesDispatcherRule = CoroutinesDispatcherRule()
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dispatcher = coroutinesDispatcherRule.testDispatcher
    private lateinit var roomUseCase: RoomUseCase
    private lateinit var roomViewModel: RoomViewModel
    private val api: MockVirginMoneyApi = mock()

    @Before
    fun setUp() {
        roomUseCase = RoomUseCase(api)
        roomViewModel = RoomViewModel(roomUseCase)
        roomViewModel.loadingVisibility = MutableLiveData<Int>()
        roomViewModel.error = mock()
        roomViewModel.rooms = mock()
    }

    @Test
    fun `When RoomViewModel getRooms() called`() = dispatcher.runBlockingTest {
        roomViewModel.getRooms()
    }

    @Test
    fun `When setLoadingVisibility() true`() = dispatcher.runBlockingTest{
        roomViewModel.setLoadingVisibility(true)
        Assert.assertEquals(View.VISIBLE, roomViewModel.loadingVisibility.value)
    }

    @Test
    fun `When setLoadingVisibility() false`() = dispatcher.runBlockingTest{
        roomViewModel.setLoadingVisibility(false)
        Assert.assertEquals(View.GONE, roomViewModel.loadingVisibility.value)
    }
}
