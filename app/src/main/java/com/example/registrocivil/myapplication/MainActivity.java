package com.example.registrocivil.myapplication;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar date= Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    String fecha_nacimiento = sdf.format(date.getTime());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("CUR_DATEs1_on create", fecha_nacimiento);

        CalendarView calendarView=(CalendarView) findViewById(R.id.calView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth)

            {
                month = month + 1;
                fecha_nacimiento = dayOfMonth+"/"+month+"/"+year;
                Toast.makeText(getApplicationContext(), ""+fecha_nacimiento, Toast.LENGTH_LONG).show();

                Log.d("CUR_DATEs2_listener", fecha_nacimiento);

            }
        });


        final Button button = findViewById(R.id.btnSiguiente);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText valorNombre = (EditText)findViewById(R.id.tvNombre);
                EditText valorCel = (EditText)findViewById(R.id.tvCel);
                EditText valorEmail = (EditText)findViewById(R.id.tvEmail);
                EditText valorDes = (EditText)findViewById(R.id.tvDes);

                Intent intent = new Intent(MainActivity.this, VistaDatos.class);

                intent.putExtra("parNombre", valorNombre.getText().toString());
                intent.putExtra("parNac", fecha_nacimiento);
                intent.putExtra("parCel", valorCel.getText().toString());
                intent.putExtra("parEmail", valorEmail.getText().toString());
                intent.putExtra("parDes", valorDes.getText().toString());

                Log.d("CUR_DATEs3_on click", fecha_nacimiento);

                startActivity(intent);
            }
        });


        Intent editar= getIntent();

        Bundle extras =editar.getExtras();
        if (extras != null) {//ver si contiene datos
            //Recibe valor.
            String varNombre = editar.getStringExtra("parNombre");
            String varNac = editar.getStringExtra("parNac");
            String varCel = editar.getStringExtra("parCel");
            String varEmail = editar.getStringExtra("parEmail");
            String varDes = editar.getStringExtra("parDes");

            //asignamos el objeto
            TextView nombre = findViewById(R.id.tvNombre);
            CalendarView nac = findViewById(R.id.calView);
            TextView cel = findViewById(R.id.tvCel);
            TextView email = findViewById(R.id.tvEmail);
            TextView des = findViewById(R.id.tvDes);

            String parts[] = varNac.split("/");

            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);



            Calendar calendar = Calendar.getInstance();

            calendar.set(year, month - 1, day);

            long milliTime = calendar.getTimeInMillis();



            nombre.setText(varNombre);

            nac.setDate(milliTime);
            cel.setText(varCel);
            email.setText(varEmail);
            des.setText(varDes);

            Log.d("CUR_DATEs4_on edit, dia, mes, año, millitime", varNac + " "+ day + " "+ month+ " "+ year+ " "+ milliTime);

        }


    }



}
