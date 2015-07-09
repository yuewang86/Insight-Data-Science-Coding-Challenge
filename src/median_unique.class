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
	public void func(String inputFileName, String outputFileName){
		//read input file by line and save data to treeMap
		ArrayList<Integer> total = new ArrayList<Integer>();
		ArrayList<Double> medianList = new ArrayList<Double>();
		File fileInput = new File(inputFileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileInput));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
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
				//record the number of unique words in this tweet
				int count = 0;
				Iterator<String> it = treeMap.keySet().iterator();
				while(it.hasNext()){
					count++;
				}
				total.add(count);
				int sum = 0;
				for(int i=0; i<total.size(); i++){
					sum += total.get(i);
				}
				double median = (double)(sum)/(double)(total.size());
				medianList.add(median);
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
		
		//write information to output file
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
