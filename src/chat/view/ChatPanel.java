package chat.view;
import chat.controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JTextField chatField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton searchTwitterButton;
	private JButton loadButton;
	private JButton chatButton;
	private JButton checkerButton;
	private JScrollPane chatPane;
	private JPanel buttonPanel;
	
	private ImageIcon saveIcon;
	private ImageIcon loadIcon;
	private ImageIcon chatIcon;
	private ImageIcon tweetIcon;
	private ImageIcon checkerIcon;
	private ImageIcon searchIcon;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");
		tweetButton = new JButton("Send Tweet");
		searchTwitterButton = new JButton("Search Twitter");
		
		buttonPanel = new JPanel(new GridLayout(1,0));
		appLayout.putConstraint(SpringLayout.EAST, buttonPanel, -50, SpringLayout.EAST, this);
		buttonPanel.setBackground(Color.MAGENTA);
		chatField = new JTextField("Talk to the bot here", 50);
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 48, SpringLayout.SOUTH, chatField);
		chatArea = new JTextArea("ChatArea", 20, 50);
		chatPane = new JScrollPane();
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		setupButtons();
	}
	private void setupScrollPane() {
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	private void setupPanel() {
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1024, 768));
		buttonPanel.setPreferredSize(new Dimension(900,150));
		this.setBackground(Color.CYAN);
		this.add(buttonPanel);
		this.add(chatPane);
		this.add(chatField);
		
		JLabel lblWelcomeToChatbot = new JLabel("Welcome to Chatbot! Enter something, down below to begin");
		appLayout.putConstraint(SpringLayout.NORTH, lblWelcomeToChatbot, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, lblWelcomeToChatbot, 0, SpringLayout.WEST, chatPane);
		add(lblWelcomeToChatbot);
	}
	private void setupButtons() {
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(chatButton);
		buttonPanel.add(checkerButton);
		buttonPanel.add(tweetButton);
		buttonPanel.add(searchTwitterButton);
	}
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if (choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		return path;
	}
	private void setupLayout() {
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 30, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
	}
	private void setupListeners() {
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String userText = chatField.getText();
				String response = "";
				response = appController.interactWithChatbot(userText);
				chatArea.append(response);
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
				chatField.setText("");
			}
		});
		saveButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				String chatText = chatArea.getText();
				String path = ".";
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat saved!");
			}
				});
		
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String path = getPath("load");
				String chatText = IOController.loadFile(appController, path);
				chatArea.setText(chatText);
			}
		});
		checkerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				
			}
		});
	}
}
