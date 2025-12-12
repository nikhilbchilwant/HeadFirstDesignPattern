package com.headfirst.ch11.virtualproxy;

import java.net.*;
import java.awt.*;
import javax.swing.*;

class ImageProxy implements Icon {
	volatile ImageIcon imageIcon;
	final URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;
     
	public ImageProxy(URL url) { imageURL = url; }
     
	public int getIconWidth() {
		// TODO: Implement this method
		// If imageIcon is not null, return its width
		// Else return default width (e.g. 800)
        if(imageIcon != null) {
            return imageIcon.getIconWidth();
        }
		return 800;
	}
 
	public int getIconHeight() {
		// TODO: Implement this method
		// If imageIcon is not null, return its height
		// Else return default height (e.g. 600)
        if(imageIcon != null) {
            return imageIcon.getIconHeight();
        }
		return 600;
	}
     
	public void paintIcon(final Component c, Graphics  g, int x,  int y) {
		// 1. If imageIcon is not null, delegate to it:
		//    imageIcon.paintIcon(c, g, x, y);
		
		// 2. If imageIcon is null:
		//    - Display "Loading CD cover, please wait..." message
		//    - If not already retrieving, start a new thread to load the image
		//    - In the thread:
		//      - formatting: imageIcon = new ImageIcon(imageURL, "CD Cover");
		//      - c.repaint();
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("Loading CD cover, please wait...", x, y + getIconHeight() / 2);
            if (!retrieving) {
                retrieving = true;
                retrievalThread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            imageIcon = new ImageIcon(imageURL, "CD Cover");
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
	}
}
