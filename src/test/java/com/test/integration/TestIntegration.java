package com.test.integration;

import com.runways.RunwaysRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * TestIntegration class for integration testing
 * @author oalizada
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RunwaysRunner.class)
@AutoConfigureMockMvc
public class TestIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkReportPage() throws Exception {
        this.mockMvc.perform(get("/report")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void checkQueryPage() throws Exception {
        this.mockMvc.perform(get("/query")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void checkIndexPage() throws Exception {
        this.mockMvc.perform(get("/index")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void checkReportPageTypeHighest() throws Exception {
        this.mockMvc.perform(get("/getReport?type=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/templates/reportHighest.jsp")).
                andExpect(model().attribute("had", hasSize(10)));

    }
    @Test
    public void checkReportPageTypeLowest() throws Exception {
        this.mockMvc.perform(get("/getReport?type=2")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/templates/reportLowest.jsp")).
                andExpect(model().attribute("lad", hasSize(10)));

    }
    @Test
    public void checkReportPage10MostCommonLeIdent() throws Exception {
        this.mockMvc.perform(get("/getReport?type=4")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/templates/reportRunwayIdent.jsp")).
                andExpect(model().attribute("ri", hasSize(10)));

    }
    @Test
    public void checkReportPageTypeOfRunways() throws Exception {
        this.mockMvc.perform(get("/getReport?type=3")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/templates/reportTypeOfRunways.jsp"));

    }
    @Test
    public void checkReportPageNotAvailableReport() throws Exception {
        this.mockMvc.perform(get("/getReport?type=5")).andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/templates/errorReport.jsp"));

    }

    @Test
    public void checkReportPageCountryRequestNotEmpty() throws Exception {
        this.mockMvc.perform(get("/queryCountryRequest?countryNameOrCode=SA")).
                andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/templates/queryForCountryName.jsp"));

    }

    @Test
    public void checkReportPageCountryRequestEmpty() throws Exception {
        this.mockMvc.perform(get("/queryCountryRequest?countryNameOrCode=")).
                andDo(print()).andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/templates/errorQuery.jsp"));

    }
}