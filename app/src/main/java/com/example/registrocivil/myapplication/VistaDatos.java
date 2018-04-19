package com.example.registrocivil.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VistaDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_datos);


        //Recibe valor.
        String varNombre = getIntent().getStringExtra("parNombre");
        String varNac = getIntent().getStringExtra("parNac");
        String varCel = getIntent().getStringExtra("parCel");
        String varEmail = getIntent().getStringExtra("parEmail");
        String varDes = getIntent().getStringExtra("parDes");

       // Bundle b = getIntent().getExtras();
        //String valor_recibido = b.getString("parametro");

        //Agrega valor a TextView.
        TextView nombre = findViewById(R.id.tv2Nombre);
        TextView nac = findViewById(R.id.tv2Nac);
        TextView cel = findViewById(R.id.tv2Cel);
        TextView email = findViewById(R.id.tv2Email);
        TextView des = findViewById(R.id.tv2Des);

        nombre.setText(varNombre);
        nac.setText(varNac);
        cel.setText(varCel);
        email.setText(varEmail);
        des.setText(varDes);


        final Button button = findViewById(R.id.btnEditar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView valorNombre = (TextView)findViewById(R.id.tv2Nombre);
                TextView valorNac = (TextView)findViewById(R.id.tv2Nac);
                TextView valorCel = (TextView)findViewById(R.id.tv2Cel);
                TextView valorEmail = (TextView)findViewById(R.id.tv2Email);
                TextView valorDes = (TextView)findViewById(R.id.tv2Des);

                Intent editar = new Intent(VistaDatos.this, MainActivity.class);

                editar.putExtra("parNombre", valorNombre.getText().toString());
                editar.putExtra("parNac", valorNac.getText().toString());
                editar.putExtra("parCel", valorCel.getText().toString());
                editar.putExtra("parEmail", valorEmail.getText().toString());
                editar.putExtra("parDes", valorDes.getText().toString());

                Toast.makeText(getApplicationContext(), ""+ valorNac, Toast.LENGTH_LONG).show();
                startActivity(editar);


            }
        });

    }
}
