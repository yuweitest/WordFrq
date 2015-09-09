package initial;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcess {

	public TextProcess() {
	}

	
	//�����ı��ĵ�һ�У���ʱ��list���ϻ��ǿ�
	public ArrayList<Map1> FisrtLine_P(ArrayList<Map1> list, String[] str) {
		Map1 word = new Map1();
		word.setFrequence(1);
		word.setWord(str[0]);
		list.add(word);
		int str_Num = str.length;
		for (int i = 1; i < str_Num; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (str[i].trim().equals((String) list.get(j).getWord().toString().trim())) {
					int frq = (int) list.get(j).getFrequence();
					list.get(j).setFrequence(++frq);
					break;
				} else if (j == list.size() - 1) {
					Map1 word1 = new Map1();
					word1.setFrequence(1);
					word1.setWord(str[i]);
					list.add(word1);
				}
			}
		}

		return list;
	}
	
	
	//����ǵ�һ������
	public ArrayList<Map1<String, Integer>>UnFirstLine_P(ArrayList<Map1<String, Integer>> list,String[] str){
		int str_Num= str.length;
		int list_Num = list.size();
		for (int i = 0; i < str_Num; i++) {
			for (int j = 0; j < list_Num; j++) {
				if (str[i].trim().equals((String)list.get(j).getWord().toString().trim())) {
					int frq=(int) list.get(j).getFrequence();
					list.get(j).setFrequence(++frq);
					break;
				}else if (j==list_Num-1){
					Map1 word = new Map1();
					word.setFrequence(1);
					word.setWord(str[i]);
					list.add(word);
				}
			}
		}
		return null;
		
	}
	
	//������ʽ���ִַ�
	public String[] Text_regex(String line){
		line.trim();
		Pattern p = Pattern.compile(".,\"\\?!:'");
		Matcher m = p.matcher(line);
		line=m.replaceAll(" ");
		p=Pattern.compile("\\s+");
		String[] str=p.split(line);
		return str;
		
	}

}
