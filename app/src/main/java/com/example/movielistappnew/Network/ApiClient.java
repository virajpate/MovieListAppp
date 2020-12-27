package com.example.movielistappnew.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL="https://api.themoviedb.org/3/";
    private String API_KEY="52a18783ed514602a5facb15a0177e61";
    private static final String LANGUAGE = "en-US";
    int page=1;

    public static Retrofit retrofit=null;

    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";


    public static Retrofit getClient(){

        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .build();
        }
        return retrofit;
    }

}
