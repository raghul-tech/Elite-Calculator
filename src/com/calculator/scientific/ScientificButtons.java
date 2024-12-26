package com.calculator.scientific;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.calculator.main.Main;
import com.calculator.themes.Themes;

@SuppressWarnings("static-access")
public class ScientificButtons { 
	private Main main = new Main();
	private scientificCalculator calc = new scientificCalculator();
	
		private Font ff1 = new Font("Serif", Font.PLAIN, 20);	
	    private  Font ff2 = new Font("Ink.Free",Font.BOLD,20);
	    private  Font ff3 = new Font("Monospaced", Font.PLAIN, 18);	
	
	public static JButton numBtn[] = new JButton[10];
	public static JButton btnPlus, btnMinus, btnMult, btnDiv, btnMod;
		
public static JButton btn2nd,btnpi,btnE,btnCE,btnDel,
		              btnhyp,btnSin,btnCos,btnTan,btnSec,
		              btnCsc,btnCot,btnRand,btnFloor,btnCeil,
		              btnx2,btn1x,btnabs,btnExp,//Mod
		              btnSqrt,btnOpenBracket,btnCloseBracket,btnFact,//div
	                  btnxy,//seven //eight //nine //multi
	                  btn10x,//four //five //six //minus
	                  btnLog,//one //two //three //plus
	                  btnLn,btnChangeSign,btnZero,btnDec,btnEqual;
	    

private boolean isSecondFunctionActive = false;
private boolean isHypFunctionActive = false;

	    /**
		  * scientific button panel
		  */
		
