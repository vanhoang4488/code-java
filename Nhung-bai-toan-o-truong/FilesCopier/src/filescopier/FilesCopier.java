package filescopier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
 
 

public class FilesCopier {
 
	public static void main(String[] args) {
 
		// Source file.
		Path source = Paths.get("C:\\Users\\Nguyen Van Hoang\\Documents\\a font.mp3");
 
		// Destination file.
		Path destination = Paths.get("C:\\Users\\Nguyen Van Hoang\\Downloads\\a font.mp3");
		
		try {
			copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Problem occurs when copying files");
			e.printStackTrace();
		}
	}
 
	
	public static void copyFile(Path source, Path destination) throws IOException {
		Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
	}
}