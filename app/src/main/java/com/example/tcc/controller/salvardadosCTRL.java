package com.example.tcc.controller;


import com.example.tcc.SalvarDadosDAO.salvardadosDAO;
import com.example.tcc.dbHelper.ConxãoSQLitee;

public class salvardadosCTRL {


    private final salvardadosDAO SALVARDAO;

    public salvardadosCTRL(ConxãoSQLitee.ConexaoSQLite salvarDadosDAO){
        SALVARDAO =  new salvardadosDAO(salvarDadosDAO);
        }
/*
        public long salvarProdutoCtrl(salvardadosDAO salvarDadosDAO){
            return this.SALVARDAO.salvarDadosDAO(salvarDadosDAO);
        }
*/
}