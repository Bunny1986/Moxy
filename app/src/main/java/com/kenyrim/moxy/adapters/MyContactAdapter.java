package com.kenyrim.moxy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.kenyrim.moxy.R;
import com.kenyrim.moxy.models.Datum;

import java.util.List;

import androidx.annotation.NonNull;

public class MyContactAdapter extends ArrayAdapter<Datum> {

    private List<Datum> contactList;
    private Context context;
    private LayoutInflater mInflater;

    public MyContactAdapter(Context context,List<Datum> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public Datum getItem(int position) {
        return contactList.get(position);
    }

    @NonNull
    @Override
    public View getView(final int position,View convertView,@NonNull ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        final Datum item = getItem(2);

        assert item != null;
        vh.textViewName.setText(item.getData().getVariants().get(position).getText());

        vh.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,String.valueOf(item.getData().getVariants().get(position).getId()),Toast.LENGTH_SHORT).show();
            }
        });
        return vh.rootView;
    }

    private static class ViewHolder {
        private final RelativeLayout rootView;
        private final TextView textViewName;

        private ViewHolder(RelativeLayout rootView,TextView textViewName) {
            this.rootView = rootView;
            this.textViewName = textViewName;
        }

        private static ViewHolder create(RelativeLayout rootView) {
            TextView textViewName = rootView.findViewById(R.id.textViewName);

            return new ViewHolder(rootView, textViewName);
        }
    }
}
