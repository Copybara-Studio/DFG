/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

/**
 * 
 * @author Kay Jay O'Nail
 */
public class Variable
{
    private int value;
    private ReadingNode reader;
    private WritingNode writer;
    
    public void setValue(int newValue)
    {
        value = newValue;
    }
    
    public int getValue()
    {
        return value;
    }
    
//    public void setReader(ReadingNode node)
//    {
//        reader = node;
//        // (This shall be the variable of the node.)
//    }
//    
//    public void setWriter(WritingNode node)
//    {
//        writer = node;
//        node.setVariable(this);
//        // (This shall be the variable of the node.)
//    }
}
