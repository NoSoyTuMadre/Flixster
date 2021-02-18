package com.codepath.tonifields.flixster.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    String basePath;
    String posterSize = "w342";
    String landscapePosterSize = "w780";

    public Movie(JSONObject jsonObject) throws JSONException {
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
    }

    public Movie(JSONObject jsonObject, Object object2) throws JSONException {
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
        this.basePath = object2.toString();
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray, JSONObject posterJsonObject) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i), posterJsonObject.get("secure_base_url")));
        }
        return movies;
    }

    public String getPosterPath() {
        return basePath + posterSize + posterPath;
    }

    public String getBackdropPath() {
        return basePath + landscapePosterSize + backdropPath;
    }
    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getPosterSize() {
        return posterSize;
    }
    public String getLandscapePosterSize() {
        return landscapePosterSize;
    }
}
