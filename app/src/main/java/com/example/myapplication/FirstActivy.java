package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.models.Data;

public class FirstActivy extends AppCompatActivity {

    TextView textView;
    Button validate;
    Button cancel;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activy);

        textView = findViewById(R.id.fstTextView);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            String string = (String) extras.get("string");

            if(string != null) {
                textView.setText(string);
            }

//            Data data = (Data) intent.getExtras().get("data");
//
//            if (data != null)
//            {
//                textView.setText(data.getText());
//            }
        }

        validate = findViewById(R.id.validate);
        cancel = findViewById(R.id.cancel);
        spinner = findViewById(R.id.spinner);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("result", spinner.getSelectedItem().toString());
                setResult(RESULT_OK, intent1);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}