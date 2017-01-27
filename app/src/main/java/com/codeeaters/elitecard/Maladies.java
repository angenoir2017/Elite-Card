package com.codeeaters.elitecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Maladies extends AppCompatActivity implements View.OnClickListener {

    Spinner maladie;
    Spinner insecte;
    EditText observation;
    Button enrergistrer;
    String nommaladie;
    String nominsecte;
    String obs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maladies);
        maladie=(Spinner)findViewById(R.id.maladie_deroulant);
        insecte=(Spinner)findViewById(R.id.insecte_deroulant);
        observation=(EditText)findViewById(R.id.observationsmaux);
        enrergistrer=(Button)findViewById(R.id.enregistrermaladiebtn);
        enrergistrer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nominsecte=insecte.getSelectedItem().toString();
        nommaladie=maladie.getSelectedItem().toString();
        obs=observation.getText().toString();
    }
}
