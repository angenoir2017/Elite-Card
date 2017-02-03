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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.codeeaters.elitecard.Aide;
import com.codeeaters.elitecard.Apropos;
import com.codeeaters.elitecard.R;
import com.codeeaters.elitecard.adapter.SpinnerAdapter;
import com.codeeaters.elitecard.database.dao.ArbreDAO;
import com.codeeaters.elitecard.database.dao.ProducteurDAO;
import com.codeeaters.elitecard.database.entities.Arbre;
import com.codeeaters.elitecard.database.entities.Producteur;

import java.util.ArrayList;

public class EnregistrerAapeSuiteActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private String[] spinnerValue = new String[]{
            "Non",
            "Faible",
            "Moyen",
            "Fort"
    };

    private TextView selcouretaletxt;
    private TextView selcourcompactetxt;
    private TextView selcourratattxt;

    private EditText diametrecourns;
    private EditText diametrecoureo;
    private Switch couronnetaille;
    private Spinner couronneetale;
    private Spinner couronnecomp;
    private Spinner arbreratat;
    private EditText ecartement;
    private EditText obs;

    private Button enregistrer;
    private SpinnerAdapter spinnerAdapter;
    private Arbre arbre;
    private Producteur producteur;
    private ProducteurDAO producteurDao;
    private ArbreDAO arbreDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrer_aape_suite);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface ubuntuCondenced = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular.ttf");

        selcouretaletxt = (TextView) findViewById(R.id.selcouretaletxt);
        selcourcompactetxt = (TextView) findViewById(R.id.selcourcompactetxt);
        selcourratattxt = (TextView) findViewById(R.id.selcourratattxt);

        diametrecourns = (EditText) findViewById(R.id.diametrecouronnensaape);
        diametrecoureo = (EditText) findViewById(R.id.diametrecouronneeoaape);
        couronnetaille = (Switch) findViewById(R.id.couronnetailleeaape);
        couronneetale = (Spinner) findViewById(R.id.couronneetaleeaape);
        couronnecomp = (Spinner) findViewById(R.id.couronnecompacteaape);
        arbreratat = (Spinner) findViewById(R.id.arbreratatineeaape);
        ecartement = (EditText) findViewById(R.id.ecartementpiedprocheaape);
        obs = (EditText) findViewById(R.id.observationaape);

        couronnetaille.setTypeface(ubuntuCondenced);
        selcouretaletxt.setTypeface(ubuntuCondenced);
        selcourcompactetxt.setTypeface(ubuntuCondenced);
        selcourratattxt.setTypeface(ubuntuCondenced);

        enregistrer = (Button) findViewById(R.id.enregistreraapebtn);
        enregistrer.setTypeface(ubuntuCondenced);
        enregistrer.setOnClickListener(this);

        producteurDao = new ProducteurDAO(this);
        arbreDao = new ArbreDAO(this);

        arbre = (Arbre) getIntent().getExtras().get("arbre");
        producteur = (Producteur) getIntent().getExtras().get("producteur");
        ArrayList<Arbre> arbres = getIntent().getParcelableArrayListExtra("arbres");
        producteur.setArbres(arbres);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        spinnerAdapter = new SpinnerAdapter(
                this, R.layout.spinner_item, spinnerValue
        );

        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);

        couronneetale.setAdapter(spinnerAdapter);
        couronnecomp.setAdapter(spinnerAdapter);
        arbreratat.setAdapter(spinnerAdapter);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this, EnregistrementAapeActivity.class);
        this.startActivityForResult(intent, 0);

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
            Intent intent = new Intent(this, EnregistrementAapeActivity.class);
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
        if (diametrecourns.getText().toString().equals("") | diametrecoureo.getText().toString().equals("")
                | ecartement.getText().toString().equals("")) {

        } else {
            arbre.setDiametreCouronneNordSud(Double.parseDouble(diametrecourns.getText().toString()));
            arbre.setDiametreCouronneEstOuest(Double.parseDouble(diametrecoureo.getText().toString()));
            arbre.setEcratemementPied(Double.parseDouble(ecartement.getText().toString()));
            arbre.setCouronneTaille(couronnetaille.isChecked() ? 1 : 0);
            arbre.setCouronneEtalee(couronneetale.getSelectedItem().toString());
            arbre.setCouronneCompacte(couronnecomp.getSelectedItem().toString());
            arbre.setArbreRatatine(arbreratat.getSelectedItem().toString());
            arbre.setObservation(obs.getText().toString());

            Log.d("Add Arbre", arbre.toString());

            arbre = arbreDao.add(arbre);
            producteur = producteurDao.updateSequence(producteur);
            producteur.addArbre(arbre);

//            Intent intent = new Intent(this, ListArbresActivity.class);
            Intent intent = new Intent();
            intent.putExtra("isResume", Boolean.TRUE);
            intent.putParcelableArrayListExtra("arbres", getProducteur().getArbres());
            intent.putExtra("producteur", getProducteur());
            setResult(RESULT_OK, intent);
            finish();
//            startActivity(intent);
        }
    }

    public Producteur getProducteur() {
        return producteur;
    }

    public void setProducteur(Producteur producteur) {
        this.producteur = producteur;
    }
}
