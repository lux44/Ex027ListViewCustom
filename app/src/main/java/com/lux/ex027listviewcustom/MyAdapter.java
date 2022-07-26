package com.lux.ex027listviewcustom;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Item> items;
    Context context;

    //생성자 메소드
    public MyAdapter(Context context, ArrayList<Item> items){
        this.items=items;
        this.context=context;
    }

    //이 메소드가 리턴한 숫자만큼 뷰가 만들어짐
    @Override
    public int getCount() {
        return items.size();
    }

    //파라미터의 전달된 positon (i)의 아이템을 리턴해주는 기능메소드
    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    //아이템 클릭시에 position(i) 말고 id로 구분하고자 할때 position별 id를 정하는
    //기능메소드 - 통상적으로는 position과 id를 같게 만들기에 그냥 i값을 리턴하면 됨.
    @Override
    public long getItemId(int i) {
        return i;
    }

    //아이템 1개의 뷰를 만들어서 리턴해주는 기능메소드
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //1번째 파라미터 i : 현재 만들어야 할 번째의 item 위치 즉, position[0,1,2,,]
        //3번째 파라미터 viewGroup : ListView참조변수
        //2번째 파라미터 view : 재활용하는 view가 있다면 참조, 없으면 null

        //1. create view :  리스트뷰에 보여질 항목 하나의 뷰 객체를 생성
        //layout폴더 안에 있는 listview_item.xml를 읽어와서 뷰객체로 만들어주는 (inflater)
        //객체가 있음 - LayoutInflater 이 객체에게 뷰를 만들어 달라고 요청

        //재활용할 뷰가 있는지 확인 먼저
        if(view==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.listview_item,viewGroup,false);
        }



        //2. bind view : 만들어진 뷰객체 안에 데이터를 연결해주는 작업
        ImageView iv=view.findViewById(R.id.listview_item_iv);
        TextView tv_nation=view.findViewById(R.id.listview_item_tv_nation);
        TextView tv_name=view.findViewById(R.id.listview_item_tv_name);

        //이 메소드의 첫번째 파라미터인 위치값(position)번째의 데이터 가져오기
        Item item =items.get(i);
        iv.setImageResource(item.imgid);
        tv_name.setText(item.name);
        tv_nation.setText(item.nation);

        return view;
    }
}
