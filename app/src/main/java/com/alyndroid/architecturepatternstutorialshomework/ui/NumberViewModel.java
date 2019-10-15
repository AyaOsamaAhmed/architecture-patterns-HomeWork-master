package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {

    //Data live
    LiveData<String> NumberLiveData;
    // nutable live data can change data manual
    MutableLiveData<NumberModel> mutableLiveData = new MutableLiveData<>();

    public void getNumber(){
        NumberModel  re_number = getNumberFronDatabase();

        mutableLiveData.setValue(re_number);
    }

    private NumberModel getNumberFronDatabase()
    {

        return new DataBase().getNumbers();
    }

}
