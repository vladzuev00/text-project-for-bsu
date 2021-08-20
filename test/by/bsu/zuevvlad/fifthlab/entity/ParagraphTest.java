package by.bsu.zuevvlad.fifthlab.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ParagraphTest
{
    public ParagraphTest()
    {
        super();
    }

    @Test
    public final void researchStringShouldBeMatchedRegularOfParagraph()
    {
        final String researchString = "It has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Assert.assertTrue(researchString.matches(Paragraph.REGULAR_EXPRESSION_OF_PARAGRAPH));
    }

    @Test
    public final void researchStringShouldNotBeMatchedRegularOfParagraph()
    {
        final String researchString = "Hello. I am not paragraph";
        Assert.assertFalse(researchString.matches(Paragraph.REGULAR_EXPRESSION_OF_PARAGRAPH));
    }

    @Test
    public final void paragraphShouldBeCreatedByDefault()
    {
        final Paragraph createdParagraph = new Paragraph();
        final List<Sentence> expectedComponents = new ArrayList<Sentence>();
        final List<Sentence> actualComponents = createdParagraph.getComponents();
        Assert.assertEquals(actualComponents, expectedComponents);
    }

    @Test
    public final void paragraphShouldBeCreatedByComponents()
    {
        final Word[] wordsOfFirstSentence = new Word[]{
                new Word(Arrays.<Symbol>asList(new Symbol('I'))),
                new Word(Arrays.<Symbol>asList(new Symbol('a'), new Symbol('m'))),
                new Word(Arrays.<Symbol>asList(new Symbol('V'), new Symbol('l'),
                        new Symbol('a'), new Symbol('d')))
        };
        final Symbol symbolOfEndOfFirstSentence = new Symbol('.');
        final List<SymbolComponent> componentsOfFirstSentence = new ArrayList<SymbolComponent>()
        {
            {
                this.addAll(Arrays.<Word>asList(wordsOfFirstSentence));
                this.add(symbolOfEndOfFirstSentence);
            }
        };
        final Sentence firstSentence = new Sentence(componentsOfFirstSentence);

        final Word[] wordsOfSecondSentence = new Word[]{
                new Word(Arrays.<Symbol>asList(new Symbol('I'))),
                new Word(Arrays.<Symbol>asList(new Symbol('a'), new Symbol('m'))),
                new Word(Arrays.<Symbol>asList(new Symbol('V'), new Symbol('l'),
                        new Symbol('a'), new Symbol('d')))
        };
        final Symbol symbolOfEndOfSecondSentence = new Symbol('.');
        final List<SymbolComponent> componentsOfSecondSentence = new ArrayList<SymbolComponent>()
        {
            {
                this.addAll(Arrays.<Word>asList(wordsOfSecondSentence));
                this.add(symbolOfEndOfSecondSentence);
            }
        };
        final Sentence secondSentence = new Sentence(componentsOfSecondSentence);

        final List<Sentence> sentencesOfParagraph = Arrays.asList(firstSentence, secondSentence);
        final Paragraph createdParagraph = new Paragraph(sentencesOfParagraph);

        final List<Sentence> expectedComponentsOfParagraph = sentencesOfParagraph;
        final List<Sentence> actualComponentsOfParagraph = createdParagraph.getComponents();
        Assert.assertSame(actualComponentsOfParagraph, expectedComponentsOfParagraph);
    }

    @Test
    public final void paragraphShouldBeComposed()
    {
        final Word[] wordsOfFirstSentence = new Word[]{
                new Word(Arrays.<Symbol>asList(new Symbol('I'))),
                new Word(Arrays.<Symbol>asList(new Symbol('a'), new Symbol('m'))),
                new Word(Arrays.<Symbol>asList(new Symbol('V'), new Symbol('l'),
                        new Symbol('a'), new Symbol('d')))
        };
        final Symbol symbolOfEndOfFirstSentence = new Symbol('.');
        final List<SymbolComponent> componentsOfFirstSentence = new ArrayList<SymbolComponent>()
        {
            {
                this.addAll(Arrays.<Word>asList(wordsOfFirstSentence));
                this.add(symbolOfEndOfFirstSentence);
            }
        };
        final Sentence firstSentence = new Sentence(componentsOfFirstSentence);

        final Word[] wordsOfSecondSentence = new Word[]{
                new Word(Arrays.<Symbol>asList(new Symbol('I'))),
                new Word(Arrays.<Symbol>asList(new Symbol('a'), new Symbol('m'))),
                new Word(Arrays.<Symbol>asList(new Symbol('V'), new Symbol('l'),
                        new Symbol('a'), new Symbol('d')))
        };
        final Symbol symbolOfEndOfSecondSentence = new Symbol('.');
        final List<SymbolComponent> componentsOfSecondSentence = new ArrayList<SymbolComponent>()
        {
            {
                this.addAll(Arrays.<Word>asList(wordsOfSecondSentence));
                this.add(symbolOfEndOfSecondSentence);
            }
        };
        final Sentence secondSentence = new Sentence(componentsOfSecondSentence);

        final List<Sentence> sentencesOfParagraph = Arrays.asList(firstSentence, secondSentence);
        final Paragraph paragraph = new Paragraph(sentencesOfParagraph);

        final String expectedComposedParagraph = "I am Vlad. I am Vlad.";
        final String actualComposedParagraph = paragraph.compose();
        Assert.assertEquals(actualComposedParagraph, expectedComposedParagraph);
    }
}
