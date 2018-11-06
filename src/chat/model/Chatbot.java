package chat.model;

import java.util.ArrayList;

public class Chatbot
{
	ArrayList responseList = new ArrayList();
	ArrayList spookyList = new ArrayList();
	private String joke;
	private String currentUser;
	private String content;
	private String getContent;
	private String contentChecker;
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
	public boolean contentChecker(String text) {
		boolean hasContent = false;
		if (text.equals(content)) {
			hasContent = true;
		} else if(text.equals(null)) {
				hasContent = false;
		} else {
			hasContent = false;
		}
		return hasContent;
	}
	public String processText(String userText)
	{
		String answer = "";
		answer += "You said " + userText;
		if (contentChecker(userText)) {
			answer += "You said the special words. \n";
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
		boolean isSpooky = false;
		if(input.contains("Halloween")) {
			isSpooky = true;
		}
		for(String phrase: spookyList.getSpookyList())
		{
			
		}
	
		
		
	}
	public getSpookyList() {
		ArrayList spookyList = new ArrayList();
		return getSpookyList();
	}
	public void getContent() {
		
	}
	public void getResponseList() {
		
	}
	
	
}
