package chat.controller;
import javax.swing.JOptionPane;

import chat.model.Chatbot;
import chat.view.ChatFrame;
public class ChatController
{
	
	private Chatbot simpleBot;
	private ChatFrame appFrame;
	public ChatController()
	
	{
		simpleBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}
	
	public void start() 
	{		
		
	}
	
	public String interactWithChatbot(String text) {
		String output = "null";
		if(text == null) {
			output += "You really shouldnt send null";
		}
		String userResponse = JOptionPane.showInputDialog(null, "Hi Whats  up??");
		output += simpleBot.processText(userResponse);
		return output;	
	}
	public String useChatbotCheckers(String text)
	{
		return "Halloween";
	}
	
	public Chatbot getChatbot() 
	{
		return simpleBot;
		
	}
}
