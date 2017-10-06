package me.didik.dailyquotes.feature.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.didik.dailyquotes.R;
import me.didik.dailyquotes.model.random.RandomQuote;

/**
 * Created by didik on 05/10/17.
 */

class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.MyHolder> {
    private List<RandomQuote> dataset;

    QuoteAdapter() {
        this.dataset = new ArrayList<>();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_quote, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.bind(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void updateList(List<RandomQuote> list) {
        if (list.size() != this.dataset.size() || !this.dataset.containsAll(list)) {
            this.dataset = list;
            notifyDataSetChanged();
        }
    }


    class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_quote) TextView tvQuote;
        @BindView(R.id.tv_author) TextView tvAuthor;

        MyHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(RandomQuote data){
            tvQuote.setText(data.getQuote());
            tvAuthor.setText(data.getAuthor());
        }
    }
}
