/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

import java.util.*;
import my.dfg.expression.Term;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Node
{
    private NodeOperation nodeOperation;
    
    private List<Edge> inputEdges;
    private List<Edge> outputEdges;
    
    protected Node(NodeOperation operation)
    {
        nodeOperation = operation;
        inputEdges = new ArrayList<>();
        outputEdges = new ArrayList<>();
    }
    
    public void addInputEdge(Edge edge)
    {
        inputEdges.add(edge);
        // (This shall become the edge's head.)
    }
    
    public void addOutputEdge(Edge edge)
    {
        outputEdges.add(edge);
        // (This shall become the edge's tail.)
    }
    
    public static Node makeNode(NodeOperation operation)
    {
        Node node = null;
        
        switch (operation)
        {
            case READ ->
            {
                node = new ReadingNode();
            }
        }
        
        return node;
    }
}
