package com.marcus.crud_produto.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.marcus.crud_produto.database.DadosOpenHelper;
import com.marcus.crud_produto.dominio.entidade.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio {

    public SQLiteDatabase conexao;
    //public DadosOpenHelper dadosOpenHelper;

    public ProdutoRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void inserir(Produto produto){

        ContentValues contentValues = new ContentValues();

        contentValues.put("NOME",produto.nome);
        contentValues.put("PRECO",produto.preco);
        contentValues.put("DESCRICAO",produto.descricao);

        conexao.insert("PRODUTOS", null, contentValues);
    }

    public void alterar(Produto produto){

            ContentValues contentValues = new ContentValues();

            contentValues.put("NOME",produto.nome);
            contentValues.put("PRECO",produto.preco);
            contentValues.put("DESCRICAO",produto.descricao);

            String[] args = new String[1];
            args[0] = String.valueOf(produto.codigo);

            conexao.update("PRODUTOS", contentValues, "CODIGO=?", args);

    }

    public void deletar(int codigo){

            String[] args = new String[1];
            args[0] = String.valueOf(codigo);

            conexao.delete("PRODUTOS", "CODIGO=?", args);

    }

    public List<Produto> listar(){

        List<Produto> produtoLista = new ArrayList<Produto>();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT NOME, PRECO, DESCRICAO FROM PRODUTOS");
        Cursor resultado = conexao.rawQuery(sql.toString(),null);
        if (resultado.getCount()>0){

            resultado.moveToFirst();

            do {
                Produto p = new Produto();
                p.nome = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
                p.preco = resultado.getString(resultado.getColumnIndexOrThrow("PRECO"));
                p.descricao = resultado.getString(resultado.getColumnIndexOrThrow("DESCRICAO"));
                produtoLista.add(p);

            }while(resultado.moveToNext());

        }//fim do if

        return produtoLista;

    }
}
