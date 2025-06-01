import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombreInput, idPasaporteInput, emailRegistroInput, passwordRegistroInput;
    private Button registrarseButton;
    private TextView volverLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreInput = findViewById(R.id.nombreInput);
        idPasaporteInput = findViewById(R.id.idPasaporteInput);
        emailRegistroInput = findViewById(R.id.emailRegistroInput);
        passwordRegistroInput = findViewById(R.id.passwordRegistroInput);
        registrarseButton = findViewById(R.id.registrarseButton);
        volverLoginLink = findViewById(R.id.volverLoginLink);

        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarRegistro();
            }
        });

        volverLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void validarRegistro() {
        String nombre = nombreInput.getText().toString().trim();
        String pasaporte = idPasaporteInput.getText().toString().trim();
        String email = emailRegistroInput.getText().toString().trim();
        String password = passwordRegistroInput.getText().toString().trim();

        if (TextUtils.isEmpty(nombre)) {
            Toast.makeText(this, "Por favor ingresa tu nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pasaporte)) {
            Toast.makeText(this, "Por favor ingresa tu ID de pasaporte", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Por favor ingresa tu email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Por favor ingresa tu contraseña", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Registro exitoso (aquí iría tu lógica)", Toast.LENGTH_SHORT).show();

        // Podrías redirigir a login después de registro exitoso si quieres
        startActivity(new Intent(RegistroActivity.this, MainActivity.class));
        finish();
    }
}