package by.bsu.zuevvlad.fifthlab.entity;

import java.util.List;

public final class Text extends SymbolComposite<Paragraph>
{
    private static final String PREFIX_OF_FIRST_PARAGRAPH = "\t";
    private static final String PREFIX_OF_NOT_FIRST_PARAGRAPH = "\n\t";
    private static final String REGULAR_EXPRESSION_OF_PREFIX_OF_PARAGRAPH = "(" + Text.PREFIX_OF_FIRST_PARAGRAPH
            + "|" + Text.PREFIX_OF_NOT_FIRST_PARAGRAPH + ")";
    public static final String REGULAR_EXPRESSION_OF_TEXT = "(" + Text.REGULAR_EXPRESSION_OF_PREFIX_OF_PARAGRAPH
            + Paragraph.REGULAR_EXPRESSION_OF_PARAGRAPH + ")+";

    public Text()
    {
        super();
    }

    public Text(final List<Paragraph> paragraphs)
    {
        super(paragraphs);
    }

    @Override
    public final String compose()
    {
        final StringBuilder composedText = new StringBuilder();
        final List<Paragraph> paragraphsOfText = this.getComponents();
        composedText.append(Text.PREFIX_OF_FIRST_PARAGRAPH);
        composedText.append(paragraphsOfText.get(0).compose());
        Paragraph paragraphOfText;
        for(int i = 1; i < paragraphsOfText.size(); i++)
        {
            paragraphOfText = paragraphsOfText.get(i);
            composedText.append(Text.PREFIX_OF_NOT_FIRST_PARAGRAPH);
            composedText.append(paragraphOfText.compose());
        }
        return composedText.toString();
    }
}
