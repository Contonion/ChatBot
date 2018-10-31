package chat.controller;
import javax.swing.JOptionPane;

import chat.model.Chatbot;
public class ChatController
{
	
	private Chatbot simpleBot;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
	}
	public void start() {
		String userText = "";
		while (!userText.equalsIgnoreCase("Quit"))
		{
			
		}
	}
	
	public String interactWithChatbot(String text) {
		String output = "";
		String userResponse = JOptionPane.showInputDialog(text);
		output = simpleBot.processText(userResponse);
		return output;	
	}
	public String useChatbotCheckers(String text)
	{
		return null;
	}
	
	public Object getChatbot() 
	{
		return null;
	}
}
