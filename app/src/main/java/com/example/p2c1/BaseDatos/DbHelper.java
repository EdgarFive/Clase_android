package com.example.p2c1.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    private static final int DB_VERSION = 1;
    private static final String DB_NOMBRE = "db_umg.db";
    public static final String TABLE_CONTACTOS = "t_contactos";

    //columnas de la tabla ==========================================
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "Nombre";
    private static final String COLUMN_TELEFONO = "Telefono";
    private static final String COLUMN_EMAIL = "Email";


    //constructor
    public DbHelper(@Nullable Context context) {
        super(context, DB_NOMBRE, null, DB_VERSION);
    }


    // Método para crear la base de datos (se ejecuta la primera vez que se usa) =============
    @Override
    //se crea la tabla la primera vez que se ejecuta la aplicacion
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CONTACTOS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL, Telefono TEXT, Email TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTOS);
        onCreate(db);
    }

    // Método para insertar datos en la tabla
    public void addContact(String name, String phone, String email) {
        // Obtener una referencia a la base de datos en modo escritura
        SQLiteDatabase db = this.getWritableDatabase();

        // Crear un objeto ContentValues para almacenar los datos a insertar
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, name);
        values.put(COLUMN_TELEFONO, phone);
        values.put(COLUMN_EMAIL, email);

        // Insertar los datos en la tabla
        long result = db.insert(TABLE_CONTACTOS, null, values);

        // Verificar si la inserción fue exitosa
        if (result == -1) {
            Log.e("DB_ERROR", "Failed to insert data");
        } else {
            Log.d("DB_SUCCESS", "Data inserted successfully");
        }

        // Cerrar la conexión con la base de datos
        db.close();
    }

}
