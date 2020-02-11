package com.mike.miwok;

public class Word {
    private String mEnglishWord;
    private String mMiwokWord;

    public Word(String englishWord, String miwokWord) {
        mEnglishWord = englishWord;
        mMiwokWord = miwokWord;
    }

    public String getmEnglishWord() {
        return mEnglishWord;
    }

    public String getMiwokWord() {
        return mMiwokWord;
    }
}
