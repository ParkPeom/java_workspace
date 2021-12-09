package xyz.itwill.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램
// => 형식에 맞지 않은 생년월일을 입력한 경우 에러 메세지 출력 후 프로그램 종료
public class DayCalculateApp {
	public static void main(String[] args) {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		Date birthday=null;
		System.out.print("생년월일 입력[ex.2000-01-01] >> ");
		try {
			//SimpleDateFormat.parse(String source) : SimpleDateFormat 인스턴스에 저장된
			//날짜와 시간 패턴 형식의 문자열을 전달받아 Date 인스턴스로 변환하여 반환하는 메소드
			// => ParseException 발생 : 패턴 형식의 문자열이 아닌 경우 발생되는 예외 
			birthday=dateFormat.parse(in.readLine().replace(" ", ""));
			
			//살아온 날짜를 계산하여 저장
			//System.currentTimeMillis() : 시스템의 현재 날짜와 시간에 대한 타임스템프를 반환하는 메소드
			//타임스템프(TimeStamp) : 1970년 1월 1일 기준으로 초(ms)단위로 증가된 정수값(long)
			// => 날짜와 시간을 계산하기 위해 변환되는 정수값
			//Date.getTime() : Date 인스턴스에 저장된 날짜와 시간에 대한 타임스템프를 반환하는 메소드
			long day=(System.currentTimeMillis()-birthday.getTime())/(1000*60*60*24);
			System.out.println("[결과]당신은 태어난지 "+day+"일이 지났습니다.");
		} catch (ParseException e) {
			System.out.println("[에러]생년월일을 형식에 맞게 입력해 주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
