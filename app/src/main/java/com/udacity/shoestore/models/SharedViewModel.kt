package com.udacity.shoestore.models

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {
//    private var _isLogged = MutableLiveData<Boolean>()


    private var _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    //to access the value from XML (two-way data binding)
    val _shoe_=MutableLiveData<Shoe>()
    private var _shoe = MutableLiveData<Shoe>()

//    fun loginActivity() {
//        _isLogged.value = !_isLogged.value!!
//    }

    fun addShoe() {
        _shoe.value = _shoe_.value
        _shoeList.value?.add(_shoe.value!!)
        _shoe_.value = Shoe()
    }

    init {
        _shoe_.value = Shoe()
        _shoeList.value = mutableListOf()
//        _isLogged.value = true
    }
}