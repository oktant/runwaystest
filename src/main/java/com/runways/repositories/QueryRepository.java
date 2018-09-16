package com.runways.repositories;

import com.runways.model.QueryTypeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Querying Countries
 * @author oalizada
 */


@Repository
public interface QueryRepository  {
    List<QueryTypeDao> getQueryByCountryCodeOrName(String codeOrName);


}
