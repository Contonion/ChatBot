package chat.controller;
import chat.view.*;
import java.util.Calendar;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
public class IOController
{
	public static void saveText(ChatController app, String path, String textToSave)
	{
		try
		{
			String filename = path;
			Calendar date = Calendar.getInstance();
			filename += "/" + Calendar.MONTH + " " + Calendar.DAY_OF_MONTH;
			filename += " at " + date.get(Calendar.HOUR) + "-" + date.get(Calendar.MINUTE);
			filename += "chat save.txt";
			File saveFile = new File(filename);
			Scanner textScanner = new Scanner(textToSave);
			PrintWriter saveText = new PrintWriter(saveFile);
			while(textScanner.hasNext())
			{
				String currentLine = textScanner.nextLine();
				saveText.println(currentLine);
			}
			
			
			textScanner.close();
			saveText.close();
		} catch(IOException error) {
			app.handleErrors(error);
		}
		catch(Exception genericError) {
			app.handleErrors(genericError);
		}
	}
		public static String loadFile(ChatController app, String path)
		{
			String contents = "";
			try
			{
				File saveFile = new File(path);
				Scanner fileScanner;
				if(saveFile.exists())
				{
					fileScanner = new Scanner(saveFile);
					while (fileScanner.hasNext())
					{
						contents += fileScanner.nextLine() + "\n";
					}
					fileScanner.close();
				}
			}
		
		
		catch(IOException error) {
			app.handleErrors(error);
			//My Back Hurts...
			//Like really bad.
			//Do you wanna give me a back rub?
			//I'll go for a walk. Cya in a bit.
		}
		catch(Exception genericError) {
			app.handleErrors(genericError);
		}
			return contents;
	}
}
