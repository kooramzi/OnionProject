package Member;

public class MemberVo {
//	VO) 여러 다른 타입의 데이터를 다른 클래스로 전달할 때 사용

	private String id;
	private String pw;
	private String name;
	private String pnum;

	public MemberVo() {
	}

	public MemberVo(String id, String pw, String name, String pnum) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.pnum = pnum;
	}

	public String getId() {
		return id;

	}

	public String getPassword() {
		return pw;

	}

	public String getName() {
		return name;

	}

	public String getPnum() {
		return pnum;

	}

	public void setId(String id) {
		this.id = id;
	}

	public void getPassword(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

}
