
package me.didik.dailyquotes.model.qotd;

import com.google.gson.annotations.SerializedName;

public class QotdResponse {

    @SerializedName("contents")
    private Contents mContents;
    @SerializedName("success")
    private Success mSuccess;

    public Contents getContents() {
        return mContents;
    }

    public void setContents(Contents contents) {
        mContents = contents;
    }

    public Success getSuccess() {
        return mSuccess;
    }

    public void setSuccess(Success success) {
        mSuccess = success;
    }

}