		  public void addScientificButtons() {
		    	 main.getPanel().removeAll();
		    	 main.getFrame().setSize(500, 640);
		       	 main.getPanel().setLayout(new GridLayout(9,5));
		    	 documentListener();
		    	
		         for(int i = 1;i<10;i++) {
		             numBtn[i] = new JButton(String.valueOf(i));
		             main.getPanel().add(numBtn[i]);
		             numBtn[i].setFont(ff2);
		             numBtn[i].setFocusable(false);
		             int finalI = i; // this is to capture the i from lambda function
		             numBtn[i].addActionListener(e -> calc.Button(finalI));
		         }
		      
		         
		         //2nd Button
		           btn2nd = new JButton("<html>2<sup>nd</sup></html>");
		           btn2nd.setFont(ff3);
		           btn2nd.setFocusable(false);

		           //pi Button
		           btnpi = new JButton("π");
		           btnpi.setFont(ff1);
		           btnpi.setFocusable(false);

		           //Euler button e 
		           btnE = new JButton("e");
		           btnE.setFont(ff3);
		           btnE.setFocusable(false);

		           // clear entry CE and AC 
		           btnCE = new JButton("AC");
		           btnCE.setFont(ff3);
		           btnCE.setFocusable(false);

		           //Delete or backspace Button
		           btnDel = new JButton("<html><big>&larr;</big></html>");
		           btnDel.setFont(ff3);
		           btnDel.setFocusable(false);
		         
		           //hyp Button
		           btnhyp = new JButton("hyp");
		           btnhyp.setFont(ff3);
		           btnhyp.setFocusable(false);

		           //Sin Button
		           btnSin = new JButton("sin");
		           btnSin.setFont(ff3);
		           btnSin.setFocusable(false);
		           
		           //cos Button
		           btnCos = new JButton("cos");
		           btnCos.setFont(ff3);
		           btnCos.setFocusable(false);

		           //Tan Button
		           btnTan = new JButton("tan");
		           btnTan.setFont(ff3);
		           btnTan.setFocusable(false);
		         
		           //Sec Button
		           btnSec = new JButton("sec");
		           btnSec.setFont(ff3);
		           btnSec.setFocusable(false);
		           
		           //Csc Button
		           btnCsc = new JButton("csc");
		           btnCsc.setFont(ff3);
		           btnCsc.setFocusable(false);

		           //Cot Button
		           btnCot = new JButton("cot");
		           btnCot.setFont(ff3);
		           btnCot.setFocusable(false);
		           
		           //Random Button
		           btnRand = new JButton("rand");
		           btnRand.setFont(ff3);
		           btnRand.setFocusable(false);

		          // Floor Button
		           btnFloor = new JButton("⌊𝑥⌋");
		           btnFloor.setFont(ff3);
		           btnFloor.setFocusable(false);

		           // Ceil Button
		           btnCeil = new JButton("⌈𝑥⌉");
		           btnCeil.setFont(ff3);
		           btnCeil.setFocusable(false);
		           
		           //x2 Button  square
		           btnx2 = new JButton("𝑥\r\n²");
		           btnx2.setFont(ff3);
		           btnx2.setFocusable(false);

		           // 1/x Button Reciprocal
		           btn1x = new JButton("1\r\n"
		           + "/𝑥\r\n");
		           btn1x.setFont(ff3);
		           btn1x.setFocusable(false);
		           
		           //absolute btn
		           btnabs = new JButton("|𝑥|");
		           btnabs.setFont(ff3);
		           btnabs.setFocusable(false);
		           
		           // Exponential
		           btnExp = new JButton("exp");
		           btnExp.setFont(ff3);
		           btnExp.setFocusable(false);
		       
		           // % reminder
		           btnMod = new JButton("mod");
		           btnMod.setFont(ff3);
		           btnMod.setFocusable(false);
		            
		           // squareroot Button
		           btnSqrt = new JButton("2√"+"𝑥\r\n");
		           btnSqrt.setFont(ff3);
		           btnSqrt.setFocusable(false);
		           
		           // open bracket Button
		           btnOpenBracket = new JButton("(");
		           btnOpenBracket.setFont(ff3);
		           btnOpenBracket.setFocusable(false);
		           
		           // close bracket Button
		           btnCloseBracket = new JButton(")");
		           btnCloseBracket.setFont(ff3);
		           btnCloseBracket.setFocusable(false);
		           
		           // factorialButton
		           btnFact = new JButton("n!");
		           btnFact.setFont(ff3);
		           btnFact.setFocusable(false);
		           
		           //div /  Button
		           btnDiv = new JButton("÷");
		           btnDiv.setFont(ff3);
		           btnDiv.setFocusable(false);
		           
		           
		           // x power y Button
		           btnxy = new JButton("<html>𝑥<sup>𝑦</sup></html>");
		           btnxy.setFont(ff3);
		           btnxy.setFocusable(false);
		           
		           //seven
		           //eight
		           //nine
		           
		           //multi *  Button
		           btnMult = new JButton("X");
		           btnMult.setFont(ff3);
		           btnMult.setFocusable(false);
		           
		           //10 power x  Button
		           btn10x = new JButton("<html>10<sup>𝑥</sup></html>");
		           btn10x.setFont(ff3);
		           btn10x.setFocusable(false);
		           
		           //four
		           //five
		           //six
		           
		           //minus - Button
		           btnMinus = new JButton("-");
		           btnMinus.setFont(ff3);
		           btnMinus.setFocusable(false);
		           
		           
		           //log  logbase10  Button
		           btnLog = new JButton("log");
		           btnLog.setFont(ff3);
		           btnLog.setFocusable(false);
		           
		           //one
		           //two
		           //three
		           
		           // add + Button
		           btnPlus = new JButton("+");
		           btnPlus.setFont(ff3);
		           btnPlus.setFocusable(false);
		           
		           // ln  naturalLog btn
		           btnLn = new JButton("ln");
		           btnLn.setFont(ff3);
		           btnLn.setFocusable(false);
		           
		           // change the sign 
		           btnChangeSign = new JButton("+/-");
		           btnChangeSign.setFont(ff3);
		           btnChangeSign.setFocusable(false);
		            
		           // zero 0 btn
		           btnZero = new JButton("0");
		           btnZero.setFont(ff2);
		           btnZero.setFocusable(false);
		           
		           //Decimal Button
		           btnDec = new JButton(".");
		           btnDec.setFont(ff2);
		           btnDec.setFocusable(false);
		           
		           //Equal Button
		           btnEqual = new JButton("=");
		           btnEqual.setFont(ff2);
		           btnEqual.setFocusable(false);
		           
		           
		           /**
		            * adding scientific buttons to panel
		            */
		           
		           main.getPanel().add(btn2nd);
		           main.getPanel().add(btnpi);
		           main.getPanel().add(btnE);
		           main.getPanel().add(btnCE);
		           main.getPanel().add(btnDel);
		         
		           main.getPanel().add(btnhyp);
		           main.getPanel().add(btnSin);
		           main.getPanel().add(btnCos);
		           main.getPanel().add(btnTan);
		           main.getPanel().add(btnSec);
		           
		           main.getPanel().add(btnCsc);
		           main.getPanel().add(btnCot);
		           main.getPanel().add(btnRand);
		           main.getPanel().add(btnFloor);
		           main.getPanel().add(btnCeil);
		           
		           main.getPanel().add(btnx2);
		           main.getPanel().add(btn1x);
		           main.getPanel().add(btnabs);
		           main.getPanel().add(btnExp);
		           main.getPanel().add(btnMod);
		           
		           main.getPanel().add(btnSqrt);
		           main.getPanel().add(btnOpenBracket);
		           main.getPanel().add(btnCloseBracket);
		           main.getPanel().add(btnFact);
		           main.getPanel().add(btnDiv);
		           
		           main.getPanel().add(btnxy);
		           main.getPanel().add(numBtn[7]);
		           main.getPanel().add(numBtn[8]);
		           main.getPanel().add(numBtn[9]);
		           main.getPanel().add(btnMult);
		           
		           main.getPanel().add(btn10x);
		           main.getPanel().add(numBtn[4]);
		           main.getPanel().add(numBtn[5]);
		           main.getPanel().add(numBtn[6]);
		           main.getPanel().add(btnMinus);
		           
		           main.getPanel().add(btnLog);
		           main.getPanel().add(numBtn[1]);
		           main.getPanel().add(numBtn[2]);
		           main.getPanel().add(numBtn[3]);
		           main.getPanel().add(btnPlus);
		           
		           main.getPanel().add(btnLn);
		           main.getPanel().add(btnChangeSign);
		           main.getPanel().add(btnZero);
		           main.getPanel().add(btnDec);
		           main.getPanel().add(btnEqual);
		        
		           	
		           /**
		            * Action Listener 
		            * 
		            */
		           
		           btn2nd.addActionListener(e -> toggleSecondFunction(Themes.getCurrentTheme()) );
		           btnpi.addActionListener(e -> calc.PI());
		           btnE.addActionListener(e -> calc.Euler());
		           btnCE.addActionListener(e ->calc.checkForClearBtn() );
		           btnDel.addActionListener(e -> calc.deleteNum());
		           
		           btnhyp.addActionListener(e -> toggleHypFunction(Themes.getCurrentTheme()));
		           btnSin.addActionListener(e -> performTrigOperation(btnSin));
		           btnCos.addActionListener(e -> performTrigOperation(btnCos));
		           btnTan.addActionListener(e -> performTrigOperation(btnTan));
		           btnSec.addActionListener(e -> performTrigOperation(btnSec));
		           
		           
		           btnCsc.addActionListener(e -> performTrigOperation(btnCsc));
		           btnCot.addActionListener(e -> performTrigOperation(btnCot));
		           btnRand.addActionListener(e -> calc.Random());
		           btnFloor.addActionListener(e -> calc.Floor());
		           btnCeil.addActionListener(e -> calc.Ceil());
		           
		           
		           btnx2.addActionListener(e -> perform2ndOperation(btnx2));
		           btn1x.addActionListener(e -> calc.reciprocal1x());
		           btnabs.addActionListener(e -> calc.Abs());
		           btnExp.addActionListener(e -> calc.Exp());
		           btnMod.addActionListener(e -> calc.handleOperator(btnMod));
		           
		           
		           btnSqrt.addActionListener(e -> perform2ndOperation(btnSqrt));
		           btnOpenBracket.addActionListener(e -> calc.openBracket());
		           btnCloseBracket.addActionListener(e -> calc.closeBracket());
		           btnFact.addActionListener(e -> calc.factorial());
		           btnDiv.addActionListener(e -> calc.handleOperator(btnDiv));
		           
		           btnxy.addActionListener(e -> perform2ndOperation(btnxy));
		          //seven
		           //eight
		           //nine
		           btnMult.addActionListener(e -> calc.handleOperator(btnMult));
		           
		           
		           btn10x.addActionListener(e -> perform2ndOperation(btn10x));
			       //four
		           //five
			       //six
		           btnMinus.addActionListener(e -> calc.handleOperator(btnMinus));
		           
			       btnLog.addActionListener(e -> perform2ndOperation(btnLog));
		           //one
			       //two
		           //three
     	           btnPlus.addActionListener(e -> calc.handleOperator(btnPlus));
		           
     	           btnLn.addActionListener(e -> perform2ndOperation(btnLn));
     	           btnChangeSign.addActionListener(e -> calc.changeSign());
     	           btnZero.addActionListener(e -> calc.Zero());
     	           btnDec.addActionListener(e -> calc.Decimal());
		           btnEqual.addActionListener(e -> calc.Equal());
				           
		           
		         main.getPanel().revalidate();
		         main.getPanel().repaint();
		       //  main.getPanel().requestFocusInWindow();
		       	
		    }
		  
