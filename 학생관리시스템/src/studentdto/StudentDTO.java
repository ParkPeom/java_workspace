package studentdto;

public class StudentDTO {

	private int hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int count;
	
	public StudentDTO() {}
	
	public StudentDTO(int hak, String name, int kor, int eng, int mat, int tot ) {
		super();
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
	}

	public int getHak() {
		return hak;
	}

	public void setHak(int hak) {
		this.hak = hak;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	@Override
	public String toString() {
		return "StudentDTO [hak=" + hak + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + "]";
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
