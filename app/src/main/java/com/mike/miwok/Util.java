package com.mike.miwok;

import android.media.MediaPlayer;

public class Util {
    public static MediaPlayer releaseMediaPlayer(MediaPlayer mp) {
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.stop();
            }
            mp.reset();
            mp.release();
        }
        return null;
    }
}
