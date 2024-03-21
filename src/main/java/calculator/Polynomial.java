package calculator;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private HashMap <Integer, Double> polinom; //cream o variabilă privată de instanță

    public Polynomial(HashMap<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    public static HashMap<Integer, Double> addPolynomials(Polynomial a, Polynomial b) {
        HashMap<Integer, Double> solution;
        solution = new HashMap<Integer, Double>(); //alocam memorie
        for(int cheie:a.polinom.keySet())
        {
            double coeficientA = a.polinom.get(cheie);
            double coeficientB = b.polinom.getOrDefault(cheie, 0.0); //cazul in care nu exista coef pt b
            double suma = coeficientA + coeficientB;
            if (suma != 0.0)
                solution.put(cheie,suma);
        }
        for(int cheie:b.polinom.keySet())
        {
            if(!solution.containsKey((cheie))) //vf daca in polinomul rezultat nu exista x care are gradul cheie
            {
                double coeficienB = b.polinom.get(cheie);
                solution.put(cheie, coeficienB);
            }
        }
        return solution;
    }
    public static HashMap<Integer, Double> subtractPolynomials(Polynomial a, Polynomial b) {
        HashMap<Integer, Double> solution;
        solution = new HashMap<Integer, Double>(); //alocam memorie
        for(int cheie:a.polinom.keySet())
        {
            double coeficientA = a.polinom.get(cheie);
            double coeficientB = b.polinom.getOrDefault(cheie, 0.0);
            double diferenta = coeficientA - coeficientB;
            if (diferenta != 0.0)
                solution.put(cheie,diferenta);
        }
        for(int cheie:b.polinom.keySet())
        {
            if(!solution.containsKey((cheie)))//vf daca in polinomul rezultat nu exista x care are gradul cheie
            {
                double coeficienB = -b.polinom.get(cheie); //inmultim cu -1 ca sa obtinem valoarea opusa
                solution.put(cheie, coeficienB);
            }
        }
        return solution;
    }
    public static HashMap<Integer, Double> multiplicatePolynomials(Polynomial a, Polynomial b) {
        HashMap<Integer, Double> solution;
        solution = new HashMap<Integer, Double>();
        for(int cheie1:a.polinom.keySet())
        {
            for(int cheie2:b.polinom.keySet())
            {
                int cheie = cheie1 + cheie2;
                double valoare = a.polinom.get(cheie1) * b.polinom.get(cheie2);
                if (solution.containsKey(cheie)) { //vf daca cheia exista in solution
                    valoare = valoare + solution.get(cheie); //valoarea corespunzatoare cheii este adaugata in valoare
                }
                solution.put(cheie, valoare);
            }
        }
        return solution;
    }
    public static HashMap<Integer, Double> derivationPolynomials(Polynomial a) {
        HashMap<Integer, Double> solution;
        solution = new HashMap<Integer, Double>();
        for(int cheie:a.polinom.keySet())
        {
            if(cheie - 1 >= 0)
                solution.put(cheie - 1, a.polinom.get(cheie) * cheie);
        }
        return solution;
    }
    public static HashMap<Integer, Double> integrationPolynomials(Polynomial a) {
        HashMap<Integer, Double> solution;
        solution = new HashMap<Integer, Double>();
        for(int cheie:a.polinom.keySet())
        {
            if(cheie + 1 != 0)
                solution.put(cheie + 1, a.polinom.get(cheie) / (cheie + 1));
        }
        return solution;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(); //poate sa concateneze mai multe bucati din string
        boolean isFirstTerm = true; //vf daca elementul actual este primul elem al sirului
        for (int grad : polinom.keySet()) {
            double coef = polinom.get(grad); //coef va fi valoarea polinomului la gradul respectiv
            if (coef == 0) {
                continue;
            }
            if (!isFirstTerm && coef > 0) {
                str.append("+"); //adaugam +
            }
            if (coef == -1 && grad > 0) {
                str.append("-"); //adaugam -
            } else if (coef != 1 || grad == 0) {
                str.append(coef);
            }
            if (grad > 0) {
                str.append("x"); //adaugam x
                if (grad > 1) {
                    str.append("^").append(grad);
                }
            }
            isFirstTerm = false;
        }
        if (isFirstTerm) {
            str.append("0");
        }
        return str.toString();
    }

}
