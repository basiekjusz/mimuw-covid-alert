package com.basiekjusz.MimuwCovidAlert.dto;

import com.basiekjusz.MimuwCovidAlert.entity.report.TotalInfectionStats;
import com.basiekjusz.MimuwCovidAlert.entity.report.CovidDailyReport;
import com.basiekjusz.MimuwCovidAlert.entity.report.TodayInfectionStats;

public class CovidDailyReportDto {
  String reportDate;
  int infections;
  int deaths;
  int totalInfections;
  int totalDeaths;
  int totalRecovered;

  public CovidDailyReportDto(CovidDailyReport covidDailyReport) {
    TotalInfectionStats totalInfectionStats = covidDailyReport.getGeneral();
    TodayInfectionStats todayInfectionStats = covidDailyReport.getToday();

    this.reportDate = covidDailyReport.getReportDate();
    this.totalInfections = totalInfectionStats.getInfections();
    this.totalDeaths = totalInfectionStats.getDeaths();
    this.totalRecovered = totalInfectionStats.getRecovered();
    this.infections = todayInfectionStats.getNewInfections();
    this.deaths = todayInfectionStats.getNewDeaths();
  }

  public String getReportDate() {
    return reportDate;
  }

  public int getInfections() {
    return infections;
  }

  public int getDeaths() {
    return deaths;
  }

  public int getTotalDeaths() {
    return totalDeaths;
  }

  public int getTotalInfections() {
    return totalInfections;
  }

  public int getTotalRecovered() {
    return totalRecovered;
  }
}
