package com.calculator.standard;

import java.awt.Font;
import java.util.Stack;

import javax.swing.JButton;

import com.calculator.main.Main;

public class standardCalculator {
  private Main main = new Main(); 
  private char opr = '\0';
  private  Font ff1 = new Font("Ink.Free",Font.BOLD,35);
  
  
  
  
@SuppressWarnings("static-access")
public synchronized void  Button(int num ) {
            main.screen.setText(main.screen.getText().concat(String.valueOf(num)));
}

   //Zero
   @SuppressWarnings("static-access")
public synchronized void Zero() {
        try {
            int currentValue = Integer.parseInt(main.screen.getText());
            int newValue = currentValue * 10; 
            main.screen.setText(String.valueOf(newValue));
        } catch (NumberFormatException ex) {
            main.screen.setText(main.screen.getText().concat("0"));
        }
    }


    
    // For Decimal Button
   @SuppressWarnings("static-access")
   public synchronized void Decimal() {
	    String currentText = main.screen.getText().trim();
	    String[] parts = currentText.split(" ");
	    String lastPart = parts[parts.length - 1];

	    if (!lastPart.contains(".")) {
	        main.screen.setText(currentText.concat("."));
	    } else {
	        main.screen.setText(currentText);
	    }
	}

	

    // For All Clear Button
    @SuppressWarnings("static-access")
	public synchronized void allClear() {
        main.screen.setText("");
        main.screen.setFont(ff1);
    }
    

    // For delete a number
    @SuppressWarnings("static-access")
   	public synchronized void deleteNum() {
   		if(main.screen.getText().contentEquals("Error")) {
   			allClear();
   		}
   	else if (main.screen.getText().length() > 0) {
               StringBuilder str = new StringBuilder(main.screen.getText());
               str.deleteCharAt(main.screen.getText().length() - 1);
               main.screen.setText(str.toString());
           }else {
           	allClear();      
           	}
       }
    

    // For Operator Buttons
    @SuppressWarnings("static-access")
	public synchronized void handleOperator(JButton operatorButton) {
	    try {
	        String currentText = main.screen.getText().trim();
	        char lastChar = currentText.charAt(currentText.length() - 1);
	        char[] operators = {'+', '-', 'x', '÷', '%'};
	        
	        boolean lastCharIsOperator = false;
	        
	        for (char operator : operators) {
	            if (lastChar == operator) {
	                lastCharIsOperator = true;
	                break;
	            }
	        }
	        
	        if (!lastCharIsOperator) {
	            if (operatorButton == StandardButtons.btnPlus) {
	                opr = '+';
	            } else if (operatorButton == StandardButtons.btnMinus) {
	                opr = '-';
	            } else if (operatorButton == StandardButtons.btnMult) {
	                opr = 'x';
	            } else if (operatorButton == StandardButtons.btnDiv) {
	                opr = '÷';
	            } else if (operatorButton == StandardButtons.btnMod) {
	                opr = '%';
	            }
	            
	            main.screen.setText(currentText + " " + opr + " "); 
	        }
	    } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
	        
	        // JOptionPane.showMessageDialog(null, "Invalid Input");
	    }
	}
    
    

    // For Square Root Button 2 root x
    @SuppressWarnings("static-access")
    public synchronized void squareRoot() {
        try {
          Double num1 = Double.parseDouble(main.screen.getText());
            if (num1 < 0) {
                return;
            }

           Double result = Math.sqrt(num1);
            String resultString = String.format("%.15f", result).replaceAll("\\.?0*$", "");
            main.screen.setText(resultString);

        } catch (NumberFormatException ex) {
          //  JOptionPane.showMessageDialog(null, "Invalid Input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            //main.screen.setText(""); 
        }
    }

    @SuppressWarnings("static-access")
	public void Equals() {
        String expression = main.screen.getText().trim();
        try {
            if (expression.isEmpty()) {
                return;
            }
            double result = evaluate(expression);
            main.screen.setText(String.valueOf(result));
        } catch (Exception ex) {
            //main.screen.setText("Error");
        }
    }

    public double evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            // Skip whitespace
            if (tokens[i] == ' ') continue;

            // Parse numbers, including negative numbers
            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.' || 
                (tokens[i] == '-' && (i == 0 || tokens[i - 1] == '(' || isOperator(tokens[i - 1])))) {
                StringBuilder sbuf = new StringBuilder();

                if (tokens[i] == '-') sbuf.append(tokens[i++]);

                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.')) {
                    sbuf.append(tokens[i++]);
                }
                values.push(Double.parseDouble(sbuf.toString()));
                i--; // Adjust index for for-loop increment
            }
            // Handle operators
            else if (isOperator(tokens[i])) {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }
    
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'x' || c == '÷' || c == '%';
    }



    public boolean hasPrecedence(char op1, char op2) {
        return !(op1 == 'x' || op1 == '÷' || op1 == '%') || (op2 == '+' || op2 == '-');
    }

    public double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '÷':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            case '%':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a % b;
            default:
                throw new UnsupportedOperationException("Unknown operator: " + op);
        }
    }


    
    @SuppressWarnings("static-access")
	public synchronized void clearEntry() {
        String currentText = main.screen.getText().trim();
        if (currentText.length() > 0) {
            String[] parts = currentText.split(" ");
            if (parts.length == 3) {
                main.screen.setText(parts[0] + " " + parts[1]);
            } else if (parts.length == 2) {
                main.screen.setText(parts[0]);
            } else if (parts.length == 1) {
               allClear();
            }
        }
    }


    @SuppressWarnings("static-access")
	public synchronized void reciprocal() {
        try {
            double value = Double.parseDouble(main.screen.getText());
            if (value != 0) {
            	
                main.screen.setText(String.valueOf(1 / value)); 
            } 
        } catch (NumberFormatException e) {
           // main.screen.setText("Error");
        }
    }

    @SuppressWarnings("static-access")
	public synchronized void square() {
        try {
            double value = Double.parseDouble(main.screen.getText());
            main.screen.setText(String.valueOf(value * value)); 
        } catch (NumberFormatException e) {
           
         //   main.screen.setText("Error");
        }
    }

    @SuppressWarnings("static-access")
    public synchronized void changeSign() {
        try {
            String expression = main.screen.getText().trim();

            int lastOperatorIndex = -1;
            for (int i = expression.length() - 1; i >= 0; i--) {
                if (isOperator(expression.charAt(i)) || expression.charAt(i) == '(') {
                    lastOperatorIndex = i;
                    break;
                }
            }

            String lastNumber = expression.substring(lastOperatorIndex + 1).trim();
            if (lastNumber.isEmpty()) {
                return; 
            }

            double value = Double.parseDouble(lastNumber);
            String changedNumber = String.valueOf(-value);

            String updatedExpression = expression.substring(0, lastOperatorIndex + 1) + changedNumber;
            main.screen.setText(updatedExpression);
        } catch (NumberFormatException e) {
           
            // main.screen.setText("Error");
        }
    
    }
    
    
}







