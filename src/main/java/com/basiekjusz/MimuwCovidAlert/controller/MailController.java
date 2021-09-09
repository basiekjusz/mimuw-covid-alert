package com.basiekjusz.MimuwCovidAlert.controller;

import java.util.List;

import com.basiekjusz.MimuwCovidAlert.entity.Mail;
import com.basiekjusz.MimuwCovidAlert.service.MailService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
  MailService mailService;

  public MailController(MailService mailService) {
    this.mailService = mailService;
  }

  @GetMapping("/add/{mail}")
  public void save(@PathVariable("mail") String mail) {
    mailService.save(mail);
  }

  @GetMapping("delete/{mail}")
  public void delete(@PathVariable("mail") String mail) {
    mailService.delete(mail);
  }

  @GetMapping()
  public List<Mail> findAll() {
    return mailService.findAll();
  }
}
