package com.calculator.standard;


import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.calculator.main.Main;

public class standardShortcuts {
	
	private Main main = new Main();
	private StandardButtons buttons = new StandardButtons();
	
	 /**
     *  This short cut is 
     *  for standard calculator
     */
    
	@SuppressWarnings({ "serial", "static-access" })  
	public synchronized void addStandardShortcutKeys() {
	
        InputMap inputMap = main.getFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = main.getFrame().getRootPane().getActionMap();

        for (int i = 0; i < 10; i++) {
            int index = i;
             
            // number 1 to 9
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_0 + index, 0), "number" + i);
            actionMap.put("number" + index, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	 buttons.numBtn[index].doClick();
                }
            });

            // Numpad numbers
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0 + i, 0), "numpadNumber" + i);
            actionMap.put("numpadNumber" + i, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	 buttons.numBtn[index].doClick();
                }
            });
        }

        
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
        
        // All Clear
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.SHIFT_DOWN_MASK), "clear");
        actionMap.put("clear", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 buttons.btnAC.doClick();
            }
        });

        // Delete
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "delete");
        actionMap.put("delete", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 buttons.btnDel.doClick();
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


        // Equals
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS,0), "equals");
        actionMap.put("equals", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 buttons.btnEqual.doClick();
            }
        });
        
     // Equals (Enter key)
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        actionMap.put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 buttons.btnEqual.doClick();
            }
        });
        
     // Reciprocal (R for 1/x)
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "RECIPROCAL");
        actionMap.put("RECIPROCAL", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 buttons.btnReci.doClick();
            }
        });

        // Square (Q for x^2)
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "SQUARE");
        actionMap.put("SQUARE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 buttons.btnSquare.doClick();
            }
        });

        // Square Root (Shift + 2 for √x)
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.SHIFT_DOWN_MASK), "SQUAREROOT");
        actionMap.put("SQUAREROOT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 buttons.btnSqrt.doClick();
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
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "minus");  
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
    
    
    public synchronized void clearStandardShortcutKeys() {
		 InputMap inputMap = main.getFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	        ActionMap actionMap = main.getFrame().getRootPane().getActionMap();

       inputMap.clear();
       actionMap.clear();
      // System.out.println("Standard shortcuts cleared");
   }
    
    }
	

