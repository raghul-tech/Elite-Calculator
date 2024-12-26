package com.calculator.themes;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.calculator.main.Main;
import com.calculator.scientific.ScientificButtons;
import com.calculator.standard.StandardButtons;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class Themes {

	private static Main main = new Main();
	private static final String APP_DIR = System.getProperty("user.home") + File.separator + "Elite Calculator";
	private static final String CONFIG_FILE_THEME = APP_DIR  + File.separator + "theme_saved.properties";
	private static final String CONFIG_FILE_SIZE = APP_DIR +  File.separator + "window_position.properties";
	
	private static StandardButtons standard = new StandardButtons();
	private static ScientificButtons scientific = new ScientificButtons();
	
	Color darkMode = new Color(40,40,40);
	Color lightMode = new Color(200,200,200);
	private static String currentTheme;
	
	
	/***
	 * this is to change theme 
	 * @param theme
	 */
	
	
	@SuppressWarnings("static-access")
	public synchronized void setTheme(String theme) {
		this.currentTheme = theme;
		applyTheme(theme);
		applyFontMain(theme);
		applyFontStandard(theme);
		applyFontScientific(theme);
	}
	
	public synchronized static String getCurrentTheme() { 
		return currentTheme;
		}
	
	public synchronized void applyTheme(String theme) {
		if("Dark".equalsIgnoreCase(theme)) {
			 try {
				UIManager.setLookAndFeel(new FlatMacDarkLaf());
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} 
			 
		}else {
			 try {
				UIManager.setLookAndFeel(new FlatMacLightLaf());
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}		 
			 
		}
		
		saveThemePreference(theme);
       // currentTheme = theme;
         SwingUtilities.invokeLater(() -> {
             if (main.getFrame() != null) {
                  SwingUtilities.updateComponentTreeUI(main.getFrame());
                     }
         });
	}
	
	
	/***
	 * this font is for the sidePanel , sidePanelBtn,
	 * menubtn and modetextfield
	 * @param theme
	 */

	public synchronized void applyFontMain(String theme) {
	    if ("Dark".equalsIgnoreCase(theme)) {
	        // Applying dark theme colors
	        main.getMenuButton().setBackground(new Color(40, 40, 40));
	        main.getModeText().setForeground(Color.WHITE);

	        if (main.getStandardButton() != null) {
	            main.getSidePanel().setBackground(new Color(40, 40, 40));
	            main.getStandardButton().setBackground(new Color(40, 40, 40));
	            main.getStandardButton().setForeground(Color.WHITE);
	            main.getScientificButton().setBackground(new Color(40, 40, 40));
	            main.getScientificButton().setForeground(Color.WHITE);
	            main.getSettingsButton().setBackground(new Color(40, 40, 40));
	            main.getSettingsButton().setForeground(Color.WHITE);
	        }
	    } else {
	        // Applying light theme colors
	        main.getMenuButton().setBackground(new Color(245, 245, 245));
	        main.getModeText().setForeground(Color.BLACK);

	        if (main.getStandardButton() != null) {
	            main.getSidePanel().setBackground(new Color(245, 245, 245));
	            main.getStandardButton().setBackground(new Color(245, 245, 245));
	            main.getStandardButton().setForeground(Color.BLACK);
	            main.getScientificButton().setBackground(new Color(245, 245, 245));
	            main.getScientificButton().setForeground(Color.BLACK);
	            main.getSettingsButton().setBackground(new Color(245, 245, 245));
	            main.getSettingsButton().setForeground(Color.BLACK);
	        }
	    }
	    SwingUtilities.invokeLater(() -> {
            if (main.getFrame() != null) {
                 SwingUtilities.updateComponentTreeUI(main.getFrame());
                    }
        });
	}

	
	/***
	 * this font is for standard calculator
	 * @param theme
	 */
	
	@SuppressWarnings("static-access")
	public synchronized void applyFontStandard(String theme) {
	    if ("Dark".equalsIgnoreCase(theme)) {
	        if (standard.btnAC != null) {
	            for (int i = 1; i < 10; i++) {
	                standard.numBtn[i].setBackground(new Color(40, 40, 40));
	                standard.numBtn[i].setForeground(Color.WHITE);
	            }
	            standard.btnPlus.setBackground(new Color(40, 40, 40));
	            standard.btnPlus.setForeground(Color.GREEN);
	            standard.btnMinus.setBackground(new Color(40, 40, 40));
	            standard.btnMinus.setForeground(Color.GREEN);
	            standard.btnMult.setBackground(new Color(40, 40, 40));
	            standard.btnMult.setForeground(Color.GREEN);
	            standard.btnDiv.setBackground(new Color(40, 40, 40));
	            standard.btnDiv.setForeground(Color.GREEN);
	            standard.btnMod.setBackground(new Color(40, 40, 40));
	            standard.btnMod.setForeground(Color.GREEN);
	            standard.btnZero.setBackground(new Color(40, 40, 40));
	            standard.btnZero.setForeground(Color.WHITE);
	            standard.btnEqual.setForeground(Color.WHITE);
	            standard.btnDec.setBackground(new Color(40, 40, 40));
	            standard.btnDec.setForeground(Color.GREEN);
	            standard.btnAC.setBackground(new Color(40, 40, 40));
	            standard.btnAC.setForeground(Color.GREEN);
	            standard.btnSqrt.setBackground(new Color(40, 40, 40));
	            standard.btnSqrt.setForeground(Color.GREEN);
	            standard.btnDel.setBackground(new Color(40, 40, 40));
	            standard.btnDel.setForeground(Color.GREEN);
	            standard.btnCE.setBackground(new Color(40, 40, 40));
	            standard.btnCE.setForeground(Color.GREEN);
	            standard.btnReci.setBackground(new Color(40, 40, 40));
	            standard.btnReci.setForeground(Color.GREEN);
	            standard.btnSquare.setBackground(new Color(40, 40, 40));
	            standard.btnSquare.setForeground(Color.GREEN);
	            standard.btnChangeSign.setBackground(new Color(40, 40, 40));
	            standard.btnChangeSign.setForeground(Color.GREEN);
	        }
	    } else{
	        if (standard.btnAC != null) {
	            for (int i = 1; i < 10; i++) {
	                standard.numBtn[i].setBackground(new Color(240, 240, 240)); 
	                standard.numBtn[i].setForeground(Color.BLACK);
	            }
	            standard.btnPlus.setBackground(new Color(240, 240, 240)); 
	            standard.btnPlus.setForeground(Color.BLUE);
	            standard.btnMinus.setBackground(new Color(240, 240, 240));
	            standard.btnMinus.setForeground(Color.BLUE);
	            standard.btnMult.setBackground(new Color(240, 240, 240)); 
	            standard.btnMult.setForeground(Color.BLUE);
	            standard.btnDiv.setBackground(new Color(240, 240, 240)); 
	            standard.btnDiv.setForeground(Color.BLUE);
	            standard.btnMod.setBackground(new Color(240, 240, 240)); 
	            standard.btnMod.setForeground(Color.BLUE);
	            standard.btnZero.setBackground(new Color(240, 240, 240)); 
	            standard.btnZero.setForeground(Color.BLACK);
	            standard.btnEqual.setBackground(new Color(220, 220, 220));
	            standard.btnEqual.setForeground(Color.BLACK);
	            standard.btnDec.setBackground(new Color(240, 240, 240)); 
	            standard.btnDec.setForeground(Color.BLUE);
	            standard.btnAC.setBackground(new Color(240, 240, 240)); 
	            standard.btnAC.setForeground(Color.RED);
	            standard.btnSqrt.setBackground(new Color(240, 240, 240)); 
	            standard.btnSqrt.setForeground(Color.BLUE);
	            standard.btnDel.setBackground(new Color(240, 240, 240)); 
	            standard.btnDel.setForeground(Color.RED);
	            standard.btnCE.setBackground(new Color(240, 240, 240));
	            standard.btnCE.setForeground(Color.BLUE);
	            standard.btnReci.setBackground(new Color(240, 240, 240)); 
	            standard.btnReci.setForeground(Color.BLUE);
	            standard.btnSquare.setBackground(new Color(240, 240, 240)); 
	            standard.btnSquare.setForeground(Color.BLUE);
	            standard.btnChangeSign.setBackground(new Color(240, 240, 240)); 
	            standard.btnChangeSign.setForeground(Color.BLUE);
	        }
	    }
	    SwingUtilities.invokeLater(() -> {
            if (main.getFrame() != null) {
                 SwingUtilities.updateComponentTreeUI(main.getFrame());
                    }
        });
	}

	
	/***
	 * this is for scientific calculator
	 * @param theme
	 */
	
	@SuppressWarnings("static-access")
	public synchronized void applyFontScientific(String theme) {
		 if ("Dark".equalsIgnoreCase(theme)) {
			 if(scientific.btnCE != null) {
				 for(int i = 1;i<10;i++) {
				 scientific.numBtn[i].setBackground(new Color(40,40,40));
				 scientific.numBtn[i].setForeground(Color.WHITE);
				 }
				 scientific.btn2nd.setBackground(new Color(40,40,40));
		         scientific.btn2nd.setForeground(Color.GREEN);
		         scientific.btnpi.setBackground(new Color(40,40,40));
		         scientific.btnpi.setForeground(Color.GREEN);
		         scientific.btnE.setBackground(new Color(40,40,40));
		         scientific.btnE.setForeground(Color.GREEN);
		         scientific.btnCE.setBackground(new Color(40,40,40));
		         scientific.btnCE.setForeground(Color.GREEN);
		         scientific.btnDel.setBackground(new Color(40,40,40));
		         scientific.btnDel.setForeground(Color.GREEN);
		         scientific.btnhyp.setBackground(new Color(40,40,40));
		         scientific.btnhyp.setForeground(Color.GREEN);
		         scientific.btnSin.setBackground(new Color(40,40,40));
		         scientific.btnSin.setForeground(Color.GREEN);
		         scientific.btnCos.setBackground(new Color(40,40,40));
		         scientific.btnCos.setForeground(Color.GREEN);
		         scientific.btnTan.setBackground(new Color(40,40,40));
		         scientific.btnTan.setForeground(Color.GREEN);
		         scientific.btnSec.setBackground(new Color(40,40,40));
		         scientific.btnSec.setForeground(Color.GREEN);
		         scientific.btnCsc.setBackground(new Color(40,40,40));
		         scientific.btnCsc.setForeground(Color.GREEN);
		         scientific.btnCot.setBackground(new Color(40,40,40));
		         scientific.btnCot.setForeground(Color.GREEN);
		         scientific.btnRand.setBackground(new Color(40,40,40));
		         scientific.btnRand.setForeground(Color.GREEN);
		         scientific.btnFloor.setBackground(new Color(40, 40, 40));
		         scientific.btnFloor.setForeground(Color.GREEN);
		         scientific.btnCeil.setBackground(new Color(40, 40, 40));
		         scientific.btnCeil.setForeground(Color.GREEN);
		         scientific.btnx2.setBackground(new Color(40,40,40));
		         scientific.btnx2.setForeground(Color.GREEN);
		         scientific.btn1x.setBackground(new Color(40,40,40));
		         scientific.btn1x.setForeground(Color.GREEN);
		         scientific.btnabs.setBackground(new Color(40,40,40));
		         scientific.btnabs.setForeground(Color.GREEN);
		         scientific.btnExp.setBackground(new Color(40,40,40));
		         scientific.btnExp.setForeground(Color.GREEN);
		         scientific.btnMod.setBackground(new Color(40,40,40));
		         scientific.btnMod.setForeground(Color.GREEN);
		         scientific.btnSqrt.setBackground(new Color(40,40,40));
		         scientific.btnSqrt.setForeground(Color.GREEN);
		         scientific.btnOpenBracket.setBackground(new Color(40,40,40));
		         scientific.btnOpenBracket.setForeground(Color.GREEN);
		         scientific.btnCloseBracket.setBackground(new Color(40,40,40));
		         scientific.btnCloseBracket.setForeground(Color.GREEN);
		         scientific.btnFact.setBackground(new Color(40,40,40));
		         scientific.btnFact.setForeground(Color.GREEN);
		         scientific.btnDiv.setBackground(new Color(40,40,40));
		         scientific.btnDiv.setForeground(Color.GREEN);
		         scientific.btnxy.setBackground(new Color(40,40,40));
		         scientific.btnxy.setForeground(Color.GREEN);
		         scientific.btnMult.setBackground(new Color(40,40,40));
		         scientific.btnMult.setForeground(Color.GREEN);
		         scientific.btn10x.setBackground(new Color(40,40,40));
		         scientific.btn10x.setForeground(Color.GREEN);
		         scientific.btnMinus.setBackground(new Color(40,40,40));
		         scientific.btnMinus.setForeground(Color.GREEN);
		         scientific.btnLog.setBackground(new Color(40,40,40));
		         scientific.btnLog.setForeground(Color.GREEN);
		         scientific.btnPlus.setBackground(new Color(40,40,40));
		         scientific.btnPlus.setForeground(Color.GREEN);
		         scientific.btnLn.setBackground(new Color(40,40,40));
		         scientific.btnLn.setForeground(Color.GREEN);
		         scientific.btnChangeSign.setBackground(new Color(40,40,40));
		         scientific.btnChangeSign.setForeground(Color.GREEN);
		         scientific.btnZero.setBackground(new Color(40,40,40));
		         scientific.btnZero.setForeground(Color.WHITE);
		         scientific.btnDec.setBackground(new Color(40,40,40));
		         scientific.btnDec.setForeground(Color.GREEN);
		         scientific.btnEqual.setForeground(Color.WHITE);
		           
			 }
	}else {
		        if (scientific.btnCE != null) {
		            for (int i = 1; i < 10; i++) {
		                scientific.numBtn[i].setBackground(new Color(240, 240, 240)); 
		                scientific.numBtn[i].setForeground(Color.BLACK);
		            }
		            scientific.btn2nd.setBackground(new Color(240, 240, 240));
		            scientific.btn2nd.setForeground(Color.BLUE);
		            scientific.btnpi.setBackground(new Color(240, 240, 240));
		            scientific.btnpi.setForeground(Color.BLUE);
		            scientific.btnE.setBackground(new Color(240, 240, 240));
		            scientific.btnE.setForeground(Color.BLUE);
		            scientific.btnCE.setBackground(new Color(240, 240, 240));
		            scientific.btnCE.setForeground(Color.RED);
		            scientific.btnDel.setBackground(new Color(240, 240, 240));
		            scientific.btnDel.setForeground(Color.RED);
		            scientific.btnhyp.setBackground(new Color(240, 240, 240));
		            scientific.btnhyp.setForeground(Color.BLUE);
		            scientific.btnSin.setBackground(new Color(240, 240, 240));
		            scientific.btnSin.setForeground(Color.BLUE);
		            scientific.btnCos.setBackground(new Color(240, 240, 240));
		            scientific.btnCos.setForeground(Color.BLUE);
		            scientific.btnTan.setBackground(new Color(240, 240, 240));
		            scientific.btnTan.setForeground(Color.BLUE);
		            scientific.btnSec.setBackground(new Color(240, 240, 240));
		            scientific.btnSec.setForeground(Color.BLUE);
		            scientific.btnCsc.setBackground(new Color(240, 240, 240));
		            scientific.btnCsc.setForeground(Color.BLUE);
		            scientific.btnCot.setBackground(new Color(240, 240, 240));
		            scientific.btnCot.setForeground(Color.BLUE);
		            scientific.btnRand.setBackground(new Color(240, 240, 240));
		            scientific.btnRand.setForeground(Color.BLUE);
		            scientific.btnFloor.setBackground(new Color(240, 240, 240));
		            scientific.btnFloor.setForeground(Color.BLUE);
		            scientific.btnCeil.setBackground(new Color(240, 240, 240));
		            scientific.btnCeil.setForeground(Color.BLUE);
		            scientific.btnx2.setBackground(new Color(240, 240, 240));
		            scientific.btnx2.setForeground(Color.BLUE);
		            scientific.btn1x.setBackground(new Color(240, 240, 240));
		            scientific.btn1x.setForeground(Color.BLUE);
		            scientific.btnabs.setBackground(new Color(240, 240, 240));
		            scientific.btnabs.setForeground(Color.BLUE);
		            scientific.btnExp.setBackground(new Color(240, 240, 240));
		            scientific.btnExp.setForeground(Color.BLUE);
		            scientific.btnMod.setBackground(new Color(240, 240, 240));
		            scientific.btnMod.setForeground(Color.BLUE);
		            scientific.btnSqrt.setBackground(new Color(240, 240, 240));
		            scientific.btnSqrt.setForeground(Color.BLUE);
		            scientific.btnOpenBracket.setBackground(new Color(240, 240, 240));
		            scientific.btnOpenBracket.setForeground(Color.BLUE);
		            scientific.btnCloseBracket.setBackground(new Color(240, 240, 240));
		            scientific.btnCloseBracket.setForeground(Color.BLUE);
		            scientific.btnFact.setBackground(new Color(240, 240, 240));
		            scientific.btnFact.setForeground(Color.BLUE);
		            scientific.btnDiv.setBackground(new Color(240, 240, 240));
		            scientific.btnDiv.setForeground(Color.BLUE);
		            scientific.btnxy.setBackground(new Color(240, 240, 240));
		            scientific.btnxy.setForeground(Color.BLUE);
		            scientific.btnMult.setBackground(new Color(240, 240, 240));
		            scientific.btnMult.setForeground(Color.BLUE);
		            scientific.btn10x.setBackground(new Color(240, 240, 240));
		            scientific.btn10x.setForeground(Color.BLUE);
		            scientific.btnMinus.setBackground(new Color(240, 240, 240));
		            scientific.btnMinus.setForeground(Color.BLUE);
		            scientific.btnLog.setBackground(new Color(240, 240, 240));
		            scientific.btnLog.setForeground(Color.BLUE);
		            scientific.btnPlus.setBackground(new Color(240, 240, 240));
		            scientific.btnPlus.setForeground(Color.BLUE);
		            scientific.btnLn.setBackground(new Color(240, 240, 240));
		            scientific.btnLn.setForeground(Color.BLUE);
		            scientific.btnChangeSign.setBackground(new Color(240, 240, 240));
		            scientific.btnChangeSign.setForeground(Color.BLUE);
		            scientific.btnZero.setBackground(new Color(240, 240, 240));
		            scientific.btnZero.setForeground(Color.BLACK);
		            scientific.btnDec.setBackground(new Color(240, 240, 240));
		            scientific.btnDec.setForeground(Color.BLUE);
		            scientific.btnEqual.setBackground(new Color(220, 220, 220));
		            scientific.btnEqual.setForeground(Color.BLACK);
		        }
		    }  
		 SwingUtilities.invokeLater(() -> {
	             if (main.getFrame() != null) {
	                  SwingUtilities.updateComponentTreeUI(main.getFrame());
	                     }
	         });
		}
	
	 public void ensureAppDirectoryExists() {
	        File appDir = new File(APP_DIR);
	        if (!appDir.exists()) {
	            appDir.mkdirs();
	        }
	    }

	 
	 private synchronized void saveThemePreference(String theme) {
	        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE_THEME)) {
	            Properties prop = new Properties();
	            prop.setProperty("theme", theme);
	            prop.store(output, "Elite Calculator Theme Configuration");
	        } catch (IOException e) {
	           // e.printStackTrace();
	        	JOptionPane.showMessageDialog(main.getFrame(), "An error occurred while saving your theme preference.\n Please try again.", "Theme not saved", JOptionPane.INFORMATION_MESSAGE);
	        }
	    }

	    public synchronized  String loadThemePreference() {
	        Properties prop = new Properties();
	        File configFile = new File(CONFIG_FILE_THEME);
	        if (configFile.exists()) {
	            try (FileInputStream input = new FileInputStream(CONFIG_FILE_THEME)) {
	                prop.load(input);
	                return prop.getProperty("theme", "Dark");
	            } catch (IOException e) {
	               // e.printStackTrace();
	                return "Dark";
	            }
	        } else {
	            return "Dark";
	        }
	    }
	    
	    /**
	     * this is to save the location of
	     *  the last exit happen and reopen in the same place
	     * @return
	     */
	    private static Point loadWindowPosition() {
	        Properties properties = new Properties();
	     
	        File configFile = new File(CONFIG_FILE_SIZE);
	        if (!configFile.exists()) {
	        	return null;
	        }
	        
	        try (FileInputStream input = new FileInputStream(CONFIG_FILE_SIZE)) {
	            properties.load(input);
	            int x = Integer.parseInt(properties.getProperty("window_x", "100")); // Default X position
	            int y = Integer.parseInt(properties.getProperty("window_y", "100")); // Default Y position
	            return new Point(x, y);
	        } catch (IOException | NumberFormatException e) {
	            return null;
	        }
	    }

	    public void saveWindowSize(JFrame frame) {
	        Properties properties = new Properties();
	        File configFile = new File(CONFIG_FILE_SIZE);
	        if (!configFile.exists()) {
	            try {
	                configFile.createNewFile();
	            } catch (IOException e) {
	              //  e.printStackTrace();
	            }
	        }
	        Point location = main.getFrame().getLocation();
	       
	        properties.setProperty("window_x", String.valueOf(location.x));
	        properties.setProperty("window_y", String.valueOf(location.y));
	       
	        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE_SIZE)) {
	            properties.store(output, " Elite Calculator Window Position Configuration");
	        } catch (IOException e) {
	           // e.printStackTrace();
	        }
	    }
	    
	    public void applyWindowPosition(JFrame frame) {
	        Point savedLocation = loadWindowPosition();
	        if (savedLocation != null) {
	            frame.setLocation(savedLocation);
	        } else {
	            frame.setLocationRelativeTo(null);
	        }
	    }
	
	
}

