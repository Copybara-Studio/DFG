/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package my.sfc;

/**
 * Qualifier of a trigger. ("kwalifikator wyzwalania"))
 * 
 * Table A.5., page 220.
 * 
 * @author Kay Jay O'Nail
 */
public enum Qualifier
{
    /**
     * The action is being performed only while the associated step is active.
     */
    N,
    
    /**
     * Execution of associated action is stopped.
     */
    R,
    
    /**
     * 
     */
    S,
    L,
    D,
    P, 
    SD, 
    DS, 
    SL
}
