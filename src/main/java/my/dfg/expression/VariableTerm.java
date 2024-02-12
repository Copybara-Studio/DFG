/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.expression;

/**
 * Term representing a variable.
 * 
 * @author Kay Jay O'Nail
 */
public class VariableTerm extends Term
{
    /**
     * The label of the variable.
     */
    private final String label;
    
    /**
     * Constructor. Self-explanatory.
     * 
     * @param label the label
     */
    public VariableTerm(String label)
    {
        super(TermType.VARIABLE);
        this.label = label;
    }
    
    /**
     * Accessor. Self-explanatory.
     * 
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }
}
