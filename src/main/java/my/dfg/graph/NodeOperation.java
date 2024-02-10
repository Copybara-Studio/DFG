/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package my.dfg.graph;

/**
 *
 * @author Kay Jay O'Nail
 */
public enum NodeOperation
{
    READ(0),
    WRITE(1),
    CONSTANT(0),
    
    SUM(2),
    PRODUCT(2),
    QUOTIENT(2),
    
    CONJUNCTION(2),
    DISJUNCTION(2),
    
    EQUAL(2),
    GREATER(2),
    
    SELECTION(2);
    
    private int demandedArguments;
    
    private NodeOperation(int args)
    {
        demandedArguments = args;
    }
    
    public int getArgsCount()
    {
        return demandedArguments;
    }
}
