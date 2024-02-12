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
    private boolean initial_step;
    private boolean active;
    private Collection<Action> actions;

    public Step(int id, String name, boolean initial_step, boolean active)
    {
        this.id = id;
        this.name = name;
        this.initial_step = initial_step;
        this.active = false;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initial_step=" + initial_step +
                ", active=" + active +
                ", actions=" + actions +
                '}';
    }
}
