/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.expression;

/**
 * Term representing a constant.
 * 
 * @author Kay Jay O'Nail
 */
public class ConstantTerm extends Term
{
    /**
     * The value of the constant.
     */
    private final int value;
    
    /**
     * Constructor. Self-explanatory.
     * @param value the value
     */
    public ConstantTerm(int value)
    {
        super(TermType.CONSTANT);
        this.value = value;
    }
    
    /**
     * Accessor. Self-explanatory.
     * 
     * @return the value
     */
    public int getValue()
    {
        return value;
    }
}
