package com.example.lab6_20200241.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab6_20200241.R;
import com.example.lab6_20200241.adapter.IngresoAdapter;
import com.example.lab6_20200241.databinding.FragmentIngresoBinding;
import com.example.lab6_20200241.dtos.Ingreso;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;


public class IngresoFragment extends Fragment {

    FragmentIngresoBinding binding;

    IngresoAdapter adapter;
    List<Ingreso> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentIngresoBinding.inflate(inflater, container, false);
        list = new ArrayList<>();
        adapter = new IngresoAdapter(getContext(), list);


        binding.ingresoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.ingresoRecyclerView.setAdapter(adapter);

        /** Instancia de Firestore **/
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String userID = String.valueOf(getId());
        Log.d("msg-test", "EL ID DE LA SESSION ES: " + userID);


        /** Carga los datos desde Firestore **/
        db.collection("usuarios")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Ingreso ingreso = document.toObject(Ingreso.class);
                            list.add(ingreso);
                        }
                        /** Notifica al adaptador que los datos han cambiado **/
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.d("msg-test", "Error getting documents: ", task.getException());
                    }
                });



        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}