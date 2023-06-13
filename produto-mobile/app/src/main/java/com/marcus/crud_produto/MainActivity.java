package com.marcus.crud_produto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;
import com.marcus.crud_produto.database.DadosOpenHelper;
import com.marcus.crud_produto.dominio.entidade.Produto;
import com.marcus.crud_produto.dominio.repositorio.ProdutoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView listaProduto;
    public SQLiteDatabase conexao;
    public DadosOpenHelper dadosOpenHelper;
    public ConstraintLayout layoutContentMain;
    public List<Produto> produto = new ArrayList<>();
    Produto prod;

    //public ProdutoRepositorio clienteRepositorio;
    public Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("TABELA DE PRODUTOS");

        layoutContentMain = findViewById(R.id.layoutContentMain);
        btnAdd = findViewById(R.id.btnAdd);
        listaProduto = findViewById(R.id.RecyclerView);

        criarConexao();

        listaProduto.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listaProduto.setLayoutManager(linearLayoutManager);

        ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio(conexao);
        produto = produtoRepositorio.listar();
        ProdutoAdapter adapter = new ProdutoAdapter(produto);
        listaProduto.setAdapter(adapter);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormProduto.class));
            }
        });
    }
    public void criarConexao(){
        try{
            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();
            //Snackbar.make(layoutContentMain,"Conexao criada com sucesso!",Snackbar.LENGTH_SHORT).setAction("Ok",null).show();
            ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio(conexao);

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }

}
