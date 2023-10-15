package com.example.myapplicationxml.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationxml.model.UserDetail
import com.example.myapplicationxml.roomdb.MyDatabase
import com.example.myapplicationxml.roomdb.MyEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NetworkRepository, private val db: MyDatabase
) : ViewModel() {

    private val _userDataList = MutableLiveData<List<UserDetail>>()
    val userDataList: LiveData<List<UserDetail>> = _userDataList

    fun getData() = userDataList


    init {
        loadDetailData()
        insertDataBase()
    }

    private fun insertDataBase() {
        val myEntity = MyEntity(
            id = 0,  // Since it's auto-generated, set it to 0 or any default value.
            title = "Sample Title",
            desc = "Sample Description"
        )
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                db.dao().insertData(myEntity)
                Log.e("TAG", "see all data: ${db.dao().getAllData()} ")
            }
        }
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