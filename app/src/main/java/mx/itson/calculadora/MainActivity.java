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

//Funciona

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRespuesta = findViewById(R.id.txtRespuesta);
        txtOp1 = findViewById(R.id.txtOp1);
        txtOp2 = findViewById(R.id.txtOp2);

        Button btnSumar = (Button)findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(this);

        Button btnRestar = (Button)findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(this);

        Button btnMultiplicar = (Button)findViewById(R.id.btnMultiplicar);
        btnMultiplicar.setOnClickListener(this);

        Button btnDividir = (Button)findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(this);

    }


    public void sumar(View view){
        try {
            Integer res = Integer.parseInt(txtOp1.getText().toString()) + Integer.parseInt(txtOp2.getText().toString());
            txtRespuesta.setText(res+"");
            Toast.makeText(this, "La suma es: "+res, Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void restar(View view){
        try {
            Integer res = Integer.parseInt(txtOp1.getText().toString()) - Integer.parseInt(txtOp2.getText().toString());
            txtRespuesta.setText(res+"");
            Toast.makeText(this, "La resta es: "+res, Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            System.out.println(e);
        }
       }

    public void multiplicar(View view){
        try {
            Integer res = Integer.parseInt(txtOp1.getText().toString()) * Integer.parseInt(txtOp2.getText().toString());
            txtRespuesta.setText(res+"");
            Toast.makeText(this, "La multiplicacion es: "+res, Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            System.out.println(e);
        }
          }

    public void dividir(View view){
        try {
            Integer res = Integer.parseInt(txtOp1.getText().toString()) / Integer.parseInt(txtOp2.getText().toString());
            txtRespuesta.setText(res+"");
            Toast.makeText(this, "La division es: "+res, Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            System.out.println(e);
        }
    }



    @Override
    public void onClick(View view) {
        Vibrator vibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrador.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));

        if(view.getId() == R.id.btnSumar){
            sumar(view);

        } else if(view.getId() == R.id.btnRestar){
            restar(view);

        } else if(view.getId() == R.id.btnMultiplicar){
            multiplicar(view);

        }else if(view.getId() == R.id.btnDividir){
            dividir(view);
        }
    }
}