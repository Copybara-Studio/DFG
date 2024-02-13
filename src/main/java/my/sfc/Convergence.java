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
public class Convergence extends Component
{
    private Collection<Integer> sources;
    //private Collection<Step> inputSteps;
    //private Step outputStep;

    public Convergence(int id, Collection<Integer> sources)
    {
        super(id, ComponentType.CONVERGENCE);
        this.sources = sources;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(":[sources=");
        
        // tu trzeba by dopisać elementy 'sources'
        
        return builder.toString();
    }
}
