package com.mike.miwok;

import javax.xml.transform.Source;

public class Word {
    private String mEnglishWord;
    private String mMiwokWord;
    private int mImageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String englishWord, String miwokWord) {
        mEnglishWord = englishWord;
        mMiwokWord = miwokWord;
    }

    public Word(String englishWord, String miwokWord, int imageId) {
        mEnglishWord = englishWord;
        mMiwokWord = miwokWord;
        mImageId = imageId;
    }

    public String getEnglishWord() {
        return mEnglishWord;
    }

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public int getImageId() {
        return mImageId;
    }

    public boolean hasImage() {
        return mImageId != NO_IMAGE_PROVIDED;
    }
}
