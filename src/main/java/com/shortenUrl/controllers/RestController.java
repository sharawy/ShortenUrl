
package com.shortenUrl.controllers;

import com.shortenUrl.common.ShortenUrlUtils;
import com.shortenUrl.models.UrlModel;
import com.shortenUrl.services.UrlService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author abdalrahman.sharawy
 */
@Controller
public class RestController {

    @Autowired
    public UrlService urlService;

    @RequestMapping(value = "/shortUrl", method = RequestMethod.POST,consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public
            ResponseEntity shortUrl(@RequestBody @Valid UrlModel urlModel, BindingResult result) {
        String msg = "Failed";
        JsonResponse jsonResponse = new JsonResponse();

        if (result.hasErrors()) {
            jsonResponse.setErrors(result.getFieldErrors());
        } else {
            //check url existindb
            ShortenUrlUtils utils = new ShortenUrlUtils();

            UrlModel existed = urlService.findUrlModelByUrl(urlModel.getUrl());
            if (existed == null) {
                //insert short url
                urlModel = urlService.save(urlModel);
                // generate short code
                urlModel.setShortCode(utils.generatShortCode(urlModel.getId()));
                urlModel = urlService.save(urlModel);
                msg = "Created";
            } else {
                urlModel = existed;
                msg = "Already Exist";
            }

            jsonResponse.setResult(urlModel);
        }

        jsonResponse.setMsg(msg);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

    }
            
  @RequestMapping(value = "/getShortedUrls", method = RequestMethod.GET)
    public ResponseEntity getUrlList() {
        String msg = "Failed";
        JsonResponse jsonResponse = new JsonResponse();
        List<UrlModel> urls = urlService.findAllUrls();
        if(urls != null)
            msg = "Success";
        
        jsonResponse.setMsg(msg);
        jsonResponse.setResult(urls);
        return new ResponseEntity(jsonResponse, HttpStatus.OK);
    }
}
