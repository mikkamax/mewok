package com.mike.miwok;

public class Word {
    private String mEnglishWord;
    private String mMiwokWord;
    private int mSoundResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String englishWord, String miwokWord, int soundResourceId) {
        mEnglishWord = englishWord;
        mMiwokWord = miwokWord;
        mSoundResourceId = soundResourceId;
    }

    public Word(String englishWord, String miwokWord, int imageResourceId, int soundResourceId) {
        mEnglishWord = englishWord;
        mMiwokWord = miwokWord;
        mImageResourceId = imageResourceId;
        mSoundResourceId = soundResourceId;
    }

    public String getEnglishWord() {
        return mEnglishWord;
    }

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getSoundResourceId() {
        return mSoundResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
