package com.rayeston.header;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

/**
 * Created by lirui on 2017/3/12.
 */
@Controller
public class TradeController {

    @RequestMapping(value = "/trades/one", method = RequestMethod.GET)
    public String handleAllTradesRequests(@RequestHeader("User-Agent") String userAgent, Model model) {
        model.addAttribute("msg", "all trades requests, User-Agent header: " + userAgent);
        return "my-page";
    }

    @RequestMapping(value = "/trades/two", method = RequestMethod.GET)
    public String handleRequestByFromHeader(@RequestHeader String From, Model model) {
        model.addAttribute("msg", "trade request by From header: " + From);
        return "my-page";
    }

    @RequestMapping(value = "/trades/three", method = RequestMethod.GET)
    public String handleRequestByTwoHeaders(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Accept-Language") String acceptLanguage, Model model) {
        model.addAttribute("msg", "Trade request by User-Agent and Accept headers : " + userAgent + ", " + acceptLanguage);
        return "my-page";
    }

    @RequestMapping(value = "/trades/four", method = RequestMethod.GET)
    public String handleRequestWithAllHeaders(@RequestHeader Map<String, String> headers, Model model) {
        model.addAttribute("msg", "Trade request with all headers " + headers);
        return "my-page";
    }

    @RequestMapping(value = "/trades/five", method = RequestMethod.GET)
    public String handleRequestWithAllHeaders(@RequestHeader HttpHeaders httpHeaders, Model model) {
        model.addAttribute("msg", "Trade request with all headers " + httpHeaders);
        return "my-page";
    }

    @RequestMapping(value = "/trades/trade/{tradeId}", method = RequestMethod.GET)
    public String handleRequestById(@PathVariable("tradeId") String tradeId, @RequestHeader("If-Modified-Since") Date date, Model model) {
        model.addAttribute("msg", "Trade request by trade id and If-Modified-Since : " + tradeId + ", " + date);
        return "my-page";
    }

    @RequestMapping(value = "/trades/exchangeRates", method = RequestMethod.GET)
    public String handleExchangeRatesRequest(@RequestHeader(value = "Accept", required = false) String acceptHeader, Model model) {
        model.addAttribute("msg", "exchange rates request. AcceptHeader: " + acceptHeader);
        return "my-page";
    }
}
