package by.bsu.zuevvlad.fifthlab.entity;

import java.util.List;

public final class Sentence extends SymbolComposite<SymbolComponent>
{
    public static final String REGULAR_EXPRESSION_OF_SENTENCE = "((" + Word.REGULAR_EXPRESSION_OF_WORD + "([ \n)"
            + Symbol.ALLOWABLE_PUNCTUATION_SIGNS + "]+ ?)?)+" + Word.REGULAR_EXPRESSION_OF_WORD + "["
            + Symbol.ALLOWABLE_SIGNS_OF_END_OF_SENTENCE + "]+)+";

    public Sentence()
    {
        super();
    }

    public Sentence(final List<SymbolComponent> wordsAndPunctuationSignsOfSentence)
    {
        super(wordsAndPunctuationSignsOfSentence);
    }

    @Override
    public final String compose()
    {
        final StringBuilder composedSentence = new StringBuilder();
        final List<SymbolComponent> wordsAndPunctuationSignsOfSentence = this.getComponents();
        composedSentence.append(wordsAndPunctuationSignsOfSentence.get(0).compose());
        SymbolComponent currentComponentOfSentence;
        boolean previousIsNewLine = false;
        for(int i = 1; i < wordsAndPunctuationSignsOfSentence.size(); i++)
        {
            currentComponentOfSentence = wordsAndPunctuationSignsOfSentence.get(i);
            if((currentComponentOfSentence instanceof Word) && !previousIsNewLine)
            {
                composedSentence.append(Sentence.PREFIX_OF_WORD_IN_SENTENCE);
            }
            composedSentence.append(currentComponentOfSentence.compose());
            previousIsNewLine = currentComponentOfSentence.equals(Sentence.SYMBOL_OF_NEW_LINE);
        }
        return composedSentence.toString();
    }

    private static final Symbol SYMBOL_OF_NEW_LINE = new Symbol('\n');
    private static final char PREFIX_OF_WORD_IN_SENTENCE = ' ';
}
