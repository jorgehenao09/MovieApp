package com.smarthec.movieapp.dto.detail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class BelongsToCollection {
  @SerializedName("backdrop_path")
  @Expose
  private Object backdrop_path;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("poster_path")
  @Expose
  private Object poster_path;
  public void setBackdrop_path(Object backdrop_path){
   this.backdrop_path=backdrop_path;
  }
  public Object getBackdrop_path(){
   return backdrop_path;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setId(Integer id){
   this.id=id;
  }
  public Integer getId(){
   return id;
  }
  public void setPoster_path(Object poster_path){
   this.poster_path=poster_path;
  }
  public Object getPoster_path(){
   return poster_path;
  }
}