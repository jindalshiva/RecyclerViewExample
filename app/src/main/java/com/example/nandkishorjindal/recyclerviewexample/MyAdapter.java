package com.example.nandkishorjindal.recyclerviewexample;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems,Context context){
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.list_item,viewGroup,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListItem listItem = listItems.get( i );
        viewHolder.textViewHead.setText( listItem.getHead() );
        viewHolder.textViewDesc.setText( listItem.getDesc() );

        Picasso.get().load(listItem.getImageUrl()).into(viewHolder.imageVIEW);
    }

    @Override
    public int getItemCount() {
        return listItems.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageVIEW;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            textViewHead = (TextView) itemView.findViewById( R.id.textHeading );
            textViewDesc = (TextView) itemView.findViewById( R.id.textDescription );
            imageVIEW = (ImageView) itemView.findViewById( R.id.imageView );
        }
    }
}
