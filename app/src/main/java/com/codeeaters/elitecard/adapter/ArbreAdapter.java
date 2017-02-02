package com.codeeaters.elitecard.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codeeaters.elitecard.R;
import com.codeeaters.elitecard.activity.EnregistrementAapeActivity;
import com.codeeaters.elitecard.activity.ListArbresActivity;
import com.codeeaters.elitecard.activity.MapActivity;
import com.codeeaters.elitecard.activity.VisiteFloraisonActivity;
import com.codeeaters.elitecard.database.entities.Arbre;
import com.codeeaters.elitecard.database.entities.Producteur;

import java.util.ArrayList;

/**
 * Created by leinad on 1/21/17 8:56 AM.
 */

public class ArbreAdapter extends RecyclerView.Adapter<ArbreAdapter.ArbreViewHolder> {

    private Context context;
    private ArrayList<Arbre> arbres;

    public ArbreAdapter(ArrayList<Arbre> arbres, Context context) {
        this.context = context;
        this.arbres = arbres;
    }

    public void update(ArrayList<Arbre> arbres) {
        this.arbres.clear();
        for (Arbre arbre :
                arbres) {
            this.arbres.add(arbre);
        }
        notifyDataSetChanged();
    }

    @Override
    public ArbreAdapter.ArbreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArbreViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ArbreAdapter.ArbreViewHolder holder, int position) {
        Arbre arbre = this.arbres.get(position);
        holder.code.setText(arbre.getCodeArbre());
        holder.reigon.setText(arbre.getRegion());
        holder.prefecture.setText(arbre.getPrefecture());
        holder.canton.setText(arbre.getCanton());
        holder.village.setText(arbre.getVillage());
    }

    @Override
    public int getItemCount() {
        return this.arbres.size();
    }

    public class ArbreViewHolder extends RecyclerView.ViewHolder {

        public TextView tcode;
        public TextView treigon;
        public TextView tprefecture;
        public TextView tcanton;
        public TextView tvillage;

        public TextView code;
        public TextView reigon;
        public TextView prefecture;
        public TextView canton;
        public TextView village;

        public ArbreViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));

            Typeface ubuntuCondenced = Typeface.createFromAsset(context.getAssets(), "fonts/PoiretOne-Regular.ttf");

            tcode = (TextView) itemView.findViewById(R.id.textView1cardPro);
            tcode.setText("Code de l'arbre");
            treigon = (TextView) itemView.findViewById(R.id.textView2cardPro);
            tprefecture = (TextView) itemView.findViewById(R.id.textView3cardPro);
            tcanton = (TextView) itemView.findViewById(R.id.textView4cardPro);
            tvillage = (TextView) itemView.findViewById(R.id.textView5cardPro);

            code = (TextView) itemView.findViewById(R.id.card_arb_code);
            reigon = (TextView) itemView.findViewById(R.id.card_arb_region);
            prefecture = (TextView) itemView.findViewById(R.id.card_arb_prefecture);
            canton = (TextView) itemView.findViewById(R.id.card_arb_canton);
            village = (TextView) itemView.findViewById(R.id.card_arb_village);

            code.setTypeface(ubuntuCondenced);
            reigon.setTypeface(ubuntuCondenced);
            prefecture.setTypeface(ubuntuCondenced);
            canton.setTypeface(ubuntuCondenced);
            village.setTypeface(ubuntuCondenced);

            tcode.setTypeface(ubuntuCondenced);
            treigon.setTypeface(ubuntuCondenced);
            tprefecture.setTypeface(ubuntuCondenced);
            tcanton.setTypeface(ubuntuCondenced);
            tvillage.setTypeface(ubuntuCondenced);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(MapActivity.AGENT_PREFERENCES, Context.MODE_PRIVATE);
                    if (sharedPreferences.getBoolean("isVisite", Boolean.FALSE)) {
                        Intent intent = new Intent(context, VisiteFloraisonActivity.class);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}