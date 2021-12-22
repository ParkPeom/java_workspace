
package ��������;

public class PersonInfo{

  private String name;      //�ʼ������� �޾��� ����
  private int age;          //���������� �޾Ƶ� �Ǵ� ����
  private int phonNumber;   //���������� �޾Ƶ� �Ǵ� ����

  private PersonInfo(){

  }

  // ����Ŭ���� 
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
	   PersonInfo personInfo = new PersonInfo( ); // ��ü����
	   personInfo.name = name;
	   personInfo.age = age;
	   personInfo.phonNumber = phonNumber;
	  
	   return personInfo; // ��ȯ PersonInfo 
   	 }
  }
	@Override
	public String toString() {
		return "PersonInfo [name=" + name + ", age=" + age + ", phonNumber=" + phonNumber + "]";
	}
    
}

