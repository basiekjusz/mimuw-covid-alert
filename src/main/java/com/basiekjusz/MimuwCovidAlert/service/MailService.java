package com.basiekjusz.MimuwCovidAlert.service;

import java.util.List;

import com.basiekjusz.MimuwCovidAlert.entity.Mail;
import com.basiekjusz.MimuwCovidAlert.repository.MailRepository;

import org.springframework.stereotype.Service;

@Service
public class MailService {
  MailRepository mailRepository;

  public MailService(MailRepository mailRepository) {
    this.mailRepository = mailRepository;
  }

  public void save(String mail) {
    Mail mailEntity = new Mail(mail);
    mailRepository.save(mailEntity);
  }

  public void delete(String mail) {
    mailRepository.deleteById(mail);
  }

  public List<Mail> findAll() {
    return mailRepository.findAll();
  }
}