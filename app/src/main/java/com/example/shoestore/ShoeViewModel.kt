package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {




     val shoeName = MutableLiveData<String>()

    val image = addImage()

    val description = MutableLiveData<String>()

     val company = MutableLiveData<String>()

     val shoeSize = MutableLiveData<String>()


//item storage list
     val _showList = MutableLiveData<MutableList<Shoe>>()
    val showList : LiveData<MutableList<Shoe>> = _showList


init {
 resterData()
}


// to make item from data show equle item in viewModel
    fun listView(){
        val data = Shoe(
            shoeName.value?:"",
            shoeSize.value?.toDouble()?:0.0,
            company.value?:"",
            description.value?:"",
            image.random()
        )
    // if item in viewModel is empty / item viewModel = data item
        if (_showList.value == null){
            _showList.value = mutableListOf(data)
        }else{
            //to add new item
            _showList.value?.add(data)
        }

    }
//  to rester viewModel item to putting another item
    fun resterData(){
        shoeName.value = ""
        description.value = ""
        shoeSize.value = ""
        company.value = ""
    }
// to puttin image
    fun addImage() : List<Int>{
        return listOf(R.drawable.image1,R.drawable.image2,R.drawable.image4,R.drawable.image5)

    }


    fun isvaildEntry(name:String,company:String,size:String,decription :String): Boolean{
        return name.isNotBlank() && company.isNotBlank() &&
                size.isNotBlank()&& decription.isNotBlank()

    }












}