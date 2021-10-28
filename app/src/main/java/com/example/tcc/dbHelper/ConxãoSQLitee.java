package com.example.tcc.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ConxãoSQLitee {

    public static class ConexaoSQLite extends SQLiteOpenHelper {

        private static ConexaoSQLite INSTANCIA_CONEXAO;
        private static final int VERSAO_DB = 1;
        private static final String NOME_DB = "bd_produto_app";

        public ConexaoSQLite(Context context) {
            super(context, NOME_DB,null,VERSAO_DB);
        }

        public static ConexaoSQLite getInstancia(Context context){
            if(INSTANCIA_CONEXAO == null){
                INSTANCIA_CONEXAO = new ConexaoSQLite(context);
            }
            return INSTANCIA_CONEXAO;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String sqlSalvarDados = "CREATE TABLE IF NOT EXISTS Dados" +
                    "(" +
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT," +
                    "quantidade_em_estoque INTEGER," +
                    "preco REAL" +
                    ")";


            sqLiteDatabase.execSQL(sqlSalvarDados);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
