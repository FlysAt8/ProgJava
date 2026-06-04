package lr8.tasks;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSONTasks {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray tasks = new JSONArray();

        JSONObject task1 = new JSONObject();
        task1.put("title", "Task1");
        task1.put("priority", "High");
        task1.put("status", "InProgres");

        JSONObject task2 = new JSONObject();
        task2.put("title", "Task2");
        task2.put("priority", "Low");
        task2.put("status", "Done");

        JSONObject task3 = new JSONObject();
        task3.put("title", "Task3");
        task3.put("priority", "Medium");
        task3.put("status", "NotStarted");

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        library.put("tasks", tasks);

        try (FileWriter file = new FileWriter("src/lr8/tasks/tasks.json")) {
            file.write(library.toJSONString());
            System.out.println("Json файл создан");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
