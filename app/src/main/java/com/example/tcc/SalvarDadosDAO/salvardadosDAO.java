package com.example.tcc.SalvarDadosDAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.tcc.dbHelper.ConxãoSQLitee;

public class salvardadosDAO {


    private final ConxãoSQLitee.ConexaoSQLite conexaoSQLite;

    public salvardadosDAO(ConxãoSQLitee.ConexaoSQLite conexaoSQLite){
        this.conexaoSQLite = conexaoSQLite;
    }
/*
    public long salvarDadosDAO(salvardadosDAO sSalvar) {
        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("id", sSalvar.getId());
            values.put("nome",sSalvar.getNome());
            values.put("quantidade_em_estoque",sSalvar.getQuantidadeEstoque());
            values.put("preco",sSalvar.getPreco());

            long idProdutoInserido = db.insert("produto",null,values );
            return idProdutoInserido;
        }catch(Exception e){
            e.printStackTrace();

        }
        return 0;
    }*/
}

