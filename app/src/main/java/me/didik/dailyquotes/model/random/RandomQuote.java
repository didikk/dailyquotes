
package me.didik.dailyquotes.model.random;

import com.google.gson.annotations.SerializedName;

public class RandomQuote {

    @SerializedName("author")
    private String mAuthor;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("quote")
    private String mQuote;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getQuote() {
        return mQuote;
    }

    public void setQuote(String quote) {
        mQuote = quote;
    }

}
