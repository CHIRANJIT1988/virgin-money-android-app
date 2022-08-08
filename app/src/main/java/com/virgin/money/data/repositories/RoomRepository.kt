package com.virgin.money.data.repositories

import com.virgin.money.coroutines.CoroutineDispatcherWrapper
import com.virgin.money.data.api.VirginMoneyApi
import com.virgin.money.data.models.Room
import com.virgin.money.data.states.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RoomRepository@Inject constructor(private val virginMoneyApi: VirginMoneyApi)
    : BaseRepository(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + CoroutineDispatcherWrapper.IO

    suspend fun getRooms() : Result<List<Room>> {
        val result: Result<List<Room>> = try {
            virginMoneyApi.getRooms().let {
                if(it!!.isSuccessful) Result.success(it.body()) else Result.none()
            }
        } catch (e: Exception) {
            Result.error<List<Room>>(e)
        }
        return result
    }
}
