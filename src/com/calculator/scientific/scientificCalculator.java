package com.calculator.scientific;

import java.awt.Font;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

import javax.swing.JButton;

import com.calculator.main.Main;

@SuppressWarnings("static-access")
public class scientificCalculator {

	  private Main main = new Main(); 
	  private BigDecimal result;
	  private BigDecimal  baseValue;
	  private char opr = '\0';
	  private  Font ff1 = new Font("Ink.Free",Font.BOLD,35);
	  private static final MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
	  
		private boolean waitingForExponent = false;
		private boolean readyToCalculate = false;
		private boolean waitingForRoot = false;
		private boolean waitingForBase = false;

		
	  // This is for buttons 1 to 9 
	public synchronized void  Button(int num ) {
	            main.screen.setText(main.screen.getText().concat(String.valueOf(num)));
	}
	
	
	//pi value 
	public synchronized void PI() {
	    BigDecimal pi = new BigDecimal(Math.PI, MathContext.DECIMAL128);
	    String piString = pi.toString();
	    main.screen.setText(piString);
	}
	
	//Euler's Value 
	public synchronized void Euler() {
		  BigDecimal E = new BigDecimal(Math.E, MathContext.DECIMAL128);
		  String eString = E.toString();
		  main.screen.setText(eString);
	}
	
	
	
