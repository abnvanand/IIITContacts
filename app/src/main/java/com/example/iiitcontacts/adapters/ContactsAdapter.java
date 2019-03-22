package com.example.iiitcontacts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iiitcontacts.BR;
import com.example.iiitcontacts.R;
import com.example.iiitcontacts.databinding.ItemContactBinding;
import com.example.iiitcontacts.localdb.Contact;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contact> mDataset;

    public ContactsAdapter(List<Contact> myDataset) {
        mDataset = myDataset;
    }

    @NotNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        ItemContactBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_contact, parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setData(List<Contact> newData) {
        mDataset = newData;
        notifyDataSetChanged();
    }


    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemContactBinding binding;


        public ViewHolder(ItemContactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(onClickListenerItem);

        }

        private View.OnClickListener onClickListenerItem = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener == null) return;
                itemClickListener.onItemClick(binding);
            }
        };


        public void bind(Object object) {
            binding.setVariable(BR.contact, object);
            binding.executePendingBindings();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(@NonNull ItemContactBinding binding);
    }

    protected OnItemClickListener itemClickListener;

}