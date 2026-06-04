package lr8.tasks;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONParserTask {
    private static final String FILE_PATH = "src/lr8/tasks/tasks.json";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        getTasks();

        System.out.println("\nДобавление новой задачи:");
        System.out.print("Название задачи: ");
        String title = in.nextLine();
        System.out.print("Приоритет: ");
        String priority = in.nextLine();
        System.out.print("Статус: ");
        String status = in.nextLine();
        addTask(title, priority, status);

        getTasks();

        System.out.print("Введите статус для поиска: ");
        status = in.nextLine();
        searchTaskByStatus(status);

        System.out.print("Введите название задачи для удаления: ");
        title = in.nextLine();
        deleteTaskByTitle(title);

        getTasks();

        in.close();
    }

    @SuppressWarnings("unchecked")
    public static void addTask(String title, String priority, String status) {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");
            reader.close();
            
            JSONObject newTask = new JSONObject();
            newTask.put("title", title);
            newTask.put("priority", priority);
            newTask.put("status", status);
            
            jsonArray.add(newTask);
            
            java.io.FileWriter writer = new java.io.FileWriter(FILE_PATH);
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();
            
            System.out.println("Задача \"" + title + "\" успешно добавлена!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchTaskByStatus(String searchStatus) {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");
            reader.close();
            
            boolean found = false;
            
            for (Object o : jsonArray) {
                JSONObject task = (JSONObject) o;
                String status = (String) task.get("status");
                
                if (status != null && status.toLowerCase().contains(searchStatus.toLowerCase())) {
                    System.out.println("Название: " + task.get("title"));
                    System.out.println("Приоритет: " + task.get("priority"));
                    System.out.println("Статус: " + status);
                    System.out.println();
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("Задачи со статусом \"" + searchStatus + "\" не найдены");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTaskByTitle(String deleteTitle) {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");
            reader.close();
            
            boolean found = false;
            int indexToRemove = -1;
            
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject task = (JSONObject) jsonArray.get(i);
                String title = (String) task.get("title");
                
                if (title != null && title.equalsIgnoreCase(deleteTitle)) {
                    indexToRemove = i;
                    found = true;
                    break;
                }
            }
            
            if (found) {
                jsonArray.remove(indexToRemove);
                
                java.io.FileWriter writer = new java.io.FileWriter(FILE_PATH);
                writer.write(jsonObject.toJSONString());
                writer.flush();
                writer.close();
                
                System.out.println("Задача \"" + deleteTitle + "\" успешно удалена!");
            } else {
                System.out.println("Задача с названием \"" + deleteTitle + "\" не найдена");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getTasks() {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("tasks");

            System.out.println("\nТекущие задачи\n");

            for (Object o : jsonArray) {
                JSONObject task = (JSONObject) o;
                System.out.println("Название задачи: " + task.get("title"));
                System.out.println("Приоритет: " + task.get("priority"));
                System.out.println("Статус: " + task.get("status"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
