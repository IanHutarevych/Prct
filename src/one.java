

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class one {

    static String[] commands = {"exit", "showAll", "add", "delete", "update"};

    static List<Contact> contactsList = new ArrayList<>();

    private static void fromJsonToArr() throws IOException {
        String path = "src/Gson.json";
        String file = new String(Files.readAllBytes(Paths.get(path)));
        JsonParser parser = new JsonParser();
        JsonArray ja = parser.parse(file).getAsJsonArray();

        for (int i = 0; i < ja.size(); i++) {
            JsonObject jo = ja.get(i).getAsJsonObject();
            String name = jo.get("name").getAsString();
            String number = jo.get("number").getAsString();
            Contact contact = new Contact(name, number);
            contactsList.add(contact);
        }
    }

    public static void main(String[] args) throws IOException {
        fromJsonToArr();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write any command or `help` to see all commands");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                exit exit = new exit();
                exit.exit(contactsList);
            } else if (command.equalsIgnoreCase("help")) {
                System.out.println("All commands");
                for (int i = 0; i < commands.length; i++) {
                    System.out.println(i + ". " + commands[i]);
                }
                System.out.println("Write command");

            } else if (command.equalsIgnoreCase("add")) {
                add add = new add();
                add.add(contactsList, scanner);
                System.out.println("Write any command");

            }else if (command.equalsIgnoreCase("delete")) {
                delete del = new delete();
                del.delete(contactsList, scanner);
                System.out.println("Write command");
            }  else if (command.equalsIgnoreCase("showAll")) {
                showAll show = new showAll();
                show.show(contactsList);
                System.out.println("Write command");
            }else if (command.equalsIgnoreCase("update")) {
                update show = new update();
                show.updata(contactsList, scanner);
                System.out.println("Write command");
            } else {
                System.out.println("done");
            }
        }
    }
}