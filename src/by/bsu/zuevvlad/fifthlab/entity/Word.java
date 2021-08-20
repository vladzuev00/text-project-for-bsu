package by.bsu.zuevvlad.fifthlab.entity;

import java.util.List;
//TODO: the better to do "Lexeme extends SymbolComposite<Symbol>" and "Sentence extends SymbolComposite<Lexeme>" instead of it, lexeme contains letters of word and signs of punctuations
public final class Word extends SymbolComposite<Symbol>
{
    public static final String REGULAR_EXPRESSION_OF_WORD = Symbol.REGULAR_EXPRESSION_OF_LETTER + "+";

    public Word()
    {
        super();
    }

    public Word(final List<Symbol> letters)
    {
        super(letters);
    }
}