		  private synchronized void documentListener() {
			  main.screen.getDocument().addDocumentListener(new DocumentListener() {
		            @Override
		            public void insertUpdate(DocumentEvent e) {
		            	 checkAndUpdateClearButton();
		            }

		            @Override
		            public void removeUpdate(DocumentEvent e) {
		            	 checkAndUpdateClearButton();
		            }

		            @Override
		            public void changedUpdate(DocumentEvent e) {
		            	 checkAndUpdateClearButton();
		            }
		        });
		  }
		  
		// this is  to check and update the button text  
		private synchronized void checkAndUpdateClearButton() { 
			  String currentText = main.screen.getText().trim();
		        if (currentText.length() > 0) {
		            String[] parts = currentText.split(" ");
		            if (parts.length > 1) {
		               btnCE.setText("CE");
		            }else {
		            	btnCE.setText("AC");
		            }
		        }
			  }		
		

		// this is  to toggle "2nd" button functionality
		private synchronized void toggleSecondFunction(String theme) {
		    isSecondFunctionActive = !isSecondFunctionActive;

		    Color activeColor = "Dark".equalsIgnoreCase(theme) ? Color.RED : Color.GREEN; 
		    Color defaultBackground = "Dark".equalsIgnoreCase(theme) ? new Color(40, 40, 40) : new Color(240, 240, 240);
		    Color defaultForeground = "Dark".equalsIgnoreCase(theme) ? Color.GREEN : Color.BLUE;

		    if (isSecondFunctionActive) {
		        btn2nd.setBackground(activeColor);
		    } else {
		    	 btn2nd.setForeground(defaultForeground);
		        btn2nd.setBackground(defaultBackground);
		       
		    }

		    updateTrigFunctionLabels();
		}

