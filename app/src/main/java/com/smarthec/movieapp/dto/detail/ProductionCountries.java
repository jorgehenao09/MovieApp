package com.smarthec.movieapp.dto.detail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class ProductionCountries {
  @SerializedName("iso_3166_1")
  @Expose
  private String iso_3166_1;
  @SerializedName("name")
  @Expose
  private String name;
  public void setIso_3166_1(String iso_3166_1){
   this.iso_3166_1=iso_3166_1;
  }
  public String getIso_3166_1(){
   return iso_3166_1;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
}