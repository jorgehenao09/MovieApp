package com.smarthec.movieapp.activities.mainActivity;

import android.widget.ImageView;

import com.smarthec.movieapp.activities.mainActivity.interfaces.MainModel;
import com.smarthec.movieapp.activities.mainActivity.interfaces.MainView;
import com.smarthec.movieapp.dto.movies.MoviesListResponse;
import com.smarthec.movieapp.util.CallbackRetrofit;

import org.reactivestreams.Subscription;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Jorge Henao on 11/01/2018.
 */

public class MainPresenter {

    private MainView mView;
    private MainModel mModel;

    public MainPresenter(MainView view, MainModel model) {
        this.mView = view;
        this.mModel = model;
    }

    /**
     * Ordena al interactor llamar el servicio que trae la lista de peliculas populares
     */
    public void getPopularMovies() {

        //llamado asíncrono con Retrofit y RxJava
       mModel.getPopularMovies(new CallbackRetrofit<MoviesListResponse>() {
            @Override
            public void onResponse(MoviesListResponse result) {
                //Se esconde el progressBar de la seccion popular
                mView.hideProgressPopular();

                //Se verifica que el listado no este vacio
                if (result.getResults() != null && !result.getResults().isEmpty()){

                    //Se llena el recycler con la lista de peliculas populares
                    mView.fillDataPopular(result.getResults());

                } else {

                    //Se muestra el indicador de datos vacios en la seccion popular
                    mView.showIndicatorPopular();
                }
            }

            @Override
            public void onFailure(Throwable error) {

                //Se esconde el progressBar de la seccion topRated
                mView.hideProgressPopular();

                //Se muestra el indicador de datos vacios en la seccion topRated
                mView.showIndicatorPopular();
            }
        });
    }

    /**
     * Ordena al interactor llamar el servicio que trae la lista de peliculas con mejor calificación
     */
    public void getTopRatedMovies() {

        //llamado asíncrono con Retrofit y RxJava
        mModel.getTopRatedMoview(new CallbackRetrofit<MoviesListResponse>() {
            @Override
            public void onResponse(MoviesListResponse result) {

                //Se esconde el progressBar de la seccion topRated
                mView.hideProgressTopRated();

                //Se verifica que el listado no este vacio
                if (result.getResults() != null && !result.getResults().isEmpty()){

                    //Se llena el recycler con la lista de peliculas con mejor ranking
                    mView.fillDataTopRated(result.getResults());

                } else {

                    //Se muestra el indicador de datos vacios en la seccion topRated
                    mView.showIndicatorTopRated();
                }
            }

            @Override
            public void onFailure(Throwable error) {

                //Se esconde el progressBar de la seccion topRated
                mView.hideProgressTopRated();

                //Se muestra el indicador de datos vacios en la seccion topRated
                mView.showIndicatorTopRated();
            }
        });
    }

    /**
     * Ordena al interactor llamar el servicio que trae la lista de peliculas
     */
    public void getUpcoming() {

        //llamado asíncrono con Retrofit y RxJava
        mModel.getUpcomingMovies(new CallbackRetrofit<MoviesListResponse>() {
            @Override
            public void onResponse(MoviesListResponse result) {

                //Se esconde el progressBar de la seccion upcoming
                mView.hideProgressUpcoming();

                //Se verifica que el listado no este vacio
                if (result.getResults() != null && !result.getResults().isEmpty()){

                    //Se llena el recycler con la lista de peliculas estreno
                    mView.fillDataUpcoming(result.getResults());

                } else {

                    //Se muestra el indicador de datos vacios en la seccion upcoming
                    mView.showIndicatorUpcoming();
                }
            }

            @Override
            public void onFailure(Throwable error) {

                //Se esconde el progressBar de la seccion upcoming
                mView.hideProgressUpcoming();

                //Se muestra el indicador de datos vacios en la seccion upcoming
                mView.showIndicatorUpcoming();
            }
        });
    }

    /**
     * Metodo que ordena al interactor mostrar la imagen de la película dada la url
     *
     * @param posterPath
     * @param movieImage
     */
    public void setImageMovie(String posterPath, ImageView movieImage) {
        mModel.setImageDish(posterPath, movieImage);
    }

    /**
     * Libera las instancias del view y del model
     */
    public void onDestroy() {

        mView = null;
        mModel = null;
    }
}
