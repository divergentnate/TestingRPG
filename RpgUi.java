import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

class RpgUi {
	JFrame frame;
	JPanel controlPanel, infoPanel, promptPanel, choicePanel;
	JLabel choice1, choice2, choice3, choice4;
	JTextArea promptText;
	JScrollPane promptScroll;
	GridBagConstraints controlPanelConstraints;
	BackgroundPanel artPanel;
	Image artPanelBackground;
	
	RpgUi(){
		createJFrame();
		createPanels();
	}
	
	private void createJFrame(){
		frame = new JFrame();
		frame.setTitle("RpgUI");
		frame.setLayout(new GridBagLayout());
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(1280 , 720));
		frame.setMaximumSize(new Dimension(1280 , 720));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createPanels(){
		createArtPanel();
		createControlPanel();
		createInfoPanel();
		frame.pack();
	}
	
	private void createArtPanel(){
		ClassLoader loader = RpgUi.class.getClassLoader();
        URL classLocation = loader.getResource("RpgUi.class");
        System.out.println(classLocation);
        String classLocationToString = classLocation.toString();
        String location = classLocationToString.substring(0, classLocationToString.length() - 11) + "Lava.jpg";
        System.out.println(location);
        
		try {
			artPanelBackground = ImageIO.read(new URL(location));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		artPanel = new BackgroundPanel(artPanelBackground, BackgroundPanel.SCALED, 0.0f, 0.0f);
		artPanel.setPreferredSize(artPanel.getPreferredSize());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		artPanel.setPreferredSize(artPanel.getPreferredSize());
		frame.add(artPanel, gbc);
	}
	
	private void createControlPanel(){
		controlPanel = new JPanel(); 
		controlPanel.setLayout(new GridBagLayout());
		controlPanel.setBackground(Color.yellow);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 0.65;
		
		controlPanelConstraints = new GridBagConstraints();
		createPromptPanel();
		createChoicePanel();
		
		frame.add(controlPanel, gbc);
	}

	private void createPromptPanel(){
		promptPanel = new JPanel();
		promptPanel.setBackground(Color.BLACK);
		promptPanel.setPreferredSize(promptPanel.getPreferredSize());
		
		promptText = new JTextArea("Hello World please be bigger ........Hello World please be bigger ........Hello World please be bigger ........Hello World please be bigger ........");
		promptText.setLineWrap(true);
		promptText.setEditable(false);
		
		promptScroll = new JScrollPane(promptText);
		promptScroll.setBackground(Color.RED);
		promptScroll.setPreferredSize(new Dimension(500,100));
		
		GridBagConstraints promptPanelConstraints = new GridBagConstraints();
		promptPanelConstraints.fill = GridBagConstraints.NONE;
		promptPanelConstraints.gridx = 0;
		promptPanelConstraints.gridy = 0;
		promptPanelConstraints.weightx = 1.0;
		promptPanelConstraints.weighty = 1.0;
		
		promptPanel.add(promptScroll, promptPanelConstraints);
		
		controlPanelConstraints.fill = GridBagConstraints.BOTH;
		controlPanelConstraints.gridx = 0;
		controlPanelConstraints.gridy = 0;
		controlPanelConstraints.weightx = 1.0;
		controlPanelConstraints.weighty = 0.65;

		controlPanel.add(promptPanel, controlPanelConstraints);
	}

	private void createChoicePanel(){
		choicePanel = new JPanel();
		choicePanel.setLayout(new GridBagLayout());
		choicePanel.setBackground(Color.ORANGE);
		choicePanel.setPreferredSize(choicePanel.getPreferredSize());
		
		choice1 = new JLabel("Choice 1");
		choice2 = new JLabel("Choice 2");
		choice3 = new JLabel("Choice 3"); 
		choice4 = new JLabel("Choice 4");
		
		choice1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {	
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {	
			}
        });
		
		choice2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setChoices();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {	
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {	
			}
        });
		
		choice3.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPrompt();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {	
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {	
			}
        });
		
		choice4.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {	
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {	
			}
        });
		
		GridBagConstraints choicePanelConstraints = new GridBagConstraints();
		choicePanelConstraints.fill = GridBagConstraints.NONE;
		choicePanelConstraints.gridx = 0;
		choicePanelConstraints.gridy = 0;
		choicePanelConstraints.weightx = 1.0;
		choicePanelConstraints.weighty = 1.0;
		
		choicePanel.add(choice1, choicePanelConstraints);
		
		choicePanelConstraints.gridy = 1;
		choicePanel.add(choice2, choicePanelConstraints);

		choicePanelConstraints.gridy = 2;
		choicePanel.add(choice3, choicePanelConstraints);

		choicePanelConstraints.gridy = 3;
		choicePanel.add(choice4, choicePanelConstraints);
		
		controlPanelConstraints.fill = GridBagConstraints.BOTH;
		controlPanelConstraints.gridx = 0;
		controlPanelConstraints.gridy = 1;
		controlPanelConstraints.weightx = 1.0;
		controlPanelConstraints.weighty = 0.65;
		
		controlPanel.add(choicePanel, controlPanelConstraints);
	}
	
	private void createInfoPanel(){
		infoPanel = new JPanel();
		infoPanel.setBackground(Color.red);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.weightx = 0.35;
		gbc.weighty = 1.0;
		
		frame.add(infoPanel, gbc);
	}
	
	public void setChoices(){
		choice1.setText("Testing");
		choice2.setText("Testing 1");
		choice3.setText("Testing 2");
		choice4.setText("Testing 3");
	}
	
	public void setPrompt(){
		promptText.setText("WABLE WUE");
	}
}