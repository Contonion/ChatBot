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
		output += simpleBot.processText(text);
		return output;	
	}
	public String useChatbotCheckers(String text)
	{
			String testedValues = "The following checkers passed:";
			if (simpleBot.contentChecker(text)) {
			testedValues += "\nContent Checker";
			if (simpleBot.spookyChecker(text)) {
				return "\nSpooky Checker Happy Halloween";
			}
			if (simpleBot.validityChecker(text))
			{
				testedValues += "\nValidity Checker";
			}
		}
		return testedValues;
	}
	private void close()
	{
		System.exit(0);
	}
	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}
	public ChatFrame getAppFrame()
	{
		return appFrame;
	}
	
	public Chatbot getChatbot() 
	{
		return simpleBot;
		
	}
}
