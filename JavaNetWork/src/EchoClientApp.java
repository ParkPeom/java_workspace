import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//키보드로 메세지를 입력받아 서버에 접속하여 접속 서버에 메세지를 전달하는 클라이언트 프로그래밍
public class EchoClientApp {
	
	public static void main(String[] args) throws IOException {
		
		// 키보드로 입력받은걸 확장시켜서 문자열로 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력  >> ");
		String message = br.readLine();
		
		try {
			Socket socket = new Socket("172.31.98.131",5000);	
			
			/*
			// 대용량 스트림으로 확장 
			// 소켓의 출력 스트림을 반환받아 문자열을 전달할 수 있도록 확장시켰다. 
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//BufferedWriter.write(String str) : 출력스트림을 이용하여 문자열을 전달하는 메소드 
			out.write(message);
			//BufferedWriter.flush() : 출력스트림의 버퍼(임시메모리)에 존재하는 모든 문자열을 전달하는 메소드
			out.flush();
			*/
			
			// 소켓의 출려스트림을 반환받아 모든 자료형의 값을 문자열로 전달할 수 있도록 확장
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println(message);
			out.flush();
			
			socket.close();
		} catch(Exception e) {
			System.out.print("[에러]서버에 접속 할 수 없습니다.");
		}
	}
}
