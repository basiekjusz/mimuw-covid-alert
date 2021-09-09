package com.basiekjusz.MimuwCovidAlert.entity.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidDailyReport {
  String reportDate;
  TotalInfectionStats general;
  TodayInfectionStats today;

  public void setToday(TodayInfectionStats today) {
    this.today = today;
  }

  public TodayInfectionStats getToday() {
    return today;
  }

  public TotalInfectionStats getGeneral() {
    return general;
  }

  public void setGeneral(TotalInfectionStats general) {
    this.general = general;
  }

  public void setReportDate(String reportDate) {
    this.reportDate = reportDate;
  }

  public String getReportDate() {
    return reportDate;
  }

  @Override
  public String toString() {
    return reportDate;
  }
}
