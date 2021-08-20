package by.bsu.zuevvlad.fifthlab.entity;

import java.util.List;

public final class Paragraph extends SymbolComposite<Sentence>
{
    private static final char DELIMITER_OF_SENTENCES_IN_PARAGRAPH = ' ';
    public static final String REGULAR_EXPRESSION_OF_PARAGRAPH = "(" + Sentence.REGULAR_EXPRESSION_OF_SENTENCE
            + Paragraph.DELIMITER_OF_SENTENCES_IN_PARAGRAPH + "?)+";

    public Paragraph()
    {
        super();
    }

    public Paragraph(final List<Sentence> sentences)
    {
        super(sentences);
    }

    @Override
    public final String compose()
    {
        final StringBuilder composedParagraph = new StringBuilder();
        final List<Sentence> sentencesOfParagraph = this.getComponents();
        Sentence sentenceOfParagraph;
        for(int i = 0; i < sentencesOfParagraph.size() - 1; i++)
        {
            sentenceOfParagraph = sentencesOfParagraph.get(i);
            composedParagraph.append(sentenceOfParagraph.compose());
            composedParagraph.append(Paragraph.DELIMITER_OF_SENTENCES_IN_PARAGRAPH);
        }
        final int indexOfLastSentence = sentencesOfParagraph.size() - 1;
        final Sentence lastSentenceOfParagraph = sentencesOfParagraph.get(indexOfLastSentence);
        composedParagraph.append(lastSentenceOfParagraph.compose());
        return composedParagraph.toString();
    }
}

