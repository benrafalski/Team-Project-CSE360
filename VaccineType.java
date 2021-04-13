
public class VaccineType {
	private String type;
	private int count;
	
	public VaccineType(String type) {
		this.type = type;
		this.count = 0;
	}
	public void incrementCount() {
		this.count++;
	}
	public void decrementCount() {
		this.count--;
	}
	public String getType() {
		return this.type;
	}
	public int getCount() {
		return this.count;
	}
}
