package com.example.recyclerviewproject;

public class exampleitem {
    private int mImagereasource ;
    private String mText1 ;
    private String mText2;
    public exampleitem(int imageResource , String text1 , String text2){
        mImagereasource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }
    public void changeText1(String text){
        mText1 = text;
    }
    public int getmImagereasource() {
        return mImagereasource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }
}
