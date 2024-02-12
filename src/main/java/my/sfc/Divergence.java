/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

import java.util.Collection;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Divergence
{
    private int id;
    private int source;
    //private Step inputStep;
    //private Collection<Step> outputSteps;

    public Divergence(int id, int source) {
        this.id = id;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Divergence{" +
                "id=" + id +
                ", inputStep=" + source +
                '}';
    }
}
