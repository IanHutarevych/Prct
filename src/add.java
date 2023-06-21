

import java.util.List;
import java.util.Scanner;

public class add {

    public void add(List<Contact> arr, Scanner s){
        System.out.println("Write your number");
        String number = s.nextLine();
        System.out.println("Write name");
        String name = s.nextLine();

        Contact contact = new Contact(name, number);
        arr.add(contact);
        System.out.println("Successful added");
    }
}
