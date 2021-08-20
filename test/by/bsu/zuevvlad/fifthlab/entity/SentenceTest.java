package by.bsu.zuevvlad.fifthlab.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceTest
{
    public SentenceTest()
    {
        super();
    }

    @Test
    public final void researchStringShouldBeMatchedOfRegularOfSentence()
    {
        final String researchString = "Hello, I am test for regular expression of sentences!!!";
        Assert.assertTrue(researchString.matches(Sentence.REGULAR_EXPRESSION_OF_SENTENCE));
    }

    @Test
    public final void researchStringShouldNotBeMatchedOfRegularOfSentence()
    {
        final String researchString = "Hello, I am bad sentence";
        Assert.assertFalse(researchString.matches(Sentence.REGULAR_EXPRESSION_OF_SENTENCE));
    }

    @Test
    public final void sentenceShouldBeCreatedByDefault()
    {
        final Sentence sentence = new Sentence();
        final List<SymbolComponent> expectedComponents = new ArrayList<>();
        final List<SymbolComponent> actualComponents = sentence.getComponents();
        Assert.assertEquals(actualComponents, expectedComponents);
    }

    @Test
    public final void sentenceShouldBeCreatedByComponents()
    {
        final Word[] wordsOfSentence = new Word[]{
                new Word(Arrays.<Symbol>asList(new Symbol('I'))),
                new Word(Arrays.<Symbol>asList(new Symbol('a'), new Symbol('m'))),
                new Word(Arrays.<Symbol>asList(new Symbol('V'), new Symbol('l'),
                        new Symbol('a'), new Symbol('d')))
        };
        final Symbol symbolOfEndOfSentence = new Symbol('.');
        final List<SymbolComponent> componentsOfSentence = new ArrayList<SymbolComponent>()
        {
            {
                this.addAll(Arrays.<Word>asList(wordsOfSentence));
                this.add(symbolOfEndOfSentence);
            }
        };
        final Sentence createdSentence = new Sentence(componentsOfSentence);
        final List<SymbolComponent> expectedComponents = componentsOfSentence;
        final List<SymbolComponent> actualComponents = createdSentence.getComponents();
        Assert.assertSame(actualComponents, expectedComponents);
    }

    @Test
    public final void sentenceShouldBeComposed()
    {
        final Word[] wordsOfSentence = new Word[]{
                new Word(Arrays.<Symbol>asList(new Symbol('I'))),
                new Word(Arrays.<Symbol>asList(new Symbol('a'), new Symbol('m'))),
                new Word(Arrays.<Symbol>asList(new Symbol('V'), new Symbol('l'),
                        new Symbol('a'), new Symbol('d')))
        };
        final Symbol symbolOfEndOfSentence = new Symbol('.');
        final List<SymbolComponent> componentsOfSentence = new ArrayList<SymbolComponent>()
        {
            {
                this.addAll(Arrays.<Word>asList(wordsOfSentence));
                this.add(symbolOfEndOfSentence);
            }
        };
        final Sentence sentence = new Sentence(componentsOfSentence);
        final String expectedComposedSentence = "I am Vlad.";
        final String actualComposedSentence = sentence.compose();
        Assert.assertEquals(actualComposedSentence, expectedComposedSentence);
    }
}
