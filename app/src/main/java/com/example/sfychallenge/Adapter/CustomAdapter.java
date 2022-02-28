package com.example.sfychallenge.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sfychallenge.R;
import com.example.sfychallenge.models.Photo;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> implements View.OnClickListener {

    private List<Photo> dataList;
    private View.OnClickListener listener;

    public CustomAdapter(List<Photo> dataList) {
        this.dataList = dataList;
    }

    @Override
    public void onClick(View view) {

        if (listener != null){
            listener.onClick(view);
        }
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public CustomViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.photoImageView);
        }

        void bindPhoto(Photo photo){

            Picasso.Builder builder = new Picasso.Builder(imageView.getContext());
            builder.downloader(new OkHttp3Downloader(imageView.getContext()));

            builder.build()
                    .load(photo.getUrls().getRegular())
                    .fit()
                    .centerCrop()
                    .into(imageView);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_photo,parent,false);
        view.setOnClickListener(this);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bindPhoto(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

}
