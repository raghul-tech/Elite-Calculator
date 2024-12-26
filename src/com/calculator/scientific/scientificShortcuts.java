package com.calculator.scientific;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.calculator.main.Main;

public class scientificShortcuts {

	private Main main = new Main();
	private ScientificButtons buttons = new ScientificButtons();
	private String storeBtn;
	
	/**
	 * this is a shortcut for 
	 * scientific calculator
	 */
	
	@SuppressWarnings({ "serial", "static-access" })
	public synchronized void addScientificShortcutKeys() {
		
		  InputMap inputMap = main.getFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	        ActionMap actionMap = main.getFrame().getRootPane().getActionMap();

	        // Numbers 1-9
	        for (int i = 1; i < 10; i++) {
	            int index = i;
	            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_0 + i, 0), "number" + i);
	            actionMap.put("number" + i, new AbstractAction() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	buttons.numBtn[index].doClick();
	                }
	            });
	            // For numpad 1-9 keys
	            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0 + i, 0), "numpadNumber" + i);
	            actionMap.put("numpadNumber" + i, new AbstractAction() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	buttons.numBtn[index].doClick();
	                }
	            });
	        }
	        
	     // pi p
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "pi");
	        actionMap.put("pi", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnpi.doClick();
	            }
	        });
	        
	        // e shift+e
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.SHIFT_DOWN_MASK), "E");
	        actionMap.put("E", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnE.doClick();
	            }
	        });
	        
	       
	        // All Clear and CE  shift + c
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.SHIFT_DOWN_MASK), "clear");
	        actionMap.put("clear", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnCE.doClick();
	            }
	        });

	        // Delete  backspace
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "delete");
	        actionMap.put("delete", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnDel.doClick();
	            }
	        });
	        
	      
	        
	     // Sin (S)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "SIN");
	        actionMap.put("SIN", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSin.getText();
	            	buttons.btnSin.setText("sin");
	                buttons.btnSin.doClick();
	                buttons.btnSin.setText(storeBtn);
	            }
	        });

	        // Sin-1 (Shift + S)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK), "SINInverse");
	        actionMap.put("SINInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSin.getText();
	            	buttons.btnSin.setText("sin⁻¹");
	                buttons.btnSin.doClick();
	                buttons.btnSin.setText(storeBtn);
	                
	            }
	        });

	        // Sinh (Ctrl + S)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "SINH");
	        actionMap.put("SINH", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSin.getText();
	            	buttons.btnSin.setText("sinh");
	                buttons.btnSin.doClick();
	                buttons.btnSin.setText(storeBtn);
	            }
	        });

	        // Sinh-1 (Ctrl + Shift + S)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK), "SINHInverse");
	        actionMap.put("SINHInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSin.getText();
	            	buttons.btnSin.setText("sinh⁻¹");
	                buttons.btnSin.doClick();
	                buttons.btnSin.setText(storeBtn);
	            }
	        });

	        // Tan (T)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), "TAN");
	        actionMap.put("TAN", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnTan.getText();
	            	buttons.btnTan.setText("tan");
	                buttons.btnTan.doClick();
	                buttons.btnTan.setText(storeBtn);
	            }
	        });

	        // Tan-1 (Shift + T)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.SHIFT_DOWN_MASK), "TANInverse");
	        actionMap.put("TANInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnTan.getText();
	            	buttons.btnTan.setText("tan⁻¹");
	                buttons.btnTan.doClick();
	                buttons.btnTan.setText(storeBtn);
	            }
	        });

	        // Tanh (Ctrl + T)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK), "TANH");
	        actionMap.put("TANH", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnTan.getText();
	            	buttons.btnTan.setText("tanh");
	                buttons.btnTan.doClick();
	                buttons.btnTan.setText(storeBtn);
	            }
	        });

	        // Tanh-1 (Ctrl + Shift + T)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK), "TANHInverse");
	        actionMap.put("TANHInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnTan.getText();
	            	buttons.btnTan.setText("tanh⁻¹");
	                buttons.btnTan.doClick();
	                buttons.btnTan.setText(storeBtn);
	            }
	        });

	        // Cos (O)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0), "COS");
	        actionMap.put("COS", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCos.getText();
	            	buttons.btnCos.setText("cos");
	                buttons.btnCos.doClick();
	                buttons.btnCos.setText(storeBtn);
	            }
	        });

	        // Cos-1 (Shift + O)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.SHIFT_DOWN_MASK), "COSInverse");
	        actionMap.put("COSInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCos.getText();
	            	buttons.btnCos.setText("cos⁻¹");
	                buttons.btnCos.doClick();
	                buttons.btnCos.setText(storeBtn);
	            }
	        });

	        // Cosh (Ctrl + O)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK), "COSH");
	        actionMap.put("COSH", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCos.getText();
	            	buttons.btnCos.setText("cosh");
	                buttons.btnCos.doClick();
	                buttons.btnCos.setText(storeBtn);
	            }
	        });

	        // Cosh-1 (Ctrl + Shift + O)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK), "COSHInverse");
	        actionMap.put("COSHInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCos.getText();
	            	buttons.btnCos.setText("cosh⁻¹");
	                buttons.btnCos.doClick();
	                buttons.btnCos.setText(storeBtn);
	            }
	        });

	        // Sec (U)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_U, 0), "SEC");
	        actionMap.put("SEC", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSec.getText();
	            	buttons.btnSec.setText("sec");
	                buttons.btnSec.doClick();
	                buttons.btnSec.setText(storeBtn);
	            }
	        });

	        // Sec-1 (Shift + U)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.SHIFT_DOWN_MASK), "SECInverse");
	        actionMap.put("SECInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSec.getText();
	            	buttons.btnSec.setText("sec⁻¹");
	                buttons.btnSec.doClick();
	                buttons.btnSec.setText(storeBtn);
	            }
	        });

	        // Sech (Ctrl + U)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK), "SECH");
	        actionMap.put("SECH", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSec.getText();
	            	buttons.btnSec.setText("sech");
	                buttons.btnSec.doClick();
	                buttons.btnSec.setText(storeBtn);
	            }
	        });

	        // Sech-1 (Ctrl + Shift + U)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK), "SECHInverse");
	        actionMap.put("SECHInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSec.getText();
	            	buttons.btnSec.setText("sech⁻¹");
	                buttons.btnSec.doClick();
	                buttons.btnSec.setText(storeBtn);
	            }
	        });

	        // Cot (J)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0), "COT");
	        actionMap.put("COT", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCot.getText();
	            	buttons.btnCot.setText("cot");
	                buttons.btnCot.doClick();
	                buttons.btnCot.setText(storeBtn);
	            }
	        });

	        // Cot-1 (Shift + J)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.SHIFT_DOWN_MASK), "COTInverse");
	        actionMap.put("COTInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCot.getText();
	            	buttons.btnCot.setText("cot⁻¹");
	                buttons.btnCot.doClick();
	                buttons.btnCot.setText(storeBtn);
	            }
	        });

	        // Coth (Ctrl + J)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK), "COTH");
	        actionMap.put("COTH", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCot.getText();
	            	buttons.btnCot.setText("coth");
	                buttons.btnCot.doClick();
	                buttons.btnCot.setText(storeBtn);
	            }
	        });

	        // Coth-1 (Ctrl + Shift + J)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK), "COTHInverse");
	        actionMap.put("COTHInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCot.getText();
	            	buttons.btnCot.setText("coth⁻¹");
	                buttons.btnCot.doClick();
	                buttons.btnCot.setText(storeBtn);
	            }
	        });

	        // Csc (I)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "CSC");
	        actionMap.put("CSC", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCsc.getText();
	            	buttons.btnCsc.setText("csc");
	                buttons.btnCsc.doClick();
	                buttons.btnCsc.setText(storeBtn);
	            }
	        });

	        // Csc-1 (Shift + I)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.SHIFT_DOWN_MASK), "CSCInverse");
	        actionMap.put("CSCInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCsc.getText();
	            	buttons.btnCsc.setText("csc⁻¹");
	                buttons.btnCsc.doClick();
	                buttons.btnCsc.setText(storeBtn);
	            }
	        });

	        // Csch (Ctrl + I)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK), "CSCH");
	        actionMap.put("CSCH", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCsc.getText();
	            	buttons.btnCsc.setText("csch");
	                buttons.btnCsc.doClick();
	                buttons.btnCsc.setText(storeBtn);
	            }
	        });

	        // Csch-1 (Ctrl + Shift + I)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK), "CSCHInverse");
	        actionMap.put("CSCHInverse", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnCsc.getText();
	            	buttons.btnCsc.setText("csch⁻¹");
	                buttons.btnCsc.doClick();
	                buttons.btnCsc.setText(storeBtn);
	            }
	        });
	        
	        // random shift+r
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK), "random");
	        actionMap.put("random", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            buttons.btnRand.doClick();
	            }
	        });
	        
	        
	        // Square (Q for x2)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "SQUARE");
	        actionMap.put("SQUARE", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnx2.getText();
	            	buttons.btnx2.setText("𝑥\r\n²");
	                buttons.btnx2.doClick();
	                buttons.btnx2.setText(storeBtn);
	            }
	        });
	        
	        // Square (shift+3 for x3)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.SHIFT_DOWN_MASK), "CUBE");
	        actionMap.put("CUBE", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnx2.getText();
	            	buttons.btnx2.setText( "𝑥\r\n³");
	                buttons.btnx2.doClick();
	                buttons.btnx2.setText(storeBtn);
	            }
	        });
	        
	       
	        // Reciprocal (R for 1/x)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "RECIPROCAL");
	        actionMap.put("RECIPROCAL", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btn1x.doClick();
	            }
	        });
	        
	        // EXP E
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "expE");
	        actionMap.put("expE", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnExp.doClick();
	            }
	        });
	        
	        // EXP X
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "expX");
	        actionMap.put("expX", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnExp.doClick();
	            }
	        });

	       

	        // Square Root (Shift + 2 for 2√x)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.SHIFT_DOWN_MASK), "SQUAREROOT");
	        actionMap.put("SQUAREROOT", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSqrt.getText();
	            	buttons.btnSqrt.setText("2√"+"𝑥\r\n");
	                buttons.btnSqrt.doClick();
	                buttons.btnSqrt.setText(storeBtn);
	            }
	        });
	        
	     // cube Root (b for 3√x)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_B,0), "CUBEROOT");
	        actionMap.put("CUBEROOT", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnSqrt.getText();
	            	buttons.btnSqrt.setText("3√"+"𝑥\r\n");
	                buttons.btnSqrt.doClick();
	                buttons.btnSqrt.setText(storeBtn);
	            }
	        });
	        
	       
	        
	     //  ( (shift + 9 for  ( ) open bracket
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_9,InputEvent.SHIFT_DOWN_MASK), "open bracket");
	        actionMap.put("open bracket", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnOpenBracket.doClick();
	            }
	        });
	        
	    //  ) (shift + 0 for  ) ) close bracket
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_0,InputEvent.SHIFT_DOWN_MASK), "close bracket");
	        actionMap.put("close bracket", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnCloseBracket.doClick();
	            }
	        });
	        
	    //  n! ( shift + 1 for n!) factorial
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_1,InputEvent.SHIFT_DOWN_MASK), "factorial");
	        actionMap.put("factorial", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnFact.doClick();
	            }
	        });
	        
	        // xy (y for xy)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y,0), "XY");
	        actionMap.put("XY", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnxy.getText();
	            	buttons.btnxy.setText("<html>𝑥<sup>𝑦</sup></html>");
	                buttons.btnxy.doClick();
	                buttons.btnxy.setText(storeBtn);
	            }
	        });
	        
	        // y√x  (ctrl + y for y√x)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y,InputEvent.CTRL_DOWN_MASK), "yrootx");
	        actionMap.put("yrootx", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnxy.getText();
	            	buttons.btnxy.setText("𝑦√"+"𝑥\r\n");
	                buttons.btnxy.doClick();
	                buttons.btnxy.setText(storeBtn);
	            }
	        }); 
	        
	        // 10x  (ctrl + g for 10x)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_DOWN_MASK), "10x");
	        actionMap.put("10x", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btn10x.getText();
	            	buttons.btn10x.setText("<html>10<sup>𝑥</sup></html>");
	                buttons.btn10x.doClick();
	                buttons.btn10x.setText(storeBtn);
	            }
	        }); 
	        
	        // 2x  ( g for 2x)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_G,0), "2x");
	        actionMap.put("2x", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btn10x.getText();
	            	buttons.btn10x.setText("<html>2<sup>𝑥</sup></html>");
	                buttons.btn10x.doClick();
	                buttons.btn10x.setText(storeBtn);
	            }
	        }); 
	        
	        
	        // log  ( l for log)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_L,0), "log");
	        actionMap.put("log", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnLog.getText();
	            	buttons.btnLog.setText("log");
	                buttons.btnLog.doClick();
	                buttons.btnLog.setText(storeBtn);
	            }
	        }); 
	        
	     // logyx  (shift + l for logyx)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.SHIFT_DOWN_MASK), "logxy");
	        actionMap.put("logxy", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnLog.getText();
	            	buttons.btnLog.setText("<html>log<sub>𝑦</sub>𝑥</html>");
	                buttons.btnLog.doClick();
	                buttons.btnLog.setText(storeBtn);
	            }
	        }); 
	        
	        // ln  ( n for ln)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_N,0), "ln");
	        actionMap.put("ln", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnLn.getText();
	            	buttons.btnLn.setText("ln");
	                buttons.btnLn.doClick();
	                buttons.btnLn.setText(storeBtn);
	            }
	        }); 
	        
	     // ex  (ctrl + n for ex)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK), "ex");
	        actionMap.put("ex", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	storeBtn = buttons.btnLn.getText();
	            	buttons.btnLn.setText("<html>e<sup>𝑥</sup></html>");
	                buttons.btnLn.doClick();
	                buttons.btnLn.setText(storeBtn);
	            }
	        }); 
	        
	        
	        //Zero
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), "zero");
	        actionMap.put("zero", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnZero.doClick();
	            }
	        });
	        
	        //zero in numpad
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "numpadzero");
	        actionMap.put("numpadzero", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnZero.doClick();
	            }
	        });
	        
	        // Decimal
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), "decimal");
	        actionMap.put("decimal", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnDec.doClick();
	            }
	        });
	        
	     // Decimal (numpad decimal key)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0), "numpadDecimal");
	        actionMap.put("numpadDecimal", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnDec.doClick();
	            }
	        });
	        
	        // Equals
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS,0), "equals");
	        actionMap.put("equals", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnEqual.doClick();
	            }
	        });
	        
	     // Equals (Enter key)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
	        actionMap.put("enter", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	buttons.btnEqual.doClick();
	            }
	        });
	        
	        // Numpad Enter
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "numpadEnter");
	        actionMap.put("numpadEnter", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnEqual.doClick();
	            }
	        });

	        
	     // side panel (alt + h)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.ALT_DOWN_MASK), "sidepanel");
	        actionMap.put("sidepanel", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	main.toggleSidePanel();
	            }
	        }); 
	        

	        // Addition  shift+=
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.SHIFT_DOWN_MASK), "plus");
	        actionMap.put("plus", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnPlus.doClick();
	            }
	        });
	        
	        // + numpad
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "plusNumpad"); 
	        actionMap.put("plusNumpad", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnPlus.doClick();
	            }
	        });

	        // Sub -
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "minus");  // Regular '-'
	        actionMap.put("minus", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnMinus.doClick();
	            }
	        });
	        
	        //sub numpad
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "minusNumpad");  
	        actionMap.put("minusNumpad", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnMinus.doClick();
	            }
	        });

	        // Multi shift+8
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.SHIFT_DOWN_MASK), "multShift");  
	        actionMap.put("multShift", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnMult.doClick();
	            }
	        });
	        
	        //multi numpad
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "multNumpad");  
	        actionMap.put("multNumpad", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnMult.doClick();
	            }
	        });

	        // divide /
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "div");  	
	        actionMap.put("div", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnDiv.doClick();
	            }
	        });
	        
	        // div numpad /
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "divNumpad");  	
	        actionMap.put("divNumpad", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnDiv.doClick();
	            }
	        });

	        // Modulus Shift+5 
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.SHIFT_DOWN_MASK), "mod");  	
	        actionMap.put("mod", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttons.btnMod.doClick();
	            }
	        });      
	        
	        // Exit (Alt + F4)
	        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK), "exit");
	        actionMap.put("exit", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	main.getFrame().dispose();
	                System.exit(0); 
	            }
	        });
	       
    }
	
	
	public synchronized void clearScientificShortcutKeys() {
		 InputMap inputMap = main.getFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	        ActionMap actionMap = main.getFrame().getRootPane().getActionMap();

        inputMap.clear();
        actionMap.clear();
       // System.out.println("Scientific shortcuts cleared");
    }
	
}
