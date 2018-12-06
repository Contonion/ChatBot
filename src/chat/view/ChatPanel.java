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
	private JButton loadButton;
	private JButton chatButton;
	private JButton checkerButton;
	private JScrollPane chatPane;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -108, SpringLayout.WEST, loadButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 470, SpringLayout.WEST, this);
		chatButton = new JButton("Chat");
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 114, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, chatButton);
		checkerButton = new JButton("Check Text");
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -82, SpringLayout.WEST, checkerButton);
		chatField = new JTextField("Talk to the bot here", 50);
		chatArea = new JTextArea("ChatArea", 20, 50);
		chatPane = new JScrollPane();
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
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
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.CYAN);
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(chatField);
	}
	private void setupLayout() {
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -74, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 651, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -74, SpringLayout.SOUTH, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 26, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 99, SpringLayout.WEST, chatPane);
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
		
	}
}
