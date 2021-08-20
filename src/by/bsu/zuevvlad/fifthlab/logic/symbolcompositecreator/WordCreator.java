package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.Symbol;
import by.bsu.zuevvlad.fifthlab.entity.Word;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WordCreator extends SymbolCompositeCreator<Symbol>
{
    public WordCreator()
    {
        super();
    }

    @Override
    public final Word create(final String contentOfWord)
            throws SymbolCompositeCreatingException
    {
        if(!SymbolCompositeCreatable.SYMBOL_COMPOSITE_VALIDATOR.isValidWord(contentOfWord))
        {
            throw new SymbolCompositeCreatingException("Impossible to create object of class '" + Word.class.getName()
                    + "' by given of its content. Given content : " + contentOfWord + ".");
        }
        final List<Symbol> lettersOfWord = new ArrayList<Symbol>();
        final Pattern patternOfLetter = Pattern.compile(Symbol.REGULAR_EXPRESSION_OF_LETTER);
        final Matcher matcherOfLetter = patternOfLetter.matcher(contentOfWord);
        char characterOfLetterOfWord;
        Symbol letterOfWord;
        while(matcherOfLetter.find())
        {
            characterOfLetterOfWord = contentOfWord.charAt(matcherOfLetter.start());
            letterOfWord = new Symbol(characterOfLetterOfWord);
            lettersOfWord.add(letterOfWord);
        }
        return new Word(lettersOfWord);
    }
}