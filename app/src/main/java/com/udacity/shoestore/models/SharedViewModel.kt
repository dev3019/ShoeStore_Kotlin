package com.udacity.shoestore.models

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {
    private var _isLogged = MutableLiveData<Boolean>()


    private var _shoeList = MutableLiveData<MutableList<Shoe>>(
        mutableListOf(
            Shoe(
                "Subakov", 7.0, "ADIDAS", "Style Refined"
            ),
            Shoe(
                "Climax", 9.0, "NIKE", "Float like a butterfly"
            ),
            Shoe(
                "XOOM", 8.5, "PUMA", "Run like a cheetah"
            )
        )
    )

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val _shoe_=MutableLiveData<Shoe>()
    private var _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    fun loginActivity() {
        _isLogged.value = !_isLogged.value!!
    }

    fun addShoe() {
        _shoe.value = _shoe_.value
        _shoeList.value?.add(_shoe.value!!)
        println(_shoeList.value)
    }

    init {
//        _shoeList.value = mutableListOf()
        _isLogged.value = true
    }
}