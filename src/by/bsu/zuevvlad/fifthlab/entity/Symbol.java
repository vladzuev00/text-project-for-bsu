package by.bsu.zuevvlad.fifthlab.entity;

public final class Symbol implements SymbolComponent
{
    private final char character;

    public static final String REGULAR_EXPRESSION_OF_SYMBOL = ".";
    public static final String REGULAR_EXPRESSION_OF_LETTER = "[a-zA-Z]";
    public static final String ALLOWABLE_PUNCTUATION_SIGNS = ",:;";
    public static final String ALLOWABLE_SIGNS_OF_END_OF_SENTENCE = ".!?";

    public Symbol(final char character)
    {
        super();
        this.character = character;
    }

    public final char getCharacter()
    {
        return this.character;
    }

    @Override
    public final String compose()
    {
        return Character.toString(this.character);
    }

    @Override
    public final String toString()
    {
        return this.getClass().getSimpleName() + "[character = " + this.character + "]";
    }

    @Override
    public final boolean equals(final Object otherObject)
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
        final Symbol other = (Symbol)otherObject;
        return this.character == other.character;
    }

    @Override
    public final int hashCode()
    {
        return Character.hashCode(this.character);
    }
}
