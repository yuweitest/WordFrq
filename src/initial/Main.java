package initial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		String input_Path="source.text";
		String output_Path="export.text";
		String line=null ;
		ArrayList<Map1> list = new ArrayList();
		boolean is_First=true;
		BufferedReader br = new BufferedReader(new FileReader(input_Path));
		TextProcess tp= new TextProcess();
		try {
			line=br.readLine();
			while (line!=null) {
				String[] str=tp.Text_regex(line);
				if(is_First){
					tp.FisrtLine_P(list, str);
				}else {
					tp.UnFirstLine_P(list, str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter wr = new BufferedWriter(new FileWriter(output_Path));
		for (int i = 0; i <list.size(); i++) {
			wr.write((String)list.get(i).getWord());
			wr.write("  "+(int)list.get(i).getFrequence());
			wr.newLine();
		}
		br.close();
		wr.close();
	}

}
