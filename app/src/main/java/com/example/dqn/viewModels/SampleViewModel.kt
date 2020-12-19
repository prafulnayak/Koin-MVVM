package com.example.dqn.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dqn.database.model.Sample
import com.example.dqn.repository.SampleRepository
import kotlinx.coroutines.launch

class SampleViewModel(val repository: SampleRepository):ViewModel() {
    val sampleData = MutableLiveData<List<Sample>>()
    fun getSampleData(){
        viewModelScope.launch {
            val result = repository.getAllSampleData()
            sampleData.value = result
        }

    }
}