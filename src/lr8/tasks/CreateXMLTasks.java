package lr8.tasks;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CreateXMLTasks {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("tasks");
            doc.appendChild(rootElement);

            Element task1 = doc.createElement("task");
            rootElement.appendChild(task1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Купить продукты"));
            task1.appendChild(title1);

            Element priority1 = doc.createElement("priority");
            priority1.appendChild(doc.createTextNode("Высокий"));
            task1.appendChild(priority1);

            Element status1 = doc.createElement("status");
            status1.appendChild(doc.createTextNode("В работе"));
            task1.appendChild(status1);

            Element task2 = doc.createElement("task");
            rootElement.appendChild(task2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Сделать ДЗ"));
            task2.appendChild(title2);

            Element priority2 = doc.createElement("priority");
            priority2.appendChild(doc.createTextNode("Средний"));
            task2.appendChild(priority2);

            Element status2 = doc.createElement("status");
            status2.appendChild(doc.createTextNode("Выполнена"));
            task2.appendChild(status2);

            Element task3 = doc.createElement("task");
            rootElement.appendChild(task3);

            Element title3 = doc.createElement("title");
            title3.appendChild(doc.createTextNode("Написать отчет"));
            task3.appendChild(title3);

            Element priority3 = doc.createElement("priority");
            priority3.appendChild(doc.createTextNode("Низкий"));
            task3.appendChild(priority3);

            Element status3 = doc.createElement("status");
            status3.appendChild(doc.createTextNode("Не начата"));
            task3.appendChild(status3);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result 
                    = new javax.xml.transform.stream.StreamResult(new File("src/lr8/tasks/tasks.xml"));
            transformer.transform(source, result);

            System.out.println("XML файл создан");
        } catch (Exception pce) {
            pce.printStackTrace();
        }
    }
}
