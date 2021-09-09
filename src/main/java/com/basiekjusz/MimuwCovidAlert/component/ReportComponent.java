package com.basiekjusz.MimuwCovidAlert.component;

import com.basiekjusz.MimuwCovidAlert.dto.CovidDailyReportDto;
import com.basiekjusz.MimuwCovidAlert.service.AlertSenderService;
import com.basiekjusz.MimuwCovidAlert.service.CovidReportService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportComponent {
  CovidReportService covidReportService;
  AlertSenderService alertSenderService;

  public ReportComponent(AlertSenderService alertSenderService, CovidReportService covidReportService) {
    this.alertSenderService = alertSenderService;
    this.covidReportService = covidReportService;
  }

  @Scheduled(cron = "45 5 16 * * *")
  public void sendDailyReport() {
    CovidDailyReportDto covidDailyReportDto = covidReportService.getDailyReport();
    alertSenderService.sendDailyAlert(covidDailyReportDto);
  }
}
