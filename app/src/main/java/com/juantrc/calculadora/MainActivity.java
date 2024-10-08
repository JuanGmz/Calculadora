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

    String cantidad1 = "";
    String cantidad2 = "";
    char operador;
    boolean isOperacion = false;

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

        setNumberListeners();
        setOperationListeners();
    }

    private void setNumberListeners() {
        View.OnClickListener numberListener = v -> {
            Button b = (Button) v;
            if (!isOperacion) {
                cantidad1 += b.getText().toString();
                textView.setText(cantidad1);
            } else {
                cantidad2 += b.getText().toString();
                textView.setText(cantidad2);
            }
        };

        numero0.setOnClickListener(numberListener);
        numero1.setOnClickListener(numberListener);
        numero2.setOnClickListener(numberListener);
        numero3.setOnClickListener(numberListener);
        numero4.setOnClickListener(numberListener);
        numero5.setOnClickListener(numberListener);
        numero6.setOnClickListener(numberListener);
        numero7.setOnClickListener(numberListener);
        numero8.setOnClickListener(numberListener);
        numero9.setOnClickListener(numberListener);
    }

    private void setOperationListeners() {
        sumar.setOnClickListener(v -> {
            operador = '+';
            isOperacion = true;
        });

        restar.setOnClickListener(v -> {
            operador = '-';
            isOperacion = true;
        });

        multiplicar.setOnClickListener(v -> {
            operador = '*';
            isOperacion = true;
        });

        dividir.setOnClickListener(v -> {
            operador = '/';
            isOperacion = true;
        });

        borrar.setOnClickListener(v -> {
            cantidad1 = "";
            cantidad2 = "";
            operador = ' ';
            isOperacion = false;
            textView.setText("");
        });

        igual.setOnClickListener(v -> {
            if (!cantidad1.equals("") && !cantidad2.equals("")) {
                double resultado = realizarOperacion(Double.parseDouble(cantidad1), Double.parseDouble(cantidad2), operador);
                textView.setText(String.valueOf(resultado));
                // Reiniciar valores después de la operación
                cantidad1 = String.valueOf(resultado);
                cantidad2 = "";
                isOperacion = false;
            } else {
                Toast.makeText(MainActivity.this, "Introduce ambos números", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double realizarOperacion(double num1, double num2, char operador) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                    return 0;
                }
            default:
                return 0;
        }
    }
}
