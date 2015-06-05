package Apr09_2;

public class DataRecord {
	
	public static final int NEVER_USED = 0;
	public static final int PREVIOUSLY_USED = 1;
	private DataRecord next;
	private String name;
	private String phoneNumber;
	private int used;

	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}

	public DataRecord getNext() {
		return next;
	}
	public void setNext(DataRecord next) {
		this.next = next;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return "<" + name + ", " + phoneNumber + ">";
	}
}
