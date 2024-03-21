package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static calculator.Polynomial.*;

public class Interfata {
        public static HashMap<Integer, Double> parsare(String str) {
                HashMap<Integer, Double> solution = new HashMap<>();
                int size = str.length();
                int pozition = 0;
                while (pozition < size) { //cat timp nu am ajuns la capatul sirului
                        char c = str.charAt(pozition); //caracterul la poz curenta
                        double coeficient = 1.0;
                        int grad = 0;
                        if (c == '-') {
                                coeficient = -1.0;
                                pozition++;
                                c = str.charAt(pozition);
                        }
                        if (c >= '0' && c <= '9') {
                                String coeficientStr = ""; //initializam coef lui x
                                while (pozition < size && (c >= '0' && c <= '9' || c == '.')) {
                                        coeficientStr += c;
                                        pozition++;
                                        if (pozition < size) {
                                                c = str.charAt(pozition);
                                        }
                                }
                                coeficient *= Double.parseDouble(coeficientStr);
                        }
                        if (c == 'x') {
                                pozition++;
                                c = str.charAt(pozition);
                                if (c == '^') {
                                        pozition++;
                                        c = str.charAt(pozition);
                                        grad = Character.getNumericValue(c); //facem de la caracter la un numar
                                        pozition++;
                                } else {
                                        grad = 1;
                                }
                        }
                        if (coeficient != 0.0) {
                                solution.put(grad, coeficient);
                        }
                        pozition++;
                }
                return solution;
        }

        private JTextField firstP;
        private JTextField secondP;
        private JButton derivationButton;
        private JButton integrationButton;
        private JButton addButton;
        private JButton multiplicateButton;
        private JButton divideButton;
        private JButton substractButton;
        private JTextField rezultat;
        private JPanel calculator;

        public Interfata()
        {
                JFrame frame = new JFrame("Polynomial Calculator");
                frame.setContentPane(calculator);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(750,300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.getHSBColor(0.58f,0.25f,1.0f));
                multiplicateButton.setBackground(Color.getHSBColor(0.95f, 0.25f, 1.0f));
                addButton.setBackground(Color.getHSBColor(0.95f, 0.25f, 1.0f));
                substractButton.setBackground(Color.getHSBColor(0.95f, 0.25f, 1.0f));
                divideButton.setBackground(Color.getHSBColor(0.95f, 0.25f, 1.0f));
                integrationButton.setBackground(Color.getHSBColor(0.95f, 0.25f, 1.0f));
                derivationButton.setBackground(Color.getHSBColor(0.95f, 0.25f, 1.0f));


                addButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
                                HashMap<Integer, Double> polinom2 = new HashMap<Integer, Double>();
                                polinom1 = parsare(firstP.getText());
                                polinom2 = parsare(secondP.getText());
                                Polynomial pol1 = new Polynomial(polinom1);
                                Polynomial pol2 = new Polynomial(polinom2);
                                HashMap<Integer, Double> rez = new HashMap<Integer, Double>();
                                rez = addPolynomials(pol1, pol2);
                                Polynomial solution = new Polynomial(rez);
                                rezultat.setText(solution.toString());
                        }
                });

                substractButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
                                HashMap<Integer, Double> polinom2 = new HashMap<Integer, Double>();
                                polinom1 = parsare(firstP.getText());
                                polinom2 = parsare(secondP.getText());
                                Polynomial pol1 = new Polynomial(polinom1);
                                Polynomial pol2 = new Polynomial(polinom2);
                                HashMap<Integer, Double> rez = new HashMap<Integer, Double>();
                                rez = subtractPolynomials(pol1, pol2);
                                Polynomial solution = new Polynomial(rez);
                                rezultat.setText(solution.toString());
                        }
                });
                multiplicateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
                                HashMap<Integer, Double> polinom2 = new HashMap<Integer, Double>();
                                polinom1 = parsare(firstP.getText());
                                polinom2 = parsare(secondP.getText());
                                Polynomial pol1 = new Polynomial(polinom1);
                                Polynomial pol2 = new Polynomial(polinom2);
                                HashMap<Integer, Double> rez = new HashMap<Integer, Double>();
                                rez = multiplicatePolynomials(pol1, pol2);
                                Polynomial solution = new Polynomial(rez);
                                rezultat.setText(solution.toString());
                        }
                });
                integrationButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
                                polinom1 = parsare(firstP.getText());
                                Polynomial pol1 = new Polynomial(polinom1);
                                HashMap<Integer, Double> rez = new HashMap<Integer, Double>();
                                rez = integrationPolynomials(pol1);
                                Polynomial solution = new Polynomial(rez);
                                rezultat.setText(solution.toString());
                        }
                });
                derivationButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                HashMap<Integer, Double> polinom1 = new HashMap<Integer, Double>();
                                polinom1 = parsare(firstP.getText());
                                Polynomial pol1 = new Polynomial(polinom1);
                                HashMap<Integer, Double> rez = new HashMap<Integer, Double>();
                                rez = derivationPolynomials(pol1);
                                Polynomial solution = new Polynomial(rez);
                                rezultat.setText(solution.toString());
                        }
                });
        }
        public static void main(String [] args)
        {
                String s = new String("3x^2+6x^1+9x^0");
                System.out.println(parsare(s));
        }

}
