package me.didik.dailyquotes.feature.main;

import java.util.List;

import me.didik.dailyquotes.base.mvp.BaseView;
import me.didik.dailyquotes.model.qotd.Quote;
import me.didik.dailyquotes.model.random.RandomQuote;

/**
 * Created by didik on 05/10/17.
 */

interface MainView extends BaseView {
    void initSwipeRefresh();

    void initRecycler();

    void setToolbarBehaviour();

    void setQotd(Quote quote);

    void updateRecycler(List<RandomQuote> list);
}
