package com.example.androidhrd.localstorage_demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText productName,productPrice;
    private Button btnSave,btnRead;
    private TextView restult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productName=findViewById(R.id.product);
        productPrice=findViewById(R.id.price);
        btnSave=findViewById(R.id.btnSave);
        btnRead=findViewById(R.id.btnRead);
        restult=findViewById(R.id.result);
        btnSave.setOnClickListener(v->{
                saveData();
        });

        btnRead.setOnClickListener(v->{
            restult.setText(getData());
        });

    }
    public void saveData(){
       // SharedPreferences preferences=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences preferences=getSharedPreferences("product",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("product",productName.getText().toString());
        editor.putFloat("price",Float.parseFloat(productPrice.getText().toString()));

        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public String getData(){
        //SharedPreferences preferences=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences preferences=getSharedPreferences("product",Context.MODE_PRIVATE);

        String data="";

        data= "Product Name : " +preferences.getString("product","Iphone X");
        data = data + " price :" +preferences.getFloat("price",0f);

        return data;
    }
}
