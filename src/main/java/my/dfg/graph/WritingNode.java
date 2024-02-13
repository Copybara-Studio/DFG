/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

/**
 *
 * @author Kay Jay O'Nail
 */
public class WritingNode extends Node
{
    Variable variable;
    
    public WritingNode()
    {
        super(NodeOperation.WRITE);
    }
    
    public void setVariable(Variable newVariable)
    {
        variable = newVariable;
        variable.setWriter(this);
    }
    
    @Deprecated
    @Override
    public Result getResult() throws Exception
    {
        return null;
    }
}
