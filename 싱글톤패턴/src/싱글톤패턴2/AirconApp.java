package �̱�������2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AirconApp {
	
	BufferedReader br;
	int number;
	public AirconApp() {
		br = new BufferedReader(new InputStreamReader(System.in));
		start();
	}
	public void start() {
		Print.showmenu();
		int number = setMessage("����");
		menu(number);
	}
	// �ݺ� �Է� 
	public int setMessage(String msg) {
		String answer = "";
		try { 
			System.out.print(msg + " >> ");
			number = Integer.parseInt(br.readLine());
			throw new ThrowException();
		} catch (ThrowException e) {
				System.out.println("���� �����ϴ�.");
		} catch (IOException e) {
				System.out.println("");
		} finally {
				
		}
		return number;	
	}
	// �޴� 
	public void menu(int number) {		
		switch(number) {
		case 1:
			// ȸ�� ����
			break;
		case 2:
			// ��ǰ ���
			break;
		case 3:
			// ���� ���
			break;
		case 4:
			// 
			break;
		case 5:
			break;
		
		case 6:
			break;
		
		case 7:
			break;
		}
	}
	// �����
	
	// ������ ����    
	
	// ���� ǰ��
	
	// ��� 
	
	// 
	public static void main(String[] args) {
		new AirconApp().start();
		/*
		Aircon samsung = SamgSungAircon.getInstance();
		Aircon lg = LGAircon.getInstance();
		Aircon carrier = CarrierAircon.getInstance();
		Aircon bokuk = Bokuk.getInstance();
		*/
		// ��� ��� �޼ҵ� 
		UseAirCon use = new UseAirCon();
		// use.turnon(samsung); 	// �Ｚ ����Ŵ 
		// use.useAircon(samsung); // �Ｚ 
		use.template(samsung);
		use.template(lg);
		use.template(carrier);
		use.template(bokuk);
		// �����
		Customer user1 = new Customer();
		// �Ӽ� ��� 
		// ���� ���
	}
}
