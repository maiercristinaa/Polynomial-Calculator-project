package calculator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void addPolynomialsTest() {
        HashMap<Integer, Double> poli1 = new HashMap<Integer, Double>();
        poli1.put(3,6.0);
        poli1.put(1,2.0);
        HashMap<Integer, Double> poli2 =new HashMap<Integer, Double>();
        poli2.put(3,5.0);
        poli2.put(1,1.0);
        HashMap<Integer, Double> poli3 = new HashMap<Integer, Double>();
        poli3.put(3,11.0);
        poli3.put(1,3.0);
        Polynomial polynomial1 = new Polynomial(poli1);
        Polynomial polynomial2 = new Polynomial(poli2);
        HashMap<Integer, Double> expected = poli3;
        HashMap<Integer, Double> actual = polynomial1.addPolynomials(polynomial1, polynomial2);
        assertEquals(expected, actual);
    }

    @Test
    void subtractPolynomialsTest() {
        HashMap<Integer, Double> poli1 = new HashMap<Integer, Double>();
        poli1.put(3,6.0);
        poli1.put(1,2.0);
        HashMap<Integer, Double> poli2 = new HashMap<Integer, Double>();
        poli2.put(3,5.0);
        poli2.put(1,1.0);
        HashMap<Integer, Double> poli3 = new HashMap<Integer, Double>();
        poli3.put(3,1.0);
        poli3.put(1,1.0);
        Polynomial polynomial1 = new Polynomial(poli1);
        Polynomial polynomial2 = new Polynomial(poli2);
        HashMap<Integer, Double> expected = poli3;
        HashMap<Integer, Double> actual = polynomial1.subtractPolynomials(polynomial1, polynomial2);
        assertEquals(expected, actual);
    }

    @Test
    void multiplicatePolynomialsTest() {
        HashMap<Integer, Double> poli1 = new HashMap<Integer, Double>();
        poli1.put(3,6.0);
        poli1.put(1,2.0);
        HashMap<Integer,Double>poli2 = new HashMap<Integer, Double>();
        poli2.put(3,5.0);
        poli2.put(1,1.0);
        HashMap<Integer, Double> poli3 = new HashMap<Integer, Double>();
        poli3.put(6,30.0);
        poli3.put(4,16.0);
        poli3.put(2,2.0);
        Polynomial polynomial1 = new Polynomial(poli1);
        Polynomial polynomial2 = new Polynomial(poli2);
        HashMap<Integer, Double> expected = poli3;
        HashMap<Integer, Double> actual = polynomial1.multiplicatePolynomials(polynomial1,polynomial2);
        assertEquals(expected, actual);
    }

    @Test
    void derivationPolynomialsTest() {
        HashMap<Integer, Double> poli1 = new HashMap<Integer, Double>();
        poli1.put(3,6.0);
        poli1.put(1,2.0);
        HashMap<Integer, Double> expected = new HashMap<Integer, Double>();
        expected.put(2,18.0);
        expected.put(0,2.0);
        Polynomial polynomial1 = new Polynomial(poli1);
        HashMap<Integer, Double> actual = polynomial1.derivationPolynomials(polynomial1);
        assertEquals(expected, actual);
    }

    @Test
    void integrationPolynomialsTest() {
        HashMap<Integer, Double> poli1 = new HashMap<Integer, Double>();
        poli1.put(3,6.0);
        poli1.put(1,2.0);
        HashMap<Integer, Double> expected = new HashMap<Integer, Double>();
        expected.put(4, 1.5);
        expected.put(2,1.0);
        Polynomial polynomial1 = new Polynomial(poli1);
        HashMap<Integer, Double> actual = polynomial1.integrationPolynomials(polynomial1);
        assertEquals(expected, actual);
    }
}