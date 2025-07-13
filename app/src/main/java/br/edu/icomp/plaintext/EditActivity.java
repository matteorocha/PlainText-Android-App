package br.edu.icomp.plaintext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    private PasswordDAO passwordDAO;
    private int passwordId;
    private EditText editName, editLogin, editPassword, editNotes;
    private TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Inicializa os componentes da UI
        editName = findViewById(R.id.addName);
        editLogin = findViewById(R.id.addLogin);
        editPassword = findViewById(R.id.addPassword);
        editNotes = findViewById(R.id.addNotes);
        textTitle = findViewById(R.id.textTitle);

        passwordDAO = new PasswordDAO(this);

        // Verifica se um ID foi passado (modo de edição)
        Intent intent = getIntent();
        passwordId = intent.getIntExtra("passwordId", -1);

        if (passwordId != -1) {
            // Modo de edição: carrega os dados existentes
            textTitle.setText("Editar Senha");
            Password password = passwordDAO.get(passwordId);
            if (password != null) {
                editName.setText(password.getName());
                editLogin.setText(password.getLogin());
                editPassword.setText(password.getPassword());
                editNotes.setText(password.getNotes());
            }
        }
    }

    public void salvarClicado(View view) {
        Password password = new Password(
                passwordId,
                editName.getText().toString(),
                editLogin.getText().toString(),
                editPassword.getText().toString(),
                editNotes.getText().toString()
        );

        boolean result;
        if (passwordId == -1) {
            result = passwordDAO.add(password);
        } else {
            result = passwordDAO.update(password);
        }

        if (result) {
            finish();
        }
    }
}