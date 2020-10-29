
package phonebook;

import static java.lang.System.*;
import java.io.Serializable;


/** 
 * create serialization so files can be written and read in byte form
 * and allow readability of types
 */

@SuppressWarnings("serial")
public class Contact implements Serializable{
  public Node head;
  private int length;
  // hidden root node
  public Contact() {

     head = null;
     length = 0;
        
                
}
 public void add(String name, String phoneNumber) {

		Node current = head;
		Node previous = null;
	        Node newNode = new Node();
	
		newNode.setName(name);
		newNode.setPhoneNumber(phoneNumber);

		if (isEmpty()) {
			head = newNode;
			length++;
		} else {

			// compare last names of entries for priority by first
			// letter in last name

			for (int i = 0; i < length; i++) {
				String[] ourNames2 = current.getName().split(" ");
				String[] ourNames1 = newNode.getName().split(" ");

				int result = ourNames2[ourNames2.length-1].compareToIgnoreCase(ourNames1[ourNames1.length-1]);

				// if last name entered goes before what's stored in
				// the head, new entry becomes the head
				if (result > 0) {
					if (previous == null) {
						newNode.setNext(current);
						head = newNode;
						length++;
						break;
					}

					
					previous.setNext(newNode);
					newNode.setNext(current);
					length++;
					break;
				}

				else 
					
				{
					if (current.getNext() == null) {
						current.setNext(newNode);
						newNode.setNext(null);
						length++;
						break;
					}
					
					previous = current;
					current = current.getNext();

				}
			}
		}

	}

	public void printList () {

		
		Node tempNode = head;
		if (head == null) {
			System.out.println("The list is empty!");
		} else {
		
			for (int i = 0; i < length; i++) {
				System.out.print("Index = " + (i+1) + " ");
				System.out.println(tempNode);
				tempNode = tempNode.getNext();
			}

		}
		System.out.println();
	}


	public boolean isEmpty() {
		return (length == 0);
	}



	public void nameSearch(String name) {
		Node current = head;
		boolean empty = true;

	
		if (isEmpty()) {
			System.out.println("The list is empty!");
		}else {
			
			for (int i = 0; i < length; i++) {
				if (current.getName().toLowerCase().contains(name.toLowerCase())) {
					System.out.print("Index = " + (i+1) + " ");
					System.out.println(current);
					empty = false;

				}
			
				current = current.getNext();
			}
			
			if (empty){
				System.out.println("No matches to that name!");
			}
}

	}
        public void phoneSearch(String phoneNumber){
            Node current = head;
		boolean empty = true;

		if (isEmpty()) {
			System.out.println("The list is empty!");
		}else {

			for (int i = 0; i < length; i++) {
				if (current.getPhoneNumber().toLowerCase().contains(phoneNumber.toLowerCase())) {
					System.out.print("Index = " + (i+1) + " ");
					System.out.println(current);
					empty = false;
                                }
				current = current.getNext();
			}
			if (empty){
				System.out.println("No matches to that number!");
			}
}
        }



	public void delete (int index) {
		Node current = head;
		Node previous = null;
		boolean empty = true;
		
		if (isEmpty()) {
			System.out.println("The list is empty!");
		} else {
			
			for (int i = 0; i < length; i++) {
				if ((index-1) == i) {
					if (previous == null) {
						head = head.getNext();
						length--;
						empty = false;
						break;
					} else if (current.getNext() == null){
						previous.setNext(null);
						length--;
						empty = false;
						break;
					} else {
						previous.setNext(current.getNext());
						length--;
						empty = false;
						break;
					}
				} else {
					previous = current;
					current = current.getNext();
				}
			}
			if (empty){
				System.out.println("Index Does Not Exist!");
			} else {
		
				System.out.println("Successfully deleted index " + index);
			}
		}

	}

}
