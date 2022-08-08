package com.virgin.money.helpers

import com.nhaarman.mockitokotlin2.mock
import com.virgin.money.data.api.VirginMoneyApi
import com.virgin.money.data.models.People
import com.virgin.money.data.models.Room
import retrofit2.Response

open class MockVirginMoneyApi: VirginMoneyApi {

    override suspend fun getPeoples(): Response<List<People>> = mock()

    override suspend fun getRooms(): Response<List<Room>> = mock()
}