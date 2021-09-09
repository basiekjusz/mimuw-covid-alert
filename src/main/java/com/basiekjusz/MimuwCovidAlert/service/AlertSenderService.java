package com.basiekjusz.MimuwCovidAlert.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.basiekjusz.MimuwCovidAlert.dto.CovidDailyReportDto;
import com.basiekjusz.MimuwCovidAlert.entity.Mail;
import com.basiekjusz.MimuwCovidAlert.repository.MailRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AlertSenderService {
  MailRepository mailRepository;
  JavaMailSender javaMailSender;

  public AlertSenderService(MailRepository mailRepository, JavaMailSender javaMailSender) {
    this.mailRepository = mailRepository;
    this.javaMailSender = javaMailSender;
  }

  public void sendDailyAlert(CovidDailyReportDto covidDailyReportDto) {
    try {
      String[] stringMails = getMails();

      SimpleMailMessage message = new SimpleMailMessage();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String date = dateFormat.format(new Date());

      message.setFrom("noreply@covid-alert.mimuw.edu.pl");
      message.setBcc(stringMails);
      message.setSubject("Alert covidowy - " + date);

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Statystyki dzisiaj (").append(date).append(")");
      stringBuilder.append("\nZakażenia: ").append(covidDailyReportDto.getInfections());
      stringBuilder.append("\nZgony: ").append(covidDailyReportDto.getDeaths());
      stringBuilder.append("\n\nStatystyki od początku pandemii");
      stringBuilder.append("\nZakażenia: ").append(covidDailyReportDto.getTotalInfections());
      stringBuilder.append("\nZgony: ").append(covidDailyReportDto.getTotalDeaths());
      stringBuilder.append("\nWyzdrowienia: ").append(covidDailyReportDto.getTotalRecovered());

      message.setText(stringBuilder.toString());

      javaMailSender.send(message);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public String[] getMails() {
    List<Mail> mails = mailRepository.findAll();
    ArrayList<String> stringMails = new ArrayList<String>();
    for (Mail mail : mails) {
      stringMails.add(mail.getMail());
    }
    return stringMails.toArray(String[]::new);
  }
}
