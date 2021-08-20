package by.bsu.zuevvlad.fifthlab.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public final class SymbolTest
{
    public SymbolTest()
    {
        super();
    }

    @Test
    public final void symbolShouldBeCreated()
    {
        final char character = 'a';
        final Symbol symbol = new Symbol(character);
        final char expectedCharacter = character;
        final char actualCharacter = symbol.getCharacter();
        Assert.assertEquals(actualCharacter, expectedCharacter);
    }

    @Test
    public final void characterShouldBeGot()
    {
        final char character = 'a';
        final Symbol symbol = new Symbol(character);
        final char expectedCharacter = character;
        final char actualCharacter = symbol.getCharacter();
        Assert.assertEquals(actualCharacter, expectedCharacter);
    }

    @Test
    public final void symbolShouldBeComposed()
    {
        final char character = 'a';
        final Symbol symbol = new Symbol(character);
        final String expectedComposedSymbol = Character.toString(character);
        final String actualComposedSymbol = symbol.compose();
        Assert.assertEquals(actualComposedSymbol, expectedComposedSymbol);
    }

    @Test
    public final void descriptionOfSymbolShouldBeFound()
    {
        final char character = 'a';
        final Symbol symbol = new Symbol(character);
        final String expectedDescription = "Symbol[character = " + character + "]";
        final String actualDescription = symbol.toString();
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test
    public final void symbolsShouldBeEqual()
    {
        final char character = 'a';
        final Symbol firstSymbol = new Symbol(character);
        final Symbol secondSymbol = new Symbol(character);
        Assert.assertEquals(firstSymbol, secondSymbol);
    }

    @Test
    public final void symbolsShouldNotBeEqual()
    {
        final char characterOfFirstSymbol = 'a';
        final Symbol firstSymbol = new Symbol(characterOfFirstSymbol);
        final char characterOfSecondSymbol = (char)((int)characterOfFirstSymbol + 1);
        final Symbol secondSymbol = new Symbol(characterOfSecondSymbol);
        Assert.assertNotEquals(firstSymbol, secondSymbol);
    }

    @Test
    public final void hashCodeOfSymbolShouldBeFound()
    {
        final char character = 'a';
        final Symbol symbol = new Symbol(character);
        final int expectedHashCode = Character.hashCode(character);
        final int actualHashCode = symbol.hashCode();
        Assert.assertEquals(actualHashCode, expectedHashCode);
    }

    @Test
    public final void stringShouldBeMatchedRegularExpressionOfSymbol()
    {
        final char character = 'a';
        final String researchString = Character.toString(character);
        Assert.assertTrue(researchString.matches(Symbol.REGULAR_EXPRESSION_OF_SYMBOL));
    }

    @Test
    public final void stringShouldNotBeMatchedRegularExpressionOfSymbol()
    {
        final String researchString = "";
        Assert.assertFalse(researchString.matches(Symbol.REGULAR_EXPRESSION_OF_SYMBOL));
    }
}
