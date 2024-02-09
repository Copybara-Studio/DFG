/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package my.dfg.expression;

/**
 *
 * @author Kay Jay O'Nail
 */
public enum TermType
{
    VARIABLE, // to reading or writing
    ASSIGNMENT, // symbol: <-
    CONSTANT,
    
    SUM, // symbol: +
    PRODUCT, // symbol: *
    QUOTIENT, // symbol: /
    
    CONJUNCTION, // symbol: &
    DISJUNCTION, // symbol: |
    
    EQUAL, // symbol: =
    GREATER, // symbol: >
    
    COMPLEMENT, // -
    NEGATION, // !
    REMAINDER // %
    
    //, SELECTION
}
