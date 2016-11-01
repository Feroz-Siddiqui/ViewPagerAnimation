package com.example.feroz.androidcms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.feroz.androidcms.R;
import com.example.feroz.androidcms.cmsslide.CMSTextItem;

import java.util.ArrayList;

/**
 * Created by Feroz on 31-10-2016.
 */

public class TitleListAdapter extends  RecyclerView.Adapter<TitleListAdapter.ViewHolder> {
    ArrayList<CMSTextItem> cmsTextItems;
    private Context context;

    public TitleListAdapter(Context context,ArrayList<CMSTextItem> cmsTextItems) {
        this.cmsTextItems = cmsTextItems;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TitleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        if(cmsTextItems.get(position).getText() != null)
        viewHolder.txtViewTitle.setText(cmsTextItems.get(position).getText());


    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.list_item_text);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cmsTextItems.size();
    }
}