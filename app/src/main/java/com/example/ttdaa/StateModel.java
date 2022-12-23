package com.example.ttdaa;

public class StateModel {
    String answer;
    int image;

    public StateModel(String answer, int image){
        this.answer = answer;
        this.image = image;
    }
    public String getName(){
        return answer;
    }
    public  int getImage(){return image;}
}
