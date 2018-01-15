package com.smarthec.movieapp.services;

import com.smarthec.movieapp.dto.movies.MoviesListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jorge Henao on 14/01/2018.
 */

public interface MoviesInterface {

    /**
     * Obtiene el listado de películas populares
     *
     * @param apiKey
     * @return
     */
    @GET("movie/popular")
    Observable<MoviesListResponse> getPopularMovies(@Query("api_key") String apiKey);

    /**
     * Obtiene el listado de peliculas mejor puntuadas
     *
     * @param apiKey
     * @return
     */
    @GET("movie/top_rated")
    Observable<MoviesListResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    /**
     * Obtiene el listado de peliculas proximas a estrenar
     *
     * @param apiKey
     * @return
     */
    @GET("movie/upcoming")
    Observable<MoviesListResponse> getUpcomingMovies(@Query("api_key") String apiKey);
}
