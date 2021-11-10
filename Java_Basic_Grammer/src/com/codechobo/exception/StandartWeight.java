package com.codechobo.exception;

import java.lang.ProcessHandle.Info;
import java.util.Scanner;

public class StandartWeight {
        int age, height, gender, weight;
        double standardWeight;
        double index;//지수
        String bodyType;

        public StandartWeight() {

        }

    //입력 받는 메소드
    public int getData(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.print(msg+"=");
        return scan.nextInt();

    }

    //표준체중
    public void setStandard() {
        standardWeight = (height - 100)* 0.90; //남:35이하, 여:36이상
        if(gender==1 && age>=36) {
            standardWeight = (height-100) * 0.95;
        } else if(gender==2 && age<36) {
            standardWeight = (height-100) * 0.85;
        }
    }
    //표준체중 지수
    public void setWeightIndex() {
        index = (weight/standardWeight) * 100;
    }
    
    //체형
    public void setBodyType() {
        if (index<=85) {
            bodyType = "마른형";
        } else if (index<=95) {
            bodyType="조금마른형";
        } else if (index<=115) {
            bodyType="표준형";
        } else if (index<=125) {
            bodyType="조금비만형";
        } else {
            bodyType="비만형";
        } 
    }

    //출력 하는 메소드
    public void resultOutput() {
        System.out.println("표준체중=" + standardWeight);
        System.out.println("당신의 표준체중지수는 "+index+"으로"+bodyType+"입니다");
    }

    public void startInfo() {
        //나이
        age = getData("나이");
        gender = getData("성별(1:남성, 2:여성)");
        height = getData("키");
        weight = getData("현재체중");
        setStandard();//표준체중
        setWeightIndex();
        setBodyType();
        resultOutput();//출력
    }
    public static void main(String[] args) {
        new StandartWeight().startInfo();
    }
}
