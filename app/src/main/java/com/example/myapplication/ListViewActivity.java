package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {

    String[] pays = new String[] {
            "Algerie",
            "Egypte",
            "Tunisie",
            "Maroc",
            "Mauritanie",
            "Mali",
            "Senegal",
            "Gambie",
            "Guinnee",
            "Guinne Bis",
            "Guinne EQ",
            "Cote d'ivoire",
            "Nigeria",
            "Cameroun",
            "RDC",
            "Ghana",
            "Afrique S",
            "Burkina",
            "Angola",
            "Cap Vert",
            "Namibie"
    };

    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pays);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "Selected item : " + pays[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}