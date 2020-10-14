package com.example.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private Context mcontext;
    private List<MyList> listdata;


    public MyListAdapter(Context mcontext, List<MyList> listdata) {
        this.mcontext = mcontext;
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyList myListData = listdata.get(position);
        holder.img.setImageResource(listdata.get(position).getimag());
        holder.namesong.setText(listdata.get(position).getsongName());
        holder.nameartist.setText(listdata.get(position).getArtistName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, PlayingNow.class);
                intent.putExtra("song_name", myListData.getsongName());
                intent.putExtra("band_name", myListData.getArtistName());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView namesong;
        public TextView nameartist;
        public ImageView img;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.img = itemView.findViewById(R.id.imageView);
            this.namesong = itemView.findViewById(R.id.songname);
            this.nameartist = itemView.findViewById(R.id.artistname);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
