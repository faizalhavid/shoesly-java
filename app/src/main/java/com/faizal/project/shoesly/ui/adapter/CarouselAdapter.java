package com.faizal.project.shoesly.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.faizal.project.shoesly.R;
import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {

    private  final List<Integer> images;
    private final Context context;

    public CarouselAdapter(Context context, List<Integer> images) {
        this.context = context;
        this.images = images;
    }
    @NonNull
    @Override
    public CarouselAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_carousel, parent, false);
        return new ViewHolder(view);
    }

@Override
public void onBindViewHolder(@NonNull CarouselAdapter.ViewHolder holder, int position) {
    int image = images.get(position);
    Log.d("CarouselAdapter", "Position: " + position + ", Image: " + image);
    Glide.with(context).load(image).into(holder.image);
}

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ViewHolder(@NonNull android.view.View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}

