package com.huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

public class Main {
    //private static final Logger logger = Logger.getLogger(Main.class);
    private static HashMap<Integer, RoadInfo> RoadMap = new HashMap<>();
    private static HashMap<Integer, CrossInfo> CrossMap = new HashMap<>();
    public static void main(String[] args)
    {
		//List<RoadInfo> RoadsInfo = new ArrayList<RoadInfo>();
		List<String> aa = readFile("F:/�ܱ�/road.txt");
		for (String attribute : aa) {
			RoadInfo temp = new RoadInfo();
			temp.getRoadLine(attribute);
			RoadMap.put(temp.getRoadId(), temp);
		}
		List<String> bb = readFile("F:/�ܱ�/cross.txt");
		for (String attribute1 : bb) {
			CrossInfo crossTemp = new CrossInfo();
			crossTemp.getRoadLine(attribute1);
			CrossMap.put(crossTemp.getCrossId(), crossTemp);
		}
    }
    
    public static List<String> readFile(String filePath) {
		List<String> list = new ArrayList<>();
		String encoding = "UTF-8";
        File file = new File(filePath);
        if(file.isFile()&&file.exists()) {
        	try {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
				BufferedReader buffReader = new BufferedReader(read);
				String st;
				//ȥ����һ��ע��
				buffReader.readLine();
				while((st=buffReader.readLine())!=null) {
					list.add(st);
				}
				buffReader.close();
				read.close();
			} catch (Exception e) {
				Logger.getLogger("��ȡ�ļ�����");
				e.printStackTrace();
			}
        }else {
        	Logger.getLogger("ָ���ļ�������");
        }
        return list;
    }
}