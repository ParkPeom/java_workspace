package �������丮�޼���;

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

	    Person p  = Person.newInstance(); // ����� �ν��Ͻ� ����
	    Person p2 = Person.newInstanceByName("Mommoo"); // name�Ӽ��� ������ �ν��Ͻ� ���� 

	  }
	}
