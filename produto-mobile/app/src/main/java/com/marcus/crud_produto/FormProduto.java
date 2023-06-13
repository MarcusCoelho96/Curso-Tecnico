package com.marcus.crud_produto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.marcus.crud_produto.database.DadosOpenHelper;
import com.marcus.crud_produto.dominio.entidade.Produto;
import com.marcus.crud_produto.dominio.repositorio.ProdutoRepositorio;


public class FormProduto extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtPreco;
    private EditText edtDescricao;
    public Button btnAdd;

    //atributos para a conexão com banco de dados
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    //atributo de visualização do retorno da conexão
    private ConstraintLayout layoutContentActCadProduto;
    //atributo Clientes para enviar ao bd
    private ProdutoRepositorio produtoRepositorio;
    public Produto produto;

    public void criarConexao() {
        try {
            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();
            Snackbar.make(layoutContentActCadProduto, "Conexao criada com sucesso!", Snackbar.LENGTH_SHORT).setAction("Ok", null).show();
            produtoRepositorio = new ProdutoRepositorio(conexao);

        } catch (SQLException ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    public void verificaParametros() {
        Bundle bundle = getIntent().getExtras();
        produto = new Produto();
        if ((bundle != null)) {
            produto.codigo = bundle.getInt("codigo");
            edtNome.setText(bundle.getString("nome"));
            edtPreco.setText(bundle.getString("preco"));
            edtDescricao.setText(bundle.getString("descricao"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_form);

        edtNome = findViewById(R.id.edtNome);
        edtPreco = findViewById(R.id.edtPreco);
        edtDescricao = findViewById(R.id.edtDescricao);
        layoutContentActCadProduto = findViewById(R.id.layoutContentForm);
        produto = new Produto();
        produto.codigo = 0;
        criarConexao();
        verificaParametros();
    }

    private boolean validaCampos() {
        boolean res = false;
        String nome = edtNome.getText().toString();
        String preco = edtPreco.getText().toString();
        String descricao = edtDescricao.getText().toString();

        if (res = isCampoVazio(nome)) {
            edtNome.requestFocus();
        } else if (res = isCampoVazio(preco)) {
            edtPreco.requestFocus();
        } else if (res = isCampoVazio(descricao)) {
            edtDescricao.requestFocus();
        }
        if (res) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Aviso");
            dlg.setMessage("Campos inválidos ou em branco");
            dlg.setNeutralButton("ok", null);
            dlg.show();
        } else {
            produto.nome = nome;
            produto.preco = preco;
            produto.descricao = descricao;
            try {
                if (produto.codigo == 0) {
                    produtoRepositorio.inserir(produto);
                    Toast.makeText(this, "Salvou!", Toast.LENGTH_LONG).show();
                } else {
                    produtoRepositorio.alterar(produto);
                    Toast.makeText(this, "Editou!", Toast.LENGTH_LONG).show();
                }
                finish();
            } catch (SQLException ex) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("Erro");
                dlg.setMessage(ex.getMessage());
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
        }
        return res;
    }

    private boolean isCampoVazio(String valor) {

        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;
            case R.id.title_menu_cadastrar:
                validaCampos();
                break;
            case R.id.title_menu_cancelar:
                if (produto.codigo != 0)
                    produtoRepositorio.deletar(produto.codigo);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}