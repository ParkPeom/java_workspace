package com.codechobo.exception;

import java.lang.ProcessHandle.Info;
import java.util.Scanner;

public class StandartWeight {
        int age, height, gender, weight;
        double standardWeight;
        double index;//����
        String bodyType;

        public StandartWeight() {

        }

    //�Է� �޴� �޼ҵ�
    public int getData(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.print(msg+"=");
        return scan.nextInt();

    }

    //ǥ��ü��
    public void setStandard() {
        standardWeight = (height - 100)* 0.90; //��:35����, ��:36�̻�
        if(gender==1 && age>=36) {
            standardWeight = (height-100) * 0.95;
        } else if(gender==2 && age<36) {
            standardWeight = (height-100) * 0.85;
        }
    }
    //ǥ��ü�� ����
    public void setWeightIndex() {
        index = (weight/standardWeight) * 100;
    }
    
    //ü��
    public void setBodyType() {
        if (index<=85) {
            bodyType = "������";
        } else if (index<=95) {
            bodyType="���ݸ�����";
        } else if (index<=115) {
            bodyType="ǥ����";
        } else if (index<=125) {
            bodyType="���ݺ���";
        } else {
            bodyType="����";
        } 
    }

    //��� �ϴ� �޼ҵ�
    public void resultOutput() {
        System.out.println("ǥ��ü��=" + standardWeight);
        System.out.println("����� ǥ��ü�������� "+index+"����"+bodyType+"�Դϴ�");
    }

    public void startInfo() {
        //����
        age = getData("����");
        gender = getData("����(1:����, 2:����)");
        height = getData("Ű");
        weight = getData("����ü��");
        setStandard();//ǥ��ü��
        setWeightIndex();
        setBodyType();
        resultOutput();//���
    }
    public static void main(String[] args) {
        new StandartWeight().startInfo();
    }
}
