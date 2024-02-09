/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

/**
 *
 * @author Kay Jay O'Nail
 */
public class ReadingNode extends Node
{
    Variable variable;
    
    public ReadingNode()
    {
        super(NodeOperation.READ);
    }
    
    public void setVariable(Variable newVariable)
    {
        variable = newVariable;
    }
}
