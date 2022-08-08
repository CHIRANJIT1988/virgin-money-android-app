package com.virgin.money.helpers

import com.virgin.money.coroutines.CoroutineDispatcherWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class CoroutinesDispatcherRule : TestWatcher() {
    val testDispatcher = TestCoroutineDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
        CoroutineDispatcherWrapper.setDefault(testDispatcher)
        CoroutineDispatcherWrapper.setIO(testDispatcher)
        CoroutineDispatcherWrapper.setMain(testDispatcher)
        CoroutineDispatcherWrapper.setUnconfined(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}
