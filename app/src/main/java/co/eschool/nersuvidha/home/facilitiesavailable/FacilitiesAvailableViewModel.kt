package co.eschool.nersuvidha.home.facilitiesavailable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.eschool.nersuvidha.model.ActivityState

class FacilitiesAvailableViewModel(private val facilitiesAvailableRepository: FacilitiesAvailableRepository) :
    ViewModel() {

    private val _state: MutableLiveData<ActivityState> = MutableLiveData()
    val state: LiveData<ActivityState> = _state
}