package Main;

public class detailVo {
	
	private String title;
	private String paydate;
	private int fee;
	private String term;
	private String card_name;
	private String bank_name;
	
	public detailVo() {
		
	}
	
	public detailVo(String title, String paydate, int fee, String term, String card_name, String bank_name) {
		this.title = title;
		this.paydate = paydate;
		this.fee = fee;
		this.term = term;
		this.card_name = card_name;
		this.bank_name = bank_name;	
	}
	
	public String getTitle() {
		return title;
	}
	public String getPaydate() {
		return paydate;
	}
	public int getFee() {
		return fee;
	}
	public String getTerm() {
		return term;
	}
	public String getCard() {
		return card_name;
	}
	public String getBank() {
		return bank_name;
	}
	
	
}
