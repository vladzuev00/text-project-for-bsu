package by.bsu.zuevvlad.fifthlab.logic.symbolcompositevalidator;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class SymbolCompositeValidatorTest
{
    public SymbolCompositeValidatorTest()
    {
        super();
    }

    @Test
    public final void researchStringShouldBeValidWord()
    {
        final String researchString = "word";
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertTrue(symbolCompositeValidator.isValidWord(researchString));
    }

    @Test
    public final void researchStringShouldNotBeValidWord()
    {
        final String researchString = "word1";
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertFalse(symbolCompositeValidator.isValidWord(researchString));
    }

    @Test
    public final void researchStringShouldBeValidSentence()
    {
        final String researchString = "I am a sentence.";
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertTrue(symbolCompositeValidator.isValidSentence(researchString));
    }

    @Test
    public final void researchStringShouldNotBeValidSentence()
    {
        final String researchString = "I am not a sentence";
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertFalse(symbolCompositeValidator.isValidSentence(researchString));
    }

    @Test
    public final void researchStringShouldBeValidParagraph()
    {
        final String researchString = "I am a paragraph. I am\n a good paragraph.";
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertTrue(symbolCompositeValidator.isValidParagraph(researchString));
    }

    @Test
    public final void researchStringShouldNotBeValidParagraph()
    {
        final String researchString = "I am not a paragraph. I am\n a bad paragraph";
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertFalse(symbolCompositeValidator.isValidParagraph(researchString));
    }

    @Test
    public final void researchStringShouldBeValidText()
    {
        final String researchString = "\tIt has survived not only five centuries, but also the leap into electronic\n" +
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
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertTrue(symbolCompositeValidator.isValidText(researchString));
    }

    @Test
    public final void researchStringShouldNotBeValidText()
    {
        final String researchString = "\tI am not text.\n Bad text";
        final SymbolCompositeValidator symbolCompositeValidator = new SymbolCompositeValidator();
        Assert.assertFalse(symbolCompositeValidator.isValidText(researchString));
    }
}
