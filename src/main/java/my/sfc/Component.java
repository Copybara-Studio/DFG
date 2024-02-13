/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.sfc;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Component
{
    private Integer id;
    private ComponentType type;
    
    public Component(int id, ComponentType type)
    {
        this.id = id;
        this.type = type;
    }
    
    public Integer getID()
    {
        return id;
    }
    
    public ComponentType getType()
    {
        return type;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Component[ID=");
        builder.append(id);
        builder.append(", type=");
        builder.append(type.name());
        builder.append("]");
        return builder.toString();
    }
}
