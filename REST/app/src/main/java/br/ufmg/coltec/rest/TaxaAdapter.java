package br.ufmg.coltec.rest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufmg.coltec.rest.Services.Taxa;


/**
 * Created by a2016951600 on 22/08/18.
 */

public class TaxaAdapter extends BaseAdapter {

    // lista que conterá a linguagens a serem exibidas
    private ArrayList<Taxa> taxas;
    private Context context;

    public  TaxaAdapter(Context context, ArrayList<Taxa> t) {
        this.context = context;
        this.taxas = t;
    }

    @Override
    public int getCount() {
        return this.taxas.size();
    }

    @Override
    public Object getItem(int i) {
        return this.taxas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Taxa taxa = this.taxas.get(i);

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.taxa_adapter, viewGroup, false);

        // recupera cada um dos campos do item
        TextView lblNome = newView.findViewById(R.id.lbl_nome);
        TextView lblValor = newView.findViewById(R.id.lbl_valor);


        // define o valor de cada um dos campos
        lblNome.setText(taxa.getNome());
        String ValorStr = Float.toString(taxa.getValor());
        lblValor.setText(ValorStr);


        final Intent intent = new Intent(context, ItemSelecionado.class);

        intent.putExtra("nome", taxa.getNome());
        intent.putExtra("valor", ValorStr);

        newView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(intent);

            }
        });

        return newView;


    }
}
