package com.smarthec.movieapp.activities.mainActivity.interfaces;

import android.widget.ImageView;

import com.smarthec.movieapp.dto.movies.MoviesListResponse;
import com.smarthec.movieapp.util.CallbackRetrofit;

import org.reactivestreams.Subscription;

/**
 * Created by Jorge Henao on 11/01/2018.
 */

public interface MainModel {

    /**
     * Realiza el llamado al servicio que trae la lista de peliculas populares
     *
     * @param callbackRetrofit
     * @return
     */
    void getPopularMovies(CallbackRetrofit<MoviesListResponse> callbackRetrofit);

    /**
     * Realiza el llamado al servicio que trae la lista de peliculas con mejor ranking
     *
     * @param callbackRetrofit
     * @return
     */
    void getTopRatedMoview(CallbackRetrofit<MoviesListResponse> callbackRetrofit);

    /**
     * Realiza el llamado al servicio que trae la lista de peliculas por estrenar
     *
     * @param callbackRetrofit
     * @return
     */
    void getUpcomingMovies(CallbackRetrofit<MoviesListResponse> callbackRetrofit);

    /**
     * Realiza las acciones necesaria con Picasso para descargar y mostrar la imagen de la película
     *
     * @param posterPath
     * @param movieImage
     */
    void setImageDish(String posterPath, ImageView movieImage);
}
