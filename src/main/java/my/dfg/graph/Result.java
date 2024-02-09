/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.graph;

import java.util.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Result
{
    private int value;
    private Map<String, Integer> notes;
    
    public Result(int value)
    {
        this.value = value;
        notes = new HashMap<>();
    }
    
    public void set(int newValue)
    {
        value = newValue;
    }
    public int get()
    {
        return value;
    }
    
    public void addNote(String label, int value)
    {
        notes.put(label, value);
    }
    
    public Integer getNote(String label)
    {
        return notes.get(label);
    }
}
