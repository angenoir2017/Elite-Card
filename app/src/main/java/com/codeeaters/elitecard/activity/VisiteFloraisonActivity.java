package com.codeeaters.elitecard.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.codeeaters.elitecard.Aide;
import com.codeeaters.elitecard.Apropos;
import com.codeeaters.elitecard.R;
import com.codeeaters.elitecard.activity.EnregistrementAapeActivity;
import com.codeeaters.elitecard.activity.ListeVisitesActivity;
import com.codeeaters.elitecard.activity.PlaningVisitesActivity;
import com.codeeaters.elitecard.adapter.SpinnerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VisiteFloraisonActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private TextView tauxfleur;
    private TextView datv;
    private Spinner tauxhermaph;
    private DatePicker datePicker;
    private EditText observ;
    private Button enreg;
    private Button photo;
    private SpinnerAdapter spinnerAdapter;
    private ImageView photofloraison1;
    private ImageView photofloraison2;
    private ImageView photofloraison3;
    private String[] taux = new String[]{
            "Non",
            "Faible",
            "Moyen",
            "Fort"
    };
    private static final int CAMERA_REQUEST_CODE = 1;
    private int nbrPhoto = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visite_floraison);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface ubuntuCondenced = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular.ttf");

        tauxhermaph = (Spinner) findViewById(R.id.abondancefleurs);
        photofloraison1 = (ImageView) findViewById(R.id.photofloraison1);
        photofloraison2 = (ImageView) findViewById(R.id.photofloraison2);
        photofloraison3 = (ImageView) findViewById(R.id.photofloraison3);
        datePicker = (DatePicker) findViewById(R.id.datefloraison);
        observ = (EditText) findViewById(R.id.observationsfloraison);
        tauxfleur = (TextView) findViewById(R.id.selctauxtxt);
        datv = (TextView) findViewById(R.id.selcttxt);

        photo = (Button) findViewById(R.id.photographierfloraisonbtn);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });
        enreg = (Button) findViewById(R.id.enregistrerfloraisonbtn);
        enreg.setOnClickListener(this);

        tauxfleur.setTypeface(ubuntuCondenced);
        datv.setTypeface(ubuntuCondenced);
        photo.setTypeface(ubuntuCondenced);
        enreg.setTypeface(ubuntuCondenced);

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
                this, R.layout.spinner_item, taux
        );
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        tauxhermaph.setAdapter(spinnerAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            if (nbrPhoto == 1){
                photofloraison1.setImageBitmap(imageBitmap);
            }
            if (nbrPhoto == 2){
                photofloraison2.setImageBitmap(imageBitmap);
            }
            if (nbrPhoto == 3){
                photofloraison3.setImageBitmap(imageBitmap);
                photo.setEnabled(false);
            }
            nbrPhoto++;
        }
    }

    public static java.util.Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);


        return calendar.getTime();

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
//        tauxfleur = tauxhermaph.getSelectedItem().toString();
//        obs = observ.getText().toString();
        Date er = getDateFromDatePicker(datePicker);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(er);
        Toast.makeText(this, dateString, Toast.LENGTH_LONG).show();


    }
}
