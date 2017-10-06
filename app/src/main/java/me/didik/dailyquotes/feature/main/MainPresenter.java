package me.didik.dailyquotes.feature.main;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import me.didik.dailyquotes.app.network.Api;
import me.didik.dailyquotes.base.mvp.BasePresenter;
import me.didik.dailyquotes.base.network.CallbackWrapper;
import me.didik.dailyquotes.model.qotd.QotdResponse;
import me.didik.dailyquotes.model.random.RandomQuote;

/**
 * Created by didik on 05/10/17.
 */

class MainPresenter extends BasePresenter<MainView> {
    @Inject
    MainPresenter(CompositeDisposable compositeDisposable, Api api) {
        super(compositeDisposable, api);
    }

    void getQuotes() {
        getView().showLoading();

        getCompositeDisposable().add(api.getQotd()
                .compose(this.<QotdResponse>applySchedulers())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        getRandomQuotes();
                    }
                })
                .subscribeWith(new CallbackWrapper<QotdResponse>(getView()) {
                    @Override
                    protected void onSuccess(QotdResponse qotdResponse) {
                        getView().setQotd(qotdResponse.getContents().getQuotes().get(0));
                    }
                })
        );
    }

    private void getRandomQuotes(){
        final String url = "https://andruxnet-random-famous-quotes.p.mashape.com/?cat=famous&count=10";

        getCompositeDisposable().add(api.getRandomQuotes(url)
                .compose(this.<List<RandomQuote>>applySchedulers())
                .subscribeWith(new CallbackWrapper<List<RandomQuote>>(getView()) {
                    @Override
                    protected void onSuccess(List<RandomQuote> randomQuotes) {
                        getView().hideLoading();
                        getView().updateRecycler(randomQuotes);
                    }
                })
        );
    }
}
