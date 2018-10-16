package model;

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
		
		spookyList.add("Christmas is better than Halloween");
		spookyList.add("Boo");
		spookyList.add("Turn around...");
	}
}
