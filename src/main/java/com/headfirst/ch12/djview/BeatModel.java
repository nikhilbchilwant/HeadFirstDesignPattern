package com.headfirst.ch12.djview;

import javax.sound.midi.*;
import java.util.*;

public class BeatModel implements BeatModelInterface, MetaEventListener {
	Sequencer sequencer;
	ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
	int bpm = 90;
	Sequence sequence;
	Track track;

	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}

	public void on() {
		sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		sequencer.start();
		setBPM(getBPM());
	}

	public void off() {
		// TODO: Implement the off method
		// 1. set the tempo factor to 0 or stop the sequencer
		// 2. stop the sequencer
        sequencer.stop();
	}

	public void setBPM(int bpm) {
		this.bpm = bpm;
		notifyBPMObservers();
		sequencer.setTempoInBPM(getBPM());
	}

	public int getBPM() {
		return bpm;
	}

	public void beatEvent() {
		notifyBeatObservers();
	}

	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void removeObserver(BeatObserver o) {
		beatObservers.remove(o);
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	public void removeObserver(BPMObserver o) {
		bpmObservers.remove(o);
	}
	
	public void notifyBeatObservers() {
		for (BeatObserver observer : beatObservers) {
			observer.updateBeat();
		}
	}

	public void notifyBPMObservers() {
		for (BPMObserver observer : bpmObservers) {
			observer.updateBPM();
		}
	}

	// MIDI Setup Code - Provided for convenience
	public void meta(MetaMessage message) {
		if (message.getType() == 47) {
			beatEvent();
			sequencer.start();
			setBPM(getBPM());
		}
	}

	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = {35, 0, 46, 0};

		sequence.deleteTrack(null);
		track = sequence.createTrack();

		makeTracks(trackList);
		track.add(makeEvent(192, 9, 1, 0, 4));      
		try {
			sequencer.setSequence(sequence);                    
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
			
	public void makeTracks(int[] list) {        
		for (int i = 0; i < list.length; i++) {
			int key = list[i];

			if (key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	}
		
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception e) {
			e.printStackTrace(); 
		}
		return event;
	}
}
