

package com.shortenUrl.services;

import com.shortenUrl.models.UrlModel;
import com.shortenUrl.repositories.UrlRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdalrahman.sharawy
 */
@Service
public class UrlService {
    @Autowired
    UrlRepository urlRepository;
    
    public List<UrlModel> findAllUrls(){
       return  urlRepository.findAll();
    }
    public UrlModel save(UrlModel urlModel){
       return urlRepository.save(urlModel);
    }
    public UrlModel getOne(int id){
        return urlRepository.getOne(id);
    }
    public UrlModel findUrlModelByUrl(String url){
       return  urlRepository.findByUrl(url);
    }
    public UrlModel findUrlModelByShortCode(String shortCode){
       return  urlRepository.findByShortCode(shortCode);
    }
    
    
}
