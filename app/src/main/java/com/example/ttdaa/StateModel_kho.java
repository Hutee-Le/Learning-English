package com.example.ttdaa;

public class StateModel_kho {
    String answer;
    String question;
    int image;

    public StateModel_kho(String answer, String question, int image){
        this.answer = answer;
        this.image = image;
        this.question = question;
    }
    public String getAnswer(){
        return answer;
    }
    public String getQuestion(){
        return answer;
    }
    public  int getImage(){return image;}
}
