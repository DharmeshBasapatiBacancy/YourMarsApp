package com.kudos.yourmarsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kudos.yourmarsapp.network.models.AmphibiansApiResponseItem
import com.kudos.yourmarsapp.network.models.MarsApiResponseItem
import com.kudos.yourmarsapp.repository.MainRepository
import com.kudos.yourmarsapp.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmphibiansViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<Status>()

    // The external immutable LiveData for the request status
    val status: LiveData<Status> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _amphibians = MutableLiveData<List<AmphibiansApiResponseItem>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val amphibians: LiveData<List<AmphibiansApiResponseItem>> = _amphibians

    init {
        getAmphibians()
    }

    private fun getAmphibians() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _amphibians.value = mainRepository.getAmphibians()
                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _amphibians.value = listOf()
            }
        }
    }

}