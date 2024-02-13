/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

import java.util.*;

/**
 * A single step of a SFC.
 * 
 * Definition 3.14., page 85.
 * 
 * @author Kay Jay O'Nail
 */
public class Step
{
    private int id;
    private String name;
    private boolean initialStep;
    private boolean active;
    private Collection<Action> actions;

    public Step(int id, String name, boolean initialStep)
    {
        this.id = id;
        this.name = name;
        this.initialStep = initialStep;
        this.active = false;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initial_step=" + initialStep +
                ", active=" + active +
                ", actions=" + actions +
                '}';
    }
}
