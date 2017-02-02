package com.codeeaters.elitecard.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.codeeaters.elitecard.Aide;
import com.codeeaters.elitecard.Apropos;
import com.codeeaters.elitecard.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VisiteRecoltesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    Spinner amande;
    DatePicker datePicker;
    Switch facdepel;
    Switch bonneforme;
    Switch separ;
    EditText rendement;
    EditText observ;
    Button enregistrer;
    String aman;
    Date daterecolte;
    int fd;
    int bf;
    int sep;
    float rend;
    String obs;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visite_recoltes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amande=(Spinner)findViewById(R.id.tauxamande);
        datePicker=(DatePicker)findViewById((R.id.daterecolte));
        facdepel=(Switch)findViewById(R.id.facilitedepelliculage);
        bonneforme=(Switch)findViewById(R.id.bonneformenoix);
        separ=(Switch)findViewById(R.id.faciliteseparationnoixpomme);
        rendement=(EditText)findViewById(R.id.rendementrecolte);
        observ=(EditText)findViewById(R.id.observationsrecolte);
        enregistrer=(Button)findViewById(R.id.enregistrerrecoltebtn);
        enregistrer.setOnClickListener(this);

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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
            Intent intent = new Intent(this, EnregistrementAapeActivity.class);
            SharedPreferences sharedPreferences = getSharedPreferences(MapActivity.AGENT_PREFERENCES, Context.MODE_PRIVATE);
            sharedPreferences.edit().putBoolean("isVisite", Boolean.FALSE).apply();
            this.startActivityForResult(intent,0);
        }if (id == R.id.planing_visites_aape) {
            // Handle the camera action
            Intent intent = new Intent(this,PlaningVisitesActivity.class);
            this.startActivityForResult(intent,0);
        }
        else if (id == R.id.visite_collecte_aape){
            Intent intent = new Intent(this,ListeVisitesActivity.class);
            this.startActivityForResult(intent,0);
        }
        else if (id == R.id.aide_aape){
            Intent intent = new Intent(this,Aide.class);
            this.startActivityForResult(intent,0);
        }
        else if (id == R.id.apropos_aape){
            Intent intent = new Intent(this,Apropos.class);
            this.startActivityForResult(intent,0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        aman=amande.getSelectedItem().toString();
        if (facdepel.isChecked()){
            fd=1;
        }else {
            fd=0;
        }
        if (bonneforme.isChecked()){
            bf=1;
        }else {
            bf=0;
        }
        if (separ.isChecked()){
            sep=1;
        }
        else{
            sep=0;
        }
        daterecolte= VisiteFloraisonActivity.getDateFromDatePicker(datePicker);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(daterecolte);
        try {
            rend=Float.parseFloat(rendement.getText().toString());
        }
        catch (NumberFormatException ex){

        }

        obs=observ.getText().toString();
        Toast.makeText(this,dateString,Toast.LENGTH_LONG).show();


    }
}
