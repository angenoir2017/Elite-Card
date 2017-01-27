package com.codeeaters.elitecard.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.codeeaters.elitecard.Aide;
import com.codeeaters.elitecard.Apropos;
import com.codeeaters.elitecard.R;
import com.codeeaters.elitecard.adapter.ArbreAdapter;
import com.codeeaters.elitecard.database.dao.ArbreDao;
import com.codeeaters.elitecard.database.dao.ProducteurDao;
import com.codeeaters.elitecard.database.entities.Arbre;
import com.codeeaters.elitecard.database.entities.Producteur;

import java.util.ArrayList;


public class ListArbresActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private ArbreAdapter arbreAdapter;
    private Producteur producteur;
    private Context context;
    private FloatingActionButton fab;
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_items);
        this.context = this;

        producteur = (Producteur) getIntent().getExtras().get("producteur");
        ArrayList<Arbre> arbres = getIntent().getParcelableArrayListExtra("arbres");
        producteur.setArbres(arbres);

        arbreAdapter = new ArbreAdapter(producteur.getArbres(), this);

        recyclerView = (RecyclerView) findViewById(R.id.pro_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(arbreAdapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EnregistrementAapeActivity.class);
                intent.putParcelableArrayListExtra("arbres", getProducteur().getArbres());
                intent.putExtra("producteur", getProducteur());
                mystartActivityForResult(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void mystartActivityForResult(Intent intent) {
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onResume() {
//        super.onResume();
//        SharedPreferences sharedPreferences = getSharedPreferences(MapActivity.AGENT_PREFERENCES, Context.MODE_PRIVATE);
//        boolean isvisite = sharedPreferences.getBoolean("isVisitte", Boolean.FALSE);
//        if (isvisite){
//            fab.hide();
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            producteur = (Producteur) data.getExtras().get("producteur");
            ArrayList<Arbre> arbres = data.getParcelableArrayListExtra("arbres");

            producteur.setArbres(arbres);
            setProducteur(producteur);
            arbreAdapter.update(getProducteur().getArbres());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, ListProducteursActivity.class);
        startActivity(intent);
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.enregistrer_aape) {
            // Handle the camera action
//            Intent intent = new Intent(this, EnregistrementAapeActivity.class);
            Intent intent = new Intent(this, ListProducteursActivity.class);
            this.startActivityForResult(intent, 0);
        }
        if (id == R.id.planing_visites_aape) {
            // Handle the camera action
            Intent intent = new Intent(this, PlaningVisitesActivity.class);
            this.startActivityForResult(intent, 0);
        } else if (id == R.id.visite_collecte_aape) {
            Intent intent = new Intent(this, ListeVisitesActivity.class);
            this.startActivityForResult(intent, 0);
        } else if (id == R.id.aide_aape) {
            Intent intent = new Intent(this, Aide.class);
            this.startActivityForResult(intent, 0);
        } else if (id == R.id.apropos_aape) {
            Intent intent = new Intent(this, Apropos.class);
            this.startActivityForResult(intent, 0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        //producteurDao.fetchOneWithChild(1);
    }

    public Context getContext() {
        return context;
    }

    public Producteur getProducteur() {
        return producteur;
    }

    public void setProducteur(Producteur producteur) {
        this.producteur = producteur;
    }
}
