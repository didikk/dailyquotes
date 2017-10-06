
package me.didik.dailyquotes.model.qotd;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contents {

    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("quotes")
    private List<Quote> mQuotes;

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public List<Quote> getQuotes() {
        return mQuotes;
    }

    public void setQuotes(List<Quote> quotes) {
        mQuotes = quotes;
    }

}
