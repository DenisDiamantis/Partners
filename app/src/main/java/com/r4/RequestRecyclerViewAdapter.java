package com.r4;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.r4.databinding.FragmentItem2Binding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Request}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RequestRecyclerViewAdapter extends RecyclerView.Adapter<RequestRecyclerViewAdapter.ViewHolder>{

    private final List<Request> requests;
    private RequestFragment.OnRequestListener listener;

    public RequestRecyclerViewAdapter(List<Request> items, RequestFragment.OnRequestListener listener) {
        this.listener = listener;
        requests = items;
    }

    @Override
    public RequestRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item,parent,false);
        return new RequestRecyclerViewAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = requests.get(position);
        holder.skillsText.setText(requests.get(position).getSender().getSkills());
        holder.timelineText.setText(requests.get(position).getSender().getTimeline());
        holder.accept_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.AcceptSelection(requests.get(position));

            }
        });
        holder.decline_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.DeclineSelection(requests.get(position));

            }
        });

    }


    @Override
    public int getItemCount() {
        return requests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView skillsText;
        public final TextView timelineText;
        public Request mItem;
        public final Button accept_button;
        public final Button decline_button;


        public ViewHolder(View view) {
            super(view);

            skillsText = (TextView) view.findViewById(R.id.skills);
            timelineText = (TextView) view.findViewById(R.id.timeline);
            accept_button=  view.findViewById(R.id.accept_button);
            decline_button = view.findViewById(R.id.decline_button);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + skillsText.getText() + "'";
        }
    }
}