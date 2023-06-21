

import java.util.List;

public class showAll{

    public void show(List<Contact> contactList) {

        System.out.println("All yor contact");
        for (int i = 0; i < contactList.size(); i ++ ){
            System.out.println("\t" + (i+1) + ". " + contactList.get(i) );
        }

    }


}