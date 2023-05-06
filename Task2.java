import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Task2 {
    public static ArrayList<String> getName(String [] list){
        ArrayList<String> namesList = new ArrayList<>();

        for (String name : list) {
            String [] fullName = name.split(" ");
            namesList.add(fullName[0]);
        }
        return namesList;
    }

    public static HashMap<String, Integer> makeMap(ArrayList<String> names) {
        HashMap<String, Integer> namesMap = new HashMap<>();
        for (String name : names) {
            if (namesMap.containsKey(name)) {
                namesMap.put(name, namesMap.get(name) + 1);
            } else {
                namesMap.put(name, 1);
            }
        }
        return namesMap;
    }

    public static void printSortedNames(Map<String, Integer> map){
        ArrayList<Integer> listCount = new ArrayList<>();
        for(var item : map.entrySet()) {
            if (listCount.contains(item.getValue()) == false) listCount.add(item.getValue());
        }
        listCount.sort(null);
        for (int i = listCount.size()-1; i >= 0; i--){
            for (var item: map.entrySet()){
                if (listCount.get(i) == item.getValue())
                System.out.printf("%s: %d;\n", item.getKey(), item.getValue());
            }
        }
    }
    public static void main(String[] args) {
        String[] people = new String[] {
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"
        };

        ArrayList<String> names = getName(people);
        HashMap<String, Integer> mapOfNames =  makeMap(names);

        System.out.println("Имена, отсортированные по убыванию популярности: ");
        printSortedNames(mapOfNames);
    }
}