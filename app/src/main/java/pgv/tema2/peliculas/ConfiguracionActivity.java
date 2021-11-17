package pgv.tema2.peliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfiguracionActivity extends AppCompatActivity {
    private SharedPreferences preferencias;
    private EditText etApiKey;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        etApiKey = (EditText) findViewById(R.id.etApiKey);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        // Preferencias.
        preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // Mostrar en la pantalla.
        etApiKey.setText(preferencias.getString("api_key","") );

        btnGuardar.setOnClickListener( e -> {
            //SharedPreferences.Editor editor = preferencias.edit();
            //editor.putString("api_key", etApiKey.getText().toString());
            //editor.commit();
            Toast t = Toast.makeText(getApplicationContext(), "Configuración " +
                    "guardada correctamente", Toast.LENGTH_SHORT);
                    t.show();
            finish();
        });
    }
}