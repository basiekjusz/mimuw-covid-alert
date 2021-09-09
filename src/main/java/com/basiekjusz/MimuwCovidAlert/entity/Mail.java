package com.basiekjusz.MimuwCovidAlert.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mail {
  @Id
  String mail;

  public Mail(String mail) {
    this.mail = mail;
  }

  public Mail() {
    super();
  }

  public String getMail() {
    return mail;
  }

  public String toString() {
    return mail;
  }
}
