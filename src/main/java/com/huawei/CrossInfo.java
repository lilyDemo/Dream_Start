package com.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
			setCrossInfo(ak[0],ak[1],ak[2],ak[3],ak[4]);
		}else {
			Logger.getLogger("数据错误");
			return;
		}	
		return;
	}
	/**
	 * 获取道路优先级
	 * @param origin
	 * @param dest
	 * @return
	 */
	public int getPriority(int origin,int dest) {
    	if((this.roadId1==origin&&this.roadId2==dest)||(this.roadId2==origin&&this.roadId3==dest)||(this.roadId3==origin&&this.roadId4==dest)||(this.roadId4==origin&&this.roadId1==dest)) {
    		return 2;
    	}else if((this.roadId1==origin&&this.roadId3==dest)||(this.roadId2==origin&&this.roadId4==dest)||(this.roadId3==origin&&this.roadId1==dest)||(this.roadId4==origin&&this.roadId2==dest)) {
    		return 1;
    	}else {
    		return 3;
    	}
	}
	
	/**
	 * 获取可达路口
	 * @param origin
	 * @param dest
	 * @return
	 */
	public List<Integer> accessCross(int crossId, HashMap<Integer,RoadInfo> RoadMap) {
		List<Integer> accessCrossResult = new ArrayList<Integer>();
		if(roadId1 != -1)
		{
			RoadInfo road1 = RoadMap.get(roadId1);
			if(road1.getIsDuplex() == 1) //道路是双向的
			{
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
				else
					accessCrossResult.add(road1.getStartCross());
			}
			else{ //单向的则crossId必须为StartCross
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
			}
		}
		if(roadId2 != -1)
		{
			RoadInfo road1 = RoadMap.get(roadId2);
			if(road1.getIsDuplex() == 1) //道路是双向的
			{
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
				else
					accessCrossResult.add(road1.getStartCross());
			}
			else{ //单向的则crossId必须为StartCross
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
			}
		}
		if(roadId3 != -1)
		{
			RoadInfo road1 = RoadMap.get(roadId3);
			if(road1.getIsDuplex() == 1) //道路是双向的
			{
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
				else
					accessCrossResult.add(road1.getStartCross());
			}
			else{ //单向的则crossId必须为StartCross
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
			}
		}
		if(roadId4 != -1)
		{
			RoadInfo road1 = RoadMap.get(roadId4);
			if(road1.getIsDuplex() == 1) //道路是双向的
			{
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
				else
					accessCrossResult.add(road1.getStartCross());
			}
			else{ //单向的则crossId必须为StartCross
				if(crossId == road1.getStartCross())
					accessCrossResult.add(road1.getEndCross());
			}
		}	
    	return accessCrossResult;
	}
	
	
	
//	/**
//	 * 获取车子当前速度
//	 * @param roadSpeed 道路最高限速
//	 * @param carSpeed 车子最高限速
//	 * @param roadNowSpeed 道路当前速度
//	 */
//	public int curSpeed(int roadSpeed,int carSpeed,int roadNowSpeed)
//	{
//		int temp1 = Math.min(roadSpeed, carSpeed);
//		return Math.min(temp1,roadNowSpeed);
//	}
	
}
