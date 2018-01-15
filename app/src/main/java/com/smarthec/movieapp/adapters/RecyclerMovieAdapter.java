package com.smarthec.movieapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.smarthec.movieapp.R;
import com.smarthec.movieapp.activities.mainActivity.interfaces.MainView;
import com.smarthec.movieapp.dto.movies.DataMovies;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jorge Henao on 14/01/2018.
 */

public class RecyclerMovieAdapter extends RecyclerView.Adapter<RecyclerMovieAdapter.PopularViewHolder> {

    private List<DataMovies> mMoviesList;
    private Context mContext;
    private MainView mView;

    public RecyclerMovieAdapter(List<DataMovies> moviesList, Context context, MainView view) {
        mMoviesList = moviesList;
        mContext = context;
        mView = view;
    }

    /**
     * Este metodo asocia el layout item_recycler_movie.xml con el recyclerView (infla el layout)
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_movie, parent, false);

        return new PopularViewHolder(view);
    }

    /**
     * Este metodo modifica los elementos de la clase AddressViewHolder con respecto a cada objeto de la lista items
     *
     * @param popularViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(PopularViewHolder popularViewHolder, int position) {
        final DataMovies dataMovies = mMoviesList.get(position);

        //Se descarga la imagen de la película
        mView.setImageMovie(dataMovies.getPosterPath(), popularViewHolder.mMovieImage);

        //Se hace la correlación de datos
        popularViewHolder.mMovieName.setText(dataMovies.getTitle());
        popularViewHolder.mMovieLanguage.setText(dataMovies.getOriginalLanguage());
        popularViewHolder.mMovieCount.setText(String.valueOf(dataMovies.getVoteCount()) + " votos");
        popularViewHolder.mMovieDate.setText(dataMovies.getReleaseDate());
        popularViewHolder.mMovieRating.setProgress(Float.valueOf(String.valueOf(dataMovies.getVoteAverage())).intValue());

        //Acciones realizadas al momento de dar clic sobre la tarjeta
        popularViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mView.launchIntentDetails(dataMovies);
            }
        });
    }

    /**
     * Cantidad de elementos que contiene la lista
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder {

        private View view;

        @BindView(R.id.movie_image) ImageView mMovieImage;

        @BindView(R.id.movie_name) TextView mMovieName;
        @BindView(R.id.movie_language) TextView mMovieLanguage;
        @BindView(R.id.movie_count) TextView mMovieCount;
        @BindView(R.id.movie_date) TextView mMovieDate;

        @BindView(R.id.movie_rating) RatingBar mMovieRating;

        public PopularViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }
    }
}
