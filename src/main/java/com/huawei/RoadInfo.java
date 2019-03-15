package com.huawei;

import java.util.logging.Logger;

public class RoadInfo {
	//��·id
	private int roadId;
	//��·����
	private int roadLength;
	//�������
	private int highSpeedLimit;
	//������Ŀ
	private int carLanes;
	//��ʼ��id��·�ڣ�
	private int startCross;
	//�յ�id��·�ڣ�
	private int endCross;
	//�Ƿ�˫��
	private int isDuplex;
	public void setRoadInfo(int roadId1,int roadLength1,int highSpeedLimit1,int carLanes1,int startCross1,int endCross1,int isDuplex1)
	{
		this.roadId = roadId1;
		this.roadLength = roadLength1;
		this.highSpeedLimit = highSpeedLimit1;
		this.carLanes = carLanes1;
		this.startCross = startCross1;
		this.endCross = endCross1;
		this.isDuplex = isDuplex1;
	}
	public int getRoadId() {
		return roadId;
	}
	public void setRoadId(int roadId) {
		this.roadId = roadId;
	}
	public int getRoadLength() {
		return roadLength;
	}
	public void setRoadLength(int roadLength) {
		this.roadLength = roadLength;
	}
	public int getHighSpeedLimit() {
		return highSpeedLimit;
	}
	public void setHighSpeedLimit(int highSpeedLimit) {
		this.highSpeedLimit = highSpeedLimit;
	}
	public int getCarLanes() {
		return carLanes;
	}
	public void setCarLanes(int carLanes) {
		this.carLanes = carLanes;
	}
	public int getStartCross() {
		return startCross;
	}
	public void setStartCross(int startCross) {
		this.startCross = startCross;
	}
	public int getEndCross() {
		return endCross;
	}
	public void setEndCross(int endCross) {
		this.endCross = endCross;
	}
	public int getIsDuplex() {
		return isDuplex;
	}
	public void setIsDuplex(int isDuplex) {
		this.isDuplex = isDuplex;
	}
	public void getRoadLine(String RoadLine)
	{
		if(RoadLine.charAt(0)=='#') {
			return;
		}
		int len = RoadLine.length();
		RoadLine = RoadLine.substring(1, len-1);
		//��ȥ�ո�
		RoadLine = RoadLine.replaceAll(" ", "");
		String[] RoadInformation = RoadLine.split(",");
		if(RoadInformation.length == 7) {
			int[] ak = new int[7];
			for(int i = 0;i < 7;i++) {
				ak[i] = Integer.parseInt(RoadInformation[i]);
			}
			//System.out.println("Road:" + ak[0] + " " + ak[1] + " " + ak[2] + " " + ak[3] + " " + ak[4]+ " " + ak[5] + " " + ak[6]);
			setRoadInfo(ak[0],ak[1],ak[2],ak[3],ak[4],ak[5],ak[6]);
		}else {
			Logger.getLogger("���ݴ���");
			return;
		}	
		return;
	}
	
	
}
