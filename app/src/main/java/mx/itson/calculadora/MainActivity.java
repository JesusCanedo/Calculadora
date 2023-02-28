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

    private TextView txtRespuesta;

    private EditText txtOp1;
    private EditText txtOp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRespuesta = findViewById(R.id.txtRespuesta);
        txtOp1 = findViewById(R.id.txtOp1);
        txtOp2 = findViewById(R.id.txtOp2);

        Button btnSumar = (Button) findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(this);

        Button btnRestar = (Button) findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(this);

        Button btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnMultiplicar.setOnClickListener(this);

        Button btnDividir = (Button) findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(this);

    }


    public void operar(View view) {
        int op1 = 0, op2 = 0;
        try {
            op1 = Integer.parseInt(txtOp1.getText().toString());
            op2 = Integer.parseInt(txtOp2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese números válidos", Toast.LENGTH_SHORT).show();
            return;
        }
        int res = 0;
        switch (view.getId()) {
            case R.id.btnSumar:
                res = op1 + op2;
                Toast.makeText(this, "La suma es: " + res, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRestar:
                estar:
                res = op1 - op2;
                Toast.makeText(this, "La resta es: " + res, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMultiplicar:
                res = op1 * op2;
                Toast.makeText(this, "La multiplicación es: " + res, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDividir:
                if (op2 == 0) {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = op1 / op2;
                Toast.makeText(this, "La división es: " + res, Toast.LENGTH_SHORT).show();
                break;
        }
        txtRespuesta.setText(Integer.toString(res));
    }


    @Override
    public void onClick(View view) {
        Vibrator vibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrador.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));

        operar(view);
    }
}