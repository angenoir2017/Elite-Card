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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.codeeaters.elitecard.Aide;
import com.codeeaters.elitecard.Apropos;
import com.codeeaters.elitecard.R;
import com.codeeaters.elitecard.adapter.SpinnerAdapter;
import com.codeeaters.elitecard.database.entities.Arbre;
import com.codeeaters.elitecard.database.entities.Producteur;

import java.util.ArrayList;

import pl.polak.clicknumberpicker.ClickNumberPickerView;

public class EnregistrementAapeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private String[] regions = new String[]{
            "Centrale",
            "Kara",
            "Plateaux",
            "Savanes"
    };
    //...................................
    private String[] preCentrale = new String[]{
            "Blitta",
            "Sotouboua",
            "Tchamba",
            "Tchaoudjo"
    };
    private String[] cantBlitta = new String[]{
            "Blitta Gare",
            "Waragni",
            "Yaloumbè"
    };
    private String[] cantSotouboua = new String[]{
            "Adjengré",
            "Fazao"
    };
    private String[] cantTchaoudjo = new String[]{
            "Kpangalam",
            "Kparatao",
            "Kpassouadè",
            "Lama-Tessi",
            "Sagbadai"
    };
    private String[] cantTchamba = new String[]{
            "Affem Boussou",
            "Alibi 1",
            "Balanka"
    };
    private String[] villBlittaGare = new String[]{
            "Blitta Gare"
    };
    private String[] villYaloumbe = new String[]{
            "Yaloumbè"
    };
    private String[] villWaragni = new String[]{
            "Waragni"
    };
    private String[] villAdjengre = new String[]{
            "Adjengré"
    };
    private String[] villFazao = new String[]{
            "Fazao"
    };
    private String[] villLamaTessi = new String[]{
            "Aou-Matchatom",
            "Damala",
            "Sakalaoudè",
            "Tchawaré"
    };
    private String[] villKpassouade = new String[]{
            "Kpassouadè"
    };
    private String[] villSagbadai = new String[]{
            "Sagbadai"
    };
    private String[] villKpangalam = new String[]{
            "Kpario"
    };
    private String[] villKparatao = new String[]{
            "Kparatao"
    };
    private String[] villBalanka = new String[]{
            "Balanka",
            "Parampa"
    };
    private String[] villAlibi1 = new String[]{
            "Alibi 1"
    };
    private String[] villAffemBoussou = new String[]{
            "Affem Boussou"
    };
    //...................................
    private String[] preKara = new String[]{
            "Assoli",
            "Bassar",
            "Dankpen"
    };
    private String[] cantBassar = new String[]{
            "Bangeli"
    };
    private String[] cantDankpen = new String[]{
            "Guérin Kouka"
    };
    private String[] cantAssoli = new String[]{
            "Bafilo",
            "Soudou"
    };
    private String[] villBangeli = new String[]{
            "Bangeli Centre",
            "Biakpabé"
    };
    private String[] villGuerinKouka = new String[]{
            "Guérin Kouka"
    };
    private String[] villBafilo = new String[]{
            "Agoudadè"
    };
    private String[] villSoudou = new String[]{
            "Gandé"
    };

    //...................................

    private String[] preSavanes = new String[]{
            "Kpendjal",
            "Oti",
            "Tône"
    };

    private String[] cantKpendjal = new String[]{
            "Ogaro",
            "NAKI-Est"
    };
    private String[] cantOti = new String[]{
            "Nagbéni"
    };
    private String[] cantTone = new String[]{
            "Bitchiengua",
            "Pana"
    };

    String[] villBitchiengua = new String[]{
            "Tantchlig"
    };
    String[] villPana = new String[]{
            "Ganloré",
            "Molibagou",
            "Tanbilé",
            "Wandjoague"
    };
    private String[] villOgaro = new String[]{
            "Kouampantè",
            "Kpengangadi",
            "Bonloaré",
            "Ogaro Centre"
    };
    private String[] villNAKIEst = new String[]{
            "Boulbene"
    };
    private String[] villNagbeni = new String[]{
            "Nadoundi",
            "Nagbéni",
            "Soumbouni",
            "Tcharbingou"
    };

    //...................................

    private String[] prePlateaux = new String[]{
            "Anié",
            "Est-Mono"
    };
    private String[] cantAnie = new String[]{
            "Adogbénou",
            "Anié",
            "Atchinédji",
            "Kolocopé",
            "Glitto"
    };
    private String[] cantEstMono = new String[]{
            "Elavagnon",
            "Gbadahè",
            "Gbadincopé",
            "Kamina",
            "N'yamassila"
    };
    private String[] villAdogbenou = new String[]{
            "Adogbénou",
            "Afolè",
            "Agossou",
            "Houndjé",
            "Idjofè",
            "Okéloukoutou"
    };
    private String[] villAtchinedji = new String[]{
            "Sossa-copé",
            "Tchame"
    };
    private String[] villAnie = new String[]{
            "Kotchi"
    };
    private String[] villKolocope = new String[]{
            "Arifè",
            "Doté",
            "Kolocopé"
    };
    private String[] villGlitto = new String[]{
            "Déwou-copé",
            "Dissagba",
            "Dokpé",
            "Glitto",
            "Ilowadant",
            "Tangbagola"
    };
    private String[] villGbadahe = new String[]{
            "Gbadahè"
    };
    private String[] villNyamassila = new String[]{
            "N'yamassila"
    };
    private String[] villElavagnon = new String[]{
            "Elavagnon"
    };
    private String[] villGbadincope = new String[]{
            "Gbadincopé"
    };
    private String[] villKamina = new String[]{
            "Kamina"
    };
    //...................................

    private TextView codev;
    private TextView code;
    private TextView tregion;
    private TextView tprefecture;
    private TextView tcanton;
    private TextView tvillage;
    private TextView tage;

    private Button suivant;
    private Spinner region;
    private Spinner prefecture;
    private Spinner canton;
    private Spinner village;
    private EditText origine;
    private Switch marquage;
    private EditText hauteur;
    private EditText rayonnord;
    private EditText rayonsud;
    private EditText rayonest;
    private EditText rayonouest;

    private SpinnerAdapter regArrayAdapter;
    private SpinnerAdapter preArrayAdapter;
    private SpinnerAdapter canArrayAdapter;
    private SpinnerAdapter villArrayAdapter;

    private ClickNumberPickerView age;
    private Producteur producteur;
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement_aape);

        Typeface ubuntuCondenced = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular.ttf");

        age = (ClickNumberPickerView) findViewById(R.id.ageaape);
        age.setPickerValue(8f);

        codev = (TextView) findViewById(R.id.codeshow);
        code = (TextView) findViewById(R.id.code);
        tregion = (TextView) findViewById(R.id.selctregiontxt);
        tprefecture = (TextView) findViewById(R.id.selctpreftxt);
        tcanton = (TextView) findViewById(R.id.selecCantonftxt);
        tvillage = (TextView) findViewById(R.id.selecVillageftxt);
        tage = (TextView) findViewById(R.id.selecAgeftxt);

        suivant = (Button) findViewById(R.id.etapebutton1);
        region = (Spinner) findViewById(R.id.regionaape);
        prefecture = (Spinner) findViewById(R.id.prefectureaape);
        canton = (Spinner) findViewById(R.id.cantonaape);
        village = (Spinner) findViewById(R.id.villageaape);
        origine = (EditText) findViewById(R.id.origineaape);
        marquage = (Switch) findViewById(R.id.marquageaape);
        hauteur = (EditText) findViewById(R.id.hauteuraape);
        rayonest = (EditText) findViewById(R.id.rayonestaape);
        rayonnord = (EditText) findViewById(R.id.rayonnordaape);
        rayonouest = (EditText) findViewById(R.id.rayonouestaape);
        rayonsud = (EditText) findViewById(R.id.rayonsudaape);

        codev.setTypeface(ubuntuCondenced);
        code.setTypeface(ubuntuCondenced);
        tregion.setTypeface(ubuntuCondenced);
        tprefecture.setTypeface(ubuntuCondenced);
        tcanton.setTypeface(ubuntuCondenced);
        tvillage.setTypeface(ubuntuCondenced);
        tage.setTypeface(ubuntuCondenced);
        marquage.setTypeface(ubuntuCondenced);

        producteur = (Producteur) getIntent().getExtras().get("producteur");
        ArrayList<Arbre> arbres = getIntent().getParcelableArrayListExtra("arbres");
        producteur.setArbres(arbres);
        code.setText(producteur.getCodeProducteur() + "-" + (producteur.getSequence() + 1));

        suivant.setTypeface(ubuntuCondenced);
        suivant.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences(MapActivity.AGENT_PREFERENCES, 0);
        String codeAgent = sharedPreferences.getString("code", "1-1");

        String[] codeAgentSlited = codeAgent.split("-");
        if (codeAgentSlited[0].equals("1")) {
            regions = new String[]{
                    "Plateaux"
            };
        }
        if (codeAgentSlited[0].equals("2")) {
            regions = new String[]{
                    "Centrale"
            };
        }
        if (codeAgentSlited[0].equals("3")) {
            regions = new String[]{
                    "Kara"
            };
        }
        if (codeAgentSlited[0].equals("4")) {
            regions = new String[]{
                    "Savanes"
            };
        }

        regArrayAdapter = new SpinnerAdapter(
                this, R.layout.spinner_item, regions
        );

        regArrayAdapter.setDropDownViewResource(R.layout.spinner_item);

        region.setAdapter(regArrayAdapter);

        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSpinner("prefecture");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        prefecture.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSpinner("canton");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        canton.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSpinner("village");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Log", "May log");
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Log.d("Log", "May log");
            setResult(resultCode, data);
            finish();
        }
    }

    private void updateSpinner(String spinner) {
        if (spinner.equals("prefecture")) {
            switch (region.getSelectedItem().toString()) {
                case "Centrale":
                    preArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, preCentrale
                    );
                    break;
                case "Kara":
                    preArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, preKara
                    );
                    break;
                case "Plateaux":
                    preArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, prePlateaux
                    );
                    break;
                case "Savanes":
                    preArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, preSavanes
                    );
                    break;
                default:
            }
            preArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
            prefecture.setAdapter(preArrayAdapter);
        }

        if (spinner.equals("canton")) {
            switch (prefecture.getSelectedItem().toString()) {
                case "Blitta":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantBlitta
                    );
                    break;
                case "Sotouboua":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantSotouboua
                    );
                    break;
                case "Tchaoudjo":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantTchaoudjo
                    );
                    break;
                case "Tchamba":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantTchamba
                    );
                    break;
                case "Bassar":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantBassar
                    );
                    break;
                case "Dankpen":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantDankpen
                    );
                    break;
                case "Assoli":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantAssoli
                    );
                    break;
                case "Anié":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantAnie
                    );
                    break;
                case "Est-Mono":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantEstMono
                    );
                    break;
                case "Tône":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantTone
                    );
                    break;
                case "Kpendjal":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantKpendjal
                    );
                    break;
                case "Oti":
                    canArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, cantOti
                    );
                    break;
                default:
            }
            canArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
            canton.setAdapter(canArrayAdapter);
        }

        if (spinner.equals("village")) {
            switch (canton.getSelectedItem().toString()) {
                case "Blitta Gare":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villBlittaGare
                    );
                    break;
                case "Yaloumbè":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villYaloumbe
                    );
                    break;
                case "Tchaoudjo":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villBlittaGare
                    );
                    break;
                case "Waragni":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villWaragni
                    );
                    break;
                case "Adjengré":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villAdjengre
                    );
                    break;
                case "Fazao":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villFazao
                    );
                    break;
                case "Lama-Tessi":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villLamaTessi
                    );
                    break;
                case "Kpassouadè":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villKpassouade
                    );
                    break;
                case "Sagbadai":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villSagbadai
                    );
                    break;
                case "Kpangalam":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villKpangalam
                    );
                    break;
                case "Kparatao":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villKparatao
                    );
                    break;
                case "Balanka":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villBalanka
                    );
                    break;
                case "Alibi 1":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villAlibi1
                    );
                    break;
                case "Affem Boussou":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villAffemBoussou
                    );
                    break;
                case "Bangeli":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villBangeli
                    );
                    break;
                case "Guérin Kouka":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villGuerinKouka
                    );
                    break;
                case "Bafilo":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villBafilo
                    );
                    break;
                case "Soudou":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villSoudou
                    );
                    break;

                case "Adogbénou":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villAdogbenou
                    );
                    break;
                case "Atchinédji":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villAtchinedji
                    );
                    break;
                case "Anié":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villAnie
                    );
                    break;
                case "Kolocopé":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villKolocope
                    );
                    break;
                case "Glitto":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villGlitto
                    );
                    break;
                case "Gbadahè":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villGbadahe
                    );
                    break;
                case "N'yamassila":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villNyamassila
                    );
                    break;
                case "Elavagnon":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villElavagnon
                    );
                    break;
                case "Gbadincopé":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villGbadincope
                    );
                    break;
                case "Kamina":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villKamina
                    );
                    break;

                case "Bitchiengua":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villBitchiengua
                    );
                    break;
                case "Pana":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villPana
                    );
                    break;
                case "Ogaro":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villOgaro
                    );
                    break;
                case "NAKI-Est":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villNAKIEst
                    );
                    break;
                case "Nagbéni":
                    villArrayAdapter = new SpinnerAdapter(
                            this, R.layout.spinner_item, villNagbeni
                    );
                    break;
                default:
            }
            villArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
            village.setAdapter(villArrayAdapter);
        }
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
        Arbre arbre = new Arbre();

        arbre.setCodeArbre(code.getText().toString());
        arbre.setAge((int) age.getValue());
        arbre.setRegion(region.getSelectedItem().toString());
        arbre.setPrefecture(prefecture.getSelectedItem().toString());
        arbre.setVillage(village.getSelectedItem().toString());
        arbre.setCanton(canton.getSelectedItem().toString());
        arbre.setChoixMarquage(marquage.isChecked() ? 1 : 0);
        arbre.setCodeProducteur(producteur.getCodeProducteur());
        arbre.setIdProducteur(producteur.getIdProducteur());

        if (hauteur.getText().toString().equals("") | rayonnord.getText().toString().equals("")
                | rayonsud.getText().toString().equals("") | rayonest.getText().toString().equals("")
                | rayonouest.getText().toString().equals("") | origine.getText().toString().equals("")) {

        } else {
            arbre.setOrigineSemence(origine.getText().toString());
            arbre.setHauteur(Double.parseDouble(hauteur.getText().toString()));
            arbre.setRayonNord(Double.parseDouble(rayonnord.getText().toString()));
            arbre.setRayonSud(Double.parseDouble(rayonsud.getText().toString()));
            arbre.setRayonEst(Double.parseDouble(rayonest.getText().toString()));
            arbre.setRayonOuest(Double.parseDouble(rayonouest.getText().toString()));

            Intent intent = new Intent(this, EnregistrerAapeSuiteActivity.class);
            intent.putParcelableArrayListExtra("arbres", getProducteur().getArbres());
            intent.putExtra("producteur", getProducteur());
            intent.putExtra("arbre", arbre);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    public Producteur getProducteur() {
        return producteur;
    }

    public void setProducteur(Producteur producteur) {
        this.producteur = producteur;
    }
}
