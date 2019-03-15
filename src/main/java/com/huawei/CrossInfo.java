package com.huawei;

import java.util.logging.Logger;

public class CrossInfo {
	//路口id
	private int crossId;
	//道路Id 按顺时针编排
	private int roadId1;
	private int roadId2;
	private int roadId3;
	private int roadId4;
	public void setCrossInfo(int crossId1,int RoadId1,int RoadId2,int RoadId3,int RoadId4)
	{
		this.crossId = crossId1;
		this.roadId1 = RoadId2;
		this.roadId2 = RoadId2;
		this.roadId3 = RoadId3;
		this.roadId4 = RoadId4;
	}
	public int getCrossId() {
		return crossId;
	}
	public void setCrossId(int crossId) {
		this.crossId = crossId;
	}
	public int getRoadId1() {
		return roadId1;
	}
	public void setRoadId1(int roadId1) {
		this.roadId1 = roadId1;
	}
	public int getRoadId2() {
		return roadId2;
	}
	public void setRoadId2(int roadId2) {
		this.roadId2 = roadId2;
	}
	public int getRoadId3() {
		return roadId3;
	}
	public void setRoadId3(int roadId3) {
		this.roadId3 = roadId3;
	}
	public int getRoadId4() {
		return roadId4;
	}
	public void setRoadId4(int roadId4) {
		this.roadId4 = roadId4;
	}
	public void getRoadLine(String RoadLine)
	{
		if(RoadLine.charAt(0)=='#') {
			return;
		}
		int len = RoadLine.length();
		RoadLine = RoadLine.substring(1, len-1);
		//消去空格
		RoadLine = RoadLine.replaceAll(" ", "");
		String[] RoadInformation = RoadLine.split(",");
		if(RoadInformation.length == 5) {
			int[] ak = new int[5];
			for(int i = 0;i < 5;i++) {
				ak[i] = Integer.parseInt(RoadInformation[i]);
			}
			//System.out.println("cross:" + ak[0] + " " + ak[1] + " " + ak[2] + " " + ak[3] + " " + ak[4]);
			setCrossInfo(ak[0],ak[1],ak[2],ak[3],ak[4]);
		}else {
			Logger.getLogger("数据错误");
			return;
		}	
		return;
	}
	
}
