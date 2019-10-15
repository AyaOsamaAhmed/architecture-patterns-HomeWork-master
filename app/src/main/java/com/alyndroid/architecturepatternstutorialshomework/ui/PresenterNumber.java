package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class PresenterNumber {

    NumberView    numberView;

    public PresenterNumber(NumberView numberView){

        this.numberView=numberView;
    }

    public NumberModel getNumberFronDatabase(){
        return new DataBase().getNumbers();
    }

    public Integer getDiv_number(){
        Integer  re_Puls;
        NumberModel  numberModel  = getNumberFronDatabase();
        re_Puls=numberModel.getFirstNum()/ numberModel.getSecondNum();
        return re_Puls;
    }

    public void get_Number(TextView result_textView){

        numberView.re_result(result_textView,getDiv_number());
    }
}
