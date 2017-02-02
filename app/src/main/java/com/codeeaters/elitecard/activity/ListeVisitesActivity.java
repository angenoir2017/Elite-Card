package com.codeeaters.elitecard.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.codeeaters.elitecard.Aide;
import com.codeeaters.elitecard.Apropos;
import com.codeeaters.elitecard.R;

import java.util.Map;

public class ListeVisitesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private Button floraison;
    private Button fructification;
    private Button recolte;
    private Button rendement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_visites);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface ubuntuCondenced = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular.ttf");

        floraison = (Button) findViewById(R.id.visitefloraison);
        floraison.setOnClickListener(this);
        fructification = (Button) findViewById(R.id.visitefructification);
        fructification.setOnClickListener(this);
        recolte = (Button) findViewById(R.id.visiterecoltes);
        recolte.setOnClickListener(this);
        rendement = (Button) findViewById(R.id.visiterendements);
        rendement.setOnClickListener(this);

        floraison.setTypeface(ubuntuCondenced);
        fructification.setTypeface(ubuntuCondenced);
        recolte.setTypeface(ubuntuCondenced);
        rendement.setTypeface(ubuntuCondenced);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ListeVisitesActivity.this, MapActivity.class));
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.enregistrer_aape) {
            // Handle the camera action
            Intent intent = new Intent(this, ListProducteursActivity.class);
            SharedPreferences sharedPreferences = getSharedPreferences(MapActivity.AGENT_PREFERENCES, Context.MODE_PRIVATE);
            sharedPreferences.edit().putBoolean("isVisite", Boolean.FALSE).apply();
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
        if (floraison.isPressed()) {
            Intent intent = new Intent(this, ListProducteursActivity.class);
            SharedPreferences sharedPreferences = getSharedPreferences(MapActivity.AGENT_PREFERENCES, Context.MODE_PRIVATE);
            sharedPreferences.edit().putBoolean("isVisite", Boolean.TRUE).apply();
            this.startActivityForResult(intent, 0);
        } else if (fructification.isPressed()) {
            Intent intent = new Intent(this, VisiteFructificationActivity.class);
            this.startActivityForResult(intent, 0);
        } else if (recolte.isPressed()) {
            Intent intent = new Intent(this, VisiteRecoltesActivity.class);
            this.startActivityForResult(intent, 0);
        } else if (rendement.isPressed()) {
            Intent intent = new Intent(this, VisiteRendementsActivity.class);
            this.startActivityForResult(intent, 0);
        }
    }
}
