package com.virgin.money.data.usecases

import com.nhaarman.mockitokotlin2.mock
import com.virgin.money.helpers.CoroutinesDispatcherRule
import com.virgin.money.data.api.VirginMoneyApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class RoomUseCaseTest {

    @get:Rule
    val coroutinesDispatcherRule = CoroutinesDispatcherRule()

    private val dispatcher = coroutinesDispatcherRule.testDispatcher
    private val api: VirginMoneyApi = mock()
    private lateinit var roomUseCase: RoomUseCase

    @Before
    fun setup() = dispatcher.runBlockingTest {
        roomUseCase = RoomUseCase(api)
    }

    @Test
    fun `When RoomUseCase execute called`() = dispatcher.runBlockingTest {
        roomUseCase().collect { result ->
            when {
                result.isLoading() -> Assert.assertTrue(result.isLoading())
                result.isSuccess() -> Assert.assertTrue(result.isSuccess())
                result.isError() -> Assert.assertTrue(result.isError())
                result.isNone() -> Assert.assertTrue(result.isNone())
            }
        }
    }
}
