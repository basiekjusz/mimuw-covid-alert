package com.basiekjusz.MimuwCovidAlert.repository;

import java.util.List;

import com.basiekjusz.MimuwCovidAlert.entity.Mail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, String> {
  public List<Mail> findAll();
}
