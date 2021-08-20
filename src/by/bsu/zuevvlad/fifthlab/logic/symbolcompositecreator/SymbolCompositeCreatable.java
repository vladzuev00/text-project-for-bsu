package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.SymbolComponent;
import by.bsu.zuevvlad.fifthlab.entity.SymbolComposite;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositevalidator.SymbolCompositeValidator;

@FunctionalInterface
public interface SymbolCompositeCreatable<TypeOfComponentOfCreatedComposite extends SymbolComponent>
{
    public static final SymbolCompositeValidator SYMBOL_COMPOSITE_VALIDATOR = new SymbolCompositeValidator();
    public abstract SymbolComposite<TypeOfComponentOfCreatedComposite> create(final String contentOfComposite)
            throws SymbolCompositeCreatingException;
}
