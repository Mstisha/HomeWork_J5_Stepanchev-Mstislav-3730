import java.util.ArrayList;
import java.util.HashMap;
public class Task1 {
    public static void addPhoneNumber(String key, String value, HashMap<String, ArrayList<String>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    public static void printPhoneBook(HashMap<String, ArrayList<String>> map){
        for (var item : map.entrySet()) {
            System.out.printf("%s: ", item.getKey());
            for(String el: item.getValue()){
                System.out.printf("%s; ", el);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        addPhoneNumber("Иванов Иван", "+7(982)999-88-77", phoneBook);
        addPhoneNumber("Иванов Иван", "+7(982)888-77-66", phoneBook);
        addPhoneNumber("Иванов Иван", "8(3456)78-90-11", phoneBook);
        addPhoneNumber("Чухонец Петр Сидорович", "+7(800)500-88-77", phoneBook);
        addPhoneNumber("Чухонец Петр Сидорович", "8(495)343-23-12", phoneBook);

        printPhoneBook(phoneBook);
    }
}