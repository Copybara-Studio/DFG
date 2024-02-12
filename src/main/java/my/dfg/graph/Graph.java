/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

import java.util.*;
import my.dfg.expression.*;
import my.sfc.SequentialFunctionChart;

class Element
{
    private final Node node;
    private int requiredResources;

    public Element(Node node, int count)
    {
        this.node = node;
        requiredResources = count;
    }

    public Node useNode()
    {
        --requiredResources;
        return node;
    }

    public int getCount()
    {
        return requiredResources;
    }
}

/**
 *
 * @author Kay Jay O'Nail
 */
public class Graph
{
    private Map<String, Variable> variables;
    private List<Node> nodes;
    private List<Edge> edges;

    public Graph()
    {
        variables = new HashMap<>();
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }
    
    public void setVariable(String label, int value)
    {
        Variable variable;
        if (variables.containsKey(label))
        {
            variable = variables.get(label);
        }
        else
        {
            variable = new Variable();
        }
        variable.setValue(value);
        variables.put(label, variable);
    }
    
    public Integer getVariable(String label)
    {
        Integer result = null;
        Variable variable = variables.get(label);
        if (variable != null)
        {
            result = variable.getValue();
        }
        return result;
    }

    private void extractOutputVariable(Expression expression, Stack<Element> stack) throws Exception
    {
        Term firstTerm = expression.get();
        if (firstTerm.getType() != TermType.VARIABLE)
        {
            throw new Exception("The expression must begin with a variable!");
        }
        String label = ((VariableTerm) firstTerm).getLabel();
        Variable outputVariable;
        if (!variables.containsKey(label))
        {
            outputVariable = new Variable();
        }
        else
        {
            outputVariable = variables.get(label);
        }
        WritingNode outputNode = (WritingNode) Node.makeNode(NodeOperation.WRITE);
        outputNode.setVariable(outputVariable);
        variables.put(label, outputVariable);
        nodes.add(outputNode);
        stack.push(new Element(outputNode, NodeOperation.WRITE.getArgsCount()));
    }
    
    public void createGraph(SequentialFunctionChart sfc)
    {
        
    }
    
    @Deprecated
    public void createGraph(Expression expression) throws Exception
    {
        Stack<Element> stack = new Stack<>();
        extractOutputVariable(expression, stack);
        EdgeAttribute attribute = EdgeAttribute.SIMPLE;

        for (Term term = expression.get(); term != null; term = expression.get())
        {
            switch (term.getType())
            {
                case VARIABLE ->
                {
                    String label = ((VariableTerm) term).getLabel();
                    Variable variable;
                    if (!variables.containsKey(label))
                    {
                        variable = new Variable();
                        variables.put(label, variable);
                    }
                    else
                    {
                        variable = variables.get(label);
                    }
                    ReadingNode node = (ReadingNode) Node.makeNode(NodeOperation.READ);
                    node.setVariable(variable);
                    Edge edge = new Edge(attribute);
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    nodes.add(node);
                    edges.add(edge);
                }
                case CONSTANT ->
                {
                    int value = ((ConstantTerm) term).getValue();
                    ConstantNode node = (ConstantNode) Node.makeNode(NodeOperation.CONSTANT);
                    node.initialize(value);
                    Edge edge = new Edge(attribute);
                    attribute = EdgeAttribute.SIMPLE;
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    nodes.add(node);
                    edges.add(edge);
                }
                case COMPLEMENT ->
                {
                    attribute = EdgeAttribute.COMPLEMENT;

                }
                case NEGATION ->
                {
                    attribute = EdgeAttribute.NEGATION;

                }
                case REMAINDER ->
                {
                    /* There might be a problem if one wants to use complement
                       or negate the remainder... */
                    Node node = Node.makeNode(NodeOperation.QUOTIENT);
                    Edge edge = new Edge(EdgeAttribute.REMAINDER);
                    attribute = EdgeAttribute.SIMPLE;
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    stack.push(new Element(node, NodeOperation.QUOTIENT.getArgsCount()));
                    nodes.add(node);
                    edges.add(edge);
                }
                case SUM ->
                {
                    Node node = Node.makeNode(NodeOperation.SUM);
                    Edge edge = new Edge(attribute);
                    attribute = EdgeAttribute.SIMPLE;
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    stack.push(new Element(node, NodeOperation.QUOTIENT.getArgsCount()));
                    nodes.add(node);
                    edges.add(edge);
                }
                case PRODUCT ->
                {
                    Node node = Node.makeNode(NodeOperation.PRODUCT);
                    Edge edge = new Edge(attribute);
                    attribute = EdgeAttribute.SIMPLE;
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    stack.push(new Element(node, NodeOperation.PRODUCT.getArgsCount()));
                    nodes.add(node);
                    edges.add(edge);
                }
                case QUOTIENT ->
                {
                    Node node = Node.makeNode(NodeOperation.QUOTIENT);
                    Edge edge = new Edge(attribute);
                    attribute = EdgeAttribute.SIMPLE;
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    stack.push(new Element(node, NodeOperation.QUOTIENT.getArgsCount()));
                    nodes.add(node);
                    edges.add(edge);
                }
                case CONJUNCTION ->
                {
                    Node node = Node.makeNode(NodeOperation.CONJUNCTION);
                    Edge edge = new Edge(attribute);
                    attribute = EdgeAttribute.SIMPLE;
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    stack.push(new Element(node, NodeOperation.CONJUNCTION.getArgsCount()));
                    nodes.add(node);
                    edges.add(edge);
                }
                case DISJUNCTION ->
                {
                    Node node = Node.makeNode(NodeOperation.DISJUNCTION);
                    Edge edge = new Edge(attribute);
                    attribute = EdgeAttribute.SIMPLE;
                    node.addOutputEdge(edge);
                    assert (!stack.isEmpty());
                    stack.peek().useNode().addInputEdge(edge);
                    if (stack.peek().getCount() == 0)
                    {
                        stack.pop();
                    }
                    stack.push(new Element(node, NodeOperation.DISJUNCTION.getArgsCount()));
                    nodes.add(node);
                    edges.add(edge);
                }
            }
            // attribute = EdgeAttribute.SIMPLE;
        }
    }
}