		// this is  to toggle "Hyp" button functionality
		private synchronized void toggleHypFunction(String theme) {
		    isHypFunctionActive = !isHypFunctionActive;

		    Color activeColor = "Dark".equalsIgnoreCase(theme) ? Color.RED : Color.GREEN; 
		    Color defaultBackground = "Dark".equalsIgnoreCase(theme) ? new Color(40, 40, 40) : new Color(240, 240, 240);
		    Color defaultForeground = "Dark".equalsIgnoreCase(theme) ? Color.GREEN : Color.BLUE;

		    if (isHypFunctionActive) {
		        btnhyp.setBackground(activeColor);
		    } else {
		    	 btnhyp.setForeground(defaultForeground);
		        btnhyp.setBackground(defaultBackground);
		       
		    }

		    updateTrigFunctionLabels();
		}


		// this is  to update trigonometric function labels based on the active states
		private synchronized void updateTrigFunctionLabels() {
		    if (isSecondFunctionActive && isHypFunctionActive) {
		        btnSin.setText("sinh⁻¹");
		        btnCos.setText("cosh⁻¹");
		        btnTan.setText("tanh⁻¹");
		        btnSec.setText("sech⁻¹");
		        btnCsc.setText("csch⁻¹");
		        btnCot.setText("coth⁻¹");
		    } else if (isHypFunctionActive) {
		        btnSin.setText("sinh");
		        btnCos.setText("cosh");
		        btnTan.setText("tanh");
		        btnSec.setText("sech");
		        btnCsc.setText("csch");
		        btnCot.setText("coth");
		    } else if (isSecondFunctionActive) {
		        btnSin.setText("sin⁻¹");
		        btnCos.setText("cos⁻¹");
		        btnTan.setText("tan⁻¹");
		        btnSec.setText("sec⁻¹");
		        btnCsc.setText("csc⁻¹");
		        btnCot.setText("cot⁻¹");
		    } else {
		        btnSin.setText("sin");
		        btnCos.setText("cos");
		        btnTan.setText("tan");
		        btnSec.setText("sec");
		        btnCsc.setText("csc");
		        btnCot.setText("cot");
		    }

		    btnx2.setText(isSecondFunctionActive ? "𝑥\r\n³" : "𝑥\r\n²");
		    btnSqrt.setText(isSecondFunctionActive ? "3√"+"𝑥\r\n" : "2√"+"𝑥\r\n");
		    btnxy.setText(isSecondFunctionActive ? "𝑦√"+"𝑥\r\n" : "<html>𝑥<sup>𝑦</sup></html>");
		    btn10x.setText(isSecondFunctionActive ? "<html>2<sup>𝑥</sup></html>" : "<html>10<sup>𝑥</sup></html>");
		    btnLog.setText(isSecondFunctionActive ? "<html>log<sub>𝑦</sub>𝑥</html>" : "log");
		    btnLn.setText(isSecondFunctionActive ? "<html>e<sup>𝑥</sup></html>" : "ln");
		}

