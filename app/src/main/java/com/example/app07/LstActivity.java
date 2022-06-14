package com.example.app07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.SearchView;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class LstActivity extends AppCompatActivity {
    private TextView lblUser;
    private ListView lstAlumnos;
    private ArrayAdapter<String> adapter;
    private SearchView srcLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst);
        srcLista = (SearchView) findViewById(R.id.menu_search);
        lblUser = (TextView) findViewById(R.id.lblUsuario);
        lstAlumnos = (ListView) findViewById(R.id.lstAlumnos);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.alumnos));
        lstAlumnos.setAdapter(adapter);

        Bundle datos =getIntent().getExtras();
        Usuarios user =(Usuarios) datos.getSerializable("usuario");
        lblUser.setText(user.getNombreCompleto());

       /*Bundle datos = getIntent().getExtras();
        lblUser.setText(datos.getString("usuario"));*/

    }
public boolean onCreateOptionsMenu(Menu menu){
    MenuInflater menuInflater = getMenuInflater();
menuInflater.inflate(R.menu.searchview,menu);
MenuItem menuItem = menu.findItem(R.id.menu_search);
SearchView searchView = (SearchView) menuItem.getActionView();
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);
        return false;
    }
});
return super.onCreateOptionsMenu(menu);

}
}