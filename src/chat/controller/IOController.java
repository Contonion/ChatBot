package chat.controller;
import java.util.Calendar;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
public class IOController
{
	public static void saveText(ChatController app, String path, String textToSave) {
		try {
			String fileName = path;
			Calendar date = Calendar.getInstance();
			fileName += "/" + date.get(Calendar.MONTH) + date.get(Calendar.DAY_OF_MONTH);
			fileName += " at " + date.get(Calendar.HOUR) + "-" + date.get(Calendar.MINUTE);
			fileName += " chat save.txt";
			
			File saveFile = new File(fileName);
			Scanner textScanner = new Scanner(textToSave);
			PrintWriter saveText = new PrintWriter(saveFile);
			
			while(textScanner.hasNext()) {
				String currentLine = textScanner.nextLine();
				saveText.println(currentLine);
			}
			textScanner.close();
			saveText.close();
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
	}
}
