import java.lang.*;
import java.io.*;	
import java.util.*;

class Demo
{
	// class used to create FileFIlter object to be able to filter which files we want to get
	static class HeiferFilter implements FileFilter
    	{
		// we only want files that are of type .txt, i.e. dog.txt.
        	public boolean accept(File path)
        	{
            		String filename = path.getName();
            		try
            		{
				// grabs a substring after the period, the file extension, and seeing if it is "txt"
               		 	return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase().equals("txt");
            		}
            		catch (Exception e)
           	 	{
               			return false;
            		}
        	}
    	}	

	public static void main(String[] args)
	{
		// if user inputs invalid filename, an exception is thrown, which is caught in the catch
		try
		{
			// grab a list of all files
//			File[] fileList = new File("animals").listFiles();

			// print out file names inside animals folder
//			for(int i = 0; i < fileList.length; i++)
//				System.out.println(fileList[i].getName());


			System.out.println("\n\n");

			// grab a list of ONLY the files under specific filter condition in accept method
//			File[] fileList2 = new File("animals").listFiles(new HeiferFilter());
//			for(int i = 0; i < fileList2.length; i++)
  //                              System.out.println(fileList2[i].getName());



			// this is the name-separator character. On UNIX systems the value of this field is '/'
			// on Microsoft Windows systems it is '\\'.
			System.out.println(File.separator);

			
			// FileInputStream is useful to read data from a file in the form of sequence of bytes. 
			// FileInputStream is meant for reading streams of raw bytes such as image data.			

			//  a data stream is an ordered sequence of bits or bytes.

			// Creates an input file stream to read from a file with the specified name
			FileInputStream inStream = new FileInputStream("animals/" + args[0]);

			// Now lets read input from the file stream
	        	Scanner fileScanner = new Scanner(inStream);

			// we grab each line of text in each file, "nextLine()"
			while(fileScanner.hasNextLine())
			{
				// grabs data until it reaches a line separator
				// The line separator used by the in-memory representation of 
				//file contents is always the newline character. 
				String grabbedText = fileScanner.nextLine();

				System.out.println(grabbedText);
			}
			
			// close the stream, not generally necessary, but good practice
			inStream.close();
		}
		catch(Exception e)
		{
			System.out.println("invalid filename!");
		}
		
	}
}
