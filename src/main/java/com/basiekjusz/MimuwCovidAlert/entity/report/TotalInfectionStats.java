package com.basiekjusz.MimuwCovidAlert.entity.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalInfectionStats {
  int infections;
  int deaths;
  int recovered;

  public void setInfections(int infections) {
    this.infections = infections;
  }

  public int getInfections() {
    return infections;
  }

  public void setDeaths(int deaths) {
    this.deaths = deaths;
  }

  public int getDeaths() {
    return deaths;
  }

  public void setRecovered(int recovered) {
    this.recovered = recovered;
  }

  public int getRecovered() {
    return recovered;
  }
}