package chat.model;

import java.util.ArrayList;

public class Chatbot
{
	ArrayList responseList = new ArrayList();
	ArrayList spookyList = new ArrayList();
	private String joke;
	private String currentUser;
	private String content;
	public Chatbot() {
		this.joke = "Why did the monkey cross the road? It was stapled to the chicken";
		this.currentUser = new String("Default User - Boring!!");
		this.content = new String("Empty of all content but not null");
		
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		buildTheLists();
	}
	private void buildTheLists() {
		responseList.add("Hello! How are you?");
		responseList.add("Goodbye");
		responseList.add("Yes");
		responseList.add("No");
		responseList.add("What is your name??????????????????????????????????????????????????TELLLLLLMEEEEEEE");
		
		spookyList.add("Halloween");
		spookyList.add("Christmas is better than Halloween");
		spookyList.add("Boo");
		spookyList.add("Turn around...");
	}
	public String processText(String userText)
	{
		String Output = "";
		Output += "You said " + userText;
		return Output;
		
	}
	public boolean sentimentChecker(String text)
	{
		boolean hasSentiment = false;
		return hasSentiment;
	}
	public boolean legitimacyChecker(String input)
	{
		boolean isValid = true;
		
		if(input == null)
		{
			isValid = false;
		}
		else if (input.length() < 2)
		{
			isValid = false;
		}
		else if (input.contains("dfg") || input.contains("cvb"))
		{
			isValid = false;
		}
		return isValid;
	}
	public boolean spookyChecker(String input)
	{
		boolean isValid = true;
		
		if(input == null)
		{
			isValid = false;
		}
		else if (input.length() < 2)
		{
			isValid = false;
		}
		else if (input.contains("dfg") || input.contains("cvb"))
		{
			isValid = false;
		}
		return isValid;
	}
	public void getSpookyList() {
		
	}
	public void getContent() {
		
	}
	public void getResponseList() {
		
	}
	
	
}
