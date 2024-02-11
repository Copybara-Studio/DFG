/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

import java.util.*;

/**
 * Program in form of a Sequential Function Chart.
 * 
 * Definition 3.13., page 85.
 * 
 * @author Kay Jay O'Nail
 */
public class SequentialFunctionChart
{
    private Collection<Step> steps;
    private Collection<Step> startSteps; // subset of 'steps'!
    private Collection<Transition> transitions;
    private Collection<Action> actions;
    
    public void readFromXML()
    {
        // ...
    }
    
    /* Jakieś akcesory do treści tego SFC, żeby go przerobić na graf.
       W praniu wyjdzie. */
}
