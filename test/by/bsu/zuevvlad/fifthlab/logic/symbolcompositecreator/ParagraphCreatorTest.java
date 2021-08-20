package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.Paragraph;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class ParagraphCreatorTest
{
    public ParagraphCreatorTest()
    {
        super();
    }

    @Test
    public final void paragraphShouldBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfParagraph = "It has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        final ParagraphCreator paragraphCreator = new ParagraphCreator();
        final Paragraph paragraph = paragraphCreator.create(contentOfParagraph);
        final String expectedComposedParagraph = contentOfParagraph;
        final String actualComposedParagraph = paragraph.compose();
        Assert.assertEquals(actualComposedParagraph, expectedComposedParagraph);
    }

    @Test(expectedExceptions = SymbolCompositeCreatingException.class)
    public final void paragraphShouldNotBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfParagraph = "I am not paragraph";
        final ParagraphCreator paragraphCreator = new ParagraphCreator();
        paragraphCreator.create(contentOfParagraph);
    }
}
