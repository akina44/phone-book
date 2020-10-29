
package phonebook;
import java.io.Serializable;


//@SuppressWarnings("serial")
public class Node {
    public String name;
    public String phoneNumber;
    public Node next;

   public Node() { 
       
       next = null;
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

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Name = " + name + " Phone Number = "
				+ phoneNumber;
}
}
