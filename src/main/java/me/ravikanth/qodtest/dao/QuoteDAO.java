package me.ravikanth.qodtest.dao;

import me.ravikanth.qodtest.resource.Quote;

/**
 * Created by ragudipati on 11/30/15.
 */
public interface QuoteDAO {
    public Quote insert(Quote quote);
    public Quote getQuote();
}
