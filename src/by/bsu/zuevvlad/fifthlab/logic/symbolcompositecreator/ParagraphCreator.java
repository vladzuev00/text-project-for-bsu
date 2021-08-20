package by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator;

import by.bsu.zuevvlad.fifthlab.entity.Paragraph;
import by.bsu.zuevvlad.fifthlab.entity.Sentence;
import by.bsu.zuevvlad.fifthlab.logic.symbolcompositecreator.exception.SymbolCompositeCreatingException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ParagraphCreator extends SymbolCompositeCreator<Sentence>
{
    public ParagraphCreator()
    {
        super(ParagraphCreator.SENTENCE_CREATOR);
    }

    private static final SentenceCreator SENTENCE_CREATOR = new SentenceCreator();

    @Override
    public final Paragraph create(final String contentOfParagraph)
            throws SymbolCompositeCreatingException
    {
        if(!SymbolCompositeCreatable.SYMBOL_COMPOSITE_VALIDATOR.isValidParagraph(contentOfParagraph))
        {
            throw new SymbolCompositeCreatingException("Impossible to create object of class '"
                    + Paragraph.class.getName() + "' by given of its content. Given content : "
                    + contentOfParagraph + ".");
        }
        final List<Sentence> sentencesOfParagraph = new ArrayList<Sentence>();
        final Pattern patternOfSentence = Pattern.compile(Sentence.REGULAR_EXPRESSION_OF_SENTENCE);
        final Matcher matcherOfSentence = patternOfSentence.matcher(contentOfParagraph);
        String contentOfSentenceOfParagraph;
        Sentence sentenceOfParagraph;
        while(matcherOfSentence.find())
        {
            contentOfSentenceOfParagraph
                    = contentOfParagraph.substring(matcherOfSentence.start(), matcherOfSentence.end());
            sentenceOfParagraph = ParagraphCreator.SENTENCE_CREATOR.create(contentOfSentenceOfParagraph);
            sentencesOfParagraph.add(sentenceOfParagraph);
        }
        return new Paragraph(sentencesOfParagraph);
    }
}