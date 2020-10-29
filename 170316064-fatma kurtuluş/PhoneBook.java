/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author Aspire 5
 */
public class PhoneBook {

	public static void main(String[] args) {

		Contact newList = new Contact();
		Scanner in = new Scanner(System.in); 

		String menu;
               
		boolean done = false;

		do {
			System.out.println();
			
			System.out.format("(A)dd \n(P)rint List \n(S)earch\n(D)elete\n(N)umber search\n(Q)uit%n");	
			
			System.out.format("Please Enter a command: ");
			menu = in.nextLine().toUpperCase();

			switch (menu) {
				case "A": 
					System.out.println("Add an entry");
					
					System.out.print("Enter a FIRST and LAST Name: ");
					String name = in.nextLine();

					System.out.print("Enter a PHONE NUMBER: ");
					String phoneNumber = in.nextLine();
	
					newList.add(name, phoneNumber); 
					break;
				case "D": 
					System.out.print("Enter index number to delete: ");
					int delete = in.nextInt();
					newList.delete(delete);
					break;
				case "P": 
					System.out.println("Print Phonebook");
					newList.printList();
					break; 
				case "S": 
                                
                                   System.out.print("Enter a Name to search for: ");
					String sName = in.nextLine();
					newList.nameSearch(sName);
                                        break;
                                
                                case "N": 
					System.out.print("Enter an Phone number to search for: ");
					String sPhone = in.nextLine();
					newList.phoneSearch(sPhone);
                                        break;
				case "Q": 
					System.out.println("Exiting!");
					done = true;
					break;
				default: 
					System.out.println("Unknown entry");
			}

		}  while (!done);
		System.out.println("Thanks for using!");

	}
}