package br.edu.icomp.plaintext;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import java.util.ArrayList;

public class PasswordDAO {
    private Context context;
    private SQLiteDatabase database;

    public PasswordDAO(Context context) {
        this.context = context;
        // Obtém uma instância do banco de dados que permite escrita.
        this.database = (new Database(context)).getWritableDatabase();
    }

    /**
     * Retorna uma lista de todas as senhas guardadas no banco de dados.
     */
    public ArrayList<Password> getList() {
        ArrayList<Password> result = new ArrayList<>();
        String sql = "SELECT * FROM passwords ORDER BY name";
        // O Cursor permite navegar pelos resultados da consulta.
        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            // Extrai os dados de cada coluna da linha atual.
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String login = cursor.getString(2);
            String password = cursor.getString(3);
            String notes = cursor.getString(4);
            // Cria um objeto Password e adiciona à lista de resultados.
            result.add(new Password(id, name, login, password, notes));
        }
        cursor.close(); // É importante fechar o cursor após o uso.
        return result;
    }

    /**
     * Busca uma senha específica pelo seu ID no banco de dados.
     */
    public Password get(int id) {
        String sql = "SELECT * FROM passwords WHERE id=" + id;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String login = cursor.getString(2);
            String password = cursor.getString(3);
            String notes = cursor.getString(4);
            cursor.close();
            return new Password(id, name, login, password, notes);
        }
        return null; // Retorna nulo se não encontrar a senha.
    }

    /**
     * Adiciona uma nova senha ao banco de dados.
     */
    public boolean add(Password password) {
        // Usa ContentValues para evitar injeção de SQL e facilitar a inserção.
        android.content.ContentValues values = new android.content.ContentValues();
        values.put("name", password.getName());
        values.put("login", password.getLogin());
        values.put("password", password.getPassword());
        values.put("notes", password.getNotes());

        try {
            database.insert("passwords", null, values);
            Toast.makeText(context, "Senha salva!", Toast.LENGTH_SHORT).show();
            return true;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao salvar! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    /**
     * Atualiza uma senha existente no banco de dados.
     */
    public boolean update(Password password) {
        android.content.ContentValues values = new android.content.ContentValues();
        values.put("name", password.getName());
        values.put("login", password.getLogin());
        values.put("password", password.getPassword());
        values.put("notes", password.getNotes());

        // A cláusula WHERE especifica qual linha (ID) será atualizada.
        String where = "id = ?";
        String[] whereArgs = { String.valueOf(password.getId()) };

        try {
            database.update("passwords", values, where, whereArgs);
            Toast.makeText(context, "Senha atualizada!", Toast.LENGTH_SHORT).show();
            return true;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao atualizar! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
