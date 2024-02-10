/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Edge
{
    private EdgeAttribute myAttribute;
    private Node tail;
    private Node head;
    
    public Edge(EdgeAttribute attribute)
    {
        myAttribute = attribute;
    }
    
    public Edge()
    {
        myAttribute = EdgeAttribute.SIMPLE;
    }
    
    public void setTail(Node node)
    {
        tail = node;
    }
    
    public void setHead(Node node)
    {
        head = node;
    }
    
    public Result getResult() throws Exception
    {
        Result result = null;
        if (tail != null)
        {
            result = tail.getResult();
            switch (myAttribute)
            {
                case SIMPLE ->
                {
                    /* Do nothing. */
                }
                case COMPLEMENT ->
                {
                    result.set(-result.get());
                }
                case NEGATION ->
                {
                    result.set(result.get() == 0 ? 0 : 1);
                }
                case REMAINDER ->
                {
                    Integer remainder = result.getNote("remainder");
                    if (remainder != null)
                    {
                        result.set(remainder);
                    }
                    else
                    {
                        throw new Exception("No \'remainder\' attribute!");
                    }
                }
            }
            result.clearNote("remainder");
        }
        else
        {
            throw new Exception("The edge's tail is null!");
        }
        return result;
    }
}
