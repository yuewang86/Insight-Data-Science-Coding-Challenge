import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;


public class words_tweeted {
	public static void main(String[] args){
		String inputFileName = "./tweet_input/tweets.txt";
		String outputFileName = "./tweet_output/ft1.txt";
		//read input file by line and save data to treeMap
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		File fileInput = new File(inputFileName);
		BufferedReader reader = null;
		try {
        		reader = new BufferedReader(new FileReader(fileInput));
        		String tempString = null;
        		int line = 1;
            
        		while ((tempString = reader.readLine()) != null) {
        			//System.out.println("line " + line + ": " + tempString);//change to call method
         			line++;
                
                		int s = 0, e = 0;		
        			for(int i=0; i<tempString.length(); i++){
        				if(tempString.charAt(i)==' ' || i == tempString.length()-1){
        					String temp = i==tempString.length()-1? tempString.substring(s, e+1):tempString.substring(s,e);
        					if(treeMap.containsKey(temp)){
        						treeMap.put(temp, treeMap.get(temp)+1);
        					}
        					else{
        						treeMap.put(temp, 1);
        					}
        					s = ++e;
        				}
        				else
        					e++;
        			}
         		}
            		reader.close();
        	} catch (IOException e) {
            		e.printStackTrace();
        	} finally {
         		if (reader != null) {
                		try {
                    			reader.close();
                		} catch (IOException e1) {
                		}
            		}
        	}

        try {
        	File fileOutput = new File(outputFileName);
        	FileWriter fw = new FileWriter(fileOutput.getAbsoluteFile());
        	BufferedWriter bw = new BufferedWriter(fw);
        	
	        Iterator<String> it = treeMap.keySet().iterator();      
	        while(it.hasNext()){
	        	Object key = it.next();	
	            String content = key.toString();
	            for(int i=0; i<30-key.toString().length(); i++){
	            	content += " ";	
	            }
	            content += treeMap.get(key)+"\n";
	            bw.write(content);	   
			}
	        bw.close();
        } 
        catch (IOException e) {
        	e.printStackTrace();
        }
 
		return;
	}
}
