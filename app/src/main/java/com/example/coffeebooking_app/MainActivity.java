package com.example.coffeebooking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPay;
    RadioGroup rgCoffeeType;
    CheckBox cbSugar, cbCream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPay = findViewById(R.id.pay_btn);
        rgCoffeeType = findViewById(R.id.q1_rbtg);
        cbSugar = findViewById(R.id.q2_a1);
        cbCream = findViewById(R.id.q2_a2);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                click(v);
            }
        });
    }

    public void click(View v) {
        String msg = "Coffee ";

        if(v.getId() == R.id.pay_btn) {

            if (cbCream.isChecked()) {
                msg += "& Cream";
            }
            if (cbSugar.isChecked()) {
                msg += "& Sugar";
            }

            int radioId = rgCoffeeType.getCheckedRadioButtonId();

            switch (radioId) {
                case R.id.q1_a1:
                    msg = "Latte " + msg;
                    Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.q1_a2:
                    msg = "Capuccino " + msg;
                    Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.q1_a3:
                    msg = "Espresso " + msg;
                    Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(MainActivity.this, getString(R.string.please_chosse), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
