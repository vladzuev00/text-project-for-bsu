package by.bsu.zuevvlad.fifthlab.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TextTest
{
    public TextTest()
    {
        super();
    }

    @Test
    public final void researchStringShouldBeMatchedRegularExpressionOfText()
    {
        final String researchString =
                "\tIt has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "normal distribution of letters, as opposed to using Content here, content\n" +
                "here, making it look like readable English.\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its\n" +
                "layout.\n" +
                "\tBye.";
        Assert.assertTrue(researchString.matches(Text.REGULAR_EXPRESSION_OF_TEXT));
    }

    @Test
    public final void researchStringShouldNotBeMatchedRegularExpressionOfText()
    {
        final String researchString = "Hello, I am not text.";
        Assert.assertFalse(researchString.matches(Text.REGULAR_EXPRESSION_OF_TEXT));
    }

    @Test
    public final void textShouldBeCreatedByDefault()
    {
        final Text createdText = new Text();
        final List<Paragraph> expectedComponentsOfCreatedText = new ArrayList<Paragraph>();
        final List<Paragraph> actualComponentsOfCreatedText = createdText.getComponents();
        Assert.assertEquals(actualComponentsOfCreatedText, expectedComponentsOfCreatedText);
    }

    @Test
    public final void textShouldBeCreatedByComponents()
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
        final List<Sentence> sentencesOfFirstParagraph = new ArrayList<Sentence>()
        {
            {
                this.add(sentence);
                this.add(sentence);
            }
        };
        final Paragraph firstParagraphOfText = new Paragraph(sentencesOfFirstParagraph);

        final List<Sentence> sentencesOfSecondParagraph = new ArrayList<Sentence>()
        {
            {
                this.add(sentence);
            }
        };
        final Paragraph secondParagraphOfText = new Paragraph(sentencesOfSecondParagraph);

        final List<Paragraph> paragraphsOfText = new ArrayList<Paragraph>()
        {
            {
                this.add(firstParagraphOfText);
                this.add(secondParagraphOfText);
            }
        };
        final Text createdText = new Text(paragraphsOfText);
        final List<Paragraph> expectedComponentsOfCreatedText = paragraphsOfText;
        final List<Paragraph> actualComponentsOfCreatedText = createdText.getComponents();
        Assert.assertSame(actualComponentsOfCreatedText, expectedComponentsOfCreatedText);
    }

    @Test
    public final void textShouldBeComposed()
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
        final List<Sentence> sentencesOfFirstParagraph = new ArrayList<Sentence>()
        {
            {
                this.add(sentence);
                this.add(sentence);
            }
        };
        final Paragraph firstParagraphOfText = new Paragraph(sentencesOfFirstParagraph);

        final List<Sentence> sentencesOfSecondParagraph = new ArrayList<Sentence>()
        {
            {
                this.add(sentence);
            }
        };
        final Paragraph secondParagraphOfText = new Paragraph(sentencesOfSecondParagraph);

        final List<Paragraph> paragraphsOfText = new ArrayList<Paragraph>()
        {
            {
                this.add(firstParagraphOfText);
                this.add(secondParagraphOfText);
            }
        };
        final Text text = new Text(paragraphsOfText);

        final String expectedComposedText = "\tI am Vlad. I am Vlad.\n\tI am Vlad.";
        final String actualComposedText = text.compose();
        Assert.assertEquals(actualComposedText, expectedComposedText);
    }
}
