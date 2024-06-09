package com.example.lab6_20200241.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab6_20200241.R;
import com.example.lab6_20200241.dtos.Ingreso;

import java.util.List;

public class IngresoAdapter extends RecyclerView.Adapter<IngresoAdapter.ingresoViewHolder> {

    Context context;
    List<Ingreso> list;

    public IngresoAdapter(Context context, List<Ingreso> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ingresoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ingreso,parent,false);
        return new ingresoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ingresoViewHolder holder, int position) {
        Ingreso ingreso = list.get(position);

        holder.tituloItem.setText(ingreso.getTitulo());
        holder.descripcionItem.setText(ingreso.getDescripcion());
        holder.fechaItem.setText(ingreso.getFecha());
        holder.montoItem.setText((int) ingreso.getMonto());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ingresoViewHolder extends RecyclerView.ViewHolder{
        TextView tituloItem, descripcionItem, fechaItem, montoItem;
        public ingresoViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloItem = itemView.findViewById(R.id.titulo);
            descripcionItem = itemView.findViewById(R.id.descripcion);
            fechaItem = itemView.findViewById(R.id.fecha);
            montoItem = itemView.findViewById(R.id.monto);
        }
    }


}
