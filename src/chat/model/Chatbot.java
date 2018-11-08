package chat.model;

import java.util.ArrayList;

public class Chatbot
{
	ArrayList<String> responseList = new ArrayList<String>();
	ArrayList<String> spookyList = new ArrayList<String>();
	private String joke;
	private String currentUser;
	private String content;
	private String getContent;
	private String contentChecker;
	private String ChatbotString;

	public Chatbot()
	{
		this.joke = "Why did the monkey cross the road? It was stapled to the chicken";
		this.currentUser = new String("Default User - Boring!!");
		this.content = new String("Empty of all content but not null");

		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		buildTheLists();
	}

	private void buildTheLists()
	{
		responseList.add("Hello! How are you?");
		responseList.add("Goodbye");
		responseList.add("Yes");
		responseList.add("No");
		responseList.add("What is your name??????????????????????????????????????????????????TELLLLLLMEEEEEEE");
		responseList.add("I Dont know");
		responseList.add("Possibly");
		responseList.add("look it up!");
		responseList.add("Thank you");
		responseList.add("No Thank you");
		responseList.add("I'm Sorry!");
		responseList.add("I hope so!");
		responseList.add("My name is Cade");
		responseList.add("Caiden is mean");
		responseList.add("Ye");

		spookyList.add("Halloween");
		spookyList.add("Christmas is better than Halloween");
		spookyList.add("Boo");
		spookyList.add("Turn around...");
		spookyList.add("Im watching :3");
		spookyList.add("Boo (Again)");
		spookyList.add("even more boo");
		spookyList.add("Pumpkin");
	}

	public boolean contentChecker(String text)
	{
		boolean hasContent = false;
		if (text == null) {
			hasContent = false;
		} else if (text.equals(content))
		{
			hasContent = true;
		}
		else
		{
			hasContent = false;
		}
		return hasContent;
	}

	public String processText(String userText)
	{
		String answer = "";
		answer += "You said: " + userText;
		if (contentChecker(userText))
		{
			answer = "";
			answer += "Chatbot says: You said the special words. \n";
		} else if (answer == null) {                     
			answer += " Chatbot says: It appears we have received null...";
		}
		return answer;

	}

	public boolean sentimentChecker(String text)
	{
		boolean hasSentiment = false;
		return hasSentiment;
	}

	public boolean legitimacyChecker(String input)
	{
		boolean isValid = true;

		if (input == null)
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
	public String ChatbotString() {
		
	}
	public ArrayList<String> getSpookyList() 
	{
		return spookyList;
	}
	public boolean spookyChecker(String input)
	{
		boolean isSpooky = false;
		if(input.contains("Halloween")) {
			isSpooky = true;
		}
		for(String phrase: spookyList)
		{
			if (input.contains(phrase)) {
				isSpooky = true;
			}
		}
		return isSpooky;
		
		
	}
	public String getContent() {
		return content;
	}
	public ArrayList<String> getResponseList()
	{
		return responseList;
	}
	public String getCurrentUser()
	{
		return currentUser;
	}
	

}
