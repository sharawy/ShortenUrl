
package com.shortenUrl.controllers;

import com.shortenUrl.models.UrlModel;
import com.shortenUrl.services.UrlService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author abdalrahman.sharawy
 */
@Controller

public class UrlShortenController {

    @Autowired
    public UrlService urlService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        List<UrlModel> urls = urlService.findAllUrls();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("urlModel", new UrlModel());
        modelAndView.addObject("urls", urls);

        return modelAndView;
    }

    

    @RequestMapping(value = "/{shortCode}", method = RequestMethod.GET)
    public String serveUrl(@PathVariable("shortCode") String ShortCode) {
        UrlModel urlModel = urlService.findUrlModelByShortCode(ShortCode);
        Integer visitors = urlModel.getVisitorsNumber() !=null ? urlModel.getVisitorsNumber()+1 : 1 ;
        urlModel.setVisitorsNumber( visitors );
        urlService.save(urlModel);
        return "redirect:" + urlModel.getUrl();
    }
}
