package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.models.Data;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText input;
    TextView content;

    Button to1stActivity;
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            (result) -> {
                if(result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    showToast("Item selected : " + intent.getExtras().getString("result"));
                } else if(result.getResultCode() == RESULT_CANCELED){
                    showToast("Action canceled");
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        button = findViewById(R.id.button);
//        input = findViewById(R.id.editTextText);
//        content = findViewById(R.id.content);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showToast("Button clicked!");
//                Editable text = input.getText();
//                content.setText(text);
//            }
//        });
        to1stActivity = findViewById(R.id.to1stActivy);

        to1stActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Data data = new Data("Custom classe");
                Intent intent = new Intent(v.getContext(), FirstActivy.class);
                intent.putExtra("string", "Groupe 1");
//                intent.putExtra("data", data);
                //startActivity(intent);
                activityResultLauncher.launch(intent);
            }
        });


    }

    private void showToast(String content) {
        Toast toast = Toast.makeText(this, content, Toast.LENGTH_SHORT);

        toast.show();
    }
}