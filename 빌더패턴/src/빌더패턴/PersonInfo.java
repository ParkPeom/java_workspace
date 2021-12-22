
package 빌더패턴;

public class PersonInfo{

  private String name;      //필수적으로 받야할 정보
  private int age;          //선택적으로 받아도 되는 정보
  private int phonNumber;   //선택적으로 받아도 되는 정보

  private PersonInfo(){

  }

  // 내부클래스 
  public static class Builder{

    private String name;
    private int age;
    private int phonNumber;

   public Builder(String name){
      this.name = name;
    }

   public Builder setAge(int age){
	 this.age = age;
	 return this;
   }

   public Builder setPhonNumber(int phonNumber){
	 this.phonNumber = phonNumber;
	 return this;
   }

   public PersonInfo build(){
	   PersonInfo personInfo = new PersonInfo( ); // 객체생성
	   personInfo.name = name;
	   personInfo.age = age;
	   personInfo.phonNumber = phonNumber;
	  
	   return personInfo; // 반환 PersonInfo 
   	 }
  }
	@Override
	public String toString() {
		return "PersonInfo [name=" + name + ", age=" + age + ", phonNumber=" + phonNumber + "]";
	}
    
}

