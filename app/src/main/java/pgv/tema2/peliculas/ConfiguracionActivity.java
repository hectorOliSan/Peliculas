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
    private EditText etApiKey, epPeliculas, epCreditos;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etApiKey = (EditText) findViewById(R.id.etApiKey);
        epPeliculas = (EditText) findViewById(R.id.epPeliculas);
        epCreditos = (EditText) findViewById(R.id.epCreditos);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        // Preferencias.
        preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // Mostrar en la pantalla.
        etApiKey.setText(preferencias.getString("api_key","") );
        epPeliculas.setText(preferencias.getString("ep_peliculas","") );
        epCreditos.setText(preferencias.getString("ep_creditos","") );

        btnGuardar.setOnClickListener( e -> {
            // Guardar preferencias y salir
            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString("api_key", etApiKey.getText().toString());
            editor.putString("ep_peliculas", epPeliculas.getText().toString());
            editor.putString("ep_creditos", epCreditos.getText().toString());
            editor.commit();

            Toast t = Toast.makeText(getApplicationContext(), "Configuración " +
                    "guardada correctamente", Toast.LENGTH_SHORT);
                    t.show();

            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}