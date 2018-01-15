package com.smarthec.movieapp.activities.mainActivity.interfaces;

import android.widget.ImageView;

import com.smarthec.movieapp.core.BaseView;
import com.smarthec.movieapp.dto.movies.DataMovies;

import java.util.List;

/**
 * Created by Jorge Henao on 11/01/2018.
 */

public interface MainView extends BaseView{

    /**
     * Esconde el indicador progressBar de la seccion popular
     */
    void hideProgressPopular();

    /**
     * Esconde el indicador progressBar de la seccion topRated
     */
    void hideProgressTopRated();

    /**
     * Esconde el indicador progressBar de la seccion uncoming
     */
    void hideProgressUpcoming();

    /**
     * Muestra el listado de peliculas populares
     *
     * @param results
     */
    void fillDataPopular(List<DataMovies> results);

    /**
     * Muestra el listado de peliculas con mejor ranking
     *
     * @param results
     */
    void fillDataTopRated(List<DataMovies> results);

    /**
     * Muestra el listado de peliculas a estrenar
     *
     * @param results
     */
    void fillDataUpcoming(List<DataMovies> results);

    /**
     * Muestra el indicador de lista vacia en la seccion popular
     */
    void showIndicatorPopular();

    /**
     * Muestra el indicador de lista vacia en la seccion top rated
     */
    void showIndicatorTopRated();

    /**
     * Muestra el indicador de lista vacia en la seccion upcoming
     */
    void showIndicatorUpcoming();

    /**
     * Agrega la imagen correspondiente de la película al contenedor de la tarjeta
     *
     * @param posterPath
     * @param movieImage
     */
    void setImageMovie(String posterPath, ImageView movieImage);

    /**
     * Realiza las acciones necesarias para mostrar la pantalla de detalle pelicula
     *
     * @param dataMovies
     */
    void launchIntentDetails(DataMovies dataMovies);
}
