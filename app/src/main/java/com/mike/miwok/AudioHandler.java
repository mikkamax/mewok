package com.mike.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

public class AudioHandler {
    private static AudioHandler mAudioHandler;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;

    public static AudioHandler getAudioHandlerInstance(Context context) {
        if (mAudioHandler == null) {
            mAudioHandler = new AudioHandler(context);
        }
        return mAudioHandler;
    }

    private AudioHandler(Context context) {
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                switch (focusChange) {
                    case AudioManager.AUDIOFOCUS_LOSS:
                        releaseMediaPlayer();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                        break;
                    case AudioManager.AUDIOFOCUS_GAIN:
                        mMediaPlayer.start();
                }
            }
        };
        mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        };
    }

    public void play(Context context, int soundResourceId) {
        releaseMediaPlayer();
        int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mMediaPlayer = MediaPlayer.create(context, soundResourceId);
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
        }
    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            try {
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer.reset();
            }
            catch (Exception ignored) {
            }
            mMediaPlayer.release();
        }
        mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
    }
}
