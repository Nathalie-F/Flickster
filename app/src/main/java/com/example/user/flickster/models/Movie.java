package com.example.user.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Movie {


    String posterPath;
    String backdropPath;
    String originalTitle;
    String overview;
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w1280/%s",backdropPath);
    }


        public Movie(JSONObject jsonObject)throws JSONException {
            this.backdropPath = jsonObject.getString("backdrop_path");
            this.posterPath = jsonObject.getString("poster_path");
            this.originalTitle = jsonObject.getString("original_title");
            this.overview = jsonObject.getString("overview");

        }

        public static ArrayList<Movie> fromJSONArray(JSONArray array){
            ArrayList<Movie> results = new ArrayList<>();
            for(int x = 0 ; x < array.length(); x++){
                try {
                    results.add(new Movie(array.getJSONObject(x)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return results;
    }
}
