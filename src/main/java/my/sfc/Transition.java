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
    private int id;
    private String name;
    private int source;
//    private Collection<Step> inputSteps;
//    private Collection<Step> outputSteps;
    private String condition;

    public Transition(int id, String condition, int source) {
        this.id = id;
        this.condition = condition;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "id=" + id +
                ", source=" + source +
                ", condition=" + condition +
                '}';
    }
}
