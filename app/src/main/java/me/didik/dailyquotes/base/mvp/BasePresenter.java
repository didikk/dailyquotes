package me.didik.dailyquotes.base.mvp;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import me.didik.dailyquotes.app.network.Api;

/**
 * Created by didik on 05/10/17.
 */

public abstract class BasePresenter<T> {
    private T view;
    private CompositeDisposable compositeDisposable;
    protected Api api;

    public BasePresenter(CompositeDisposable compositeDisposable, Api api) {
        this.compositeDisposable = compositeDisposable;
        this.api = api;
    }

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        compositeDisposable.dispose();
        view = null;
    }

    protected T getView() {
        if (view == null) {
            throw new IllegalStateException("View is null");
        }

        return view;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    protected <V> ObservableTransformer<V, V> applySchedulers() {
        return new ObservableTransformer<V, V>() {
            @Override
            public ObservableSource<V> apply(@NonNull Observable<V> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
