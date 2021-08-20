package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.Text;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class TextCreatorTest
{
    public TextCreatorTest()
    {
        super();
    }

    @Test
    public final void textShouldBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfText = "\tIt has survived not only five centuries, but also the leap into electronic\n" +
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
        final TextCreator textCreator = new TextCreator();
        final Text createdText = textCreator.create(contentOfText);
        final String expectedComposedText = contentOfText;
        final String actualComposedText = createdText.compose();
        Assert.assertEquals(actualComposedText, expectedComposedText);
    }

    @Test(expectedExceptions = SymbolCompositeCreatingException.class)
    public final void textShouldNotBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfText = "I am not text";
        final TextCreator textCreator = new TextCreator();
        textCreator.create(contentOfText);
    }
}
