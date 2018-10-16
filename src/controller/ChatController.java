package controller;
import javax.swing.JOptionPane;

import model.Chatbot;
public class ChatController
{
	public void start() {
		String userText = "";
		while (!userText.equalsIgnoreCase("Quit"))
		{
			userText = JOptionPane.showInputDialog(null, "Type 'quit' to exit");
		}
	}
	
	Chatbot Chatbot = new Chatbot();
	public Chatbot controller() {
		return Chatbot;
		
		
	}
	
}
