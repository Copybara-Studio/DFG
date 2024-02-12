package my.dfg.extractor;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import my.dfg.expression.*;

public class Extractor {
    /**
     * The name of the file to extract data from.
     */
    private final String fileName;

    /**
     * The collection of variables extracted from the file.
     */
    ArrayList<Term> termsCollection = new ArrayList<>();


    /**
     * Constructor for the extractor class.
     * @param fileName The name of the file to extract data from.
     */
    public Extractor(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Extracts useful data from the file.
     * @throws ParserConfigurationException the parser configuration exception
     * @throws IOException the io exception
     * @throws SAXException the sax exception
     */
    public void getTextFromFile() throws ParserConfigurationException, IOException, SAXException {
        File file = new File(fileName);
//        System.out.println("File path : " + file.getAbsolutePath());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("variable");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
//            System.out.println(node.getNodeName() + " with name: " + node.getAttributes().getNamedItem("name").getNodeValue());
            termsCollection.add(new VariableTerm(node.getAttributes().getNamedItem("name").getNodeValue()));
        }
        nodeList = document.getElementsByTagName("SFC");
    }

    /**
     * Prints the terms extracted from the file.
     */
    public void printTerms() {
        for (Term term : termsCollection) {
            System.out.println(term.getType() + " with label: " + ((VariableTerm) term).getLabel());
        }
    }
}
