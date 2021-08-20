package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.Sentence;
import by.bsu.zuevvlad.fifthlab.entity.Symbol;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class SentenceCreatorTest
{
    public SentenceCreatorTest()
    {
        super();
    }

    @Test
    public final void sentenceShouldBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfSentence = "I am a test.";
        final SentenceCreator sentenceCreator = new SentenceCreator();
        final Sentence createdSentence = sentenceCreator.create(contentOfSentence);
        final String expectedComposedSentence = contentOfSentence;
        final String actualComposedSentence = createdSentence.compose();
        Assert.assertEquals(actualComposedSentence, expectedComposedSentence);
    }

    @Test(expectedExceptions = SymbolCompositeCreatingException.class)
    public final void sentenceShouldNotBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfSentence = "I am a test";
        final SentenceCreator sentenceCreator = new SentenceCreator();
        sentenceCreator.create(contentOfSentence);
    }
}
