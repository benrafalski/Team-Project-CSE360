
public class Vaccine {
	
	private String id;
	private String lastName;
	private String firstName;
	private String typeVaccine;
	private String dateofVaccine;
	private String locationofVaccine;
	
	public Vaccine(String ID, String last, String first, String type, String date, String location) {
		this.id = ID;
		this.lastName = last;
		this.firstName = first;
		this.typeVaccine = type;
		this.dateofVaccine = date;
		this.locationofVaccine = location;
	}
	public void setID(String id) {
		this.id = id;
	}
	public void setLast(String last) {
		this.lastName = last;
	}
	public void setFirst(String first) {
		this.firstName = first;
	}
	public void setType(String type) {
		this.typeVaccine = type;
	}
	public void setDate(String date) {
		this.dateofVaccine = date;
	}
	public void setLocation(String loc) {
		this.locationofVaccine = loc;
	}
	public String getID() {
		return this.id;
	}
	public String getLast() {
		return this.lastName;
	}
	public String getFirst() {
		return this.firstName;
	}
	public String getType() {
		return this.typeVaccine;
	}
	public String getDate() {
		return this.dateofVaccine;
	}
	public String getLocation() {
		return this.locationofVaccine;
	}
}
