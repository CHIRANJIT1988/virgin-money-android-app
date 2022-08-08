package com.virgin.money.data.repositories

import com.nhaarman.mockitokotlin2.mock
import com.virgin.money.helpers.CoroutinesDispatcherRule
import com.virgin.money.data.api.VirginMoneyApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class PeopleRepositoryTest {
    @get:Rule
    val coroutinesDispatcherRule = CoroutinesDispatcherRule()

    private val dispatcher = coroutinesDispatcherRule.testDispatcher
    private val api: VirginMoneyApi = mock()
    private lateinit var peopleRepository: PeopleRepository

    @Before
    fun setup() = dispatcher.runBlockingTest {
        peopleRepository = PeopleRepository(api)
    }

    @Test
    fun `When PeopleRepository getPeople() called`() = dispatcher.runBlockingTest {
        peopleRepository.getPeoples()
    }
}
