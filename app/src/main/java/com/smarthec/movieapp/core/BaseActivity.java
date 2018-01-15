package com.smarthec.movieapp.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Jorge Henao on 11/01/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog waitDialog;

    private static final Integer SOLICITUD_PERMISOS_ACTIVIDAD = 2017;

    protected Boolean permisosRequeridosOtorgados = Boolean.TRUE;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bindViews();
        buildPresenter();

        initializeView();
        verificationPermission(getPermissionList());
    }

    /**
     * Verifica cada uno de los permisos y si alguno no es otorgado, se cierra la actividad
     *
     * @param permisosRequeridos
     */
    private void verificationPermission(List<String> permisosRequeridos){
        if(permisosRequeridos.size() > 0 && !permisosRequeridos.isEmpty()) {

            permisosRequeridosOtorgados = Boolean.FALSE;

            //Lista para los permisos no otorgados
            List<String> permisosNoOtorgados = new ArrayList<>();

            //Revisamos cuales de los permisos no estan otorgados
            for(String permiso : permisosRequeridos){
                if (ContextCompat.checkSelfPermission(this, permiso) != PackageManager.PERMISSION_GRANTED) {
                    permisosNoOtorgados.add(permiso);
                }
            }

            //Si hay permisos no otorgados, se solicita al usuario autorizacion
            if(!permisosNoOtorgados.isEmpty()){
                ActivityCompat.requestPermissions(
                        this,
                        permisosNoOtorgados.toArray(new String[permisosNoOtorgados.size()]),
                        SOLICITUD_PERMISOS_ACTIVIDAD);
            }else{
                //Todos los permisos requeridos estan otorgados
                permisosRequeridosOtorgados = Boolean.TRUE;
            }
        }else{
            permisosRequeridosOtorgados = Boolean.TRUE;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean todosPermisosFueronOtorgados = true;

        if(requestCode == SOLICITUD_PERMISOS_ACTIVIDAD){
            for(int resultado : grantResults){
                if(resultado == PackageManager.PERMISSION_DENIED){
                    todosPermisosFueronOtorgados = false;

                    showDialogMessage("Permisos no otorgados", "Usted debe dar acceso a todos los permisos requeridos");
                    break;
                }
            }
        }

        if(todosPermisosFueronOtorgados){
            permisosRequeridosOtorgados = Boolean.TRUE;
        }else{
            permisosRequeridosOtorgados = Boolean.FALSE;
        }
    }

    /**
     * Use este metodo para inicializar los componentes de la vista
     */
    public void initializeView() {}

    /**
     * Use este metodo para inicializar el objeto presenter de la vista actual
     */
    public void buildPresenter() {}

    /**
     * Metodo que activa el enlace de los controles con ButterKnife
     */
    private void bindViews() {
        ButterKnife.bind(this);
    }

    /**
     * @return El layout id que contiene toda la vista
     */
    protected abstract int getLayoutId();

    /**
     * Retorna la lista de permisos que necesita la actividad
     *
     * @return
     */
    protected List<String> getPermissionList(){
        return new ArrayList<>();
    }

    /**
     * Muestra un mensaje para notificar el resultado de una operacion
     *
     * @param textoMensaje
     */
    public void showMessageInformation(String textoMensaje){
        Toast.makeText(getApplicationContext(), textoMensaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Muestra una ventana con un mensaje de error
     *
     * @param tituloVentana
     * @param textoMensaje
     */
    public void showDialogMessage(String tituloVentana, String textoMensaje){
        //Se oculta el mensaje de espera si se esta visualizando
        hideWaitMessage();

        if(getApplicationContext() != null || !((Activity) getApplicationContext()).isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //No hacer nada
                }
            });

            builder.setTitle(tituloVentana);
            builder.setMessage(textoMensaje);
            AlertDialog currentDialog = builder.create();

            currentDialog.show();
        }
    }

    /**
     * Muestra un mensaje para indicar que hay un proceso actualmente en el sistema
     */
    public void showWaitMessage(String title, String message){
        if(waitDialog == null){
            waitDialog = new ProgressDialog(this);
            waitDialog.setTitle(title);
            waitDialog.setMessage(message);
            waitDialog.setIndeterminate(true);
            waitDialog.setCancelable(false);
            waitDialog.setCanceledOnTouchOutside(false);
            waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    onCancelCurrentTask(dialog);
                }
            });
        }else{
            waitDialog.setMessage(message);
        }

        if (!waitDialog.isShowing()){
            waitDialog.show();
        }
    }

    /**
     * Oculta el mensaje de espera que indicaba un procesos en curso
     */
    public void hideWaitMessage(){
        if(waitDialog != null && waitDialog.isShowing()){
            waitDialog.dismiss();
        }
    }

    protected void onCancelCurrentTask(DialogInterface dialog){
        //By default, close wait screen
        hideWaitMessage();
    }
}
