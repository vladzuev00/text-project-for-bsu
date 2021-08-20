package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.SymbolComponent;

public abstract class SymbolCompositeCreator<TypeOfComponentOfCreatedComposite extends SymbolComponent>
        implements SymbolCompositeCreatable<TypeOfComponentOfCreatedComposite>
{
    private SymbolCompositeCreator<? extends SymbolComponent> nextSymbolCompositeCreator;

    public SymbolCompositeCreator()
    {
        this.nextSymbolCompositeCreator = null;
    }

    public SymbolCompositeCreator(final SymbolCompositeCreator<? extends SymbolComponent> nextSymbolCompositeCreator)
    {
        this.nextSymbolCompositeCreator = nextSymbolCompositeCreator;
    }

    public final void setNextSymbolCompositeCreator(
            final SymbolCompositeCreator<? extends SymbolComponent> nextSymbolCompositeCreator)
    {
        this.nextSymbolCompositeCreator = nextSymbolCompositeCreator;
    }

    public final SymbolCompositeCreator<? extends SymbolComponent> getNextSymbolCompositeCreator()
    {
        return this.nextSymbolCompositeCreator;
    }
}
