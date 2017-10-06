package me.didik.dailyquotes.base.mvp;

/**
 * Created by didik on 05/10/17.
 */

public interface BaseView {
    boolean isLoadingShown();

    void showLoading();

    void hideLoading();

    void showMessage(String message);
}
