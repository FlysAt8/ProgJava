package lr8.tasks;

import java.util.Scanner;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParserTask {
    private static final String FILE_PATH = "src/lr8/tasks/tasks.xml";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Текущие задачи\n");
        getTask();

        System.out.println("Для добавления задачи введите:");
        System.out.print("Название задачи: ");
        String title = in.nextLine();
        System.out.print("Приоритет: ");
        String priority = in.nextLine();
        System.out.print("Статус: ");
        String status = in.nextLine();
        addTask(title, priority, status);

        System.out.println("Новые задачи");
        getTask();

        System.out.print("Введите статус для поиска: ");
        status = in.nextLine();
        serchTask(status);

        System.out.print("Введите название для удаления: ");
        title = in.nextLine();
        deleteTask(title);
        System.out.println("Обновленный список");
        getTask();


        in.close();
    }

    public static void addTask(String title, String priority, String status) {
        try {
            File imputFile = new File(FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(imputFile);

            Element root = doc.getDocumentElement();
            Element newTask = doc.createElement("task");

            Element titleElement = doc.createElement("title");
            titleElement.appendChild(doc.createTextNode(title));
            newTask.appendChild(titleElement);

            Element priorityElement = doc.createElement("priority");
            priorityElement.appendChild(doc.createTextNode(priority));
            newTask.appendChild(priorityElement);
            
            Element statusElement = doc.createElement("status");
            statusElement.appendChild(doc.createTextNode(status));
            newTask.appendChild(statusElement);
            
            root.appendChild(newTask);

            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result 
                    = new javax.xml.transform.stream.StreamResult(new File(FILE_PATH));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void serchTask(String searchStatus) {
        try {
            File inputFile = new File(FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("task");
            
            boolean found = false;
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("status").item(0).getTextContent();
                    
                    if (title.toLowerCase().contains(searchStatus.toLowerCase())) {
                        System.out.println("Название задачи: " + element.getElementsByTagName("title").item(0).getTextContent());
                        System.out.println("Приоритет: " + element.getElementsByTagName("priority").item(0).getTextContent());
                        System.out.println("Статус: " + element.getElementsByTagName("status").item(0).getTextContent());
                        found = true;
                    }
                }
                System.out.println();
            }
            
            if (!found) {
                System.out.println("Задачи со статусом \"" + searchStatus + "\" не найдены");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask(String deleteTitle) {
        try {
            File inputFile = new File(FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList nodeList = doc.getElementsByTagName("task");
            
            boolean found = false;
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    
                    if (title.equalsIgnoreCase(deleteTitle)) {
                        // Удаляем задачу
                        root.removeChild(node);
                        found = true;
                        System.out.println("Задача \"" + deleteTitle + "\" успешно удалена!");
                        break;
                    }
                }
            }
            
            if (!found) {
                System.out.println("Задача с названием \"" + deleteTitle + "\" не найдена");
                return;
            }
            
            // Сохраняем изменения в файл
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result 
                    = new javax.xml.transform.stream.StreamResult(new File(FILE_PATH));
            transformer.transform(source, result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getTask() {
        try {
            File imputFile = new File(FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(imputFile);
            

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("task");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Название задачи: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Приоритет: " + element.getElementsByTagName("priority").item(0).getTextContent());
                    System.out.println("Статус: " + element.getElementsByTagName("status").item(0).getTextContent());
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
