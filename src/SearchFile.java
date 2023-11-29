import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchFile {

	public static void main(String[] args) {
		Scanner scanInput = new Scanner(System.in);
		String SPACE = " ";

		while (scanInput.hasNextLine()) {
			String[] input = scanInput.nextLine().split(SPACE);

			if (input[0].equals("search") && input.length == 3) {
				String stringFind = input[1];
				String fileName = input[2];
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(fileName));
					
					String line = reader.readLine();
					
					System.out.println("SEARCHING FOR '" + stringFind + "'...\n");
					int count = 0;
					
					while (line != null) {
						if (line.matches(".*\\b" + stringFind + "\\b.*")) { // regex to find exact words only
							System.out.println(line);
							count++;
						}
						line = reader.readLine();
					}
					
					reader.close();
					if (count == 0) {
						System.out.print("...\nno instances of '" + stringFind + "' found\n");
					} else {
						System.out.println("\nEND OF FILE");
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("File not found");
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} else if (input[0].equals("quit")) {
				scanInput.close();
				break;
			} else {
				System.out.println("Input error");
			}
		}
	}

}
