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

import com.example.examen_movilFinal.modelo.ItemViewdatavolumen;
import com.example.examen_movilFinal.modelo.datavolumen;

public class volumenes extends AppCompatActivity{

   String dato;
    private InfinitePlaceHolderView InfinitePlaceHolderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);
        InfinitePlaceHolderView = (InfinitePlaceHolderView)findViewById(R.id.volumenloadMoreView);
        dato= getIntent().getStringExtra("id");
        obtnerElementosVolumen();

    }
    public void obtnerElementosVolumen(){

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id="+dato;
        JSONObject nuevo = new JSONObject();
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i = 0; i < response.length(); i++) {
                        JSONObject row = response.getJSONObject(i);
                        datavolumen nuevo = new datavolumen();
                        nuevo.setTitle(row.getString("title"));
                        nuevo.setDate_published(row.getString("date_published"));
                        nuevo.setIssue_id(row.getString("issue_id"));
                        nuevo.setVolume(row.getString("volume"));
                        nuevo.setYear(row.getString("year"));
                        nuevo.setDoi(row.getString("doi"));
                        nuevo.setCover(row.getString("cover"));
                        nuevo.setNumber(row.getString("number"));
                        InfinitePlaceHolderView.addView(new ItemViewdatavolumen(getApplicationContext(),nuevo));

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