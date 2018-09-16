package com.runways.repositories;

import com.runways.exceptions.EmptyCodeOrNameException;
import com.runways.model.QueryTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Repository for Querying Countries
 * @author oalizada
 */
@Repository
public class QueryRepositoryImpl implements QueryRepository {
    private JdbcTemplate jdbcTemplate;
    public QueryRepositoryImpl(){

    }
    @Autowired
    public QueryRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public List<QueryTypeDao> getQueryByCountryCodeOrName(String codeOrName) {

        if(codeOrName!=null && !codeOrName.trim().isEmpty() && !codeOrName.trim().equals("")) {
            return jdbcTemplate.query("select upper(cr.code) ccode, upper(cr.name) cname, ai.type atype," +
                            "ai.latitude_deg lat_deg, ai.longitude_deg long_deg,\n" +
                            "ai.elevation_ft el_ft, ai.municipality mun, ai.name aname, rn.surface rsurface, rn.le_ident rIdent, \n" +
                            "rn.closed rclosed   from lunatech.countries cr \n" +
                            "inner join lunatech.airports ai on cr.code=ai.iso_country left join lunatech.runways rn on ai.id=rn.airport_ref \n" +
                            "where (cr.code=? || cr.name like ?) ",
                    new Object[]{codeOrName.toUpperCase(), codeOrName.toUpperCase() + "%"}, new RowMapper<QueryTypeDao>() {
                        @Override
                        public QueryTypeDao mapRow(ResultSet resultSet, int i) throws SQLException {
                            QueryTypeDao rtr = new QueryTypeDao();
                            rtr.setCountryCode(resultSet.getString("ccode"));
                            rtr.setCountryName(resultSet.getString("cname"));
                            rtr.setType(resultSet.getString("atype"));
                            rtr.setName(resultSet.getString("aname"));
                            rtr.setLatitude_deg(resultSet.getString("lat_deg"));
                            rtr.setLongitude_deg(resultSet.getString("long_deg"));
                            rtr.setElevation(resultSet.getString("el_ft"));
                            rtr.setMunicipality(resultSet.getString("mun"));
                            rtr.setSurface(resultSet.getString("rsurface"));
                            rtr.setLe_ident(resultSet.getString("rident"));
                            rtr.setClosed(resultSet.getString("rclosed"));
                            return rtr;
                        }

                    });
        }
        else{
            throw new EmptyCodeOrNameException();
        }
    }

}



