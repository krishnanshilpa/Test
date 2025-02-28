package readerwriter;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

public class ReadWriteFileTest {
	
	 @Test
	  //By mocking the file system
	    public void contentReverse_withoutFileSystem() throws IOException {
	        // Enable static mocking on Paths
	    	 FileSystem fileSystem = Jimfs.newFileSystem(Configuration.windows());

	         // Create a file and write some lines to it
	         Path inputFile = fileSystem.getPath("/mockedInputFile.txt");
	         Path outputFile = fileSystem.getPath("/mockedOutputFile.txt");
	         Files.write(inputFile, "ABC".getBytes());
	         Assertions.assertEquals(ReadWriteFile.contentReverse(inputFile,outputFile), "ABC CBA");
	         
	 }
	
    @Test
    //By changing the file system
    void contentReverse_withFileSystem() throws IOException {
    	Path inputFile = Paths.get("src\\test\\resources\\Input.txt");
    	Path outputFile = Paths.get("src\\test\\resources\\Output.txt");
    	Assertions.assertEquals(ReadWriteFile.contentReverse(inputFile,outputFile), "ABCDEFGH HGFEDCBA");
    	
    }
    
   

}
