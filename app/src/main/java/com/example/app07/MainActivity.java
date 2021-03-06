package com.example.app07;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtUusario;
    private EditText txtContraseña;
    private Button btnIngresar;
    private Button btnFinalizar;
    private Usuarios user= new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        iniciar();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUusario.getText().toString().matches("")&&
                txtContraseña.getText().toString().matches("")){

                    Toast.makeText(MainActivity.this,
                            "Falto Capturar Informacion",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    if (txtUusario.getText().toString().matches(user.getUser())&&
                    txtContraseña.getText().toString().matches(user.getContraseña())){

                        Intent intent = new
                                Intent(MainActivity.this,LstActivity.class);
                        intent.putExtra("usuario",txtUusario.getText().toString());

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("usuario",user);
                        intent.putExtras(bundle);

                        startActivity(intent);

                    }
                }
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
});
confirmar.show();
            }
        });
    }

    private void iniciar(){
        txtUusario = (EditText) findViewById(R.id.txtUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        user.setUser(getResources().getString(R.string.userName));
        user.setContraseña(getResources().getString(R.string.contraseña));
        user.setNombreCompleto(getResources().getString(R.string.nombre));
        user.setEmail(getResources().getString(R.string.email));

    }

}