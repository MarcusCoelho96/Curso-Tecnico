package com.marcus.crud_produto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.marcus.crud_produto.dominio.entidade.Produto;
//import com.marcus.crud_produto.dominio.repositorio.ProdutoRepositorio;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolderProduto> {

    private List<Produto> dados;

    public ProdutoAdapter(List<Produto> dados){
        this.dados = dados;
    }

    @Override
    public ProdutoAdapter.ViewHolderProduto onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha_produto, parent, false);

        ViewHolderProduto holderProduto = new ViewHolderProduto(view, parent.getContext());

        return holderProduto;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProdutoAdapter.ViewHolderProduto holder, int position) {

        if((dados != null) && (dados.size()>0)){

            Produto produto = dados.get(position);
            holder.tvNome.setText(dados.get(position).nome);
            holder.tvPreco.setText(dados.get(position).preco);
            holder.tvDescricao.setText(dados.get(position).descricao);
        }
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderProduto extends RecyclerView.ViewHolder{
        public TextView tvNome;
        public TextView tvPreco;
        public TextView tvDescricao;

        public ViewHolderProduto(View itemView, final Context context){
            super(itemView);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvPreco = itemView.findViewById(R.id.tvPreco);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(dados.size()>0){
                        Produto produto = dados.get(getLayoutPosition());
                        Intent it = new Intent(context, FormProduto.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nome", produto.nome);
                        bundle.putString("preco", produto.preco);
                        bundle.putString("descricao", produto.descricao);
                        it.putExtras(bundle);
                        ((AppCompatActivity)context).startActivity(it);
                    }
                }
            });
        }
    }
}
