package com.example.armando.project;

import java.util.List;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

//TODO: cite the site I learned about the Recyclerview
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
private List<Course> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public Button detailsButton;
        public ToggleButton courseToggle;
        public View layout;
        //get student from intent
        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.Header);
            txtFooter = v.findViewById(R.id.Footer);
            detailsButton = v.findViewById(R.id.button);
            courseToggle = v.findViewById(R.id.toggleButton);
            courseToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // This is where registration will happen
                    } else {
                        // This is where a course is dropped.
                    }
                }
            });

        }
    }

    public void add(int position, Course item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Course> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.view_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String header = values.get(position).makeHeaderString();
        final String footer = values.get(position).makeFooterString();

        holder.txtHeader.setText(header);
        holder.txtFooter.setText(footer);
        holder.courseToggle.setTag(values.get(position).getKey()+"reg");
        holder.layout.setTag(values.get(position).getKey()+"item");
        //toggleButton listener
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}