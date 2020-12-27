package com.example.movielistappnew.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movielistappnew.Model.Movie;
import com.example.movielistappnew.Network.ApiClient;
import com.example.movielistappnew.R;

import java.util.List;

public class Movie_List_Adapter extends RecyclerView.Adapter<Movie_List_Adapter.MyViewHolder> {

    private List<Movie> movieList;
    private Context mcontext;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    public Movie_List_Adapter(List<Movie> movieList, Context mcontext) {
        this.movieList = movieList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_movielist_item,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {

        viewHolder.tvTitle.setText(movieList.get(position).getTitle());
        viewHolder.tvRealeaseDate.setText(movieList.get(position).getReleaseDate());
        viewHolder.tvOverView.setText(movieList.get(position).getOverview());

        Glide.with(mcontext).load(IMAGE_BASE_URL+movieList.get(position).getPosterPath()).into(viewHolder.ivMovie);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView ivMovie;
        TextView tvTitle,tvRealeaseDate,tvOverView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMovie=itemView.findViewById(R.id.ivMovie);
            tvTitle=itemView.findViewById(R.id.tvTitleMovie);
            tvRealeaseDate=itemView.findViewById(R.id.tvReleaseMovie);
            tvOverView=itemView.findViewById(R.id.tvOverviewMovie);


        }
    }
}
