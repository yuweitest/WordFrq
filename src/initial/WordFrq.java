package initial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordFrq {

	public static void main(String[] args) throws FileNotFoundException {
		String filePath ="source.txt";
		String outputPath="export.txt";
		String line=null;
		ArrayList<Map> list = new ArrayList();
		int str_Num=0;
		int list_Num =0;
		BufferedReader br= new BufferedReader(new FileReader(filePath));
		try {
			line=br.readLine();
			while (line!= null) {
				line.toString().trim();
				Pattern p = Pattern.compile(".,\"\\?!:'");
				Matcher m = p.matcher(line);
				line=m.replaceAll(" ");
				p=Pattern.compile("\\s+");
				String[] str=p.split(line);
				str_Num = str.length;
				list_Num = list.size();
				
				//第一排单独处理
				if (list_Num==0) {
					Map word = new Map();
					word.setFrequence(1);
					word.setWord(str[0]);
					list.add(word);
					for (int i = 1; i < str_Num; i++) {
						for (int j = 0; j < list.size(); j++) {
							if (str[i].trim().equals((String)list.get(j).getWord().toString().trim())) {//此处不相等
								int frq=(int) list.get(j).getFrequence();
								list.get(j).setFrequence(++frq);
								break;
							}else if (j==list.size()-1){
								Map word1 = new Map();
								word1.setFrequence(1);
								word1.setWord(str[i]);
								list.add(word1);
							}
						}
					}
					
				} else {
					for (int i = 0; i < str_Num; i++) {
						for (int j = 0; j < list_Num; j++) {
							if (str[i].trim().equals((String)list.get(j).getWord().toString().trim())) {
								int frq=(int) list.get(j).getFrequence();
								list.get(j).setFrequence(++frq);
								break;
							}else if (j==list_Num-1){
								Map word = new Map();
								word.setFrequence(1);
								word.setWord(str[i]);
								list.add(word);
							}
						}
					}
				}
				
				line =br.readLine();
			}
			BufferedWriter wr = new BufferedWriter(new FileWriter(outputPath));
			for (int i = 0; i <list.size(); i++) {
				wr.write((String)list.get(i).getWord());
				wr.write("  "+(int)list.get(i).getFrequence());
				wr.newLine();
			}
			br.close();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 class Map<String,Integer>{
	 private String word;
	 public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Integer getFrequence() {
		return frequence;
	}
	public void setFrequence(Integer frequence) {
		this.frequence = frequence;
	}
	private Integer frequence;
 }
