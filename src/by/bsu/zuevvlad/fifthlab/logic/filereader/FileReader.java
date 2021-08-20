package by.bsu.zuevvlad.fifthlab.logic.filereader;

import by.bsu.zuevvlad.fifthlab.logic.filereader.exception.FileReadingException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileReader
{
    public FileReader()
    {
        super();
    }

    public final String read(final File readFile)
            throws FileReadingException
    {
        if(!readFile.isFile() || !readFile.exists())
        {
            throw new FileReadingException("Impossible to read file '" + readFile.getAbsolutePath() + "'.");
        }
        try
        {
            final StringBuilder readText = new StringBuilder();
            int nextByteOfReadData;
            try(final FileInputStream fileInputStream = new FileInputStream(readFile);
                final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream))
            {
                while((nextByteOfReadData = bufferedInputStream.read()) != -1)
                {
                    readText.append((char)nextByteOfReadData);
                }
            }
            return readText.toString();
        }
        catch(final IOException cause)
        {
            throw new FileReadingException(cause);
        }
    }
}
