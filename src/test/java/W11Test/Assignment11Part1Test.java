package W11Test;

import com.shpp.p2p.cs.ihordienko.assignment11.Assignment11Part1;
import com.shpp.p2p.cs.ihordienko.assignment11.exceptions.InvalidExpressionException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment11Part1Test {
    private String run(String[] args) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Assignment11Part1.main(args);

        System.setOut(originalOut);

        return outputStream.toString().trim();
    }

    @Test
    public void test1() {
        String[] args = {"2+sin(30)"};
        String output = run(args);
        String expected = "1.0119683759071383";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void test4() {
        String[] args = {"2+sin(-30)"};
        String output = run(args);
        String expected = "2.9880316240928617";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void test2() {
        String[] args = {"2+sin(x)", "x=30"};
        String output = run(args);
        String expected = "1.0119683759071383";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void test3() {
        String[] args = {"2+sin(x)"};
        String output = run(args);
        String expected = "1.0119683759071383";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void bracesInvalidTest() {
        String[] args = {"2+sin(x))"};

//        String expected = "1.0119683759071383";

//        assertEquals(expected, output);
//        System.out.println("Expected: " + expected);
//        System.out.println(output);

        try {
            run(args);
        } catch (Exception e) {
            Exception expected = new InvalidExpressionException("Error: braces don't match");
            assertEquals(expected, e);
        }
    }

    @Test
    public void testWithNegativePow() {
        String[] args = {"3+sin(30)-9+2-3+4^-2"};
        String output = run(args);
        String expected = "-7.925531624092862";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void someTest() {
        String[] args = {"4+8-10^2-sin(30)"};
        String output = run(args);
        String expected = "-87.01196837590714";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void someTest2() {
        String[] args = {"4+8-10^2-SIN(30)"};
        String output = run(args);
        String expected = "-87.01196837590714";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void negativeVariable(){
        String[] args = {"2+sin(-x)", "x=30"};
        String output = run(args);
        String expected = "2.9880316240928617";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void negativeVariablePlusIndexCheck(){
        String[] args = {"2+sin(-x)+2", "x=30"};
        String output = run(args);
        String expected = "4.988031624092862";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void defaultTest(){
        String[] args = {"1+(2+3*(4+5-sin(45*cos(a))))/7", "a=1"};
        String output = run(args);
        String expected = "5.455953050536803";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void defaultTest2(){
        String[] args = {"2+3*(4+5-sin(45*cos(a)))/7", "a=1"};
        String output = run(args);
        String expected = "6.17";
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void sfnjdfsj(){
        String[] args = {"-3^2"};
        String output = run(args);
        String expected = "9.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void cosinus(){
        String[] args = {"cos(1)"};
        String output = run(args);
        String expected = "9.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }
    @Test
    public void ncosinus(){
        String[] args = {"45 * cos(1)"};
        String output = run(args);
        String expected = "9.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void snjkkdsdnsj(){
        String[] args = {"sin(4*cos(1))"};
        String output = run(args);
        String expected = "9.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }



}
