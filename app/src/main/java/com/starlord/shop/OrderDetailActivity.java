package com.starlord.shop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailActivity extends AppCompatActivity {

    private String username, phoneModel, phoneColor, downPayment, price;
    float emi;
    TextView greetings, productName, productCost, downPaymentTxt, emiTxt;
    Button logoutBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        // getting the extras from bundle //////////////////////////////////////////////
        username = getIntent().getStringExtra("username");
        phoneModel = getIntent().getStringExtra("phoneModel");
        phoneColor = getIntent().getStringExtra("phoneColor");
        downPayment = getIntent().getStringExtra("downPayment");
        price = getIntent().getStringExtra("price");

        /////////////////////////////////////////////////////////////////////////////////

        emi = calculateEmi(downPayment);

        /////////////////////////////////////////////////////////////////////////////////

        greetings = findViewById(R.id.greetings);
        productName = findViewById(R.id.product_name);
        productCost = findViewById(R.id.product_cost);
        downPaymentTxt = findViewById(R.id.product_down_payment);
        emiTxt = findViewById(R.id.product_emi);

        logoutBtn = findViewById(R.id.logout_btn);

        // Populating the data in views /////////////////////////////////////////////////
        greetings.setText("Hello " + username + " here's your account info");
        productName.setText(phoneModel + " in " + phoneColor);
        productCost.setText("Total Cost: $" + price);
        downPaymentTxt.setText("Based on down payment of $" + downPayment);
        emiTxt.setText("Your monthly payment is: $" + emi);

        //////////////////////////////////////////////////////////////////////////////////

        logoutBtn.setOnClickListener(v -> onBackPressed());
    }

    private float calculateEmi(String downPayment) {
        float emi = (Float.parseFloat(price) - Float.parseFloat(downPayment)) / 12;
        return emi;
    }
}