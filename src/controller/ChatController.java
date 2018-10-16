package controller;
import javax.swing.JOptionPane;

import model.Chatbot;
public class ChatController
{
	
	private Chatbot simpleBot;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
	}
	public void start() {
		String userText = "...";
		while (!userText.equalsIgnoreCase("Quit"))
		{
			userText = JOptionPane.showInputDialog(null, "Type 'quit' to exit");
		}
	}
	
		
		
	
}
