package readerwriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ReadWriteFile {
	
	public static void main(String[] args)
    {
		Path inputFilePath = Paths.get("src\\main\\resources\\Input.txt");
		Path outFilePath = Paths.get("src\\main\\resources\\Output.txt");
		contentReverse(inputFilePath,outFilePath);
    }
	
	public static String contentReverse(Path inputFilePath,Path outFilePath) {
		 
		 
	        String content = null;
	        String outputFileContect = null;
	        try {
	            content = Files.lines(inputFilePath)
	                            .collect(Collectors.joining(System.lineSeparator()));  
	            
	            String contentReverse = new StringBuilder(content)
	                    .reverse()
	                    .toString();
	            
	           
	            Files.write(outFilePath,contentReverse.getBytes());
	            outputFileContect = Files.lines(outFilePath)
                        .collect(Collectors.joining(System.lineSeparator())); 
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return content+" "+outputFileContect ;
    }

}
