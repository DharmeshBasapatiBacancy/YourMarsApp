package com.kudos.yourmarsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kudos.yourmarsapp.network.models.MarsApiResponseItem
import com.kudos.yourmarsapp.repository.MarsRepository
import com.kudos.yourmarsapp.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsViewModel @Inject constructor(private val marsRepository: MarsRepository): ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<Status>()

    // The external immutable LiveData for the request status
    val status: LiveData<Status> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _photos = MutableLiveData<List<MarsApiResponseItem>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val photos: LiveData<List<MarsApiResponseItem>> = _photos

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _photos.value = marsRepository.getMarsPhotos()
                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _photos.value = listOf()
            }
        }
    }

}