package by.bsu.zuevvlad.fifthlab.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public final class SymbolCompositeTest
{
    public SymbolCompositeTest()
    {
        super();
    }

    @Test
    public final void symbolCompositeShouldBeCreatedByDefault()
    {
        final SymbolComposite<Symbol> createdSymbolComposite = new Word();
        final List<Symbol> expectedComponentsOfCreatedSymbolComposite = new ArrayList<Symbol>();
        final List<Symbol> actualComponentsOfCreatedSymbolComposite = createdSymbolComposite.getComponents();
        Assert.assertEquals(actualComponentsOfCreatedSymbolComposite, expectedComponentsOfCreatedSymbolComposite);
    }

    @Test
    public final void symbolCompositeShouldBeCreatedWithComponents()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbolsOfWord = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final SymbolComposite<Symbol> createdSymbolComposite = new Word(symbolsOfWord);
        final List<Symbol> expectedComponentsOfSymbolComposite = symbolsOfWord;
        final List<Symbol> actualComponentsOfSymbolComposite = createdSymbolComposite.getComponents();
        Assert.assertSame(actualComponentsOfSymbolComposite, expectedComponentsOfSymbolComposite);
    }

    @Test
    public final void componentsOfSymbolCompositeShouldBeGot()
    {
        final List<Symbol> componentsOfSymbolComposite = new ArrayList<Symbol>();
        final SymbolComposite<Symbol> symbolComposite = new Word(componentsOfSymbolComposite);
        final List<Symbol> expectedComponentsOfSymbolComposite = componentsOfSymbolComposite;
        final List<Symbol> actualComponentsOfSymbolComposite = symbolComposite.getComponents();
        Assert.assertSame(actualComponentsOfSymbolComposite, expectedComponentsOfSymbolComposite);
    }

    @Test
    public final void newComponentOfSymbolCompositeShouldBeAdded()
    {
        final List<Symbol> componentsOfSymbolComposite = new ArrayList<Symbol>();
        final SymbolComposite<Symbol> symbolComposite = new Word(componentsOfSymbolComposite);
        final int amountOfComponentsBeforeAdding = symbolComposite.findAmountOfComponents();
        final Symbol addedComponent = new Symbol(' ');
        symbolComposite.add(addedComponent);
        final int amountOfComponentsAfterAdding = symbolComposite.findAmountOfComponents();
        Assert.assertEquals(amountOfComponentsAfterAdding, amountOfComponentsBeforeAdding + 1);
    }

    @Test
    public final void componentOfSymbolCompositedShouldBeRemoved()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbolsOfWord = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final SymbolComposite<Symbol> symbolComposite = new Word(symbolsOfWord);
        final Symbol removedSymbol = symbolsOfWord.get(0);
        final int amountOfComponentsBeforeRemoving = symbolComposite.findAmountOfComponents();
        symbolComposite.remove(removedSymbol);
        final int amountOfComponentsAfterRemoving = symbolComposite.findAmountOfComponents();
        Assert.assertEquals(amountOfComponentsAfterRemoving, amountOfComponentsBeforeRemoving - 1);
    }

    @Test
    public final void amountOfComponentsOfSymbolCompositeShouldBeFound()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbolsOfWord = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final SymbolComposite<Symbol> symbolComposite = new Word(symbolsOfWord);
        final int expectedAmountOfComponents = symbolsOfWord.size();
        final int actualAmountOfComponents = symbolComposite.findAmountOfComponents();
        Assert.assertEquals(actualAmountOfComponents, expectedAmountOfComponents);
    }

    @Test
    public final void symbolCompositeShouldBeComposed()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbolsOfWord = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final SymbolComposite<Symbol> symbolComposite = new Word(symbolsOfWord);
        final String expectedComposedSymbolComposite = descriptionOfWord;
        final String actualComposedSymbolComposite = symbolComposite.compose();
        Assert.assertEquals(actualComposedSymbolComposite, expectedComposedSymbolComposite);
    }

    @Test
    public final void descriptionOfSymbolCompositeShouldBeFound()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbolsOfWord = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final SymbolComposite<Symbol> symbolComposite = new Word(symbolsOfWord);
        final String expectedDescriptionOfSymbolComposite = symbolComposite.getClass().getSimpleName()
                + "[components = " + symbolsOfWord + "]";
        final String actualDescriptionOfSymbolComposite = symbolComposite.toString();
        Assert.assertEquals(actualDescriptionOfSymbolComposite, expectedDescriptionOfSymbolComposite);
    }

    @Test
    public final void symbolCompositesShouldBeEqual()
    {
        final SymbolComposite<Symbol> firstSymbolComposite = new Word();
        final SymbolComposite<Symbol> secondSymbolComposite = new Word();
        Assert.assertEquals(firstSymbolComposite, secondSymbolComposite);
    }

    @Test
    public final void symbolCompositesShouldNotBeEqual()
    {
        final SymbolComposite<?> firstSymbolComposite = new Word();
        final SymbolComposite<?> secondSymbolComposite = new Paragraph();
        Assert.assertNotEquals(firstSymbolComposite, secondSymbolComposite);
    }

    @Test
    public final void hashCodeOfSymbolShouldBeFound()
    {
        final String descriptionOfWord = "Dog";
        final List<Symbol> symbolsOfWord = new ArrayList<Symbol>()
        {
            {
                for(final char character : descriptionOfWord.toCharArray())
                {
                    this.add(new Symbol(character));
                }
            }
        };
        final SymbolComposite<Symbol> symbolComposite = new Word(symbolsOfWord);
        final int expectedHashCode = symbolsOfWord.hashCode();
        final int actualHashCode = symbolComposite.hashCode();
        Assert.assertEquals(actualHashCode, expectedHashCode);
    }
}
