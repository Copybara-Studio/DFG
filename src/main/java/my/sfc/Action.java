/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

import java.util.*;

/**
 * A single action in a SFC.
 * 
 * Definition 3.16., page 85.
 * 
 * @author Kay Jay O'Nail
 */
public class Action
{
    private boolean active;
    
    /**
     * There shall not be two triggers having both: the same qualifier
     * and the same time. (See expression (61) on page 86.) It is assumed that
     * this condition is asserted on construction of the XML file.
     */
    private Collection<Trigger> triggers;
    
    private Collection<Operation> operations;
}
