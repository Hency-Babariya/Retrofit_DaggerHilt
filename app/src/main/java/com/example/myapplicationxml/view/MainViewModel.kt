package com.example.myapplicationxml.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationxml.model.UserDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NetworkRepository) : ViewModel() {

    private val _userDataList = MutableLiveData<List<UserDetail>>()
    val userDataList: LiveData<List<UserDetail>> = _userDataList

    fun getData() = userDataList


    init {
        loadDetailData()
    }

    private fun loadDetailData() {
        viewModelScope.launch {
            val countries = repository.getUserDetail()

            when (countries.isSuccessful) {
                true -> {
                    with(countries.body().orEmpty()) {
                        _userDataList.postValue(countries.body())
                    }
                }

                else -> {
                }
            }
        }
    }
}