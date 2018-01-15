package com.smarthec.movieapp.activities.mainActivity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.smarthec.movieapp.R;
import com.smarthec.movieapp.activities.mainActivity.interfaces.MainModel;
import com.smarthec.movieapp.activities.mainActivity.interfaces.MainView;
import com.smarthec.movieapp.adapters.RecyclerMovieAdapter;
import com.smarthec.movieapp.core.BaseActivity;
import com.smarthec.movieapp.dto.movies.DataMovies;

import java.util.List;

import butterknife.BindView;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view) NavigationView mNavigationView;

    @BindView(R.id.main_recycler_popular) RecyclerView mRecyclerPopular;
    @BindView(R.id.main_recycler_top_rated) RecyclerView mRecyclerTopRated;
    @BindView(R.id.main_recycler_upcoming) RecyclerView mRecyclerUpcoming;

    @BindView(R.id.main_progress_popular) ProgressBar mProgressPopular;
    @BindView(R.id.main_progress_top_rated) ProgressBar mProgressTopRated;
    @BindView(R.id.main_progress_upcoming) ProgressBar mProgressUncoming;

    @BindView(R.id.main_popular_content_empty_data) LinearLayout mPopularEmptyData;
    @BindView(R.id.main_top_rated_content_empty_data) LinearLayout mTopRatedEmptyData;
    @BindView(R.id.main_upcoming_content_empty_data) LinearLayout mUpcomingEmptyData;

    private MainPresenter mPresenter;

    /**
     * {@inheritDoc}
     */
    @Override
    public void buildPresenter() {
        super.buildPresenter();

        MainModel model = new MainModelImpl(getApplicationContext());

        mPresenter = new MainPresenter(this, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initializeView() {
        super.initializeView();

        setToolbar();

        //Se obtienen los listados de las peliculas. Populares, mejor ranking y estrenos
        mPresenter.getPopularMovies();
        mPresenter.getTopRatedMovies();
        mPresenter.getUpcoming();
    }

    /**
     * @return El layout id que contiene toda la vista
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * Modifica los componentes utilizados en la toolbar
     */
    private void setToolbar() {
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_popular) {
            // Handle the camera action
        } else if (id == R.id.nav_top_rated) {

        } else if (id == R.id.nav_uncoming) {

        } else if (id == R.id.nav_close_app) {
            closeApplication();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Acciones realizadas al momento de dar clic en la opcion cerrar sesion
     *
     */
    private void closeApplication() {

        //Se muestra una ventana de dialogo
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    //Acciones realizadas al momento de dar clic en SI
                    case DialogInterface.BUTTON_POSITIVE:
                        finish();
                        break;

                    //Acciones realizadas al momento de dar clic en NO
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        //Se construye la ventana de dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MovieAlertDialogCustom);
        builder.setTitle(R.string.title_close).setMessage(R.string.information_warning_logout).setPositiveButton(R.string.btn_yes, dialogClickListener)
                .setNegativeButton(R.string.btn_no, dialogClickListener).show();
    }

    /**
     * Esconde el indicador progressBar de la seccion popular
     */
    @Override
    public void hideProgressPopular() {
        mProgressPopular.setVisibility(View.GONE);
    }

    /**
     * Esconde el indicador progressBar de la seccion topRated
     */
    @Override
    public void hideProgressTopRated() {
        mProgressTopRated.setVisibility(View.GONE);
    }

    /**
     * Esconde el indicador progressBar de la seccion uncoming
     */
    @Override
    public void hideProgressUpcoming() {
        mProgressUncoming.setVisibility(View.GONE);
    }

    /**
     * Muestra el listado de peliculas populares
     *
     * @param results
     */
    @Override
    public void fillDataPopular(List<DataMovies> results) {

        //Se modifica el recycler de platos
        mRecyclerPopular.setHasFixedSize(true);
        mRecyclerPopular.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        RecyclerMovieAdapter adapter = new RecyclerMovieAdapter(results, getApplicationContext(), this);

        mRecyclerPopular.setAdapter(adapter);
    }

    /**
     * Muestra el listado de peliculas con mejor ranking
     *
     * @param results
     */
    @Override
    public void fillDataTopRated(List<DataMovies> results) {

    }

    /**
     * Muestra el listado de peliculas a estrenar
     *
     * @param results
     */
    @Override
    public void fillDataUpcoming(List<DataMovies> results) {
    }

    /**
     * Muestra el indicador de lista vacia en la seccion popular
     */
    @Override
    public void showIndicatorPopular() {
        //Se esconde el recycler
        mRecyclerPopular.setVisibility(View.GONE);

        //Se muestra el indicador
        mPopularEmptyData.setVisibility(View.VISIBLE);
    }

    /**
     * Muestra el indicador de lista vacia en la seccion top rated
     */
    @Override
    public void showIndicatorTopRated() {
        //Se esconde el recycler
        mRecyclerTopRated.setVisibility(View.GONE);

        //Se muestra el indicador
        mTopRatedEmptyData.setVisibility(View.VISIBLE);
    }

    /**
     * Muestra el indicador de lista vacia en la seccion upcoming
     */
    @Override
    public void showIndicatorUpcoming() {
        //Se esconde el recycler
        mRecyclerUpcoming.setVisibility(View.GONE);

        //Se muestra el indicador
        mUpcomingEmptyData.setVisibility(View.VISIBLE);
    }

    /**
     * Agrega la imagen correspondiente de la película al contenedor de la tarjeta
     *
     * @param posterPath
     * @param movieImage
     */
    @Override
    public void setImageMovie(String posterPath, ImageView movieImage) {
        mPresenter.setImageMovie(posterPath, movieImage);
    }

    /**
     * Realiza las acciones necesarias para mostrar la pantalla de detalle pelicula
     *
     * @param dataMovies
     */
    @Override
    public void launchIntentDetails(DataMovies dataMovies) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }
}
