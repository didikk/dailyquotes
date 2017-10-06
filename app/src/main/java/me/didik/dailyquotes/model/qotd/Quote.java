
package me.didik.dailyquotes.model.qotd;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quote {

    @SerializedName("author")
    private String mAuthor;
    @SerializedName("background")
    private String mBackground;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("date")
    private String mDate;
    @SerializedName("id")
    private String mId;
    @SerializedName("length")
    private String mLength;
    @SerializedName("permalink")
    private String mPermalink;
    @SerializedName("quote")
    private String mQuote;
    @SerializedName("tags")
    private List<String> mTags;
    @SerializedName("title")
    private String mTitle;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getBackground() {
        return mBackground;
    }

    public void setBackground(String background) {
        mBackground = background;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLength() {
        return mLength;
    }

    public void setLength(String length) {
        mLength = length;
    }

    public String getPermalink() {
        return mPermalink;
    }

    public void setPermalink(String permalink) {
        mPermalink = permalink;
    }

    public String getQuote() {
        return mQuote;
    }

    public void setQuote(String quote) {
        mQuote = quote;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
