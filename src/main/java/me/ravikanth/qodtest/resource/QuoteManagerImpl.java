package me.ravikanth.qodtest.resource;

import me.ravikanth.qodtest.dao.QuoteDAO;
import me.ravikanth.qodtest.dao.QuoteDAOImpl;

/**
 * Created by ragudipati on 11/30/15.
 */
public class QuoteManagerImpl implements QuoteManager {
    public Quote postQuote(Quote quote) {
        Quote ret = null;
        QuoteDAO quoteDAO = new QuoteDAOImpl();
        ret = quoteDAO.insert(quote);
        return ret;
    }

    public Quote getQuote() {
        Quote ret = null;
        QuoteDAO quoteDAO = new QuoteDAOImpl();
        ret = quoteDAO.getQuote();
        return  ret;
    }
}
