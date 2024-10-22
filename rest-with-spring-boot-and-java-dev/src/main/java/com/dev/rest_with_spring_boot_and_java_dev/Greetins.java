package com.dev.rest_with_spring_boot_and_java_dev;

public class Greetins {
  private final long id;
  private final String content;

  public Greetins(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId(){
    return id;
  }

  public String getContent(){
    return content;
  }
}
