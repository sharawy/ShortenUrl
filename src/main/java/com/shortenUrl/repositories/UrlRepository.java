

package com.shortenUrl.repositories;

import com.shortenUrl.models.UrlModel;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdalrahman.sharawy
 */
@Repository("UrlRepository")
public interface UrlRepository extends HibernateRepository<UrlModel, Integer> {
   public UrlModel findByUrl(String url);
   public UrlModel findByShortCode(String code);
}
