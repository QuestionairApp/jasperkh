package de.mkservices.jasperkh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {
    String today;
    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aktualisieren=(Button)findViewById(R.id.btnSyncButton);
        aktualisieren.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String[] values=new String[]{"String1", "String2", "String3"};
                for (int i = 0; i < values.length; ++i) {
                    list.add(values[i]);
                }
                adapter.notifyDataSetChanged();
            }
        });

        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
            }
        });

        Date d=new Date();
        String year=String.valueOf(1900+d.getYear());
        String mon=String.valueOf(d.getMonth()+1);
        if(mon.length()==1) mon="0"+mon;
        String day=String.valueOf(d.getDate());
        if(day.length()==1) day="0"+day;
        today=year+"-"+mon+"-"+day;
        list = new ArrayList<String>();
        list.add(today);
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

}
