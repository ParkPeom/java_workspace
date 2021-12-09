package xyz.itwill.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Ű����� ��������� �Է¹޾� ���ñ��� ��ƿ� ��¥(��)�� ����Ͽ� ����ϴ� ���α׷�
// => ���Ŀ� ���� ���� ��������� �Է��� ��� ���� �޼��� ��� �� ���α׷� ����
public class DayCalculateApp {
	public static void main(String[] args) {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		Date birthday=null;
		System.out.print("������� �Է�[ex.2000-01-01] >> ");
		try {
			//SimpleDateFormat.parse(String source) : SimpleDateFormat �ν��Ͻ��� �����
			//��¥�� �ð� ���� ������ ���ڿ��� ���޹޾� Date �ν��Ͻ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			// => ParseException �߻� : ���� ������ ���ڿ��� �ƴ� ��� �߻��Ǵ� ���� 
			birthday=dateFormat.parse(in.readLine().replace(" ", ""));
			
			//��ƿ� ��¥�� ����Ͽ� ����
			//System.currentTimeMillis() : �ý����� ���� ��¥�� �ð��� ���� Ÿ�ӽ������� ��ȯ�ϴ� �޼ҵ�
			//Ÿ�ӽ�����(TimeStamp) : 1970�� 1�� 1�� �������� ��(ms)������ ������ ������(long)
			// => ��¥�� �ð��� ����ϱ� ���� ��ȯ�Ǵ� ������
			//Date.getTime() : Date �ν��Ͻ��� ����� ��¥�� �ð��� ���� Ÿ�ӽ������� ��ȯ�ϴ� �޼ҵ�
			long day=(System.currentTimeMillis()-birthday.getTime())/(1000*60*60*24);
			System.out.println("[���]����� �¾�� "+day+"���� �������ϴ�.");
		} catch (ParseException e) {
			System.out.println("[����]��������� ���Ŀ� �°� �Է��� �ּ���.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
