package com.runways.controller;


import com.mysql.jdbc.StringUtils;
import com.runways.exceptions.EmptyCodeOrNameException;
import com.runways.exceptions.NotCorrectReportException;
import com.runways.repositories.QueryRepository;
import com.runways.repositories.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Main Controller
 *
 * @author oalizada
 */
@Controller
public class CountryController {
    @Autowired
    QueryRepository queryRepository;
    @Autowired
    ReportRepository reportRepository;


    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index() {

        System.out.println("test");
        return "index";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query() {
        return "query";
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String report() {
        return "report";
    }

    @RequestMapping(value = "/getReport", method = RequestMethod.GET)

    public String getRequestType(ModelMap model, @RequestParam String type) {
        if (type != null && !type.isEmpty() && !type.equals("") && StringUtils.isStrictlyNumeric(type)) {

            if (type.equals("1")) {
                model.addAttribute("had", reportRepository.getReportTypeHighestAirportDao());
                return "reportHighest";
            } else if (type.equals("2")) {
                model.addAttribute("lad", reportRepository.getReportTypeLowestAirportDao());
                return "reportLowest";
            } else if (type.equals("3")) {
                model.addAttribute("tor", reportRepository.getReportTypeOfRunways());
                return "reportTypeOfRunways";
            } else if (type.equals("4")) {
                model.addAttribute("ri", reportRepository.getRunwayIdent());
                return "reportRunwayIdent";
            } else {

                throw new NotCorrectReportException();
            }
        }
        else {
            throw new NotCorrectReportException();
        }


    }


    @RequestMapping(value = "/queryCountryRequest", method = RequestMethod.GET)
    public String getQueryResult(ModelMap model, @RequestParam String countryNameOrCode) {

        if (countryNameOrCode != null && !countryNameOrCode.isEmpty() && !countryNameOrCode.equals("")) {
            model.addAttribute("cnoc", queryRepository.getQueryByCountryCodeOrName(countryNameOrCode));

            return "queryForCountryName";
        } else {
            throw new EmptyCodeOrNameException();
        }

    }
    @ExceptionHandler(value = NotCorrectReportException.class)
    public String getException() {
        return "errorReport";
    }

    @ExceptionHandler(value = EmptyCodeOrNameException.class)
    public String getEmptyException () {
        return "errorQuery";

    }
}

