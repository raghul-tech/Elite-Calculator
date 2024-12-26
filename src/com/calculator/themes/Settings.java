package com.calculator.themes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.calculator.main.Main;

public class Settings {

	private static Main main = new Main();
	private static Themes theme = new Themes();

	@SuppressWarnings("static-access")
	public synchronized void addSettings() {
	    main.getPanel().removeAll();
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	    JPanel appearancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JLabel appearanceLabel = new JLabel("Appearance");
	    appearanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
	    JComboBox<String> themeDropdown = new JComboBox<>(new String[]{"Dark", "Light"});
	    
	    String initialTheme = theme.getCurrentTheme();
	    themeDropdown.setSelectedItem(initialTheme);
	
	    themeDropdown.addActionListener(e -> {
	        String selectedTheme = (String) themeDropdown.getSelectedItem();
	        theme.setTheme(selectedTheme);
	    });
	    appearancePanel.add(appearanceLabel);
	    appearancePanel.add(themeDropdown);

	    // About Section
	    JPanel aboutPanel = new JPanel(new BorderLayout());
	    JLabel aboutLabel = new JLabel("About", SwingConstants.CENTER);
	    aboutLabel.setFont(new Font("Arial", Font.BOLD, 16));
	    JTextArea aboutText = new JTextArea("Elite Calculator\nVersion: 1.0.0\nAuthor: Raghul-tech");
	    aboutText.setEditable(false);
	    aboutText.setBackground(main.getFrame().getBackground());
	    aboutText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    JLabel privacyPolicy = new JLabel("<html><a href =''>📜 Privacy Policy</a></html>" );  
	   // privacyPolicy.setForeground(Color.BLUE);
        privacyPolicy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        privacyPolicy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/raghul-tech/Elite-Calculator/blob/main/privacy-policy.md"));
                } catch (Exception ex) {
                	 
                    JTextArea errorMessage = new JTextArea("Unable to open Privacy Policy Link.\nPlease visit: https://github.com/raghul-tech/Elite-Calculator");
                    errorMessage.setEditable(false);
                    errorMessage.setBackground(main.getFrame().getBackground()); 
                    errorMessage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    JOptionPane.showMessageDialog(
                            main.getFrame(),
                            new JScrollPane(errorMessage),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        
	    aboutPanel.add(aboutLabel, BorderLayout.NORTH);
	    aboutPanel.add(aboutText, BorderLayout.WEST);
	    aboutPanel.add(privacyPolicy,BorderLayout.SOUTH);

	    // License Section
	    JPanel licensePanel = new JPanel(new BorderLayout());
	    JLabel licenseLabel = new JLabel("License", SwingConstants.CENTER);
	    licenseLabel.setFont(new Font("Arial", Font.BOLD, 16));
	    JTextArea licenseText = new JTextArea("This application is licensed under MIT License.");
	    licenseText.setEditable(false);
	    licenseText.setBackground(main.getFrame().getBackground());
	    licenseText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	    JLabel license = new JLabel("<html><a href =''>📜 LICENSE</a></html>");
	   // license.setForeground(Color.BLUE);
        license.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        license.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/raghul-tech/Elite-Calculator/blob/main/LICENSE"));
                } catch (Exception ex) {
                	 
                    JTextArea errorMessage = new JTextArea("Unable to LICENSE Link.\nPlease visit: https://github.com/raghul-tech/Elite-Calculator");
                    errorMessage.setEditable(false);
                    errorMessage.setBackground(main.getFrame().getBackground()); 
                    errorMessage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    JOptionPane.showMessageDialog(
                            main.getFrame(),
                            new JScrollPane(errorMessage),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
	    
	    licensePanel.add(licenseLabel, BorderLayout.NORTH);
	    licensePanel.add(licenseText, BorderLayout.WEST);
	    licensePanel.add(license, BorderLayout.SOUTH);
	    
	    
	   // panel for feedback donate discord
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

	    // Send Feedback Button
	    JButton sendFeedbackButton = new JButton("<html>Send Feedback <font color='red'>&#x2764;</font></html>");
	    sendFeedbackButton.addActionListener(e -> {
	        try {
	            Desktop.getDesktop().mail(new URI("mailto:raghultech.app@gmail.com"));
	        } catch (Exception ex) {
	           // ex.printStackTrace();
	            JTextArea errorMessage = new JTextArea("Unable to open email client. Please send feedback to: raghultech.app@gmail.com");
                errorMessage.setEditable(false);
                errorMessage.setBackground(main.getFrame().getBackground()); 
                errorMessage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JOptionPane.showMessageDialog(
                        main.getFrame(),
                        new JScrollPane(errorMessage),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
	            
	        }
	    });
	    buttonPanel.add(sendFeedbackButton);

	    // Donate Button
	    JButton donateButton = new JButton("<html>Donate <font color='red'>&#x2764;</font></html>");
	    donateButton.addActionListener(e -> {
	        try {
	            Desktop.getDesktop().browse(new URI("https://www.buymeacoffee.com/raghultech"));
	        } catch (Exception ex) {
	          //  ex.printStackTrace();
	            JTextArea errorMessage = new JTextArea( "Unable to open the Link. Please donate in  https://www.buymeacoffee.com/raghultech ");
                errorMessage.setEditable(false);
                errorMessage.setBackground(main.getFrame().getBackground()); 
                errorMessage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JOptionPane.showMessageDialog(
                        main.getFrame(),
                        new JScrollPane(errorMessage),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
	        }
	    });
	    buttonPanel.add(donateButton);

	    // Discord Button
	    JButton discordButton = new JButton("<html>Discord <font color='yellow'>&#x1F44D;</font></html>");
	    discordButton.addActionListener(e -> {
	        try {
	            Desktop.getDesktop().browse(new URI("https://discord.gg/cdBT2KrE2D")); 
	        } catch (Exception ex) {
	            //ex.printStackTrace(); 
	            JTextArea errorMessage = new JTextArea( "Unable to open discord. Please join discord in https://discord.gg/cdBT2KrE2D");
                errorMessage.setEditable(false);
                errorMessage.setBackground(main.getFrame().getBackground()); 
                errorMessage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JOptionPane.showMessageDialog(
                        main.getFrame(),
                        new JScrollPane(errorMessage),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
	            
	        }
	    });
	    buttonPanel.add(discordButton);


	    // Contribution Section
	    JPanel contributionPanel = new JPanel(new BorderLayout());
	    JLabel contributionLabel = new JLabel("Contribute", SwingConstants.CENTER);
	    contributionLabel.setFont(new Font("Arial", Font.BOLD, 16));
	    JLabel contributionText = new JLabel("<html>To learn how you can contribute to Elite Calculator, <br>" +
	            "check out the project on <a href=''>GitHub</a>.</html>");
	    contributionText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    contributionText.setForeground(Color.BLUE);
	    contributionText.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            try {
	                Desktop.getDesktop().browse(new URI("https://github.com/raghul-tech/Elite-Calculator"));
	            } catch (Exception ex) {
	               // ex.printStackTrace();
	                JTextArea errorMessage = new JTextArea( "Unable to open github.\n Please visit: https://github.com/raghul-tech/Elite-Calculator");
	                errorMessage.setEditable(false);
	                errorMessage.setBackground(main.getFrame().getBackground()); 
	                errorMessage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	                JOptionPane.showMessageDialog(
	                        main.getFrame(),
	                        new JScrollPane(errorMessage),
	                        "Error",
	                        JOptionPane.ERROR_MESSAGE
	                );
	            }
	        }
	    });
	    contributionPanel.add(contributionLabel, BorderLayout.NORTH);
	    contributionPanel.add(contributionText, BorderLayout.WEST);

	
	    mainPanel.add(appearancePanel);
	    mainPanel.add(Box.createVerticalStrut(10));
	    mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL)); 

	    mainPanel.add(aboutPanel);
	    mainPanel.add(Box.createVerticalStrut(10));
	    mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL)); 

	    mainPanel.add(licensePanel);
	    mainPanel.add(Box.createVerticalStrut(10));
	    mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL)); 

	    mainPanel.add(buttonPanel);
	    mainPanel.add(Box.createVerticalStrut(10));
	    mainPanel.add(new JSeparator(SwingConstants.HORIZONTAL)); 

	    mainPanel.add(contributionPanel);

	    JScrollPane scrollPane = new JScrollPane(mainPanel);
	    scrollPane.setBorder(BorderFactory.createEmptyBorder());
	    scrollPane.getVerticalScrollBar().setUnitIncrement(16); 

	    main.getPanel().setLayout(new BorderLayout());
	    main.getPanel().add(scrollPane, BorderLayout.CENTER);

	    main.getPanel().revalidate();
	    main.getPanel().repaint();
	    //main.getPanel().requestFocusInWindow();
	}
	    
}
