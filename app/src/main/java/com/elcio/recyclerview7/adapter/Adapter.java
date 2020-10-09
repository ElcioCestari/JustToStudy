package com.elcio.recyclerview7.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elcio.recyclerview7.R;
import com.elcio.recyclerview7.model.Person;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Person> personList;

    public Adapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(personList.get(position).getName().toString());
        holder.txtId.setText(personList.get(position).getId().toString());
    }

    @Override
    public int getItemCount() {
        return this.personList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtId = itemView.findViewById(R.id.txtId);
        }
    }
}
