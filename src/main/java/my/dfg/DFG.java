/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package my.dfg;

import my.dfg.expression.Expression;
import my.dfg.graph.Graph;

/**
 *
 * @author Kay Jay O'Nail
 */
public class DFG
{
    public static void main(String[] args)
    {
        try
        {
            Graph graph = new Graph();
            graph.createGraph(new Expression(""));
            graph.setVariable("X", 12);
            
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
