package br.edu.icomp.plaintext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast; // Importe o Toast
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Importe a Toolbar
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PasswordsAdapter adapter;
    private PasswordDAO passwordDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // --- LÓGICA DA TOOLBAR E SAUDAÇÃO ---
        // 1. Configura a Toolbar como a barra de título da Activity
        Toolbar toolbar = findViewById(R.id.toolbar_list);
        setSupportActionBar(toolbar);

        // 2. Pega o nome do usuário da Intent
        Intent intent = getIntent();
        String login = intent.getStringExtra("LOGIN_USUARIO");

        // 3. Mostra a saudação como um pop-up (Toast)
        if (login != null && !login.isEmpty()) {
            Toast.makeText(this, "Olá, " + login + "!", Toast.LENGTH_LONG).show();
        }
        // ------------------------------------

        // --- Configuração do RecyclerView (sem alterações) ---
        passwordDAO = new PasswordDAO(this);
        recyclerView = findViewById(R.id.list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PasswordsAdapter(this, passwordDAO.getList());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.updateData(passwordDAO.getList());
    }

    public void buttonAddClick(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }

    private class PasswordsViewHolder extends RecyclerView.ViewHolder {
        public TextView name, login;

        public PasswordsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            login = itemView.findViewById(R.id.itemLogin);
        }
    }

    private class PasswordsAdapter extends RecyclerView.Adapter<PasswordsViewHolder> {
        private Context context;
        private ArrayList<Password> passwords;

        public PasswordsAdapter(Context context, ArrayList<Password> passwords) {
            this.context = context;
            this.passwords = passwords;
        }

        @NonNull
        @Override
        public PasswordsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.list_item, parent, false);
            return new PasswordsViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull PasswordsViewHolder holder, int position) {
            Password currentPassword = passwords.get(position);
            holder.name.setText(currentPassword.getName());
            holder.login.setText(currentPassword.getLogin());

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("passwordId", currentPassword.getId());
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return passwords.size();
        }

        public void updateData(ArrayList<Password> newData) {
            this.passwords = newData;
            this.notifyDataSetChanged();
        }
    }
}