package com.alyndroid.architecturepatternstutorialshomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberView {

    Button plus_button;
    TextView plus_result_textView;
    PresenterNumber presenterNumber;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;

    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    //MVVM
    NumberViewModel numberViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //----------------------------------------
        plus_button = findViewById(R.id.plus_button);
        plus_button.setOnClickListener(this);
        plus_result_textView = findViewById(R.id.plus_result_textView);
        // MVP ----------------------------------------------------
        presenterNumber = new PresenterNumber(this);
        ButterKnife.bind(this);
        divButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        // MVVM ------------------------------------
        // for make activity licener changes in numberViewModel
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        numberViewModel.mutableLiveData.observe(this, new Observer<NumberModel>() {
            @Override
            public void onChanged(NumberModel numberModel) {
                mulResultTextView.setText(numberModel.getFirstNum()*numberModel.getSecondNum()+"");
            }
        });

    }

    public NumberModel getNumberFronDatabase() {
        return new DataBase().getNumbers();
    }

    public Integer getPlus_number() {
        Integer re_Puls;
        NumberModel numberModel = getNumberFronDatabase();
        re_Puls = numberModel.getFirstNum() + numberModel.getSecondNum();
        return re_Puls;
    }

    public void re_result(TextView text_result, Integer number) {
        text_result.setText(number + "");

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.plus_button) {
            re_result(plus_result_textView, getPlus_number());
        } else if (view.getId() == R.id.div_button) {
            presenterNumber.get_Number(divResultTextView);
        }else if (view.getId()==R.id.mul_button){
         numberViewModel.getNumber();
        }
    }


}
