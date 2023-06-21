
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class exit {
    public void exit(List<Contact> contact) throws IOException{
        Gson gson = new Gson();
        FileWriter file = new FileWriter("src/Gson.json");
        gson.toJson(contact, file);
        file.close();
        System.out.println("Bye..");
        System.exit(0);
    }
}
