package com.basiekjusz.MimuwCovidAlert.entity.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodayInfectionStats {
  int newInfections;
  int newDeaths;

  public void setNewInfections(int newInfections) {
    this.newInfections = newInfections;
  }

  public int getNewInfections() {
    return newInfections;
  }

  public void setNewDeaths(int newDeaths) {
    this.newDeaths = newDeaths;
  }

  public int getNewDeaths() {
    return newDeaths;
  }
}
