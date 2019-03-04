package com.example.iiitcontacts.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.iiitcontacts.BR;
import com.example.iiitcontacts.R;
import com.example.iiitcontacts.databinding.ItemContactBinding;
import com.example.iiitcontacts.pojo.Contact;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contact> mDataset;

    public ContactsAdapter(List<Contact> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemContactBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_contact, parent, false);

        return new ViewHolder(binding);

//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//
//        ItemContactBinding itemContactBinding =
//                ItemContactBinding.inflate(inflater, parent, false);
//
//        return new ViewHolder(itemContactBinding);
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
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemContactBinding binding;


        public ViewHolder(ItemContactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object object) {
            binding.setVariable(BR.contact, object);
            binding.executePendingBindings();
        }
    }

}