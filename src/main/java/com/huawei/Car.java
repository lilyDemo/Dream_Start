package com.huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Car {
	private int id;
	private int origin;
	private int dest;
	private int limitSpeed;
	private int startTime;
	public Car() {}
	public Car(int id, int origin,int dest,int limitSpeed, int startTime) {
		this.id = id;
		this.origin = origin;
		this.dest = dest;
		this.limitSpeed = limitSpeed;
		this.startTime =startTime;
	}
	/**
	 * 根据文件路劲获取内容
	 * @param filePath
	 * @return
	 */
	public List<String> readCartxt(String filePath) {
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
	/**
	 * 根据传进来的list创建car类型
	 * @param list
	 */
	public void createCar(String st) {
		if(st.charAt(0)=='#') {
			return;
		}
		int len = st.length();
		st = st.substring(1, len-1);
		//消去空格
		st = st.replaceAll(" ", "");
		String[] sb = st.split(",");
		if(sb.length==5) {
			int[] ak = new int[5];
			for(int i=0;i<5;i++) {
				ak[i] = Integer.parseInt(sb[i]);
			}
			this.id=ak[0];
			this.origin = ak[1];
			this.dest = ak[2];
			this.limitSpeed = ak[3];
			this.startTime =ak[4];
		}else {
			Logger.getLogger("数据错误");
			return;
		}
		
		
		return;
	}
	public static void main(String[] args) {
		Car car = new Car();
		List<String>list = car.readCartxt("E:\\TESTCASE\\car.txt");
		for(String sb: list) {
			Car car1 = new Car();
			car1.createCar(sb);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public int getLimitSpeed() {
		return limitSpeed;
	}
	public void setLimitSpeed(int limitSpeed) {
		this.limitSpeed = limitSpeed;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
}
