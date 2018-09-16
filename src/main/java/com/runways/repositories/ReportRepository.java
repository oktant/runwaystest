package com.runways.repositories;

import com.runways.model.ReportTypeHighestAirportDaoAndTheLowest;

import com.runways.model.ReportTypeOfRunways;
import com.runways.model.RunwayIdent;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository for Reporting
 * @author oalizada
 */
@Repository
public interface ReportRepository {
     List<ReportTypeHighestAirportDaoAndTheLowest> getReportTypeHighestAirportDao();
    List<ReportTypeHighestAirportDaoAndTheLowest> getReportTypeLowestAirportDao();
    List<ReportTypeOfRunways> getReportTypeOfRunways();
    List<RunwayIdent> getRunwayIdent();

}
