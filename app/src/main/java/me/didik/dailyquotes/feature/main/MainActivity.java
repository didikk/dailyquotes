package me.didik.dailyquotes.feature.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import me.didik.dailyquotes.R;
import me.didik.dailyquotes.app.GlideApp;
import me.didik.dailyquotes.model.qotd.Quote;
import me.didik.dailyquotes.model.random.RandomQuote;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.tv_quote) TextView tvQuote;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.toolbar_layout) CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar) AppBarLayout appBar;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.iv_background) ImageView ivBackground;
    @BindView(R.id.tv_author) TextView tvAuthor;

    @Inject MainPresenter presenter;

    private QuoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }

        initSwipeRefresh();
        initRecycler();
        setToolbarBehaviour();

        presenter.attachView(this);
        swipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                presenter.getQuotes();
            }
        });
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @OnClick(R.id.fab)
    public void onViewClicked(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean isLoadingShown() {
        return swipeRefresh.isRefreshing();
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initSwipeRefresh() {
        swipeRefresh.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getQuotes();
            }
        });
    }

    @Override
    public void initRecycler() {
        adapter = new QuoteAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setToolbarBehaviour() {
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    toolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void setQotd(Quote quote) {
        GlideApp.with(this)
                .load(quote.getBackground())
                .centerCrop()
                .dontAnimate()
                .into(ivBackground);

        tvQuote.setText(String.format("\"%s\"", quote.getQuote()));
        tvAuthor.setText(String.format("-- %s", quote.getAuthor()));
    }

    @Override
    public void updateRecycler(List<RandomQuote> list) {
        adapter.updateList(list);
    }
}
