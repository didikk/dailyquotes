package me.didik.dailyquotes.base.network;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import me.didik.dailyquotes.base.mvp.BaseView;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by didik on 05/10/17.
 */

public abstract class CallbackWrapper<T> extends DisposableObserver<T> {
    //BaseView is just a reference of a View in MVP
    private WeakReference<BaseView> weakReference;

    public CallbackWrapper(BaseView view) {
        this.weakReference = new WeakReference<>(view);
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onNext(T t) {
        //You can return StatusCodes of different cases from your API and handle it here. I usually include these cases on BaseResponse and iherit it from every Response
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        BaseView view = weakReference.get();
        if (view.isLoadingShown()) {
            view.hideLoading();

            if (e instanceof HttpException) {
                ResponseBody responseBody = ((HttpException) e).response().errorBody();
                view.showMessage(getErrorMessage(responseBody));
            } else if (e instanceof SocketTimeoutException) {
                view.showMessage("Connection timed out");
            } else if (e instanceof IOException) {
                view.showMessage("Connection Lost, Please check your Connection");
            } else {
                view.showMessage(e.getMessage());
            }
        }
    }

    @Override
    public void onComplete() {

    }

    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
