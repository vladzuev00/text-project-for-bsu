package by.bsu.zuevvlad.fifthlab.logic.symbolcompositevalidator;

import by.bsu.zuevvlad.fifthlab.entity.Paragraph;
import by.bsu.zuevvlad.fifthlab.entity.Sentence;
import by.bsu.zuevvlad.fifthlab.entity.Text;
import by.bsu.zuevvlad.fifthlab.entity.Word;

public final class SymbolCompositeValidator
{
    public SymbolCompositeValidator()
    {
        super();
    }

    public final boolean isValidWord(final String researchWord)
    {
        return researchWord.matches(Word.REGULAR_EXPRESSION_OF_WORD);
    }

    public final boolean isValidSentence(final String researchSentence)
    {
        return researchSentence.matches(Sentence.REGULAR_EXPRESSION_OF_SENTENCE);
    }

    public final boolean isValidParagraph(final String researchParagraph)
    {
        return researchParagraph.matches(Paragraph.REGULAR_EXPRESSION_OF_PARAGRAPH);
    }

    public final boolean isValidText(final String researchText)
    {
        return researchText.matches(Text.REGULAR_EXPRESSION_OF_TEXT);
    }
}
