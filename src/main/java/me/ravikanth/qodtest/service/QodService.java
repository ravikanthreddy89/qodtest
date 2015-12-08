package me.ravikanth.qodtest.service;

import me.ravikanth.qodtest.resource.Quote;
import me.ravikanth.qodtest.resource.QuoteManager;
import me.ravikanth.qodtest.resource.QuoteManagerImpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by ragudipati on 11/30/15.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/quote")
public class QodService {
    // The Java method will process HTTP GET requests
    @GET
    @Path("/getTest")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World from qodtest";
    }


    @GET
    @Produces("application/json")
    public Quote getQuote(){
        Quote ret = null;
        QuoteManager quoteManager = new QuoteManagerImpl();
        ret = quoteManager.getQuote();
        return  ret;
    }

    @POST
    @Produces("application/json")
    public Quote postTest(Quote quote){
        Quote ret = null;
        for(String key : quote.getFields().keySet()){
            System.out.println(key + ":"+quote.getFields().get(key));
        }
        QuoteManager quoteManager = new QuoteManagerImpl();
        ret = quoteManager.postQuote(quote);
        return ret;
    }
}
