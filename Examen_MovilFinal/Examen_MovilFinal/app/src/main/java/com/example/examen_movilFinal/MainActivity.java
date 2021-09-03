package com.example.examen_movilFinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.mindorks.placeholderview.InfinitePlaceHolderView;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.examen_movilFinal.modelo.ItemViewjournal;
import com.example.examen_movilFinal.modelo.journal;

public class MainActivity extends AppCompatActivity{

    private InfinitePlaceHolderView InfinitePlaceHolderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InfinitePlaceHolderView = (InfinitePlaceHolderView) findViewById(R.id.loadMoreView);
        obtnerElementosJournail() ;
    }
    public void obtnerElementosJournail() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://revistas.uteq.edu.ec/ws/journals.php";
        JSONObject nuevo = new JSONObject();
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject row = response.getJSONObject(i);
                        journal nuevo = new journal();
                        nuevo.setJournal_id(row.getString("journal_id"));
                        nuevo.setName(row.getString("name"));
                        nuevo.setDescription(row.getString("description").replaceAll("[<p><strong></strong>]", ""));
                        nuevo.setPortada(row.getString("portada"));
                        InfinitePlaceHolderView.addView(new ItemViewjournal(getApplicationContext(), nuevo));

                    }

                } catch (Exception e) {
                }

            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);


    }




}