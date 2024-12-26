package com.calculator.standard;


import java.awt.Font;

import javax.swing.JButton;

import com.calculator.main.Main;

public class StandardButtons {

	private Main main = new Main();
	private standardCalculator calc = new standardCalculator();
	
/**
 * Standard buttons
 */
	  public static JButton numBtn[] = new JButton[10];
	  public  static JButton btnMod,btnCE,btnAC,btnDel,
	  					   	 btnReci,btnSqrt,btnSquare,btnDiv,
	  						 btnMult,btnMinus,btnPlus,
	  						 btnChangeSign,btnZero,btnDec,btnEqual;
	  						 

	  private  Font ff2 = new Font("Ink.Free",Font.BOLD,20);
	  private  Font ff3 = new Font("Monospaced", Font.PLAIN, 18);

	    
	    /**
	     * standard buttons panel
	     */
	
	 public synchronized void addStandardButtons() {
    	main.getPanel().removeAll();
    	 
       // btn for 1 to 9
        for(int i = 1;i<10;i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            main.getPanel().add(numBtn[i]);
            numBtn[i].setFont(ff2);
            numBtn[i].setFocusable(false);
            int finalI = i; 
            numBtn[i].addActionListener(e -> calc.Button(finalI));
        }
    	
          //Plus Button
          btnPlus = new JButton("+");
          btnPlus.setFont(ff2);
          btnPlus.setFocusable(false);

          //Minus Button
          btnMinus = new JButton("-");
          btnMinus.setFont(ff2);
          btnMinus.setFocusable(false);

          //Multiply Button
          btnMult = new JButton("x");
          btnMult.setFont(ff2);
          btnMult.setFocusable(false);

          //Division Button
          btnDiv = new JButton("÷");
          btnDiv.setFont(ff2);
          btnDiv.setFocusable(false);

          //Remainder Button
          btnMod = new JButton("%");
          btnMod.setFont(ff2);
          btnMod.setFocusable(false);

          //Zero Button
          btnZero = new JButton("0");
          btnZero.setFont(ff2);
          btnZero.setFocusable(false);

          //Equal Button
          btnEqual = new JButton("=");
          btnEqual.setFont(ff2);
          btnEqual.setFocusable(false);
          
          //Decimal Button
          btnDec = new JButton(".");
          btnDec.setFont(ff2);
          btnDec.setFocusable(false);

          //All Clear(AC) Button
          btnAC = new JButton("AC");
          btnAC.setFont(ff2);
          btnAC.setFocusable(false);

          //root Button
          btnSqrt = new JButton("2√"+"𝑥\r\n");
          btnSqrt.setFont(ff3);
          btnSqrt.setFocusable(false);

       // back Button
          btnDel = new JButton("<html><big>&larr;</big></html>");
          btnDel.setFont(ff2);
          btnDel.setFocusable(false);


          // clear entry
          btnCE = new JButton("CE"); // only clear the last one 
          btnCE.setFont(ff2);
          btnCE.setFocusable(false);

       // Reciprocal 
          btnReci = new JButton("1\r\n"
          		+ "/𝑥\r\n");
          btnReci.setFont(ff3);
          btnReci.setFocusable(false);


         // square
          btnSquare = new JButton("𝑥\r\n²");    
          btnSquare.setFont(ff3);
          btnSquare.setFocusable(false);
          
          // change the sign 
          btnChangeSign = new JButton("+/-");
          btnChangeSign.setFont(ff3);
          btnChangeSign.setFocusable(false);
          
          
          /**
           * adding Buttons 
           */
          main.getPanel().add(btnMod);
          main.getPanel().add(btnCE);
          main.getPanel().add(btnAC);
          main.getPanel().add(btnDel);
          
          main.getPanel().add(btnReci);
          main.getPanel().add(btnSquare);
          main.getPanel().add(btnSqrt);
          main.getPanel().add(btnDiv);
          
          main.getPanel().add(numBtn[7]);
          main.getPanel().add(numBtn[8]);
          main.getPanel().add(numBtn[9]);
          main.getPanel().add(btnMult);
          
          main.getPanel().add(numBtn[4]);
          main.getPanel().add(numBtn[5]);
          main.getPanel().add(numBtn[6]);
          main.getPanel().add(btnMinus);
          
          main.getPanel().add(numBtn[1]);
          main.getPanel().add(numBtn[2]);
          main.getPanel().add(numBtn[3]);
          main.getPanel().add(btnPlus);

          main.getPanel().add(btnChangeSign);
          main.getPanel().add(btnZero);
          main.getPanel().add(btnDec);
          main.getPanel().add(btnEqual);
          
          /**
           * Adding methods to the button to work 
           */
          
          btnMod.addActionListener(e -> calc.handleOperator(btnMod));
          btnCE.addActionListener(e -> calc.clearEntry());
          btnAC.addActionListener(e -> calc.allClear());
          btnDel.addActionListener(e -> calc.deleteNum());
          
          btnReci.addActionListener(e -> calc.reciprocal());
          btnSquare.addActionListener(e -> calc.square());
          btnSqrt.addActionListener(e -> calc.squareRoot());
          btnDiv.addActionListener(e -> calc.handleOperator(btnDiv));
          
          btnMult.addActionListener(e -> calc.handleOperator(btnMult));
          
          btnMinus.addActionListener(e -> calc.handleOperator(btnMinus));
          
          btnPlus.addActionListener(e -> calc.handleOperator(btnPlus));
          
          btnChangeSign.addActionListener(e -> calc.changeSign());
          btnZero.addActionListener(e -> calc.Zero());
          btnDec.addActionListener(e -> calc.Decimal());
          btnEqual.addActionListener(e -> calc.Equals());
          
          
          main.getPanel().revalidate();
          main.getPanel().repaint();
          //main.getPanel().requestFocusInWindow();
          
    }
	 
	
}
