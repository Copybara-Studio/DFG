/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

import java.util.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Node
{
    private final NodeOperation myOperation;

    private final List<Edge> inputEdges;
    private final List<Edge> outputEdges;

    protected Node(NodeOperation operation)
    {
        myOperation = operation;
        inputEdges = new ArrayList<>();
        outputEdges = new ArrayList<>();
    }

    public void addInputEdge(Edge edge)
    {
        inputEdges.add(edge);
        edge.setHead(this);
    }

    public void addOutputEdge(Edge edge)
    {
        outputEdges.add(edge);
        edge.setTail(this);
    }

    public Result getResult() throws Exception
    {
        Result result = new Result();
        switch (myOperation)
        {
            case SUM ->
                computeSum(result);
            case PRODUCT ->
                computeProduct(result);
            case QUOTIENT ->
                computeQuotient(result);
            case CONJUNCTION ->
                computeConjunction(result);
            case DISJUNCTION ->
                computeDisjunction(result);
            // ...
        }
        return result;
    }

    public static Node makeNode(NodeOperation operation)
    {
        Node node;
        switch (operation)
        {
            case READ ->
                node = new ReadingNode();
            case WRITE ->
                node = new WritingNode();
            case CONSTANT ->
                node = new ConstantNode();
            default ->
                node = new Node(operation);
        }
        return node;
    }

    private void computeSum(Result result) throws Exception
    {
        if (inputEdges.isEmpty())
        {
            throw new Exception("No inputs for summation!");
        }
        int sum = 0;
        for (var edge : inputEdges)
        {
            sum += edge.getResult().get();
        }
        result.set(sum);
    }

    private void computeProduct(Result result) throws Exception
    {
        if (inputEdges.isEmpty())
        {
            throw new Exception("No inputs for multiplication!");
        }
        int product = 0;
        for (var edge : inputEdges)
        {
            product *= edge.getResult().get();
        }
        result.set(product);
    }

    private void computeQuotient(Result result) throws Exception
    {
        if (inputEdges.size() == 2)
        {
            int dividend = inputEdges.get(0).getResult().get();
            int divisor = inputEdges.get(1).getResult().get();
            if (divisor == 0)
            {
                throw new Exception("Division by zero!");
            }
            else
            {
                result.set(dividend / divisor);
                result.addNote("remainder", dividend % divisor);
            }
        }
        else
        {
            throw new Exception("Wrong number of inputs for division!");
        }
    }

    private void computeConjunction(Result result) throws Exception
    {
        if (inputEdges.isEmpty())
        {
            throw new Exception("No inputs for summation!");
        }
        int conjunction = 1;
        for (var edge : inputEdges)
        {
            if (edge.getResult().get() == 0)
            {
                conjunction = 0;
                break;
            }
        }
        result.set(conjunction);
    }

    private void computeDisjunction(Result result) throws Exception
    {
        if (inputEdges.isEmpty())
        {
            throw new Exception("No inputs for summation!");
        }
        int disjunction = 0;
        for (var edge : inputEdges)
        {
            if (edge.getResult().get() != 0)
            {
                disjunction = 1;
                break;
            }
        }
        result.set(disjunction);
    }
}
