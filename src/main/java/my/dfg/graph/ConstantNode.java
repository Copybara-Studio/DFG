/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

/**
 *
 * @author Kay Jay O'Nail
 */
public class ConstantNode extends Node
{
    private int value;
    private boolean initialized = false;
    
    public ConstantNode()
    {
        super(NodeOperation.CONSTANT);
    }
    
    public void initialize(int theValue)
    {
        if (!initialized)
        {
            value = theValue;
            initialized = true;
        }
    }
    
    @Override
    public Result getResult() throws Exception
    {
        return new Result(value);
    }
}
