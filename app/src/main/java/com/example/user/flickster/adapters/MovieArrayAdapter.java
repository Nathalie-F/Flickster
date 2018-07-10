package com.example.user.flickster.adapters;

import android.content.Context;
import android.media.Image;
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

import org.w3c.dom.Text;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {
    public MovieArrayAdapter(Context context, List<Movie> movies) {
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
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverView = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // find the image view
        //ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        // clear out image from convertView
        //ivImage.setImageResource(0);

        //TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        //TextView tvOverView = (TextView) convertView.findViewById(R.id.tvOverview);

        // populate data
        //tvTitle.setText(movie.getOriginalTitle());
       // tvOverView.setText(movie.getOverview());
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverView.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivImage);

        // return the view
        return  convertView;

    }



}
