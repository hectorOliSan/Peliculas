package pgv.tema2.peliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class AcercaActivity extends AppCompatActivity {
    private ImageView imgUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        imgUser = (ImageView) findViewById(R.id.imgUser);

        imgUser.setImageResource(R.mipmap.ic_user);
    }
}