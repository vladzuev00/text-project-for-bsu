package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.*;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SentenceCreator extends SymbolCompositeCreator<SymbolComponent>
{
    public SentenceCreator()
    {
        super(SentenceCreator.WORD_CREATOR);
    }

    private static final WordCreator WORD_CREATOR = new WordCreator();

    @Override
    public final Sentence create(final String contentOfSentence)
            throws SymbolCompositeCreatingException
    {
        if(!SymbolCompositeCreatable.SYMBOL_COMPOSITE_VALIDATOR.isValidSentence(contentOfSentence))
        {
            throw new SymbolCompositeCreatingException("Impossible to create object of class '"
                    + Sentence.class.getName() + "' by given of its content. Given content : "
                    + contentOfSentence + ".");
        }
        final List<SymbolComponent> wordsAndSignsOfSentence = new ArrayList<SymbolComponent>();
        final String regularExpressionOfComponentOfSentence
                = SentenceCreator.findRegularExpressionOfComponentOfSentence();
        final Pattern patternOfComponentOfSentence = Pattern.compile(regularExpressionOfComponentOfSentence);
        final Matcher matcherOfComponentOfSentence = patternOfComponentOfSentence.matcher(contentOfSentence);
        String contentOfComponentOfSentence;
        SymbolComponent componentOfSentence;
        while(matcherOfComponentOfSentence.find())
        {
            contentOfComponentOfSentence = contentOfSentence.substring(
                    matcherOfComponentOfSentence.start(), matcherOfComponentOfSentence.end());
            if(SentenceCreator.isWord(contentOfComponentOfSentence))
            {
                componentOfSentence = SentenceCreator.WORD_CREATOR.create(contentOfComponentOfSentence);
            }
            else
            {
                componentOfSentence = new Symbol(contentOfComponentOfSentence.charAt(0));
            }
            wordsAndSignsOfSentence.add(componentOfSentence);
        }
        return new Sentence(wordsAndSignsOfSentence);
    }

    private static String findRegularExpressionOfComponentOfSentence()
    {
        return "(" + Word.REGULAR_EXPRESSION_OF_WORD + ")|([" + Symbol.ALLOWABLE_PUNCTUATION_SIGNS + "])|"
                + "([" + Symbol.ALLOWABLE_SIGNS_OF_END_OF_SENTENCE + "])|\n";
    }

    private static boolean isWord(final String researchString)
    {
        return researchString.matches(Word.REGULAR_EXPRESSION_OF_WORD);
    }
}