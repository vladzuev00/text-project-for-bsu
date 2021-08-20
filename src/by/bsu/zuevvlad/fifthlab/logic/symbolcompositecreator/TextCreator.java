package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.Paragraph;
import by.bsu.zuevvlad.fifthlab.entity.Text;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextCreator extends SymbolCompositeCreator<Paragraph>
{
    public TextCreator()
    {
        super(TextCreator.PARAGRAPH_CREATOR);
    }

    private static final ParagraphCreator PARAGRAPH_CREATOR = new ParagraphCreator();

    @Override
    public final Text create(final String contentOfText)
            throws SymbolCompositeCreatingException
    {
        if(!SymbolCompositeCreatable.SYMBOL_COMPOSITE_VALIDATOR.isValidText(contentOfText))
        {
            throw new SymbolCompositeCreatingException("Impossible to create object of class '"
                    + TextCreator.class.getName() + "' by given of its content. Given content : "
                    + contentOfText + ".");
        }
        final List<Paragraph> paragraphsOfText = new ArrayList<Paragraph>();
        final Pattern patternOfParagraph = Pattern.compile(Paragraph.REGULAR_EXPRESSION_OF_PARAGRAPH);
        final Matcher matcherOfParagraph = patternOfParagraph.matcher(contentOfText);
        String contentOfParagraphOfText;
        Paragraph paragraphOfText;
        while(matcherOfParagraph.find())
        {
            contentOfParagraphOfText = contentOfText.substring(matcherOfParagraph.start(), matcherOfParagraph.end());
            paragraphOfText = TextCreator.PARAGRAPH_CREATOR.create(contentOfParagraphOfText);
            paragraphsOfText.add(paragraphOfText);
        }
        return new Text(paragraphsOfText);
    }
}
