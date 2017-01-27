package com.codeeaters.elitecard.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.codeeaters.elitecard.database.entities.Producteur;

import java.util.ArrayList;

/**
 * Created by leinad on 1/17/17 1:19 AM.
 */

public class ProducteurAdapter extends RecyclerView.Adapter<ProducteurAdapter.ProducteurViewHolder> {

    private Context context;
    private ArrayList<Producteur> producteurs;

    public ProducteurAdapter(ArrayList<Producteur> producteurs, Context context) {
        this.context = context;
        this.producteurs = producteurs;
    }

    public void update(ArrayList<Producteur> producteurs){
        this.producteurs.clear();
        for (Producteur producteur :
                producteurs) {
            this.producteurs.add(producteur);
        }
        notifyDataSetChanged();
    }

    @Override
    public ProducteurViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProducteurViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ProducteurViewHolder holder, int position) {
        Producteur producteur = this.producteurs.get(position);

        holder.code.setText(producteur.getCodeProducteur());
        holder.reigon.setText(producteur.getRegion());
        holder.prefecture.setText(producteur.getPrefecture());
        holder.canton.setText(producteur.getCanton());
        holder.village.setText(producteur.getVillage());
        holder.setProducteur(producteur);
    }

    @Override
    public int getItemCount() {
        return this.producteurs.size();
    }

    public class ProducteurViewHolder extends RecyclerView.ViewHolder {

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
        public Producteur producteur;

        public ProducteurViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));

            Typeface ubuntuCondenced = Typeface.createFromAsset(context.getAssets(), "fonts/PoiretOne-Regular.ttf");

            tcode = (TextView) itemView.findViewById(R.id.textView1cardPro);
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
                    Log.d("ListArbres", getProducteur().getCodeProducteur() + " Producteur Arbres Size " + getProducteur().getArbres().size());
                    Intent intent = new Intent(context, ListArbresActivity.class);
                    intent.putParcelableArrayListExtra("arbres", getProducteur().getArbres());
                    intent.putExtra("producteur", getProducteur());
                    context.startActivity(intent);
                }
            });
        }

        public void setProducteur(Producteur producteur) {
            this.producteur = producteur;
        }

        public Producteur getProducteur() {
            return this.producteur;
        }
    }
}
