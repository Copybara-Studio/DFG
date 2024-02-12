/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Program in form of a Sequential Function Chart.
 *
 * Definition 3.13., page 85.
 *
 * @author Kay Jay O'Nail
 */
public class SequentialFunctionChart
{
    private Collection<Step> steps = new ArrayList<>();
    private Collection<Step> startSteps = new ArrayList<>(); // subset of 'steps'!
    private Collection<Transition> transitions = new ArrayList<>();
    private Collection<Action> actions = new ArrayList<>();
    private Collection<Variable> vars = new ArrayList<>(); // you can treat it as a map -> variables in transitions

    public void readFromXML(String fileName) throws ParserConfigurationException, IOException, SAXException
    {
        File file = new File(fileName);
        System.out.println("File path : " + file.getAbsolutePath());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("variable");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            addVarToSFC(nodeList.item(i));
        }
        nodeList = document.getElementsByTagName("step");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            addStepToSFC(nodeList.item(i));
        }
        nodeList = document.getElementsByTagName("transition");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            addTransitionToSFC(nodeList.item(i));
        }
    }

    private void addTransitionToSFC(Node node)
    {
        int id = Integer.parseInt(node.getAttributes().getNamedItem("localId").getNodeValue());
        String condition = "";
        int source = -1;

        NodeList transitionChildren = node.getChildNodes();
        for (int j = 0; j < transitionChildren.getLength(); j++)
        {
            Node transitionChild = transitionChildren.item(j);
            if (transitionChild.getNodeName().equals("connectionPointIn"))
            {
                NodeList connectionPointInChildren = transitionChild.getChildNodes();
                for (int k = 0; k < connectionPointInChildren.getLength(); k++)
                {
                    if (connectionPointInChildren.item(k).getNodeName().equals("refLocalId"))
                    {
                        source = Integer.parseInt(connectionPointInChildren.item(k).getAttributes().getNamedItem("refLocalId").getNodeValue());
                    }
                }
            }
            else if (transitionChild.getNodeName().equals("condition"))
            {
                NodeList conditionChildren = transitionChild.getChildNodes();
                for (int k = 0; k < conditionChildren.getLength(); k++)
                {
                    if (conditionChildren.item(k).getNodeName().equals("inline"))
                    {
                        for (int l = 0; l < conditionChildren.item(k).getChildNodes().getLength(); l++)
                        {
                            if (conditionChildren.item(k).getChildNodes().item(l).getNodeName().equals("ST"))
                            {
                                condition = conditionChildren.item(k).getChildNodes().item(l).getTextContent().trim();
                                System.out.println("DUPA123: " + condition.trim());
                            }
                        }
                    }
                }
            }
        }
        transitions.add(new Transition(id, condition, source));
    }

    private void addStepToSFC(Node node)
    {
        int id = Integer.parseInt(node.getAttributes().getNamedItem("localId").getNodeValue());
        String name = node.getAttributes().getNamedItem("name").getNodeValue();
        boolean initialStep = Boolean.parseBoolean(node.getAttributes().getNamedItem("initialStep").getNodeValue());
        
        Step step = new Step(id, name, initialStep);
        steps.add(step);
        if (initialStep)
        {
            startSteps.add(step);
        }
    }

    private void addVarToSFC(Node node)
    {
        vars.add(new Variable(node.getAttributes().getNamedItem("name").getNodeValue()));
    }

    public void printSFC()
    {
        System.out.println("Steps:");
        for (Step step : steps)
        {
            System.out.println(step);
        }
        System.out.println("Start steps:");
        for (Step step : startSteps)
        {
            System.out.println(step);
        }
        System.out.println("Transitions:");
        for (Transition transition : transitions)
        {
            System.out.println(transition);
        }
        System.out.println("Variables:");
        for (Variable var : vars)
        {
            System.out.println(var);
        }
    }

    /* Jakieś akcesory do treści tego SFC, żeby go przerobić na graf.
       W praniu wyjdzie. */
}
