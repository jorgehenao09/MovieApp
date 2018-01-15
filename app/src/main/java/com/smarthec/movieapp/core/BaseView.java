package com.smarthec.movieapp.core;

/**
 * Created by Jorge Henao on 11/01/2018.
 */

public interface BaseView {

    /**
     * Muestra un mensaje de espera en la pantalla mientras se realiza el procesamiento
     */
    void showWaitMessage(String title, String message);

    /**
     * Oculta el mensaje de espera
     */
    void hideWaitMessage();

    /**
     * Muestra una ventana con un mensaje de error
     *
     * @param title
     * @param message
     */
    void showDialogMessage(String title, String message);

    /**
     * Muestra un mensaje para notificar el resultado de una operacion
     *
     * @param textoMensaje
     */
    void showMessageInformation(String textoMensaje);
}
