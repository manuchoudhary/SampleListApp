package com.example.samplelistapp.adapter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.example.samplelistapp.R;
import com.example.samplelistapp.app.AppController;
import com.example.samplelistapp.main_activity.RecyclerItemClickListener;
import com.example.samplelistapp.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;
    ImageLoader imageLoader;

    public MovieAdapter(List<Movie> dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
        imageLoader = AppController.getInstance().getImageLoader();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_card, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final MovieViewHolder viewHolder = holder;
        if (!TextUtils.isEmpty(dataList.get(position).getTitle())) {
            viewHolder.movieName.setText(dataList.get(position).getTitle());
            viewHolder.releaseDate.setText(dataList.get(position).getReleaseDate());
            if(dataList.get(position).isAdult()) {
                viewHolder.adult.setText("A");
            }else{
                viewHolder.adult.setText("U/A");
            }
            viewHolder.moviePic.setImageUrl("https://image.tmdb.org/t/p/original" + dataList.get(position).getImage(), imageLoader);
            viewHolder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerItemClickListener.onItemClick(dataList.get(position));
                }
            });
        } else {
            viewHolder.movieName.setVisibility(View.GONE);
            viewHolder.releaseDate.setVisibility(View.GONE);
            viewHolder.adult.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView movieName, releaseDate, adult;
        com.android.volley.toolbox.NetworkImageView moviePic;
        CardView card;

        MovieViewHolder(View itemView) {
            super(itemView);
            this.card = itemView.findViewById(R.id.card_view);
            this.movieName = itemView.findViewById(R.id.movieName);
            this.releaseDate = itemView.findViewById(R.id.releaseDate);
            this.adult = itemView.findViewById(R.id.adult);
            this.moviePic = itemView.findViewById(R.id.moviePic);
        }
    }
}
