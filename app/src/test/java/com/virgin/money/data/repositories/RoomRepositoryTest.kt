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
class RoomRepositoryTest {
    @get:Rule
    val coroutinesDispatcherRule = CoroutinesDispatcherRule()

    private val dispatcher = coroutinesDispatcherRule.testDispatcher
    private val api: VirginMoneyApi = mock()
    private lateinit var roomRepository: RoomRepository

    @Before
    fun setup() = dispatcher.runBlockingTest {
        roomRepository = RoomRepository(api)
    }

    @Test
    fun `When RoomRepository getRooms() called`() = dispatcher.runBlockingTest {
        roomRepository.getRooms()
    }
}
