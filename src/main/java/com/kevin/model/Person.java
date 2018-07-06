package com.kevin.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person
{

  private String firstName;
  private String lastName;
  private Gender gender;
  private LocalDate birthDate;


  public Person(Gender inGender, LocalDate inBirthDate,
                String inFirstName, String inLastName)
  {
    firstName = inFirstName;
    lastName = inLastName;
    gender =  inGender;
    birthDate = inBirthDate;
  }


  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String inFirstName)
  {
    firstName = inFirstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String inLastName)
  {
    lastName = inLastName;
  }

  public long getAge(){

    return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
  }


  public long getDaysOld()
  {
    return ChronoUnit.DAYS.between(birthDate, LocalDate.now());
  }


  public boolean isMale()
  {
    return gender.equals(Gender.MALE);
  }
  public boolean isAdult() {
    long age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
  //  Duration age = Duration.between(birthDate, LocalDate.now());
  //  Duration adult = Duration.of(18, ChronoUnit.YEARS);
    return age >= 18;
  }
}

