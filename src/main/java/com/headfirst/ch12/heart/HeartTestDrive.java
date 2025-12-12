package com.headfirst.ch12.heart;

import com.headfirst.ch12.djview.ControllerInterface;

public class HeartTestDrive {
	public static void main (String[] args) {
		HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
	}
}
