package com.jvmartinez.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.jvmartinez.contactlist.Adapter.adapterSwipe;
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
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new adapterSwipe(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT));
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    public List<contact> insertContact(){
        List<contact> contacts = new ArrayList<>();
        contact contact_1 = new contact("Juan","Martinez",123456);
        contact contact_2 = new contact("Carlos","Enock",67890);
        contact contact_3 = new contact("Louis","Perdomo",12345678);
        contacts.add(contact_1);
        contacts.add(contact_2);
        contacts.add(contact_3);
        return contacts;
    }
}
