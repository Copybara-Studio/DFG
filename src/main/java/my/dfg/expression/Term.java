/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.expression;

/**
 * Represents a term an expression consists of. A term is a variable, constant
 * or operation. Subclasses are used when additional information is needed.
 * Use factory method <code>makeTerm</code> to produce new terms.
 * 
 * @author Kay Jay O'Nail
 */
public class Term
{
    /**
     * Type of the term.
     */
    private final TermType type;
    
    /**
     * Constructor. Self-explanatory.
     * @param type the type
     */
    protected Term(TermType type)
    {
        this.type = type;
    }
    
    /**
     * Accessor. Self-explanatory.
     * @return the type
     */
    public TermType getType()
    {
        return type;
    }
}
