package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {
    private var _isLogged = MutableLiveData<Boolean>()


    private val _shoeList = MutableLiveData<List<Shoe>>(
        listOf(
            Shoe(
                "Subakov", 7.0, "ADIDAS", "Style Refined"
            ),
            Shoe(
                "Climax", 9.0, "NIKE", "Float like a butterfly"
            ),
            Shoe(
                "XOOM",8.5,"PUMA","Run like a cheetah"
            )
        )
    )
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun loginActivity(){
        _isLogged.value = !_isLogged.value!!
    }

    init {
        _isLogged.value=true
    }
}