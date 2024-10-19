package com.example.p2c1;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.p2c1.BaseDatos.DbHelper;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre, txtTelefono, txtEmail;
    private Button btnGuardar;
    private DbHelper databaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo); //quí vinculamos el ativity que acabamos de hacer. ========

        //Inicializamos los campos de texto y el boton ==============
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuardar = findViewById(R.id.btnGuardar);

        databaseHelper = new DbHelper(this);

        //Configuramos el evento click del boton ===================
        btnGuardar.setOnClickListener( v -> {
            String nombre = txtNombre.getText().toString().trim();
            String telefono = txtTelefono.getText().toString().trim();
            String email = txtEmail.getText().toString().trim();

            //Vemos que los campos no estén vacios ==========================
            if( TextUtils.isEmpty(nombre) || TextUtils.isEmpty(telefono) ||TextUtils.isEmpty(email) ){
                Toast.makeText(MainActivity.this, "Por favor, debe llenar todos los campos.", Toast.LENGTH_SHORT).show();
            }else{
                //Guardamos los datos mamalones ==========
                databaseHelper.addContact(nombre,telefono,email);
                Toast.makeText(MainActivity.this, "Datos guardados correctamente.", Toast.LENGTH_SHORT).show();

                //Vamos a limpiar los campos porque no somos unos marranos. =====================

                txtNombre.setText("");
                txtTelefono.setText("");
                txtEmail.setText("");
            }


        });


    }







    //=========================================================================================================================================================
    //=========================================================================================================================================================
    //=========================================================================================================================================================

    /*


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
    /*

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

     */


}