package chat.view;
import chat.controller.*;
import java.awt.*;

import javax.swing.*;
public class ChatPanel extends JPanel
{
	private ChatController app;
	private JTextField chatField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton saveButton;
	private JButton loadButton;
	private JButton chatButton;
	private JButton checkerButton;
	private JScrollPane chatPane;
	
	public ChatPanel(ChatController app)
	{
		super();
		this.app = app;
		appLayout = new SpringLayout();
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");
		
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
		this.setBackground(Color.MAGENTA);
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(chatField);
	}
	private void setupLayout() {
		
	}
	private void setupListeners() {
		
	}
}
