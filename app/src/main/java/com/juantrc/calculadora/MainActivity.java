package com.juantrc.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button numero0, numero1, numero2, numero3, numero4, numero5, numero6, numero7, numero8, numero9, sumar, borrar, restar, igual, dividir, multiplicar;

    TextView textView;

    String cantidad = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numero0 = (Button) findViewById(R.id.numero0);
        numero1 = (Button) findViewById(R.id.numero1);
        numero2 = (Button) findViewById(R.id.numero2);
        numero3 = (Button) findViewById(R.id.numero3);
        numero4 = (Button) findViewById(R.id.numero4);
        numero5 = (Button) findViewById(R.id.numero5);
        numero6 = (Button) findViewById(R.id.numero6);
        numero7 = (Button) findViewById(R.id.numero7);
        numero8 = (Button) findViewById(R.id.numero8);
        numero9 = (Button) findViewById(R.id.numero9);

        sumar = (Button) findViewById(R.id.sumar);
        restar = (Button) findViewById(R.id.restar);
        multiplicar = (Button) findViewById(R.id.multiplicar);
        dividir = (Button) findViewById(R.id.dividir);
        borrar = (Button) findViewById(R.id.borrar);
        igual = (Button) findViewById(R.id.igual);

        textView = (TextView) findViewById(R.id.textView);
    }

    public void numero0(View v) {

    }
}