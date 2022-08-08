package com.virgin.money.data.usecases

import com.virgin.money.coroutines.CoroutineDispatcherWrapper
import com.virgin.money.data.api.VirginMoneyApi
import com.virgin.money.data.models.Room
import com.virgin.money.data.states.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class RoomUseCase@Inject constructor(private val virginMoneyApi: VirginMoneyApi)
    : BaseUseCase<Unit, Flow<Result<List<Room>>>>(CoroutineDispatcherWrapper.IO){

    override suspend fun execute(vararg params: Unit): Flow<Result<List<Room>>> = flow<Result<List<Room>>> {
        emit(Result.loading())

        val result: Result<List<Room>> = try {
            virginMoneyApi.getRooms().let {
                if(it!!.isSuccessful) {
                    Result.success(it.body())
                } else {
                    Result.none()
                }
            }
        } catch (e: Exception) {
            Result.error<List<Room>>(e)
        }

        emit(result)
    }.distinctUntilChanged()
}
