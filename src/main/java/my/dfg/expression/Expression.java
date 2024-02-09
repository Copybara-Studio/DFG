/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.dfg.expression;

import java.util.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Expression
{
    /**
     * The queue of the terms.
     */
    private Queue<Term> terms;
    
    /**
     * Creates the queue of terms from the input, or throws an exception if
     * the input is invalid.
     * @param input expression in form of text
     * @throws java.lang.Exception if input is invalid
     */
    public Expression(String input) throws Exception
    {
        /* Konstruktor przegląda input, żeby utworzyć z niego wyrażenie. Jeśliś
         * hardkor, to przyjmij sobie, że input jest w zwykłej notacji infiksowej
         * z nawiasami, np.
         * 
         *      X <- A * (B + C)
         *
         * a jeśliś tchórz i mięczak, to przyjmij, że od razu będzie w notacji
         * polskiej:
         *
         *      X <- * A + B C
         * 
         * Dopuszczalne działania:
         *  > suma: x + y
         *  > iloczyn: x * y
         *  > iloraz: x / y
         *  > suma logiczna: x | y
         *  > iloczyn logiczny: x & y
         *  > porównania:
         *     > równość: x = y
         *     > nierówność: x > y
         *  > reszta z dzielenia: x % y
         *  > minus: -x
         *  > negacja logiczna: !x
         *  > selekcja: x ? y : z
         *      (w notacji polskiej to potem może być: ? x y z)
         *
         * Algorytm ma przetworzyć wyrażenie na kolejkę poszczególnych wyrazów
         * w notacji polskiej. (Microsoft Bing podpowiada, jak przetworzyć
         * notację infiksową na polską.)
         * 
         * Przykład
         *  Wejście:
         *      X <- Y * (Z + 1)
         *
         *  (Postać pośrednia:
         *      X <- * Y + Z 1)
         *
         *  Wyjście:
         *      [VARIABLE, "X"][ASSIGNMENT][PRODUCT][VARIABLE, "Y"][SUM][VARIABLE, "Z"][CONSTANT, 1],
         *  
         *    gdzie [...] oznacza obiekt klasy Term (lub podklasy).
         *
         * Konstruktor powinien wyrzucić wyjątek, jeśli podane wyrażenie jest błędne.
         */
        terms = new ArrayDeque<>();
        
        /* Jeśli wyrażenie jest błędne, to: */
        // throw new Exception("Invalid input string!");
        
        // Jak coś, to pisz. ;)
    }
    
    private static Term makeTerm(String text)
    {
        Term term = null;
        
        /* Jeśli text reprezentuje zmienną, to: */
        // term = new VariableTerm(text);
        
        /* Jeśli text reprezentuje stałą, to: */
        // term = new ConstantTerm(Integer.valueOf(text));
        
        /* Inaczej: */
//        switch (text)
//        {
//            case "+" ->
//            {
//                term = new Term(TermType.SUM);
//            }
//            case "*" ->
//            {
//                term = new Term(TermType.PRODUCT);
//            }
//            case "/" ->
//            {
//                term = new Term(TermType.QUOTIENT);
//            }
//            case "&" ->
//            {
//                term = new Term(TermType.CONJUNCTION);
//            }
//            case "|" ->
//            {
//                term = new Term(TermType.DISJUNCTION);
//            }
//            case "=" ->
//            {
//                term = new Term(TermType.EQUAL);
//            }
//            case ">" ->
//            {
//                term = new Term(TermType.GREATER);
//            }
//            case "-" ->
//            {
//                term = new Term(TermType.COMPLEMENT);
//            }
//            case "!" ->
//            {
//                term = new Term(TermType.NEGATION);
//            }
//            case "%" ->
//            {
//                term = new Term(TermType.REMAINDER);
//            }
//        }
        
        return term;
    }
    
    /**
     * Extracts the current first term from the expression.
     * @return the term that currently is first to be extracted,
     *      or null if none is to be extracted
     */
    public Term get()
    {
        return terms.poll();
    }
}
