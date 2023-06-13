package com.marcus.crud_produto.database;

public class ScriptDDL {

    public static String getCreatTableProduto() {

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE PRODUTOS(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT, NOME VARCHAR(155) NOT NULL, PRECO VARCHAR(20) NOT NULL, DESCRICAO VARCHAR(255) NOT NULL);");
        return sql.toString();
    }
}
