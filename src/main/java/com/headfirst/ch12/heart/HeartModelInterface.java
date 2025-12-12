package com.headfirst.ch12.heart;

import com.headfirst.ch12.djview.BeatObserver;
import com.headfirst.ch12.djview.BPMObserver;

public interface HeartModelInterface {
	int getHeartRate();
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
}
