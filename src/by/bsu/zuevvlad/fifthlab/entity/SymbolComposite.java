package by.bsu.zuevvlad.fifthlab.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class SymbolComposite<TypeOfComponent extends SymbolComponent> implements SymbolComponent, Serializable
{
    private static final long serialVersionUID = 1L;

    private final List<TypeOfComponent> components;

    public SymbolComposite()
    {
        super();
        this.components = new ArrayList<TypeOfComponent>();
    }

    public SymbolComposite(final List<TypeOfComponent> components)
    {
        super();
        this.components = components;
    }

    public final List<TypeOfComponent> getComponents()
    {
        return this.components;
    }

    public final void add(final TypeOfComponent addedComponent)
    {
        this.components.add(addedComponent);
    }

    public final void remove(final TypeOfComponent removedComponent)
    {
        this.components.remove(removedComponent);
    }

    public final int findAmountOfComponents()
    {
        return this.components.size();
    }

    @Override
    public String compose()
    {
        final StringBuilder descriptionOfSymbolComposite = new StringBuilder();
        for(final SymbolComponent component : this.components)
        {
            descriptionOfSymbolComposite.append(component.compose());
        }
        return descriptionOfSymbolComposite.toString();
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + "[components = " + this.components + "]";
    }

    @Override
    public boolean equals(final Object otherObject)
    {
        if(this == otherObject)
        {
            return true;
        }
        if(otherObject == null)
        {
            return false;
        }
        if(this.getClass() != otherObject.getClass())
        {
            return false;
        }
        final SymbolComposite<TypeOfComponent> other = (SymbolComposite<TypeOfComponent>)otherObject;
        return this.components.equals(other.components);
    }

    @Override
    public int hashCode()
    {
        return this.components.hashCode();
    }
}
