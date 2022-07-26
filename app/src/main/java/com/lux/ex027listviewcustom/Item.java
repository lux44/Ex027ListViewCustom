package com.lux.ex027listviewcustom;
//대량의 데이터 1개 아이템의 데이터를 저장할 객체의 설계도면
public class Item {

    String name; //전현무
    String nation; //대한민국
    int imgid; //R.drawable.korea

    //이 클래스를 객체로 생성(new)할 때 자동으로 실행되는 메소드
    //생성자 메소드 : constructor
    public Item(String name, String nation, int imgid) {
        //파라미터로 받은 데이터들을 멤버변수로 대입해주기
        this.nation=nation;
        this.name=name;
        this.imgid=imgid;
    }

}
