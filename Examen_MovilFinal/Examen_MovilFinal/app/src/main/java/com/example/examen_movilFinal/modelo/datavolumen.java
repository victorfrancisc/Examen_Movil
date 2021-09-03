package com.example.examen_movilFinal.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class datavolumen {
    private  String issue_id;
    private String volume;
    private String number;
    private String year;
    private String date_published;
    private String title;
    private String doi;
    private String cover;
    public datavolumen()
    {

    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public datavolumen(String issue_id, String volume, String number, String year, String date_published, String title, String doi, String cover) {


        this.issue_id = issue_id;
        this.volume = volume;
        this.number = number;
        this.year = year;
        this.date_published = date_published;
        this.title = title;
        this.doi = doi;
        this.cover = cover;
    }
    public static ArrayList<datavolumen> JsonObjectsBuild(String xx) throws JSONException {
        ArrayList<datavolumen> volumen = new ArrayList<>();
        JSONArray datos = new JSONArray(xx);
        for (int i = 0; i < datos.length() ; i++) {
            JSONObject data = datos.getJSONObject(i);
            String issue_id = data.getString("issue_id") ;
            String volume =  data.getString("volume");
            String number  =  data.getString("number") ;
            String  year  =  data.getString("year");
            String  date_published  =  data.getString("date_published") ;
            String title  =  data.getString("title");
            String doi  =  data.getString("doi") ;
            String cover  =  data.getString("cover") ;
            volumen.add(new datavolumen(issue_id,volume,number,year,date_published,title,doi,cover));
        }
        return volumen;
    }
}
