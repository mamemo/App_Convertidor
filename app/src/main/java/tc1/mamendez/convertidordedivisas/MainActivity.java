package tc1.mamendez.convertidordedivisas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final double _TasaDeCambio = 577.50;
    private double _Operacion = 1/_TasaDeCambio;

    public void convertirDinero(View view){
        EditText cantidad = findViewById(R.id.edit_cantidad);
        double cantidad_a_cambiar = Double.valueOf(cantidad.getText().toString());

        double cambio = cantidad_a_cambiar * _Operacion;

        EditText edit_cambio = findViewById(R.id.edit_Cambio);
        edit_cambio.setText(String.format("%.2f",cambio));
    }

    public void cambiarOperacion(View view){
        switch(view.getId()){
            case R.id.radioCRCaUSD:
                _Operacion = 1/_TasaDeCambio;
                break;
            case R.id.radioUSDaCRC:
                _Operacion = _TasaDeCambio;
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtTasa = findViewById(R.id.txt_Tasa);
        txtTasa.setText(String.valueOf(_TasaDeCambio));
    }
}
