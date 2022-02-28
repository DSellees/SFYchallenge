package com.example.sfychallenge.api;

import com.example.sfychallenge.models.PhotoRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashApiService {

    @GET("/search/photos")
    Call<PhotoRespuesta> obtenerListaPhotos(@Query("query") String query, @Query("client_id") String clientID, @Query("per_page") int number);

}
