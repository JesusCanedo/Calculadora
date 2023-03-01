package mx.itson.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
// Declaramos las variables necesarias
    private TextView txtRespuesta;

    private EditText txtOp1;
    private EditText txtOp2;


    // Este método se ejecuta cuando se crea la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asociamos los componentes de la interfaz de usuario con las variables correspondientes
        txtRespuesta = findViewById(R.id.txtRespuesta);
        txtOp1 = findViewById(R.id.txtOp1);
        txtOp2 = findViewById(R.id.txtOp2);

         // Asociamos los botones con las variables correspondientes y agregamos un listener de clic para cada uno
        Button btnSumar = (Button) findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(this);

        Button btnRestar = (Button) findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(this);

        Button btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnMultiplicar.setOnClickListener(this);

        Button btnDividir = (Button) findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(this);

    }

    // Este método realiza las operaciones matemáticas
    public void operar(View view) {
        // Declaramos e inicializamos las variables necesarias
        int op1 = 0, op2 = 0;
        try {
            // Intentamos convertir los valores de los campos de texto a números enteros
            op1 = Integer.parseInt(txtOp1.getText().toString());
            op2 = Integer.parseInt(txtOp2.getText().toString());
        } catch (NumberFormatException e) {
            // Si alguno de los campos no contiene un número válido, mostramos un mensaje de error y salimos del método
            Toast.makeText(this, "Por favor ingrese números válidos", Toast.LENGTH_SHORT).show();
            return;
        }
        // Declaramos e inicializamos la variable que almacenará el resultado de la operación
        int res = 0;
        // Usamos un switch para determinar qué operación matemática se debe realizar según el botón que se haya presionado
        switch (view.getId()) {
             // Si se presionó el botón de sumar, realizamos la suma
            case R.id.btnSumar:
                res = op1 + op2;
                Toast.makeText(this, "La suma es: " + res, Toast.LENGTH_SHORT).show();
                break;
                 // Si se presionó el botón de restar, realizamos la resta
            case R.id.btnRestar:
                estar:
                res = op1 - op2;
                Toast.makeText(this, "La resta es: " + res, Toast.LENGTH_SHORT).show();
                break;
                 // Si se presionó el botón de multiplicar, realizamos la multiplicacion
            case R.id.btnMultiplicar:
                res = op1 * op2;
                Toast.makeText(this, "La multiplicación es: " + res, Toast.LENGTH_SHORT).show();
                break;
                 // Si se presionó el botón de dividir, realizamos la divicion
            case R.id.btnDividir:
                if (op2 == 0) {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = op1 / op2;
                Toast.makeText(this, "La división es: " + res, Toast.LENGTH_SHORT).show();
                break;
        }
        //Finalmente, el resultado se muestra en un Toast y se establece en el TextView txtRespuesta utilizando el método setText.
        txtRespuesta.setText(Integer.toString(res));
    }


    // Este método se ejecuta cuando se hace clic en uno de los botones
    @Override
    public void onClick(View view) {
        // Obtenemos una instancia del VibratorService para hacer vibrar el dispositivo
        Vibrator vibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Hacemos vibrar el dispositivo por 150 milisegundos como retroalimentación táctil al usuario
        vibrador.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));
        // Llamamos al método operar con el botón correspondiente como argumento
        operar(view);
    }
}
