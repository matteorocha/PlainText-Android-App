package br.edu.icomp.plaintext;

import android.os.Bundle;
import android.text.TextUtils; // Importe esta classe
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference; // Importe esta classe
import androidx.preference.Preference; // Importe esta classe
import androidx.preference.PreferenceFragmentCompat;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);

            // --- LÓGICA PARA MASCARAR O RESUMO DA SENHA ---
            EditTextPreference passwordPreference = findPreference("password");
            if (passwordPreference != null) {
                passwordPreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                    @Override
                    public CharSequence provideSummary(EditTextPreference preference) {
                        String text = preference.getText();
                        if (TextUtils.isEmpty(text)) {
                            // Se nenhuma senha estiver definida, mostra o resumo padrão.
                            return "Nenhuma senha definida";
                        }
                        // Se uma senha estiver definida, mostra os asteriscos.
                        return "••••••••";
                    }
                });
            }
        }
    }
}
