package com.calculator.main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.undo.UndoManager;

import com.calculator.scientific.ScientificButtons;
import com.calculator.scientific.scientificShortcuts;
import com.calculator.standard.StandardButtons;
import com.calculator.standard.standardShortcuts;
import com.calculator.themes.Settings;
import com.calculator.themes.Themes;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main{
    
	
	private static Main main = new Main();
	private static standardShortcuts standardShortcut;
	private static StandardButtons standardButtons;
	private static ScientificButtons scientificButtons;
	private static scientificShortcuts scientificShortcut;
	private static Settings settings;
	private static Themes theme;
	
	
	private static JFrame frame;
	
     public static JTextField screen, modeTextField;
    
     private static JButton   btnStandard,  btnScientific,  btnSettings, menuButton;
     
	 private static  Font ff1 = new Font("Ink.Free",Font.BOLD,35);
	 private static  Font ff3 = new Font("Monospaced", Font.PLAIN, 18);

     private static JPanel panel, sidePanel, topPanel, centerPanel;
     private static UndoManager undoManager = new UndoManager();
     
     // Load images 
    private static ImageIcon standardIcon = new ImageIcon(main.getClass().getResource("/com/calculator/assets/standard_icon.png"));
    private static ImageIcon scientificIcon = new ImageIcon(main.getClass().getResource("/com/calculator/assets/scientific_icon.png")); 
    private static ImageIcon settingsIcon = new ImageIcon(main.getClass().getResource("/com/calculator/assets/settings_icon.png"));
     
    private static String mainTheme;
    
  //Main method
	public static void main(String[] args){
    
    	 standardButtons = new StandardButtons();
    	 standardShortcut = new standardShortcuts();
    	
    	 scientificButtons = new ScientificButtons();
    	 scientificShortcut = new scientificShortcuts();
    	 
    	 settings = new Settings();
    	 theme = new Themes();
    
    	 theme.ensureAppDirectoryExists();
          mainTheme =  theme.loadThemePreference();
         theme.applyTheme(mainTheme);

         mainFrame();
      	 addingSelection();
      	 addingScreen();
       
      	 theme.setTheme(mainTheme);  
      	 }
    
    private static void  mainFrame() {
           frame = new JFrame();
    	   frame.setTitle("Elite Calculator");
    	   frame.setIconImage(new ImageIcon(main.getClass().getResource("/com/calculator/assets/Calculator.png")).getImage());
           frame.setSize(400,560);
           frame.setVisible(true);
           frame.setResizable(true);
           frame.getContentPane().setBackground(new Color(66, 63, 63));
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setLayout(new BorderLayout());     
           theme.applyWindowPosition(frame);
           frame.addWindowListener(new java.awt.event.WindowAdapter() {
               @Override
               public void windowClosing(java.awt.event.WindowEvent e) {
            	   theme.saveWindowSize(frame);
               }
           });
    }
    
    private static void addingSelection() {
    	  topPanel = new JPanel(new BorderLayout());
    	  menuButton = new JButton("\u2261"); // Unicode for ≡
          menuButton.setFont(new Font("Arial", Font.BOLD, 18));
          menuButton.setFocusable(false);
          menuButton.addActionListener(e -> toggleSidePanel());
          topPanel.add(menuButton, BorderLayout.WEST);
          
          modeTextField = new JTextField("Standard");
          modeTextField.setFont(ff3);
          modeTextField.setEditable(false); 
          modeTextField.setHorizontalAlignment(JTextField.CENTER);
          modeTextField.setFocusable(false);
          topPanel.add(modeTextField, BorderLayout.CENTER);

          frame.add(topPanel, BorderLayout.NORTH);
    }
    
    
    public static void toggleSidePanel() {
        if (sidePanel == null) {
            createSidePanel();
            theme.applyFontMain(mainTheme);
        }
        sidePanel.setVisible(!sidePanel.isVisible());
    }

    private static void createSidePanel() {
        sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1));

        btnStandard = new JButton("Standard",standardIcon);
        btnStandard.setFont(new Font("Arial", Font.PLAIN, 16));
        btnStandard.setFocusable(false);
        btnStandard.addActionListener(e -> switchToStandardMode());

        btnScientific = new JButton("Scientific",scientificIcon);
        btnScientific.setFont(new Font("Arial", Font.PLAIN, 16));
        btnScientific.setFocusable(false);
        btnScientific.addActionListener(e -> switchToScientificMode());
      
        btnSettings = new JButton("Settings",settingsIcon);
        btnSettings.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSettings.setFocusable(false);
        btnSettings.addActionListener(e -> switchToSettingsMode());
        
        sidePanel.add(btnStandard);
        sidePanel.add(btnScientific);
        sidePanel.add(btnSettings);
        frame.add(sidePanel, BorderLayout.WEST);
        sidePanel.setVisible(false);
    }
    
    
    private static void addingScreen() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(new Color(66, 63, 63));
        
        screen = new JTextField("");
        screen.setFont(ff1);
       // screen.setEditable(false);
        screen.setSize(20, 20);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setPreferredSize(new Dimension(340, 70));
     //   screen.setFocusable(false);
        
     // Add DocumentListener to adjust font size and capture text changes
        screen.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                adjustFontSize();
             
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                adjustFontSize();
               
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                adjustFontSize();
            }
        });
       
        screen.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
        
        screen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.consume(); 
            }
        });

        centerPanel.add(screen, BorderLayout.NORTH);
      
         panel = new JPanel(); 
          panel.setLayout(new GridLayout(6, 4)); 
        
          standardShortcut.clearStandardShortcutKeys();
   	     scientificShortcut.clearScientificShortcutKeys();
          standardButtons.addStandardButtons();
          standardShortcut.addStandardShortcutKeys();
          SwingUtilities.invokeLater(() -> theme.applyFontStandard(mainTheme));
      	
          centerPanel.add(panel, BorderLayout.CENTER);

          frame.add(centerPanel, BorderLayout.CENTER);
     
    }

    private static void adjustFontSize() {
        Font currentFont = screen.getFont();
        int fontSize = ff1.getSize(); 
        int textWidth = screen.getFontMetrics(currentFont).stringWidth(screen.getText());
        int maxWidth = screen.getPreferredSize().width;
       
        
        while (textWidth > maxWidth && fontSize > 15) {
            fontSize--;
            currentFont = currentFont.deriveFont((float) fontSize);
            textWidth = screen.getFontMetrics(currentFont).stringWidth(screen.getText());
           
        }
        if(screen.getText() == null || screen.getText().isEmpty()) currentFont = ff1;

        screen.setFont(currentFont);
    }
    
    @SuppressWarnings("static-access")
	private static void switchToStandardMode() {
    	frame.setSize(400, 560);
    	 standardShortcut.clearStandardShortcutKeys();
    	 scientificShortcut.clearScientificShortcutKeys();
    	panel.setLayout(new GridLayout(6, 4));
    	modeTextField.setText("Standard");
        standardButtons.addStandardButtons();
        standardShortcut.addStandardShortcutKeys();
        SwingUtilities.invokeLater(() ->theme.applyFontStandard(theme.getCurrentTheme()));
          sidePanel.setVisible(false);
          screen.setVisible(true);
    }
    
    @SuppressWarnings("static-access")
	private static void switchToScientificMode() {
    	 standardShortcut.clearStandardShortcutKeys();
    	    scientificShortcut.clearScientificShortcutKeys();
        modeTextField.setText("Scientific");
        scientificButtons.addScientificButtons();
        scientificShortcut.addScientificShortcutKeys();
        SwingUtilities.invokeLater(() ->theme.applyFontScientific(theme.getCurrentTheme()));
        sidePanel.setVisible(false);
        screen.setVisible(true);
    }
    
    private static void switchToSettingsMode() {
    	frame.setSize(400, 560);
    	 standardShortcut.clearStandardShortcutKeys();
 	    scientificShortcut.clearScientificShortcutKeys();
 	   modeTextField.setText("Settings");
 	   settings.addSettings();
 	  sidePanel.setVisible(false);
 	  screen.setVisible(false);
    }
    
    
   public JFrame getFrame() {
	   return frame;
   }
   
   public JPanel getPanel() {
	   return panel;
   }
   
   public JTextField getScreen() {
	   return screen;
   }
   
   public JButton getMenuButton() {
	 return menuButton;   
   }
   
   public JTextField getModeText() {
	   return modeTextField;
   }
   
   public JPanel getSidePanel() {
		 return sidePanel;   
	   }

   public JButton getStandardButton() {
		 return btnStandard;   
	   }
   public JButton getScientificButton() {
		 return btnScientific;   
	   }
   public JButton getSettingsButton() {
		 return btnSettings;   
	   }
   
   public JPanel getCenterPanel() {
	   return centerPanel;
   }
   
   
}