package com.headfirst.ch12.djview;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	DJView view;
   
	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(this, model);
		view.createView();
		view.createControls();
		model.initialize();
	}
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
		model.setBPM(model.getBPM() + 1);
	}
    
	public void decreaseBPM() {
		model.setBPM(model.getBPM() - 1);
	}
  
	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
}
