package com.codechobo.control;

public class IfExample {

	public static void main(String[] args) {
				//������ ����� ���ڰ��� ����ϼ���.
				//��, ������ ����� ���ڰ��� �ҹ����� ��� �빮�ڷ� ��ȯ�Ͽ� ����ϼ���.
				char mun='d';
				if('a' <= mun && mun <= 'z') {
					mun -= 32;
					System.out.println("��ȯ�� ���� : " + mun);
				} else if( 'A' <= mun && mun <= 'Z') {
					mun += 32;  // mun = mun + 32 �� int + int = int �̹Ƿ� (char)int + int ��������ȯ ����� �Ѵ�.
					System.out.println("��ȯ�� ���� : " + mun);
				}
			
				//������ ����� �������� 4�� ��������� �����Ͽ� ����ϼ���.
				int num=345644;
				
				if(num % 4 == 0) {
					System.out.println("4�� ��� �Դϴ�.");
				} else {
					System.out.println("4�� ����� �ƴմϴ�.");
				}

				//���ذ� ������� ������ �����Ͽ� ����ϼ���.
				// => �⵵�� 4�� ������ �������� 0�� ��� ����
				// => �� ������ �����ϴ� �⵵ �� 100���� ������ �������� 0�� ��� ���
				// => �� ������ �����ϴ� �⵵ �� 400���� ������ �������� 0�� ��� ����
				int year=2021;
				
				if(year % 4 == 0) {
					System.out.println("����");
						if(year % 100 == 0) {
							System.out.println("���");
						} else if(year % 400 == 0) {
							System.out.println("����");
						} 
					} else {
						System.out.println("�ش�Ǵ� ���� �ƴմϴ�.");
					}
				
				// ������� Ǭ�� 
				if(year % 4 ==0 && year % 100 !=0 || year % 400 == 0) {
					System.out.println("[���] " + year + "���� ���� �Դϴ�.");
				} else {
					System.out.println("[���] " + year + "���� ��� �Դϴ�.");
				}
				

				//�̸��� [ȫ�浿]�� �л��� �������� 89��, �������� 93��, �������� 95���� ���� ���
				//������ ���, ������ ����Ͽ� �̸�, ����, ���, ������ ����ϼ���.
				// => ����,����,���� ���� �� �ϳ��� 0~100 ������ �ƴ� ��� ���α׷� ���� ����
				//    System.exit(0) : ���α׷��� ������ �����ϴ� �޼ҵ�
				// => ����� �̿��� ���� ��� : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
				// => ����� �Ҽ��� ���ڸ������� ����ϰ� �������� ���� ó�� �ϼ���.
				
				String name = "ȫ�浿";
				int kor = 89 , eng = 93 , math = 95;
				int total = 0;
				double average;
				String grade = "";
				
				// ����� ���Ǽ��� ���ؼ� �ϳ��� �� �����ϴ°� ���� ( �α��� �н����� )
				if(0 <= kor && kor <= 100) {
					if(0 <= eng && eng <= 100) {
						if(0 <= math && math <=100) {
							total = kor + eng + math;
							average = total / 3.0;
							if( 90 <= average && average <= 100) {
								grade = "A";
							} else if(average >= 80) {
								grade = "B";
							} else if(average >= 70) {
								grade = "C";
							} else if(average >= 60) {
								grade = "D";
							} else {
								grade = "F";
							}
						System.out.printf("��� %.2f ������  %s ", average , grade);	
						}
					}
				} else {
					System.out.println("����");
					System.exit(0);
				}
				
				// switch������ Ǯ���
				int kor2 = 89 , eng2 = 93 , mat2 = 95;
				
				// �Է°� ����(Validation ��ȿ�� ����) - ���̵� ,��й�ȣ ���� �Ҷ� ���δ�. 
				
				
				
//				if(!(kor2 >= 0 && kor <= 100) || !(eng2 >= 0 && eng2 <= 100) || !(mat2 >= 0 && mat2 <= 100)) {
//					System.out.println("[����] 0 ~ 100 ������ ��� ���������� ������ �Է� �Ǿ����ϴ�.");
//					System.exit(0);
//				} // �̰ͺ��� 
				
				
				// �� ���ǰ��� ���� �ִ°� -> ����ڿ��� ���Ǽ��� ������ �� ��� �Ѵ�. ( �������α׷��� �ַ��� )  - ���� �ϳ��ϳ� �� �˻��� 
				
				boolean valid = false;
				
				if(!(kor2 >= 0 && kor2 <= 100)) {
					System.out.println("[����] 0 ~ 100 ������ ��� ���������� ���������� �Է� �Ǿ����ϴ�");
					valid = true; // ������ �����ϸ� true 
				}
				 if(!(eng2 >= 0 && eng2 <= 100)) {
					System.out.println("[����] 0 ~ 100 ������ ��� ���������� ���������� �Է� �Ǿ����ϴ�");
					valid = true;
				}
				 
				 if(!(mat2 >= 0 && mat2 <= 100)) {
					 System.out.println("[����] 0 ~ 100 ������ ��� ���������� ���������� �Է� �Ǿ����ϴ�");
					valid = true;
				} 
				 
				 // �Է°��� ���� ������ ������ ��� 
				 if(valid) {
					 System.exit(0);
				 }
				
				// ������ ���еǸ�  System.exit(0) ���� ���� �ؿ��� ������ ���� �ʴ´�. 
				
				int tot2 = kor2 + eng2 + mat2;
				grade = "";
				double ave2 = tot2 / 3.;
					
				switch((int)ave2/10) { // switch �� �Ǽ��� �������Ƿ� int�� ���� ����ȯ 
				case 10:
				case 9:
					grade = "A"; break;
				case 8:
					grade = "B"; break;
				case 7: 
					grade = "C"; break;
				case 6: 
					grade = "D"; break;
				default : 
					grade = "F"; break;
				}
				
			}
		}