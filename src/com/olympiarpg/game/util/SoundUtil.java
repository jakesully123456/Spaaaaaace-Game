package com.olympiarpg.game.util;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundUtil {

	public static Clip clip = null;

	public static void playSound(String name) throws Exception {
		if (clip != null && clip.isOpen()) clip.close();
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("res/sounds/" + name + ".wav").getAbsoluteFile());
		clip = AudioSystem.getClip();

		clip.open(audioInputStream);
		FloatControl gainControl = 
				(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-17.0f);

		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}