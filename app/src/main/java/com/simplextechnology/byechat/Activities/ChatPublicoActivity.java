package com.simplextechnology.byechat.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.simplextechnology.byechat.Fragments.ChatPublicoFragment;
import com.simplextechnology.byechat.Fragments.ConectadosFragment;
import com.simplextechnology.byechat.R;


public class ChatPublicoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_publico);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Este metodo cierra la app cuando se hunde el boton de retorno
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //Pregunta si el drawer esta desplegado, si lo esta, cuando se
        //oprima el boton de retorno se cierra el NavigationView pero la app
        //sigue abierta
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            //Si el drawer no esta desplegado y se oprime el boton de retorno
            //inmediatamente se cierra la app
        } else {
            super.onBackPressed();
        }
    }

    //Este metodo pone el menu de opciones que se encuentra en la parte
    //superior derecha
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    //Este metodo hace algo cuando un item es seleccionado en el menu de opciones
    //El que esta en la parte superior derecha, el cual por defecto tiene un
    //item llamado "Settings".
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Toast.makeText(ChatPublicoActivity.this,"Settings selected",Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Este metodo hace algo cuando es seleccionado un item en el "NavigationView"
    //Por ejemplo cuando es seleccionado el chat privado
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_publicChat) {
            setFragment(0);
        } else if (id == R.id.nav_peopleConnected) {
            setFragment(1);
        } else if (id == R.id.nav_privateChat) {
            setFragment(2);
        } else if (id == R.id.nav_changeName) {
            setFragment(3);
        } else if (id == R.id.nav_signOut) {
            setFragment(4);
        } else if (id == R.id.nav_settings) {
            setFragment(5);
        } else if (id == R.id.nav_help) {
            setFragment(6);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(int pos) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (pos) {
            case 0:
                ChatPublicoFragment fragmentChatPublico = new ChatPublicoFragment();
                transaction.replace(R.id.fragment, fragmentChatPublico);
                transaction.commit();
                Toast.makeText(ChatPublicoActivity.this, "Hola: " + R.id.nav_publicChat, Toast.LENGTH_LONG).show();
                break;
            case 1:
                ConectadosFragment fragmentConectados = new ConectadosFragment();
                transaction.replace(R.id.fragment, fragmentConectados);
                transaction.commit();
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

        }


    }

}
