package com.example.calculadoraproyecto;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    private RadioButton btndiv, btnmulti, btnrest, btnsum;
    private TextView resultadoview;
    private double division, multiplicacion, resta, suma;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazar los dos edittext
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        //Enlazar el textview
        resultadoview = findViewById(R.id.resultadoview);

        // Desactivar el teclado virtual para ambos EditText
        edit1.setShowSoftInputOnFocus(false);
        edit2.setShowSoftInputOnFocus(false);

        //Enlazamos todos los botones del radiogroup
        btndiv = findViewById(R.id.btndiv);
        btnmulti = findViewById(R.id.btnmulti);
        btnrest = findViewById(R.id.btnrest);
        btnsum = findViewById(R.id.btnsum);

        //Inicializamos las preferencias
        prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);

    }

    //Metodos para los botones si esta focus el edit text inserta el numero
    //Si ya tenia algun numero de antes, hace un getText y si inserta el nuevo numero detras
    public void btn4click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "4");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "4");
        }
    }

    public void btn5click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "5");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "5");
        }
    }

    public void btn6click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "6");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "6");
        }
    }

    public void btn7click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "7");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "7");
        }
    }

    public void btn8click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "8");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "8");
        }
    }

    public void btn9click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "9");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "9");
        }
    }

    public void btn1click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "1");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "1");
        }
    }

    public void btn2click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "2");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "2");
        }
    }

    public void btn3click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "3");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "3");
        }
    }

    public void btn0click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + "0");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + "0");
        }
    }

    public void btnpunto_click(View view) {

        if (edit1.isFocused()) {
            edit1.setText(edit1.getText().toString() + ".");
        }
        if (edit2.isFocused()) {
            edit2.setText(edit2.getText().toString() + ".");
        }
    }

    public void btn_clear(View view) {
        edit1.setText("");
        edit2.setText("");
        resultadoview.setText("");

    }

    public void btnresu_click(View view) {
        // Obtener los valores de los campos
        String num1 = edit1.getText().toString();
        String num2 = edit2.getText().toString();

        // Validar que no estén vacíos antes de convertirlos
        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show();
            return; // Detener la ejecución si los campos están vacíos
        }

        try {
            // Convertir los valores a números
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            // Operaciones según el RadioButton seleccionado
            if (btndiv.isChecked()) {
                if (n2 == 0) {
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                    edit2.setText("");
                } else {
                     division = n1 / n2;
                    resultadoview.setText(String.valueOf(division));
                }
            } else if (btnmulti.isChecked()) {
                 multiplicacion = n1 * n2;
                resultadoview.setText(String.valueOf(multiplicacion));
            } else if (btnrest.isChecked()) {
                 resta = n1 - n2;
                resultadoview.setText(String.valueOf(resta));
            } else if (btnsum.isChecked()) {
                 suma = n1 + n2;
                resultadoview.setText(String.valueOf(suma));
            } else {
                Toast.makeText(this, "Seleccione una operación", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            // Manejar el caso donde los valores no sean números válidos
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
        }
    }

    public void btn_save(View view) {
        if (resultadoview.getText().toString().isEmpty()) {
            Toast.makeText(this, "No hay resultado para guardar", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("result", resultadoview.getText().toString());
            editor.commit();
            Toast.makeText(this, "Resultado guardado", Toast.LENGTH_SHORT).show();
        }
    }
    public void btn_show(View view) {
        String result = prefs.getString("result", "");
        if (result.isEmpty()) {
            Toast.makeText(this, "No hay resultado guardado", Toast.LENGTH_SHORT).show();
            return;
        } else {
            resultadoview.setText(result);
            Toast.makeText(this, "Ultimo resultado guardado mostrado", Toast.LENGTH_SHORT).show();
        }
    }
}