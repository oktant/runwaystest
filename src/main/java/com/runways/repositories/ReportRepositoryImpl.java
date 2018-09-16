package com.runways.repositories;

import com.runways.model.ReportTypeHighestAirportDaoAndTheLowest;
import com.runways.model.ReportTypeOfRunways;
import com.runways.model.RunwayIdent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

/**
 * Repository for Reporting
 * @author oalizada
 */
@Repository
public class ReportRepositoryImpl implements ReportRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * Method which getting the Highest Number of airports per country and returns the list of Objects of Type DAO of
     * ReportTypeHighestAirportDaoAndTheLowest
     * @return List<ReportTypeHighestAirportDaoAndTheLowest>
     */

    @Override
    public List<ReportTypeHighestAirportDaoAndTheLowest> getReportTypeHighestAirportDao() {
        return jdbcTemplate.query("select c.code ccode, c.name cname, count(*) count from " +
                        "lunatech.countries c  inner join lunatech.airports a \n" +
                        "on c.code=a.iso_country group by ccode, cname order by count desc limit 10",
                new ReportTypeHighestAirportDaoAndTheLowestMapper());

    }
    /**
     *
     * Method which getting the Lowest Number of airports per country and returns the list of Objects of Type DAO of
     * ReportTypeHighestAirportDaoAndTheLowest
     * @return List<ReportTypeHighestAirportDaoAndTheLowest>
     */
    @Override
    public List<ReportTypeHighestAirportDaoAndTheLowest> getReportTypeLowestAirportDao() {
        return jdbcTemplate.query("select c.code ccode, c.name cname, count(*) count from lunatech.countries c  inner join lunatech.airports a\n" +
                        "                on c.code=a.iso_country group by ccode, cname order by count, cname limit 10",
                new ReportTypeHighestAirportDaoAndTheLowestMapper());
    }
    /**
     *
     * Method which getting the Type of runways per country and returns the list of Objects of Type DAO of
     * ReportTypeOfRunways
     * @return List<ReportTypeOfRunways>
     */
    @Override
    public List<ReportTypeOfRunways> getReportTypeOfRunways() {
        return jdbcTemplate.query("select cr.code ccode, cr.name cname, rn.surface from lunatech.countries cr \n" +
                        "inner join lunatech.airports ai on cr.code=ai.iso_country inner join lunatech.runways rn on ai.id=rn.airport_ref \n" +
                        "where rn.surface<>'' group by rn.surface"
                , new RowMapper<ReportTypeOfRunways>() {
                    @Override
                    public ReportTypeOfRunways mapRow(ResultSet resultSet, int i) throws SQLException {
                        ReportTypeOfRunways rtr = new ReportTypeOfRunways();
                        rtr.setCountryCode(resultSet.getString("ccode"));
                        rtr.setCountryName(resultSet.getString("cname"));
                        rtr.setSurface(resultSet.getString("surface"));
                        return rtr;
                    }

                    });
                }

    /**
     *
     * Method which getting 10 most common runway identifications per country and returns the list of Objects of Type DAO of
     * RunwayIdent
     * @return List<RunwayIdent>
     */
    @Override
    public List<RunwayIdent> getRunwayIdent() {

          return jdbcTemplate.query("select rn.le_ident ident, count(*) cn from lunatech.runways rn group by ident " +
                  "order by cn desc limit 10",new RowMapper<RunwayIdent>() {
              @Override
              public RunwayIdent mapRow(ResultSet resultSet, int i) throws SQLException {
                  RunwayIdent rtr = new RunwayIdent();
                  rtr.setIdent(resultSet.getString("ident"));
                  rtr.setCount(resultSet.getInt("cn"));

                  return rtr;
              }

          });

    }


}

/**
 * class mapper for  the Highest and Lowest Number of airports per country
 * @author oalizada
 */
class ReportTypeHighestAirportDaoAndTheLowestMapper implements RowMapper {
    public ReportTypeHighestAirportDaoAndTheLowest mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReportTypeHighestAirportDaoAndTheLowest reportTypeHighestAirportDao = new ReportTypeHighestAirportDaoAndTheLowest();
        reportTypeHighestAirportDao.setCount(rs.getInt("count"));
        reportTypeHighestAirportDao.setCountryCode(rs.getString("ccode"));
        reportTypeHighestAirportDao.setCountryName(rs.getString("cname"));
        return reportTypeHighestAirportDao;
    }
}