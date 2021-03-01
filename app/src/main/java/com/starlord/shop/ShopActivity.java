package com.starlord.shop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity {
    EditText usernameText, downPaymentAmountText;
    Button signUpBtn;
    Spinner phoneModelSpinner, phoneColorSpinner;
    String phoneModel, phoneColor, username, downPayment, price;
    TextView results;
    int[] priceList = {799, 1199, 1099, 899, 799, 999};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the views /////////////////////////////////////////////////////////////
        usernameText = findViewById(R.id.username);
        downPaymentAmountText = findViewById(R.id.down_payment);
        signUpBtn = findViewById(R.id.signup_btn);
        results = findViewById(R.id.result);

        // initializing the spinner and nested spinner ////////////////////////////////////////
        phoneModelSpinner = findViewById(R.id.phone);
        ArrayAdapter<CharSequence> phoneAdapter = ArrayAdapter.createFromResource(this,
                R.array.phones, android.R.layout.simple_spinner_item);
        phoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneModelSpinner.setAdapter(phoneAdapter);

        phoneModelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                phoneModel = parent.getItemAtPosition(position).toString();

                if (position == 0) {
                    price = String.valueOf(priceList[0]);
                    phoneColorSpinner = findViewById(R.id.color);
                    ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(ShopActivity.this,
                            R.array.pixel_colors, android.R.layout.simple_spinner_item);
                    colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    phoneColorSpinner.setAdapter(colorAdapter);

                    phoneColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            phoneColor = parent.getItemAtPosition(position).toString();
                            results.setText("Cost of selected phone is: $" + price);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if (position == 1 || position == 2) {
                    if (position == 1)
                        price = String.valueOf(priceList[1]);
                    else
                        price = String.valueOf(priceList[2]);
                    phoneColorSpinner = findViewById(R.id.color);
                    ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(ShopActivity.this,
                            R.array.iphone_pro_colors, android.R.layout.simple_spinner_item);
                    colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    phoneColorSpinner.setAdapter(colorAdapter);

                    phoneColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            phoneColor = parent.getItemAtPosition(position).toString();
                            results.setText("Cost of selected phone is: $" + price);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if (position == 3 || position == 4) {
                    if (position == 3)
                        price = String.valueOf(priceList[3]);
                    else
                        price = String.valueOf(priceList[4]);
                    phoneColorSpinner = findViewById(R.id.color);
                    ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(ShopActivity.this,
                            R.array.iphone_colors, android.R.layout.simple_spinner_item);
                    colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    phoneColorSpinner.setAdapter(colorAdapter);

                    phoneColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            phoneColor = parent.getItemAtPosition(position).toString();
                            results.setText("Cost of selected phone is: $" + price);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if (position == 5) {
                    price = String.valueOf(priceList[5]);
                    phoneColorSpinner = findViewById(R.id.color);
                    ArrayAdapter<CharSequence> colorAdapter = ArrayAdapter.createFromResource(ShopActivity.this,
                            R.array.samsung_colors, android.R.layout.simple_spinner_item);
                    colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    phoneColorSpinner.setAdapter(colorAdapter);

                    phoneColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            phoneColor = parent.getItemAtPosition(position).toString();
                            results.setText("Cost of selected phone is: $" + price);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ////////////////////////////////////////////// spinner code finished  ///////////////////////////////////////

        signUpBtn.setOnClickListener(v -> {
            if (validateInput()) {
                username = usernameText.getText().toString().trim();
                downPayment = downPaymentAmountText.getText().toString().trim();

                Intent intent = new Intent(ShopActivity.this, OrderDetailActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("phoneModel", phoneModel);
                intent.putExtra("phoneColor", phoneColor);
                intent.putExtra("downPayment", downPayment);
                intent.putExtra("price", price);

                startActivity(intent);
            }
        });
    }

    private boolean validateInput() {
        if (TextUtils.isEmpty(usernameText.getText().toString())){
            usernameText.setError("Required field...");
            return false;
        } else if (TextUtils.isEmpty(downPaymentAmountText.getText().toString())){
            downPaymentAmountText.setError("Required field...");
            return false;
        }
        return true;
    }
}