package com.smarthec.movieapp.util;

/**
 * Interfaz para definir las acciones a realizar despues de obtener respuesta de un llamado a Retrofit
 *
 * Created by Jorge Henao on 14/01/2018.
 */
public interface CallbackRetrofit<T> {

    /**
     * Accion a realizar cuando se obtuvo una respuesta del servidor
     *
     * @param result
     */
    void onResponse(T result);

    /**
     * Accion a realizar cuando ha ocurrido un error
     *
     * @param error
     */
    void onFailure(Throwable error);
}
