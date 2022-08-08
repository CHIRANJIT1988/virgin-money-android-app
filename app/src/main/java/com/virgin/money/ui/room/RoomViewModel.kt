package com.virgin.money.ui.room

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.virgin.money.coroutines.CoroutineDispatcherWrapper
import com.virgin.money.data.models.Room
import com.virgin.money.data.states.Result
import com.virgin.money.data.usecases.RoomUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class RoomViewModel @Inject constructor(private val roomUseCase: RoomUseCase): ViewModel() {

    @Inject
    lateinit var rooms: MutableLiveData<Result<List<Room>>>
    @Inject
    lateinit var loadingVisibility: MutableLiveData<Int>
    @Inject
    lateinit var error: MutableLiveData<Boolean>

    fun getRooms() {
        viewModelScope.launch(CoroutineDispatcherWrapper.IO) {
            roomUseCase().collect { result ->
                when {
                    result.isLoading() -> setLoadingVisibility(true)
                    result.isSuccess() -> {
                        setLoadingVisibility(false)
                        rooms.postValue(result)
                    }
                    result.isError() -> {
                        setLoadingVisibility(false)
                        error.postValue(true)
                    }
                    result.isNone() -> {
                        setLoadingVisibility(false)
                        error.postValue(true)
                    }
                }
            }
        }
    }

    fun setLoadingVisibility(visible: Boolean) {
        loadingVisibility.postValue(if (visible) View.VISIBLE else View.GONE)
    }
}
