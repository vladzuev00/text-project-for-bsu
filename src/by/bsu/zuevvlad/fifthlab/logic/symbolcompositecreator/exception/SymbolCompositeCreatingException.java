package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception;

public final class SymbolCompositeCreatingException extends Exception
{
    public SymbolCompositeCreatingException()
    {
        super();
    }

    public SymbolCompositeCreatingException(final String description)
    {
        super(description);
    }

    public SymbolCompositeCreatingException(final Exception cause)
    {
        super(cause);
    }

    public SymbolCompositeCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
