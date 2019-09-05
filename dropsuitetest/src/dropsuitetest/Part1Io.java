package dropsuitetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Part1Io {
	
	public static void main(String args[]) throws IOException {
			
			Properties prop = new Properties();
			
			FileInputStream ip = new FileInputStream("config.properties");
			
			prop.load(ip);
			
			new Part1Io().countFile(0, prop.getProperty("path"), true, prop.getProperty("extension"), "");
			
		}
			 
		public int countFile(int count, String path, boolean isrecursive, String fileType, String name) {
	        if (!isrecursive)
	            count = 0;
	        
	        File file = new File(path);
	        File[] childFile = file.listFiles();
	 
	        if (childFile != null) {
	            for (int k = 0; k < childFile.length; k++) {
	                if (childFile[k].isDirectory()) {
	                    count = countFile(count, childFile[k].toString(), true, fileType, childFile[k].getName().toLowerCase());
	                } else {
	                    if (fileType != "" && childFile[k].getName().toLowerCase().contains("."+fileType)) {
	                        count++;
	                    }else if(fileType == ""){
	                        count++;
	                    }
	 
	                }
	            }
	        }
	        
	        System.out.println(name+count);
	        return count;
	    }
	   	 
}
