package br.edu.icomp.plaintext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    // Versão do banco de dados. Incremente este número sempre que alterar a estrutura das tabelas.
    public static final int DATABASE_VERSION = 1;
    // Nome do ficheiro do banco de dados que será criado no dispositivo.
    public static final String DATABASE_NAME = "PlainText.db";

    // Comando SQL para criar a tabela de senhas.
    private static final String SQL_CREATE_PASS = "CREATE TABLE passwords (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT, " +
            "login TEXT, " +
            "password TEXT, " +
            "notes TEXT)";

    // Comando SQL para popular a tabela com um dado inicial
    private static final String SQL_POPULATE_PASS = "INSERT INTO passwords VALUES " +
            "(NULL, 'GMail', 'matheus', '12345', 'Nota de Teste')";

    // Comando SQL para apagar a tabela (usado em atualizações).
    private static final String SQL_DELETE_PASS = "DROP TABLE IF EXISTS passwords";

    /**
     * Construtor da classe.
     * @param context O contexto da aplicação (geralmente, a Activity que a está a usar).
     */
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Chamado quando o banco de dados é criado pela primeira vez.
     * Aqui é onde a criação das tabelas e a inserção inicial de dados devem acontecer.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PASS);
        // db.execSQL(SQL_POPULATE_PASS); // Descomente se quiser um dado inicial
    }

    /**
     * Chamado quando a DATABASE_VERSION é incrementada.
     * Serve para atualizar a estrutura do banco de dados.
     * A estratégia simples aqui é apagar a tabela antiga e criar uma nova.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PASS);
        onCreate(db);
    }
}
