
package me.didik.dailyquotes.model.qotd;

import com.google.gson.annotations.SerializedName;

public class Success {

    @SerializedName("total")
    private Long mTotal;

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

}
