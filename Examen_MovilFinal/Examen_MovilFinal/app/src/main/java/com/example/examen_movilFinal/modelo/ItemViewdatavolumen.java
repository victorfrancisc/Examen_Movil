package com.example.examen_movilFinal.modelo;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import com.example.examen_movilFinal.R;

@Layout(R.layout.loadmoreitemview)
public class ItemViewdatavolumen {

    @View(R.id.titleTxt)
    private TextView Txttitle;

    @View(R.id.captionTxt)
    private TextView Txtcaption;

    @View(R.id.timeTxt)
    private TextView Txttime;

    @View(R.id.imageView)
    private ImageView imageView;

    private datavolumen mInfovo;
    private Context Context;

    public ItemViewdatavolumen(Context context, datavolumen info) {
        Context = context;
        mInfovo = info;
    }

    @Resolve
    private void onResolved() {
        Txttitle.setText(mInfovo.getTitle());
        Txtcaption.setText(mInfovo.getDate_published());
        Txttime.setText(mInfovo.getVolume());
        Glide.with(Context).load(mInfovo.getCover()).into(imageView);
    }



}
