package by.bsu.zuevvlad.fifthlab.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public final class WordTest
{
    public WordTest()
    {
        super();
    }

    @Test
    public final void wordShouldBeCreatedByDefault()
    {
        final Word word = new Word();
        final List<Symbol> actualComponents = word.getComponents();
        final List<Symbol> expectedComponents = new ArrayList<Symbol>();
        Assert.assertEquals(actualComponents, expectedComponents);
    }

    @Test
    public final void wordShouldBeCreatedByGivenSymbols()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbols = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final Word word = new Word(symbols);
        final List<Symbol> expectedSymbols = symbols;
        final List<Symbol> actualSymbols = word.getComponents();
        Assert.assertSame(actualSymbols, expectedSymbols);
    }

    @Test
    public final void wordShouldBeComposed()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbols = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final Word word = new Word(symbols);
        final String actualComposedWord = word.compose();
        final String expectedComposedWord = descriptionOfWord;
        Assert.assertEquals(actualComposedWord, expectedComposedWord);
    }

    @Test
    public final void stringShouldBeMatchedRegularExpressionOfWord()
    {
        final String researchString = "Dog";
        Assert.assertTrue(researchString.matches(Word.REGULAR_EXPRESSION_OF_WORD));
    }

    @Test
    public final void stringShouldNotBeMatchedRegularExpressionOfWord()
    {
        final String researchString = "Dog!";
        Assert.assertFalse(researchString.matches(Word.REGULAR_EXPRESSION_OF_WORD));
    }
}
