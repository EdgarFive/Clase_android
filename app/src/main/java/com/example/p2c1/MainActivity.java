package com.example.p2c1;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.p2c1.BaseDatos.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button bntSaludo,btnCrearDb;
    TextView txtSaludo;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Codigo nuevo ==================================================
        bntSaludo = findViewById(R.id.btnSaludo);
        txtSaludo = findViewById(R.id.tvSaludo);
        btnCrearDb = findViewById(R.id.btnCrearDb);

        //crear db

        btnCrearDb.setOnClickListener(v ->{

            /*Toast.makeText(this, "Creando Base de Datos", Toast.LENGTH_SHORT).show();
            txtSaludo.setText("Crando base de Datos");

             */

            DbHelper dbHelper = new DbHelper(this);
            dbHelper.getWritableDatabase();
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            if(db!=null){

                Toast.makeText(this, "Creando Base de Datos", Toast.LENGTH_SHORT).show();
                txtSaludo.setText("Base de datos creada");

            }else{
                Toast.makeText(this, "Base de datos no creada", Toast.LENGTH_SHORT).show();
                txtSaludo.setText("Error");

            }
        });

        bntSaludo.setOnClickListener(v -> {
            Toast.makeText(this, "Aviso Edgar", Toast.LENGTH_SHORT).show();
            txtSaludo.setText("Hola Edgar");

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}