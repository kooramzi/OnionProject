package Main;

public class subscriptionVo {
	private String sid;
	private String paydate;
	private String category;
	private String title;
	private int fee;
	private int totalFee;

	public subscriptionVo() {

	}

	public subscriptionVo(String paydate, String title, int fee) {
		this.paydate = paydate;
		this.title = title;
		this.fee = fee;

	}
	
	public subscriptionVo(int fee) {
		this.fee = fee;

	}


	public String getSid() {
		return sid;
	}
	public String getPaydate() {
		return paydate;
	}

	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public int getFee() {
		return fee;
	}
	
	public int getTotalFee() {
		return totalFee;
	}
	

}
