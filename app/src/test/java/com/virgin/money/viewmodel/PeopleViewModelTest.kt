package com.virgin.money.viewmodel

import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.mock
import com.virgin.money.helpers.CoroutinesDispatcherRule
import com.virgin.money.helpers.MockVirginMoneyApi
import com.virgin.money.data.usecases.PeopleUseCase
import com.virgin.money.ui.people.PeopleViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class PeopleViewModelTest {

    @get:Rule
    val coroutinesDispatcherRule = CoroutinesDispatcherRule()
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dispatcher = coroutinesDispatcherRule.testDispatcher
    private lateinit var peopleUseCase: PeopleUseCase
    private lateinit var peopleViewModel: PeopleViewModel
    private val api: MockVirginMoneyApi = mock()

    @Before
    fun setUp() {
        peopleUseCase = PeopleUseCase(api)
        peopleViewModel = PeopleViewModel(peopleUseCase)
        peopleViewModel.loadingVisibility = MutableLiveData<Int>()
        peopleViewModel.error = mock()
        peopleViewModel.peoples = mock()
    }

    @Test
    fun `When PeopleViewModel getPeople() called`() = dispatcher.runBlockingTest {
        peopleViewModel.getPeoples()
    }

    @Test
    fun `When setLoadingVisibility() true`() = dispatcher.runBlockingTest{
        peopleViewModel.setLoadingVisibility(true)
        Assert.assertEquals(View.VISIBLE, peopleViewModel.loadingVisibility.value)
    }

    @Test
    fun `When setLoadingVisibility() false`() = dispatcher.runBlockingTest{
        peopleViewModel.setLoadingVisibility(false)
        Assert.assertEquals(View.GONE, peopleViewModel.loadingVisibility.value)
    }
}
