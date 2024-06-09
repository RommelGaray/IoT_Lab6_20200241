package com.example.lab6_20200241;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab6_20200241.databinding.ActivityMainBinding;
import com.example.lab6_20200241.dtos.Usuario;
import com.example.lab6_20200241.fragmentos.EgresoFragment;
import com.example.lab6_20200241.fragmentos.IngresoFragment;
import com.example.lab6_20200241.fragmentos.ResumenFragment;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


//    FirebaseFirestore db;
    ActivityMainBinding binding;
    FirebaseFirestore db;
//    ListenerRegistration snapshotListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser() ;
        String userId = user.getUid();
        String userName = user.getDisplayName();

        db = FirebaseFirestore.getInstance();
        Usuario usuario = new Usuario();
        usuario.setNombre(userName);
        usuario.setIngreso(null);
        usuario.setEgreso(null);

        db.collection("usuarios")
                .document(userId)
                .set(usuario)
                .addOnSuccessListener( unused -> {
                    Log.d("msg-test","Usuario " + usuario.getNombre() + " guardada exitosamente");
                })
                .addOnFailureListener(e -> e.printStackTrace());


        //fragmentos
        replaceFragment(new IngresoFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.ingreso){
                replaceFragment(new IngresoFragment());
            } else if (menuItem.getItemId() == R.id.egreso) {
                replaceFragment(new EgresoFragment());
            } else if (menuItem.getItemId() == R.id.resumen) {
                replaceFragment(new ResumenFragment());
            }
            return true;
        });


    }

    private  void  replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_logout,menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return logOutActionBar (item);
    }

    public boolean logOutActionBar(MenuItem item){
        if (item.getItemId() == R.id.logout) {
            Toast.makeText(this, "Sesión finalizada", Toast.LENGTH_SHORT).show();
            AuthUI.getInstance().signOut(MainActivity.this)
                    .addOnCompleteListener(task -> {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}