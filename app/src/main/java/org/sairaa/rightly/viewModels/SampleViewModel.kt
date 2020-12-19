package org.sairaa.rightly.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.sairaa.rightly.database.model.Sample
import org.sairaa.rightly.repository.SampleRepository
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