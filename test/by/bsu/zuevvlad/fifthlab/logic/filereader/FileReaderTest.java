package by.bsu.zuevvlad.fifthlab.logic.filereader;

import by.bsu.zuevvlad.fifthlab.logic.filereader.exception.FileReadingException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public final class FileReaderTest
{
    public FileReaderTest()
    {
        super();
    }

    @Test
    public final void contentOfFileShouldBeRead()
            throws FileReadingException
    {
        final FileReader fileReader = new FileReader();
        final File readFile = new File("data/fortest/text");
        final String actualContentOfFile = fileReader.read(readFile);
        final String expectedContentOfFile = "\tIt has survived not only five centuries, but also the leap into electronic\r\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\r\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\r\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable\r\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\r\n" +
                "normal distribution of letters, as opposed to using Content here, content\r\n" +
                "here, making it look like readable English.\r\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its\r\n" +
                "layout.\r\n" +
                "\tBye.";
        Assert.assertEquals(actualContentOfFile, expectedContentOfFile);
    }

    @Test(expectedExceptions = FileReadingException.class)
    public final void contentOfFileShouldNotBeRead()
            throws FileReadingException
    {
        final FileReader fileReader = new FileReader();
        final File readFile = new File("data/fortest/not_exisiting_file");
        fileReader.read(readFile);
    }
}