		private synchronized void performTrigOperation(JButton button) {
		    String label = button.getText();

		    try {
		        switch (label) {
		            case "sin":
		                calc.SIN();
		                break;
		            case "cos":
		                calc.COS();
		                break;
		            case "tan":
		                calc.TAN();
		                break;
		            case "sec":
		                calc.SEC();
		                break;
		            case "csc":
		                calc.CSC();
		                break;
		            case "cot":
		                calc.COT();
		                break;
		            case "sin⁻¹":
		                calc.SINInverse();
		                break;
		            case "cos⁻¹":
		                calc.COSInverse();
		                break;
		            case "tan⁻¹":
		                calc.TANInverse();
		                break;
		            case "sec⁻¹":
		                calc.SECInverse();
		                break;
		            case "csc⁻¹":
		                calc.CSCInverse();
		                break;
		            case "cot⁻¹":
		                calc.COTInverse();
		                break;
		            case "sinh":
		                calc.SINH();
		                break;
		            case "cosh":
		                calc.COSH();
		                break;
		            case "tanh":
		                calc.TANH();
		                break;
		            case "sech":
		                calc.SECH();
		                break;
		            case "csch":
		                calc.CSCH();
		                break;
		            case "coth":
		                calc.COTH();
		                break;
		            case "sinh⁻¹":
		                calc.SINHInverse();
		                break;
		            case "cosh⁻¹":
		                calc.COSHInverse();
		                break;
		            case "tanh⁻¹":
		                calc.TANHInverse();
		                break;
		            case "sech⁻¹":
		                calc.SECHInverse();
		                break;
		            case "csch⁻¹":
		                calc.CSCHInverse();
		                break;
		            case "coth⁻¹":
		                calc.COTHInverse();
		                break;
		        }
		    } catch (Exception ex) {
		        main.screen.setText("Error");
		    }
		}
		
		private synchronized void perform2ndOperation(JButton button) {
		    String label = button.getText().trim();

		    try {
		        switch (label) {
		            case "𝑥\r\n³":
		                calc.cubex3();
		                break;
		            case "𝑥\r\n²":
		                calc.squarex2();
		                break;
		            case "3√"+"𝑥":
		                calc.cubeRoot();
		                break;
		            case "2√"+"𝑥":
		                calc.squareRoot();
		                break;
		            case "𝑦√"+"𝑥":
		                calc.yRootX();
		                break;
		            case "<html>𝑥<sup>𝑦</sup></html>":
		                calc.xPowerY();
		                break;
		            case "<html>2<sup>𝑥</sup></html>":
		                calc.twoPowerX();
		                break;
		            case "<html>10<sup>𝑥</sup></html>":
		                calc.tenPowerX();
		                break;
		            case "<html>log<sub>𝑦</sub>𝑥</html>":
		                calc.logBaseY();
		                break;
		            case "log":
		                calc.logBase10();
		                break;
		            case "<html>e<sup>𝑥</sup></html>":
		                calc.ePowerX();
		                break;
		            case "ln":
		                calc.naturalLog();
		                break;
		            default:
		                main.screen.setText("Error");
		                break;
		        }
		    } catch (Exception ex) {
		        main.screen.setText("Error");
		    }
		}


		

		
		
}
