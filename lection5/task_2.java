import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


class task_2 {
    private static void PrintItems(ArrayList<name_to_task_2> origin) {
        for (name_to_task_2 item : origin) {
            System.out.printf("%s %d\n", item.Name, item.Count);
        }
    }


    private static ArrayList<name_to_task_2> MakeNamesArray(ArrayList<String> origin) {
        ArrayList<name_to_task_2> result = new ArrayList<name_to_task_2>();
        HashMap<String, Integer> tmpResult  = new HashMap<String, Integer>();

        for (String item : origin) {
            String name = item.split(" ")[0];
            if(tmpResult.containsKey(name))
                tmpResult.put(name, tmpResult.get(name) + 1);
            else
                tmpResult.put(name, 1);
        }

        for (var elem : tmpResult.entrySet()) 
            result.add(new name_to_task_2(elem.getKey(), elem.getValue()));
        
        
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> mainList = new ArrayList<String>( Arrays.asList(
            "Иван Иванов",
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
            "Иван Ежов"));

        var catalogName = MakeNamesArray(mainList);
        Collections.sort(catalogName);
        PrintItems(catalogName);
    }
}