package me.didik.dailyquotes.app.network;

import java.util.List;

import io.reactivex.Observable;
import me.didik.dailyquotes.model.qotd.QotdResponse;
import me.didik.dailyquotes.model.random.RandomQuote;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

/**
 * Created by didik on 05/10/17.
 */

public interface Api {
    @GET("qod.json")
    Observable<QotdResponse> getQotd();

    @Headers({
            "X-Mashape-Key:x3ePdmkSbimshqx8Hym5BzzH3miop1cdmuQjsn9Avc0zk6XJ30",
            "Accept:application/json"
    })
    @GET
    Observable<List<RandomQuote>> getRandomQuotes(@Url String url);
}
