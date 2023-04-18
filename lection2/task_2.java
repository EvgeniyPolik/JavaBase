package lection2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class task_2 {
    private static List<String> GetInfo(String fileName) throws IOException
    {
        List<String> result = new ArrayList<String>(10);
        File activeFile = new File(fileName);
        try {
            FileReader fileReader = new FileReader(activeFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while(line != null) {
                result.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
        return result;
    }
    private static void PrintInfo(List<String> originInfo)
    {
        for (var item : originInfo) {
            StringBuilder resultLine = new StringBuilder();
            var tmp = ((String) item).split(",");
            resultLine.append("Студент ");
            resultLine.append(tmp[0].split(":")[1]);
            resultLine.append(" получил ");
            resultLine.append(tmp[1].split(":")[1]);
            resultLine.append(" по предмету ");
            resultLine.append(tmp[2].split(":")[1]);
            System.out.println(resultLine.toString());
        }
    }
    public static void main(String[] args) throws IOException {
        var info = GetInfo("task_2.txt");
        PrintInfo(info);        
    }
    
}
