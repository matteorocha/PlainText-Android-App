package br.edu.icomp.plaintext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    private EditText campoLogin;
    private EditText campoSenha;
    private CheckBox checkSalvarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inicializa os campos da UI
        campoLogin = findViewById(R.id.editLogin);
        campoSenha = findViewById(R.id.editPassword);
        checkSalvarLogin = findViewById(R.id.editSaveLogin); // Supondo que o ID do seu CheckBox é editSaveLogin
    }

    /**
     * Este método é chamado sempre que a atividade volta a ser visível.
     * É o local ideal para atualizar a UI com base nas preferências.
     */
    @Override
    protected void onResume() {
        super.onResume();
        carregarPreferencias();
    }

    /**
     * Carrega as preferências do utilizador e atualiza a UI.
     */
    private void carregarPreferencias() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Verifica se a opção "Salvar informação de login" está ativada nas configurações
        boolean deveSalvarLogin = sharedPreferences.getBoolean("save_login_info", false);
        checkSalvarLogin.setChecked(deveSalvarLogin); // Atualiza o estado do CheckBox

        if (deveSalvarLogin) {
            // Se estiver ativada, preenche o campo de login
            String loginSalvo = sharedPreferences.getString("login", "");
            campoLogin.setText(loginSalvo);
        } else {
            // Se não, garante que o campo de login esteja limpo
            campoLogin.setText("");
        }

        // Limpa sempre o campo da senha por segurança
        campoSenha.setText("");
    }

    /**
     * Lógica de clique para o botão "ENTRAR".
     */
    public void entrarClicado(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String loginSalvo = sharedPreferences.getString("login", "");
        String senhaSalva = sharedPreferences.getString("password", "");

        if (loginSalvo.isEmpty() || senhaSalva.isEmpty()) {
            Toast.makeText(this, "Por favor, defina um login e senha nas Configurações.", Toast.LENGTH_LONG).show();
            return;
        }

        String loginDigitado = campoLogin.getText().toString();
        String senhaDigitada = campoSenha.getText().toString();

        if (loginDigitado.equals(loginSalvo) && senhaDigitada.equals(senhaSalva)) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("LOGIN_USUARIO", loginDigitado);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login ou senha inválidos!", Toast.LENGTH_SHORT).show();
        }
    }

    // --- Métodos do Menu (sem alterações) ---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.configs) {
            Intent intent = new Intent(this, PreferencesActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.about) {
            new AlertDialog.Builder(this)
                    .setTitle("Sobre")
                    .setMessage("PlainText Password Manager v1.0")
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
