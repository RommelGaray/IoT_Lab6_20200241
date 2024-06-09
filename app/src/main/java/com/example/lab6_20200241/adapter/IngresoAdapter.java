package com.example.lab6_20200241.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab6_20200241.dtos.Ingreso;

import java.util.List;

public class IngresoAdapter RecyclerView.Adapter<IngresoAdapter.ingresoViewholder> {

    Context context;
    List<Ingreso> list;

    public IngresoAdapter(Context context, List<Ingreso> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ingresoHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ingreso,parent,false);
        return new ingresoHolderView(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ingresoViewHolder holder, int position) {
        Ingreso ingreso = list.get(position);

        holder.tittleItem.setText(ingreso.getTitulo());
        holder.descriptionItem.setText(ingreso.getDescripcion());
        String amountString = String.valueOf(income.getAmount());
        holder.amountItem.setText(String.format("s/ %s", amountString));
    }


    @Override
    public int getAmount() {
        return list.size();
    }


    public class ingresoViewHolder extends RecyclerView.ViewHolder{
        TextView tittleItem, descriptionItem, amountItem;
        public ingresoViewHolder(@NonNull View itemView) {
            super(itemView);
            tittleItem = itemView.findViewById(R.id.nombre);
            descriptionItem = itemView.findViewById(R.id.description);
            amountItem = itemView.findViewById(R.id.amount);
        }
    }


}
