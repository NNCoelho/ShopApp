package com.coelho.shopapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementQtd();
        decrementQtd();
        orderButton();
    }

    private void incrementQtd(){

        Button plusButton = findViewById(R.id.btn_plus);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quantity < 10){
                    quantity += 1;
                }

                TextView quantityLbl = findViewById(R.id.tv_qtd);
                quantityLbl.setText(String.valueOf(quantity));
            }
        });
    }

    private void decrementQtd(){

        Button minusButton = findViewById(R.id.btn_minus);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quantity > 1){
                    quantity -= 1;
                }

                TextView quantityLbl = findViewById(R.id.tv_qtd);
                quantityLbl.setText(String.valueOf(quantity));
            }
        });
    }

    private void orderButton(){

        Button btn_compra = findViewById(R.id.btn_order);

        btn_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            double total = quantity * (.60);

            TextView tv_thanks = findViewById(R.id.tv_thanks);
            EditText et_name = findViewById(R.id.txt_name);

            @SuppressLint("DefaultLocale") String message = "Your total is €" + String.format("%.2f", total) + "!" + "\n"
                    + "Thank you for your Purchase, " + et_name.getText().toString() + "!";

            tv_thanks.setText(message);
            }
        });
    }
}