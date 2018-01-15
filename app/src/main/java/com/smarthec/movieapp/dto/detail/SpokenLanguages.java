package com.smarthec.movieapp.dto.detail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class SpokenLanguages {
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("iso_639_1")
  @Expose
  private String iso_639_1;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setIso_639_1(String iso_639_1){
   this.iso_639_1=iso_639_1;
  }
  public String getIso_639_1(){
   return iso_639_1;
  }
}