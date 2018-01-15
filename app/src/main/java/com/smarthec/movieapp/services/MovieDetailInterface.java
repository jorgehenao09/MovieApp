package com.smarthec.movieapp.services;

import com.smarthec.movieapp.dto.detail.MovieDetailResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jorge Henao on 14/01/2018.
 */

public interface MovieDetailInterface {

    @GET("movie/{id}")
    Observable<MovieDetailResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
