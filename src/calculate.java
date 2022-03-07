import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculate implements ActionListener {
    private static JTextField inputBox;

    calculate() {
    }

    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);
        frame.setSize(250, 251);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private static void createUI(JFrame frame) {
        JPanel panel = new JPanel();
        calculate calculator = new calculate();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        //panel.setBackground(new Color(15, 14, 20, 178));
        panel.setLayout(layout);

        inputBox = new JTextField(30);
        inputBox.setEditable(false);

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonDivide = new JButton("/");
        JButton buttonRemaining = new JButton("%");
        JButton buttonMultiply = new JButton("x");
        JButton buttonClear = new JButton("C");
        JButton buttonDot = new JButton(".");
        JButton buttonEquals = new JButton("=");

        button1.addActionListener(calculator);
        button2.addActionListener(calculator);
        button3.addActionListener(calculator);
        button4.addActionListener(calculator);
        button5.addActionListener(calculator);
        button6.addActionListener(calculator);
        button7.addActionListener(calculator);
        button8.addActionListener(calculator);
        button9.addActionListener(calculator);
        button0.addActionListener(calculator);

        buttonPlus.addActionListener(calculator);
        buttonMinus.addActionListener(calculator);
        buttonDivide.addActionListener(calculator);
        buttonRemaining.addActionListener(calculator);
        buttonMultiply.addActionListener(calculator);
        buttonClear.addActionListener(calculator);
        buttonDot.addActionListener(calculator);
        buttonEquals.addActionListener(calculator);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(button1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(button2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(button3, gbc);
        gbc.gridx = 3;
        gbc.gridy = 6;
        panel.add(buttonPlus, gbc);
        buttonPlus.setToolTipText("Sum operation");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(button4, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(button5, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(button6, gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
        panel.add(buttonMinus, gbc);
        buttonMinus.setToolTipText("Subtract operation");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(button7, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button8, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(button9, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(buttonDivide, gbc);
        buttonDivide.setToolTipText("Division operation");
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(buttonRemaining, gbc);
        buttonRemaining.setToolTipText("Remaining operation");
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(buttonDot, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(button0, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(buttonClear, gbc);
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(buttonMultiply, gbc);
        buttonMultiply.setToolTipText("Multiply operation");
        gbc.gridx = 3;
        gbc.gridy = 7;
        panel.add(buttonEquals, gbc);
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(inputBox, gbc);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) == 'C') {
            inputBox.setText("");
        } else if (command.charAt(0) == '=') {
            inputBox.setText(evaluate(inputBox.getText()));
        } else {
            inputBox.setText(inputBox.getText() + command);
        }
    }

    public static String evaluate(String expression) {
        char[] arr = expression.toCharArray();
        StringBuilder operand1 = new StringBuilder();
        StringBuilder operand2 = new StringBuilder();
        StringBuilder operator = new StringBuilder();
        StringBuilder finalResult = new StringBuilder();
        double result = 0;

        for (char c : arr) {
            if (c >= '0' && c <= '9' || c == '.') {
                if (operator.length() == 0) {
                    operand1.append(c);
                } else {
                    operand2.append(c);
                }
            }

            if (c == '+' || c == '-' || c == '/' || c == 'x' || c == '%') {
                operator.append(c);
            }
        }

        switch (operator.toString()) {
            case "+":
                result = (Double.parseDouble(operand1.toString()) + Double.parseDouble(operand2.toString()));
                finalResult = new StringBuilder("" + result);
                break;
            case "-":
                result = (Double.parseDouble(operand1.toString()) - Double.parseDouble(operand2.toString()));
                finalResult = new StringBuilder("" + result);
                break;
            case "/":
                result = (Double.parseDouble(operand1.toString()) / Double.parseDouble(operand2.toString()));
                finalResult = new StringBuilder("" + result);
                break;
            case "%":
                result = (Double.parseDouble(operand1.toString()) % Double.parseDouble(operand2.toString()));
                finalResult = new StringBuilder("" + result);
                break;
            case "x":
                result = (Double.parseDouble(operand1.toString()) * Double.parseDouble(operand2.toString()));
                finalResult = new StringBuilder("" + result);
                break;
            default:
                break;
        }
        return finalResult.toString();
    }
}
