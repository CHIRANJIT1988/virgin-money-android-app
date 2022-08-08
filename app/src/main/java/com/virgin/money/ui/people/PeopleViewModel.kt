package com.virgin.money.ui.people

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.virgin.money.coroutines.CoroutineDispatcherWrapper
import com.virgin.money.data.models.People
import com.virgin.money.data.states.Result
import com.virgin.money.data.usecases.PeopleUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PeopleViewModel @Inject constructor(
    private val peopleUseCase: PeopleUseCase
): ViewModel() {

    @Inject
    lateinit var people: MutableLiveData<People>
    @Inject
    lateinit var peoples: MutableLiveData<Result<List<People>>>
    @Inject
    lateinit var loadingVisibility: MutableLiveData<Int>
    @Inject
    lateinit var error: MutableLiveData<Boolean>

    fun getPeoples() {
        viewModelScope.launch(CoroutineDispatcherWrapper.IO) {
            peopleUseCase().collect { result ->
                when {
                    result.isLoading() -> setLoadingVisibility(true)
                    result.isSuccess() -> {
                        setLoadingVisibility(false)
                        peoples.postValue(result)
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

    fun setPeople(people: People) {
        this.people.value = people
    }

    fun setLoadingVisibility(visible: Boolean) {
        loadingVisibility.postValue(if (visible) View.VISIBLE else View.GONE)
    }
}
