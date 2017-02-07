package com.example.a.a06_customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        String title;
        String desc;
        int imgIcon;
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item_view, null);
            }
            TextView titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            TextView descTextView = (TextView) convertView.findViewById(R.id.descTextView);
            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.itemIcon);

            MyData data = list.get(position);
            titleTextView.setText(data.title);
            descTextView.setText(data.desc);
            imgIcon.setImageResource(data.imgIcon);

            return convertView;
        }
    }

    ArrayList<MyData> list = new ArrayList<MyData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<20; i++){
            MyData data = new MyData();
            data.title = "MyTitle"+i;
            data.desc = "MyDesc"+i;
            data.imgIcon = R.mipmap.ic_launcher;
            list.add(data);
        }

        ListView listView = (ListView) findViewById(R.id.myListView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }
}
