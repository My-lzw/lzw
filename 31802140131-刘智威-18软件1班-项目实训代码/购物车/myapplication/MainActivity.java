package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private String[] titles
            ={"波斯猫","蓝猫","埃及猫","加菲猫","汤姆猫","杰克猫"};

    private String[] prices
            ={"3000元","2000元","10000元","9999元","99999万","999999万"};

    private int[] icons={R.drawable.bosimao,R.drawable.lanmao,R.drawable.aijimao,R.drawable.jiafeimao,
            R.drawable.tangmumao,R.drawable.jieke};  protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        mListView=(ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
    }

    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return titles.length;
        }
        @Override
        public Object getItem( int position){
            return titles[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder viewHolder=null;
            if (convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.list_item,null);
                viewHolder = new ViewHolder();
                viewHolder.title =(TextView) convertView.findViewById(R.id.title);
                viewHolder.price =(TextView) convertView.findViewById(R.id.price);
                viewHolder.iv =(ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(viewHolder);
            }else {
                viewHolder=(ViewHolder)convertView.getTag();
            }


            viewHolder.title.setText(titles[position]);
            viewHolder.price.setText(prices[position]);
            viewHolder. iv.setBackgroundResource(icons[position]);
            return convertView;
        }
    }


}
