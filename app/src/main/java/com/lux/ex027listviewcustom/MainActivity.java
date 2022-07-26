package com.lux.ex027listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터를 가지는 ArrayList 객체 생성
    ArrayList<Item> items = new  ArrayList<>();

    ListView listView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터를 추가 - 실무에서는 서버나 db에서 읽어옴
        //테스트목적으로 직접 item추가
        items.add(new Item("전현무","대한민국",R.drawable.flag_korea));
        items.add(new Item("기욤패트릭","캐나다",R.drawable.flag_canada));
        items.add(new Item("타일러","미국",R.drawable.flag_usa));
        items.add(new Item("로빈","프랑스",R.drawable.flag_france));
        items.add(new Item("알베","이탈리아",R.drawable.flag_italy));
        items.add(new Item("전현무","대한민국",R.drawable.flag_korea));
        items.add(new Item("기욤패트릭","캐나다",R.drawable.flag_canada));
        items.add(new Item("타일러","미국",R.drawable.flag_usa));
        items.add(new Item("로빈","프랑스",R.drawable.flag_france));
        items.add(new Item("알베","이탈리아",R.drawable.flag_italy));

        listView=findViewById(R.id.listview);
        adapter=new MyAdapter(this,items);
        listView.setAdapter(adapter);

        //ListView의 항목을 클릭했을 때 해당 항목의 name 데이터를 dialog로 보여주기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //세번째 파라미터 i : 클릭한 항목 위치 포지션

                //해당 항목 Item의 name변수값 얻어오기
                String name = items.get(i).name;

                //AlertDialog를 만들어주는 Builder객체 생성
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(name);
                builder.create().show();
            }
        });
    }
}