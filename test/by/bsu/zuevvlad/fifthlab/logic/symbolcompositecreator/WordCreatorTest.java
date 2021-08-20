package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.Word;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class WordCreatorTest
{
    public WordCreatorTest()
    {
        super();
    }

    @Test
    public final void wordShouldBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfWord = "word";
        final WordCreator wordCreator = new WordCreator();
        final Word createdWord = wordCreator.create(contentOfWord);
        final String expectedComposedCreatedWord = contentOfWord;
        final String actualComposedCreatedWord = createdWord.compose();
        Assert.assertEquals(actualComposedCreatedWord, expectedComposedCreatedWord);
    }

    @Test(expectedExceptions = SymbolCompositeCreatingException.class)
    public final void wordShouldNotBeCreatedWithGivenContent()
            throws SymbolCompositeCreatingException
    {
        final String contentOfWord = "word1";
        final WordCreator wordCreator = new WordCreator();
        wordCreator.create(contentOfWord);
    }
}
