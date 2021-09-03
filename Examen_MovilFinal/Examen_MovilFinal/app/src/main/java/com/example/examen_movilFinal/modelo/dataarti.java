package com.example.examen_movilFinal.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class dataarti {
    public String  title;
    public  String autores;
    public String year;
    public String url;

    public dataarti(String title, String autor, String year, String url) {
        this.title = title;
        this.autores = autor;
        this.year = year;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getAño() {
        return year;
    }

    public void setAño(String año) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public static ArrayList<dataarti> JsonObjectsBuild(String dato) throws JSONException {
        ArrayList<dataarti> volu = new ArrayList<>();
        JSONArray datosjso = new JSONArray(dato);

        for (int i = 0; i < datosjso.length() ; i++) {
            JSONObject dataResivi = datosjso.getJSONObject(i);
            String title = dataResivi.getString("title") ;
            String year  =  dataResivi.getString("date_published") ;
            JSONArray galeys =  dataResivi.getJSONArray("galeys");
            JSONObject galeysob = galeys.getJSONObject(0);
            String urls = galeysob.getString("UrlViewGalley");
            JSONArray autho =  dataResivi.getJSONArray("authors");
            String aux="";
            for (int j=0;j<autho.length();j++){
                JSONObject authorsobject = autho.getJSONObject(j);
                aux= aux+", "+ authorsobject.getString("nombres");
            }
            volu.add(new dataarti(title,aux,year,urls));
        }
        return volu;
    }
}
