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
    private static final Logger logger = Logger.getLogger(Main.class);
    private static HashMap<Integer, RoadInfo> RoadMap = new HashMap<>();
    private static HashMap<Integer, CrossInfo> CrossMap = new HashMap<>();
    private static HashMap<Integer, Car> CarMap = new HashMap<>();
    public static void main(String[] args)
    {
    	 if (args.length != 4) {
             logger.error("please input args: inputFilePath, resultFilePath");
             return;
         }
         
         logger.info("Start...");
         
         String carPath = args[0];
         String roadPath = args[1];
         String crossPath = args[2];
         String answerPath = args[3];
         logger.info("carPath = " + carPath + " roadPath = " + roadPath + " crossPath = " + crossPath + " and answerPath = " + answerPath);
         //
         logger.info("start read input files");
		List<String> aa = readFile(roadPath);
		for (String attribute : aa) {
			RoadInfo temp = new RoadInfo();
			temp.getRoadLine(attribute);
			RoadMap.put(temp.getRoadId(), temp);
		}
		List<String> bb = readFile(crossPath);
		for (String attribute1 : bb) {
			CrossInfo crossTemp = new CrossInfo();
			crossTemp.getRoadLine(attribute1);
			CrossMap.put(crossTemp.getCrossId(), crossTemp);
		}
		List<String> cc = readFile(carPath);
		for(String tem : cc) {
			Car car = new Car();
			car.createCar(tem);
			CarMap.put(car.getId(), car);
		}
		
		
		
		
		  // TODO: write answer.txt
        logger.info("Start write output file");

        logger.info("End...");
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
				//去掉第一行注释
				buffReader.readLine();
				while((st=buffReader.readLine())!=null) {
					list.add(st);
				}
				buffReader.close();
				read.close();
			} catch (Exception e) {
				Logger.getLogger("读取文件错误");
				e.printStackTrace();
			}
        }else {
        	Logger.getLogger("指定文件不存在");
        }
        return list;
    }
}