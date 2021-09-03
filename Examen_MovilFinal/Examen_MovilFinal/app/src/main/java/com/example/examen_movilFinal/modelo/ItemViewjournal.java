package com.example.examen_movilFinal.modelo;


import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import com.example.examen_movilFinal.R;
import com.example.examen_movilFinal.volumenes;

@Layout(R.layout.loadmoreitemview)
public class ItemViewjournal {

    @View(R.id.titleTxt)
    private TextView Txttitle;
    @View(R.id.captionTxt)
    private TextView Txtcaption;
    @View(R.id.timeTxt)
    private TextView Txttime;
    @View(R.id.imageView)
    private ImageView imageView;
    private journal mInfo;
    private Context Context;
    public ItemViewjournal(Context context, journal info) {
        Context = context;
        mInfo = info;
    }
    @Resolve
    private void onResolved() {
        Txttitle.setText(mInfo.getName());
        Txtcaption.setText(mInfo.getAbbreviation());
        Txttime.setText(mInfo.getDescription());
        Glide.with(Context).load(mInfo.getPortada()).into(imageView);
    }
    @Click(R.id.root)
    public void onCardClick() {
        Intent intent = new Intent(Context, volumenes.class);
        intent.putExtra("id", mInfo.getJournal_id());
        Context.startActivity(intent);
    }


}
