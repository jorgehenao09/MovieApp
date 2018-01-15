package com.smarthec.movieapp.activities.mainActivity;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.smarthec.movieapp.R;
import com.smarthec.movieapp.activities.mainActivity.interfaces.MainModel;
import com.smarthec.movieapp.constants.Provider;
import com.smarthec.movieapp.dto.movies.MoviesListResponse;
import com.smarthec.movieapp.services.MoviesInterface;
import com.smarthec.movieapp.util.CallbackRetrofit;
import com.smarthec.movieapp.util.Util;
import com.squareup.picasso.Picasso;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.functions.Function;

/**
 * Created by Jorge Henao on 11/01/2018.
 */

public class MainModelImpl implements MainModel{

    private Context mContext;
    private MoviesInterface mMoviesInterface;

    public MainModelImpl(Context context) {
        this.mContext = context;
    }

    /**
     * Realiza el llamado al servicio que trae la lista de peliculas populares
     *
     * @param callbackRetrofit
     * @return
     */
    @Override
    public void getPopularMovies(final CallbackRetrofit<MoviesListResponse> callbackRetrofit) {

        mMoviesInterface = Util.getClient().create(MoviesInterface.class);

        //LLamado asíncrono
        Observable<MoviesListResponse> observable = mMoviesInterface.getPopularMovies(Provider.PROVIDER_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends MoviesListResponse>>() {
                    @Override
                    public ObservableSource<? extends MoviesListResponse> apply(Throwable throwable) throws Exception {
                        return Observable.error(throwable);
                    }
                });

        observable.subscribe(new Observer<MoviesListResponse>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoviesListResponse moviesListResponse) {
                        //Respuesta al presenter
                        callbackRetrofit.onResponse(moviesListResponse);
                    }

                    @Override
                    public void onError(Throwable error) {
                        //Respuesta al presenter
                        callbackRetrofit.onFailure(error);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * Realiza el llamado al servicio que trae la lista de peliculas con mejor ranking
     *
     * @param callbackRetrofit
     * @return
     */
    @Override
    public void getTopRatedMoview(CallbackRetrofit<MoviesListResponse> callbackRetrofit) {

    }

    /**
     * Realiza el llamado al servicio que trae la lista de peliculas por estrenar
     *
     * @param callbackRetrofit
     * @return
     */
    @Override
    public void getUpcomingMovies(CallbackRetrofit<MoviesListResponse> callbackRetrofit) {

    }

    /**
     * Realiza las acciones necesaria con Picasso para descargar y mostrar la imagen de la película
     *
     * @param posterPath
     * @param movieImage
     */
    @Override
    public void setImageDish(String posterPath, ImageView movieImage) {
        //Se obtiene la imagen desde la URL
        Picasso.with(mContext)
                .load(Provider.URL_IMAGE + posterPath)
                .placeholder(R.drawable.default_movie)
                .into(movieImage);
    }
}
