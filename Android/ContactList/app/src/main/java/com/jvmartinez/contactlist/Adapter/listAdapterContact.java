package com.jvmartinez.contactlist.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jvmartinez.contactlist.Model.contact;
import com.jvmartinez.contactlist.R;

import java.util.List;

/**
 * Created by Juan Martinez on 15/04/17.
 */

public class listAdapterContact extends RecyclerView.Adapter<listAdapterContact.Holder>{
    private List<contact> contacts;

    public listAdapterContact(List<contact> contactList){
        this.contacts = contactList;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, null);
        Holder viewHolder = new Holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        contact contact = contacts.get(position);
        holder.lblTitleContact.setText(contact.getName().concat(" ").concat(contact.getLastaName()));
        holder.lblNumberContact.setText(String.valueOf(contact.getNumber()));
        holder.imageContact.setImageResource(R.drawable.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return this.contacts.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView lblTitleContact;
        TextView lblNumberContact;
        ImageView imageContact;
        Holder(View itemView) {
            super(itemView);
            this.lblTitleContact = (TextView) itemView.findViewById(R.id.valueName);
            this.lblNumberContact = (TextView) itemView.findViewById(R.id.valuePhone);
            this.imageContact = (ImageView) itemView.findViewById(R.id.imageContact);
        }
    }
}
