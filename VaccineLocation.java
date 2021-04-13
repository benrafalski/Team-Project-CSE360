
public class VaccineLocation {
	private String location;
	private int count;
	
	public VaccineLocation(String loc) {
		this.location = loc;
		this.count = 0;
	}
	public void incrementCount() {
		this.count++;
	}
	public void decrementCount() {
		this.count--;
	}
	public String getLocation() {
		return this.location;
	}
	public int getCount() {
		return this.count;
	}
}
