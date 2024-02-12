/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Convergence
{
    private int id;
    private Collection<Integer> sources;
    //private Collection<Step> inputSteps;
    //private Step outputStep;

    public Convergence(int id, Collection<Integer> sources) {
        this.id = id;
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "Convergence{" +
                "id=" + id +
                ", inputSteps=" + sources +
                '}';
    }
}
