import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;


public class median_unique {
	public static void main(String[] args){
		String inputFileName = "./tweet_input/tweets.txt";
		String outputFileName = "./tweet_output/ft2.txt";
		//read input file by line and save data to treeMap
		ArrayList<Integer> total = new ArrayList<Integer>();
		ArrayList<Double> medianList = new ArrayList<Double>();
		
		File fileInput = new File(inputFileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileInput));
		    String tempString = null;
		    int line = 1;
		            
		    while ((tempString = reader.readLine()) != null) {
		    	TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		    	System.out.println("line " + line + ": " + tempString);//change to call method
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
		        		e++;
		        		s = e;
		        	}
		        	else
		        		e++;
		        }
		        //record the number of unique words in this tweet
		        int count = 0;
		        Iterator<String> it = treeMap.keySet().iterator();      
		        while(it.hasNext()){
		        	Object key = it.next();
		        	//System.out.println(key.toString() + " " + treeMap.get(key));
		        	count++;
		        }
		        System.out.println(count);
		        total.add(count);
		        int sum = 0;
		        for(int i=0; i<total.size(); i++){
		        	sum += total.get(i);
		        	System.out.println(total.get(i));
		        }
		        
		        double median = (double)(sum)/(double)(total.size());
		        medianList.add(median);
		        for(int i=0; i<medianList.size(); i++){
		        	System.out.println(medianList.get(i));
		        }
		        		        		        
		    }
		            reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (reader != null) {
				try {
					reader.close();
		        } 
				catch (IOException e1) {
		        }
		    }
		}
		
		try {
        	File fileOutput = new File(outputFileName);
        	FileWriter fw = new FileWriter(fileOutput.getAbsoluteFile());
        	BufferedWriter bw = new BufferedWriter(fw);
        	
	        for(int i=0; i<medianList.size(); i++){	
	            String content = medianList.get(i).toString() + '\n';
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
