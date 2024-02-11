/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

import java.util.*;

/**
 * A single transition in a SFC.
 * 
 * Definition 3.15., page 85.
 * 
 * @author Kay Jay O'Nail
 */
public class Transition
{
    private Collection<Step> inputSteps;
    private Collection<Step> outputSteps;
    private boolean condition;
}
