package 정적팩토리메서드;

public class Person{

	  private String name;

	  private Person( ){}

	  public static Person newInstance(){
	    return new Person( );
	  }

	  public static Person newInstanceByName(String name){
	    this.name = name;
	    return new Person( );
	  }

	  public static void main(String[] args){

	    Person p  = Person.newInstance(); // 평범한 인스턴스 생성
	    Person p2 = Person.newInstanceByName("Mommoo"); // name속성을 가지는 인스턴스 생성 

	  }
	}
