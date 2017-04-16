package com.jvmartinez.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jvmartinez.contactlist.Adapter.listAdapterContact;
import com.jvmartinez.contactlist.Model.contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerMain);
        listAdapterContact  adapterContact = new listAdapterContact(insertContact());
        this.recyclerView.setAdapter(adapterContact);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<contact> insertContact(){
        List<contact> contacts = new ArrayList<>();
        contact contact_1 = new contact("Juan","Martinez",00000);
        contact contact_2 = new contact("Carlos","Enock",00000);
        contacts.add(contact_1);
        contacts.add(contact_2);
        return contacts;
    }
}