	public synchronized void checkForClearBtn() {
		String currentText = main.screen.getText().trim();
		if (currentText.isEmpty() || currentText == null) { 
			allClear(); 
			} else { 
					 clearEntry();
				}
		}
	
	
	//to clear entry
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
            }else {
            	allClear();
            }
        }
    }
	
	// for all clear 
	public synchronized void allClear() {
        main.screen.setText("");
        main.screen.setFont(ff1);
    }
    

    // For delete a number
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
	
	
	public synchronized void SIN() {
	    handleTrigFunction("sin");
	}

	
	public synchronized void COS() {
	    handleTrigFunction("cos");
	}

	
	public synchronized void TAN() {
	    handleTrigFunction("tan");
	}

	
	public synchronized void SEC() {
	    handleTrigFunction("sec");
	}
	
	public synchronized void CSC() {
		handleTrigFunction("csc"); 
		} 
	
	public synchronized void COT() { 
		handleTrigFunction("cot"); 
		}

	// Helper method to handle the trigonometric functions
	private synchronized void handleTrigFunction(String function) {
		   try {
		        BigDecimal number = checkNum();
		            if (number == null) {
		            	 main.screen.setText("Error");
				            return;
		            }

	         result = BigDecimal.ZERO;

	        switch (function) {
	            case "sin":
	                result = new BigDecimal(Math.sin(Math.toRadians(number.doubleValue())), mc);
	                break;
	            case "cos":
	                result = new BigDecimal(Math.cos(Math.toRadians(number.doubleValue())), mc);
	                break;
	            case "tan":
	                result = new BigDecimal(Math.tan(Math.toRadians(number.doubleValue())), mc);
	                break;
	            case "sec":
	                result = BigDecimal.ONE.divide(
	                        new BigDecimal(Math.cos(Math.toRadians(number.doubleValue())), mc), mc);
	                break;
	            case "csc":
	                result = BigDecimal.ONE.divide(
	                        new BigDecimal(Math.sin(Math.toRadians(number.doubleValue())), mc), mc);
	                break;
	            case "cot":
	                result = BigDecimal.ONE.divide(
	                        new BigDecimal(Math.tan(Math.toRadians(number.doubleValue())), mc), mc);
	                break;
	            default:
	                main.screen.setText("Invalid Function");
	                return;
	        }

	        // Display the result in the format sin0(number) = result
	        main.screen.setText(function + "0(" + number + ") = " + result.stripTrailingZeros().toPlainString());
	    } catch (NumberFormatException | ArithmeticException e) {
	       // main.screen.setText("Error");
	    }
	}

	
	public synchronized void SINInverse() { handleTrigFunctionInverse("asin"); }
	public synchronized void COSInverse() { handleTrigFunctionInverse("acos"); }
	public synchronized void TANInverse() { handleTrigFunctionInverse("atan"); }
	public synchronized void SECInverse() { handleTrigFunctionInverse("asec"); }
	public synchronized void CSCInverse() { handleTrigFunctionInverse("acsc"); }
	public synchronized void COTInverse() { handleTrigFunctionInverse("acot"); }
	
	
	
	private synchronized void handleTrigFunctionInverse(String function) {

		    try {
		        BigDecimal number = checkNum();
		            if (number == null) {
		            	 main.screen.setText("Error");
				            return;
		            }
		       

		         result = BigDecimal.ZERO;
	        switch (function) {
	        case "asin":
                result = BigDecimal.valueOf(Math.toDegrees(Math.asin(number.doubleValue())));
                break;
            case "acos":
                result = BigDecimal.valueOf(Math.toDegrees(Math.acos(number.doubleValue())));
                break;
            case "atan":
                result = BigDecimal.valueOf(Math.toDegrees(Math.atan(number.doubleValue())));
                break;
            case "asec":
                result = BigDecimal.valueOf(Math.toDegrees(Math.acos(1 / number.doubleValue())));
                break;
            case "acsc":
                result = BigDecimal.valueOf(Math.toDegrees(Math.asin(1 / number.doubleValue())));
                break;
            case "acot":
                result = BigDecimal.valueOf(Math.toDegrees(Math.atan(1 / number.doubleValue())));
                break;
	        }
	        main.screen.setText(function + "0(" + number + ") = " + result);
	    } catch (NumberFormatException | ArithmeticException e) {
	        //main.screen.setText("Error");
	    }
	}


	public synchronized void SINH() { handleTrigFunctionHyperbolic("sinh"); }
	public synchronized void COSH() { handleTrigFunctionHyperbolic("cosh"); }
	public synchronized void TANH() { handleTrigFunctionHyperbolic("tanh"); }
	public synchronized void SECH() { handleTrigFunctionHyperbolic("sech"); }
	public synchronized void CSCH() { handleTrigFunctionHyperbolic("csch"); }
	public synchronized void COTH() { handleTrigFunctionHyperbolic("coth"); }
	
	private synchronized void handleTrigFunctionHyperbolic(String function) {
		   try {
		        BigDecimal number = checkNum();
		            if (number == null) {
		            	 main.screen.setText("Error");
				            return;
		            }

		        result = BigDecimal.ZERO;
	        switch (function) {
            case "sinh":
                result = BigDecimal.valueOf(Math.sinh(number.doubleValue()));
                break;
            case "cosh":
                result = BigDecimal.valueOf(Math.cosh(number.doubleValue()));
                break;
            case "tanh":
                result = BigDecimal.valueOf(Math.tanh(number.doubleValue()));
                break;
            case "sech":
                result = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.cosh(number.doubleValue())), mc);
                break;
            case "csch":
                result = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.sinh(number.doubleValue())), mc);
                break;
            case "coth":
                result = BigDecimal.ONE.divide(BigDecimal.valueOf(Math.tanh(number.doubleValue())), mc);
                break;
	        }
	        main.screen.setText(function + "0(" + number + ") = " + result);
	    } catch (NumberFormatException | ArithmeticException e) {
	      //  main.screen.setText("Error");
	    }
	}


	public synchronized void SINHInverse() { handleTrigFunctionInverseHyperbolic("asinh"); }
	public synchronized void COSHInverse() { handleTrigFunctionInverseHyperbolic("acosh"); }
	public synchronized void TANHInverse() { handleTrigFunctionInverseHyperbolic("atanh"); }
	public synchronized void SECHInverse() { handleTrigFunctionInverseHyperbolic("asech"); }
	public synchronized void CSCHInverse() { handleTrigFunctionInverseHyperbolic("acsch"); }
	public synchronized void COTHInverse() { handleTrigFunctionInverseHyperbolic("acoth"); }

	private synchronized void handleTrigFunctionInverseHyperbolic(String function) {
		   try {
		        BigDecimal number = checkNum();
		            if (number == null) {
		            	 main.screen.setText("Error");
				            return;
		            }

		         result = BigDecimal.ZERO;
	        switch (function) {
	        case "asinh":
                result = BigDecimal.valueOf(Math.log(number.doubleValue() + Math.sqrt(number.doubleValue() * number.doubleValue() + 1)));
                break;
            case "acosh":
                result = BigDecimal.valueOf(Math.log(number.doubleValue() + Math.sqrt(number.doubleValue() * number.doubleValue() - 1)));
                break;
            case "atanh":
                result = BigDecimal.valueOf(0.5 * Math.log((1 + number.doubleValue()) / (1 - number.doubleValue())));
                break;
            case "asech":
                result = BigDecimal.valueOf(Math.log(1 / number.doubleValue() + Math.sqrt(1 / (number.doubleValue() * number.doubleValue()) - 1)));
                break;
            case "acsch":
                result = BigDecimal.valueOf(Math.log(1 / number.doubleValue() + Math.sqrt(1 / (number.doubleValue() * number.doubleValue()) + 1)));
                break;
            case "acoth":
                result = BigDecimal.valueOf(0.5 * Math.log((number.doubleValue() + 1) / (number.doubleValue() - 1)));
                break;
        }

        main.screen.setText(function + "0(" + number + ") = " + result.round(mc));
	    } catch (NumberFormatException | ArithmeticException e) {
	       // main.screen.setText("Error");
	    }
	}

	private synchronized BigDecimal checkNum() {
		 String currentText = main.screen.getText().trim();
		 String[] parts = currentText.split(" ");
		 BigDecimal number = null;
		 if (parts.length == 1) {
	            number = new BigDecimal(currentText);
	        } else if (parts.length == 3) {
	            number = new BigDecimal(parts[2]);
	        } else if (parts.length > 3) {
	            // Check from the last part to the first for a valid number
	            boolean isNumberFound = false;
	            for (int i = parts.length - 1; i >= 0; i--) {
	                try {
	                    number = new BigDecimal(parts[i]);
	                    isNumberFound = true;
	                    break; // Exit loop if a valid number is found
	                } catch (NumberFormatException e) {
	                    // Continue to the previous part if not a number
	                }
	            }
	            if (!isNumberFound) {
	                number = BigDecimal.valueOf(-1); // Set to -1 if no valid number is found
	            }
	        } 
		 return number;
	}
	
	
	
	public synchronized void Random() {
		// Generate a random number between 0 and 1
		BigDecimal randomValue =new BigDecimal( Math.random(),MathContext.DECIMAL128);
		main.screen.setText(String.valueOf(randomValue));
	}

	public synchronized void Floor() {
	    String currentText = main.screen.getText().trim();
	    try {
	        BigDecimal number = new BigDecimal(currentText);
	        BigDecimal floorValue = number.setScale(0, RoundingMode.FLOOR);
	        main.screen.setText(floorValue.toPlainString());
	    } catch (NumberFormatException e) {
	       // main.screen.setText("Error");
	    }
	}

	public synchronized void Ceil() {
	    String currentText = main.screen.getText().trim();
	    try {
	        double number = Double.parseDouble(currentText);
	        double ceilValue = Math.ceil(number);
	        main.screen.setText(String.valueOf(ceilValue));
	    } catch (NumberFormatException e) {
	        //main.screen.setText("Error");
	    }
	}

	  
	// Square method  x^2
	public synchronized void squarex2() {
	    try {
	        String text = main.screen.getText().trim();
	        if (text.isEmpty()) {
	            throw new NumberFormatException("Input is empty");
	        }
	        BigDecimal value = new BigDecimal(text);
	        BigDecimal result = value.multiply(value); 
	        main.screen.setText(result.stripTrailingZeros().toPlainString());
	    } catch (NumberFormatException e) {
	       // System.out.println("Error in squarex2: " + e.getMessage());
	      //  main.screen.setText("Error");
	    } catch (Exception e) {
	      //  System.out.println("Unexpected error in squarex2: " + e.getMessage()); 
	       // main.screen.setText("Error");
	    }
	}

	// Cube method x^3
	public synchronized void cubex3() {
	    try {
	        String text = main.screen.getText().trim();
	       // System.out.println("Input for cubex3: " + text); 
	        if (text.isEmpty()) {
	            throw new NumberFormatException("Input is empty");
	        }

	        BigDecimal value = new BigDecimal(text);
	        BigDecimal result = value.multiply(value).multiply(value); 
	        main.screen.setText(result.stripTrailingZeros().toPlainString());
	    } catch (NumberFormatException e) {
	      //  System.out.println("Error in cubex3: " + e.getMessage()); // Debug
	       // main.screen.setText("Error");
	    } catch (Exception e) {
	     //   System.out.println("Unexpected error in cubex3: " + e.getMessage()); // Debug
	       // main.screen.setText("Error");
	    }
	}


	
	// Reciprocal method 
	public synchronized void reciprocal1x() {
	    try {
	        BigDecimal value = new BigDecimal(main.screen.getText());
	        if (value.compareTo(BigDecimal.ZERO) != 0) {
	           result = BigDecimal.ONE.divide(value, MathContext.DECIMAL128);
	            main.screen.setText(result.stripTrailingZeros().toPlainString());
	        } else {
	           // main.screen.setText("Error"); // Handle division by zero
	        }
	    } catch (NumberFormatException e) {
	       // main.screen.setText("Error");
	    }
	}
	
	
	// Absolute value method
	public synchronized void Abs() {
	    try {
	        BigDecimal value = new BigDecimal(main.screen.getText());
	        BigDecimal absValue = value.abs();
	        main.screen.setText(absValue.stripTrailingZeros().toPlainString());
	    } catch (NumberFormatException e) {
	      //  main.screen.setText("Error");
	    }
	}

	    // EXP method 
	    public synchronized void Exp() {
	        String currentText = main.screen.getText().trim();
	        try {
	            BigDecimal number = new BigDecimal(currentText);
	            baseValue = number;
	            main.screen.setText(baseValue.toPlainString() + "e+0");
	        } catch (NumberFormatException e) {
	            //main.screen.setText("Error");
	        }
	    }

	   // operator method
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
		            if (operatorButton == ScientificButtons.btnPlus) {
		                opr = '+';
		            } else if (operatorButton == ScientificButtons.btnMinus) {
		                opr = '-';
		            } else if (operatorButton == ScientificButtons.btnMult) {
		                opr = 'x';
		            } else if (operatorButton == ScientificButtons.btnDiv) {
		                opr = '÷';
		            } else if (operatorButton == ScientificButtons.btnMod) {
		                opr = '%';
		            }
		            
		            main.screen.setText(currentText + " " + opr + " ");
		        }
		    } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
		        // JOptionPane.showMessageDialog(null, "Invalid Input");
		    }
		}

	
	
		 // For Square Root Button  2√x
		public synchronized void squareRoot() {
		    try {
		        BigDecimal num1 = new BigDecimal(main.screen.getText());
		        result = new BigDecimal(Math.sqrt(num1.doubleValue()));
		        main.screen.setText(result.stripTrailingZeros().toPlainString());
		    } catch (NumberFormatException ex) {
		        //main.screen.setText("Error");
		    }
		}
		
		
		//  this is for cube root 3√x
		public synchronized void cubeRoot() {
		    try {
		        BigDecimal num1 = new BigDecimal(main.screen.getText());
		        result = new BigDecimal(Math.cbrt(num1.doubleValue()));
		        main.screen.setText(result.stripTrailingZeros().toPlainString());
		    } catch (NumberFormatException ex) {
		        // Handle invalid input
		      //  main.screen.setText("Error");
		    }
		}


	    
  
		public synchronized void openBracket() {
		    String currentText = main.screen.getText().trim();
		    main.screen.setText(currentText + "(");
		}

		public synchronized void closeBracket() {
		    String currentText = main.screen.getText().trim();
		    main.screen.setText(currentText + ")");
		}

		//this is for factorial n!
		public synchronized void factorial() {
		    String currentText = main.screen.getText().trim();
		    try {
		        int number = Integer.parseInt(currentText);

		        if (number < 0) {
		          //  main.screen.setText("Error: Negative number");
		            return;
		        }

		        BigDecimal factorialValue = BigDecimal.ONE;
		        for (int i = 1; i <= number; i++) {
		            factorialValue = factorialValue.multiply(BigDecimal.valueOf(i));
		        }

		        main.screen.setText(factorialValue.stripTrailingZeros().toPlainString());
		    } catch (NumberFormatException e) {
		       // main.screen.setText("Error");
		    }
		}

		
		
	// this is for xy 
		public synchronized void xPowerY() {
		    String currentText = main.screen.getText().trim();
		    try {
		        if (!waitingForExponent && !readyToCalculate) {
		          baseValue = new BigDecimal(currentText);
		            waitingForExponent = true;
		            main.screen.setText(currentText + "^");
		        } else if (waitingForExponent) {
		            main.screen.setText(currentText);
		            readyToCalculate = true;
		            waitingForExponent = false;
		        } else if (readyToCalculate) {
		            BigDecimal exponentValue = new BigDecimal(currentText.split("\\^")[1]);
		            BigDecimal  result = baseValue.pow(exponentValue.intValue());

		            main.screen.setText(result.stripTrailingZeros().toPlainString());
		            readyToCalculate = false;
		        }
		    } catch (NumberFormatException ex) {
		      //  main.screen.setText("Error");
		        waitingForExponent = false;
		        readyToCalculate = false;
		    }
		}
		
		// this is for y root x 
		public synchronized void yRootX() {
		    String currentText = main.screen.getText().trim();

		    try {
		        if (!waitingForRoot && !readyToCalculate) {
		        	 baseValue = new BigDecimal(currentText);
		            waitingForRoot = true;
		            main.screen.setText(currentText + " y√");
		        } else if (waitingForRoot) {
		            main.screen.setText(currentText);
		            readyToCalculate = true;
		            waitingForRoot = false;
		        } else if (readyToCalculate) {
		            String[] parts = currentText.split(" y√");
		            if (parts.length == 2) {
		                BigDecimal rootValue = new BigDecimal(parts[1]);

		                if (rootValue.compareTo(BigDecimal.ZERO) == 0) {
		                    main.screen.setText("Error");
		                    waitingForRoot = false;
		                    readyToCalculate = false;
		                    return;
		                }

		                // Calculate y-th root of x: x^(1/y)
		                double resultValue = Math.pow(baseValue.doubleValue(), 1.0 / rootValue.doubleValue());
		                result = new BigDecimal(resultValue);
		                
		                main.screen.setText(result.stripTrailingZeros().toPlainString());
		                readyToCalculate = false;
		            } else {
		                main.screen.setText("Error");
		                waitingForRoot = false;
		                readyToCalculate = false;
		            }
		        }
		    } catch (NumberFormatException ex) {
		       // main.screen.setText("Error");
		        waitingForRoot = false;
		        readyToCalculate = false;
		    }
		}


    
		
		// 10x
		public synchronized void tenPowerX() {
		    String currentText = main.screen.getText().trim();
		    try {
		        BigDecimal number = new BigDecimal(currentText);
		        result = BigDecimal.TEN.pow(number.intValue());

		        main.screen.setText(result.stripTrailingZeros().toPlainString());
		    } catch (NumberFormatException e) {
		      //  main.screen.setText("Error");
		    }
		}

		// 2^x
		public synchronized void twoPowerX() {
		    String currentText = main.screen.getText().trim();
		    try {
		        BigDecimal number = new BigDecimal(currentText);
		        double resultValue = Math.pow(2, number.doubleValue());
		        result = new BigDecimal(resultValue);
		        main.screen.setText(result.stripTrailingZeros().toPlainString());
		    } catch (NumberFormatException e) {
		       // main.screen.setText("Error");
		    }
		}

		

		
		//log
		public synchronized void logBase10() {
		    String currentText = main.screen.getText().trim();
		    try {
		        BigDecimal number = new BigDecimal(currentText);
		        if (number.compareTo(BigDecimal.ZERO) > 0) {
		            result = new BigDecimal(Math.log10(number.doubleValue()));
		            main.screen.setText(result.stripTrailingZeros().toPlainString());
		        } else {
		            main.screen.setText("Error");
		        }
		    } catch (NumberFormatException e) {
		      //  main.screen.setText("Error");
		    }
		}
		
		// log base y
		public synchronized void logBaseY() {
		    String currentText = main.screen.getText().trim();
		    try {
		        if (!waitingForBase) {
		        	  baseValue = new BigDecimal(currentText);
		            if (baseValue.compareTo(BigDecimal.ZERO) <= 0 || baseValue.compareTo(BigDecimal.ONE) == 0) {
		                main.screen.setText("Error");
		                return;
		            }
		            waitingForBase = true;
		            main.screen.setText(currentText + " logBase ");
		        } else {
		            
		            BigDecimal argumentValue = new BigDecimal(currentText.split(" logBase ")[1]);
		            if (argumentValue.compareTo(BigDecimal.ZERO) <= 0) {
		                main.screen.setText("Error");
		                waitingForBase = false;
		                return;
		            }
		            
		            double resultValue = Math.log(argumentValue.doubleValue()) / Math.log(baseValue.doubleValue());
		            result = new BigDecimal(resultValue);

		            main.screen.setText(result.stripTrailingZeros().toPlainString());
		            waitingForBase = false;
		        }
		    } catch (NumberFormatException e) {
		      //  main.screen.setText("Error");
		        waitingForBase = false;
		    }
		}

		//ln
		public synchronized void naturalLog() {
		    String currentText = main.screen.getText().trim();
		    try {
		        BigDecimal number = new BigDecimal(currentText);
		        if (number.compareTo(BigDecimal.ZERO) > 0) {
		            result = new BigDecimal(Math.log(number.doubleValue()));
		            main.screen.setText(result.stripTrailingZeros().toPlainString());
		        } else {
		            main.screen.setText("Error");
		        }
		    } catch (NumberFormatException e) {
		       // main.screen.setText("Error");
		    }
		}

		
		//e power x
		public synchronized void ePowerX() {
		    String currentText = main.screen.getText().trim();
		    try {
		        BigDecimal number = new BigDecimal(currentText);
		        double resultValue = Math.exp(number.doubleValue());
		        result = new BigDecimal(resultValue);
		        main.screen.setText(result.stripTrailingZeros().toPlainString());
		    } catch (NumberFormatException e) {
		      //  main.screen.setText("Error");
		    }
		}


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

		            // Extract the last number
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
		 
		public synchronized void Zero() {
	        try {
	            int currentValue = Integer.parseInt(main.screen.getText());
	            int newValue = currentValue * 10; 
	            main.screen.setText(String.valueOf(newValue));
	        } catch (NumberFormatException ex) {
	            main.screen.setText(main.screen.getText().concat("0"));
	        }
	    }

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

		  
		   
		 public synchronized void Equal() {
			    String expression = main.screen.getText().trim();
			    try {
			        if (expression.contains(" logBase ")) {
			            logBaseY();
			        } else if (expression.contains("e")) {
			            String[] parts = expression.split("e");
			            BigDecimal base = new BigDecimal(parts[0].trim());
			            int exponent = Integer.parseInt(parts[1].replace("+", "").trim());
			            BigDecimal result = base.multiply(BigDecimal.TEN.pow(exponent));

			            main.screen.setText(result.stripTrailingZeros().toPlainString());
			        } else if (expression.contains("^")) {
			           
			            String[] parts = expression.split("\\^");
			            if (parts.length == 2) {
			                BigDecimal base = new BigDecimal(parts[0].trim());
			                BigDecimal exponent = new BigDecimal(parts[1].trim());
			                BigDecimal result = base.pow(exponent.intValue());
			                main.screen.setText(result.stripTrailingZeros().toPlainString());
			            } else {
			                main.screen.setText("Error");
			            }
			        } else if (expression.contains(" y√")) {
			           
			            String[] parts = expression.split(" y√");
			            if (parts.length == 2) {
			                BigDecimal base = new BigDecimal(parts[0].trim());
			                BigDecimal rootValue = new BigDecimal(parts[1].trim());

			                if (rootValue.compareTo(BigDecimal.ZERO) == 0) {
			                    main.screen.setText("Error");
			                } else {
			                    double resultValue = Math.pow(base.doubleValue(), 1.0 / rootValue.doubleValue());
			                    BigDecimal result = new BigDecimal(resultValue);
			                    main.screen.setText(result.stripTrailingZeros().toPlainString());
			                }
			            } else {
			                main.screen.setText("Error");
			            }
			        } else {
			            BigDecimal result = new BigDecimal(evaluate(expression));
			            main.screen.setText(String.valueOf(result));
			        }
			    } catch (Exception ex) {
			       // main.screen.setText("Error");
			    }
			}


		// Method to evaluate the expression
		 public double evaluate(String expression) {
		     char[] tokens = expression.toCharArray();

		     // Stack for numbers: 'values'
		     Stack<Double> values = new Stack<>();

		     // Stack for operators: 'ops'
		     Stack<Character> ops = new Stack<>();

		     for (int i = 0; i < tokens.length; i++) {
		         // Skip whitespace
		         if (tokens[i] == ' ')
		             continue;

		         // Parse numbers, including negative numbers
		         if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.' || 
		             (tokens[i] == '-' && (i == 0 || tokens[i - 1] == '(' || isOperator(tokens[i - 1])))) {
		             StringBuilder sbuf = new StringBuilder();

		             // Include the negative sign if it starts the number
		             if (tokens[i] == '-') {
		                 sbuf.append(tokens[i++]);
		             }

		             while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.')) {
		                 sbuf.append(tokens[i++]);
		             }

		             values.push(Double.parseDouble(sbuf.toString()));
		             i--; // Adjust index for for-loop increment
		         }
		         // Handle opening parentheses
		         else if (tokens[i] == '(') {
		             ops.push(tokens[i]);
		         }
		         // Handle closing parentheses
		         else if (tokens[i] == ')') {
		             while (ops.peek() != '(') {
		                 values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		             }
		             ops.pop();
		         }
		         // Handle operators
		         else if (isOperator(tokens[i])) {
		             while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) {
		                 values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		             }
		             ops.push(tokens[i]);
		         }
		     }

		     // Apply remaining operators to the values stack
		     while (!ops.isEmpty()) {
		         values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		     }

		     // The top of the values stack contains the result
		     return values.pop();
		 }

		 // Helper method to check if a character is an operator
		 private boolean isOperator(char c) {
		     return c == '+' || c == '-' || c == 'x' || c == '÷' || c == '%';
		 }

		 // Returns true if 'op2' has higher or same precedence as 'op1'
		 public boolean hasPrecedence(char op1, char op2) {
		     if (op2 == '(' || op2 == ')') {
		         return false;
		     }
		     if ((op1 == 'x' || op1 == '÷' || op1 == '%') && (op2 == '+' || op2 == '-')) {
		         return false;
		     }
		     return true;
		 }


			// A utility method to apply an operator 'op' on operands 'a' 
			// and 'b'. Return the result.
			public double applyOp(char op, double b, double a) {
			    switch (op) {
			        case '+':
			            return a + b;
			        case '-':
			            return a - b;
			        case 'x':
			            return a * b;
			        case '÷':
			            if (b == 0)
			                throw new UnsupportedOperationException("Cannot divide by zero");
			            return a / b;
			        case '%':
			            if (b == 0)
			                throw new UnsupportedOperationException("Cannot divide by zero");
			            return a % b;
			    }
			    return 0;
			}


	


		   
}




