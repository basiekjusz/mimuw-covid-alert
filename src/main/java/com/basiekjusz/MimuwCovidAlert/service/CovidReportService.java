package com.basiekjusz.MimuwCovidAlert.service;

import com.basiekjusz.MimuwCovidAlert.dto.CovidDailyReportDto;
import com.basiekjusz.MimuwCovidAlert.entity.report.CovidDailyReport;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CovidReportService {
  public CovidDailyReportDto getDailyReport() {
    RestTemplate restTemplate = new RestTemplate();
    String apiUrl = "https://koronawirus-api.herokuapp.com/api/covid19/daily";

    CovidDailyReport covidDailyReport = restTemplate.getForObject(apiUrl, CovidDailyReport.class);
    CovidDailyReportDto covidDailyReportDto = new CovidDailyReportDto(covidDailyReport);

    return covidDailyReportDto;
  }
}
