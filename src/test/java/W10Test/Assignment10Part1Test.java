package W10Test;

import com.shpp.p2p.cs.ihordienko.assignment11.Assignment11Part1;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Assignment10Part1Test {

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
        String[] args = {"2+2"};
        String output = run(args);
        String expected = "4.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void test1Fail() {
        String[] args = {"2+"};
        String output = run(args);
        String expected = "2.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void testFail() {
        String[] args = {"2+^"};
        String output = run(args);
        String expected = "2.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void test2() {
        String[] args = {"-2+2"};
        String output = run(args);
        String expected = "0.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void unary_variable() {
        String[] args = {"-a+2", "a=2"};
        String output = run(args);
        String expected = "0.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void test1WithSpaces() {
        String[] args = {"2 + 2"};
        String output = run(args);
        String expected = "4.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void testWithVariable() {
        String[] args = {"x*5", "x=2"};
        String output = run(args);
        String expected = "10.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void testWithVariableAndSpaces() {
        String[] args = {"x * 5", "x=2"};
        String output = run(args);
        String expected = "10.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void testWithVariableAndOneSpace() {
        String[] args = {"x * 5", "x=2"};
        String output = run(args);
        String expected = "10.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void testWithNegativePow() {
        String[] args = {"3+6-9+2-3+4^-2"};
        String output = run(args);
        String expected = "-0.9375";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);
    }

    @Test
    public void someTest() {
        String[] args = {"4+8-10^2-1002"};
        String output = run(args);
        String expected = "-1090.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void bracketTest() {
        String[] args = {"3 + (2 * 4)"};
        String output = run(args);
        String expected = "11.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void bracketTest2() {
        String[] args = {"(3 + 6) - (9 + 2)"};
        String output = run(args);
        String expected = "-2.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void bracketTest3() {
        String[] args = {"(2 + 2)^2"};
        String output = run(args);
        String expected = "16.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void bracketTest4() {
        String[] args = {"2^(3^2)"};
        String output = run(args);
        String expected = "512.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void bracketTest5() {
        String[] args = {"( 2 + 2) ^ 2"};
        String output = run(args);
        String expected = "16.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }

    @Test
    public void powTest() {
        String[] args = {"2^(2^(2^2))"};
        String output = run(args);
        String expected = "65536.0";
        assertEquals(expected, output);
        System.out.println("Expected: " + expected);
        System.out.println(output);

    }
}
