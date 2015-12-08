package me.ravikanth.qodtest.resource;

import me.ravikanth.qodtest.resource.Quote;

/**
 * Created by ragudipati on 11/28/15.
 */
public interface QuoteManager {
    public Quote postQuote(Quote quote);
    public Quote getQuote();
}
