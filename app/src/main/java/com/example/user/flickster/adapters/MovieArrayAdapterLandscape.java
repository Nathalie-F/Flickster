package com.example.user.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.flickster.R;
import com.example.user.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieArrayAdapterLandscape extends ArrayAdapter<Movie> {
    public MovieArrayAdapterLandscape(Context context, List<Movie> movies) {
        super (context,android.R.layout.simple_list_item_1, movies);
    }
    public static class ViewHolder{
        TextView tvTitle;
        TextView tvOverView;
        ImageView ivImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the data item for this position
        Movie movie = getItem(position);
        // check the existing view being reused
        MovieArrayAdapter.ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new MovieArrayAdapter.ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitleL);
            viewHolder.tvOverView = (TextView) convertView.findViewById(R.id.tvOverviewL);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImageL);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (MovieArrayAdapter.ViewHolder) convertView.getTag();
        }


        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverView.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getBackdropPath()).resize(250, 250).placeholder(R.drawable.plc).into(viewHolder.ivImage);

        // return the view
        return  convertView;

    }

}
