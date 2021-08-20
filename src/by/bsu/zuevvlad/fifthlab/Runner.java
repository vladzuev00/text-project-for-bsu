package by.bsu.zuevvlad.fifthlab;

import by.bsu.zuevvlad.fifthlab.entity.Text;
import by.bsu.zuevvlad.fifthlab.logic.filereader.FileReader;
import by.bsu.zuevvlad.fifthlab.logic.filereader.exception.FileReadingException;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.TextCreator;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;

import java.io.File;

public final class Runner
{
    public static void main(final String[] args)
            throws FileReadingException, SymbolCompositeCreatingException
    {
        final File readFile = new File("data/text");
        final FileReader fileReader = new FileReader();
        String descriptionOfText = fileReader.read(readFile);
        descriptionOfText = descriptionOfText.replaceAll("\r", "");   //TODO: it is bad
        System.out.println(descriptionOfText);
        System.out.println("******************************************************************************");

        final TextCreator textCreator = new TextCreator();
        final Text text = textCreator.create(descriptionOfText);
        final String composedTest = text.compose();
        System.out.println(composedTest);
    }
}
