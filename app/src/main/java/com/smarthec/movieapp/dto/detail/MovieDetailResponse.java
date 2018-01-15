package com.smarthec.movieapp.dto.detail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class MovieDetailResponse{
  @SerializedName("original_language")
  @Expose
  private String originalLanguage;
  @SerializedName("imdb_id")
  @Expose
  private String imdbId;
  @SerializedName("video")
  @Expose
  private Boolean video;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("backdrop_path")
  @Expose
  private String backdropPath;
  @SerializedName("revenue")
  @Expose
  private Integer revenue;
  @SerializedName("genres")
  @Expose
  private List<Genres> genres;
  @SerializedName("popularity")
  @Expose
  private Integer popularity;
  @SerializedName("production_countries")
  @Expose
  private List<ProductionCountries> productionCountries;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("vote_count")
  @Expose
  private Integer voteCount;
  @SerializedName("budget")
  @Expose
  private Integer budget;
  @SerializedName("overview")
  @Expose
  private String overview;
  @SerializedName("original_title")
  @Expose
  private String originalTitle;
  @SerializedName("runtime")
  @Expose
  private Integer runtime;
  @SerializedName("poster_path")
  @Expose
  private String posterPath;
  @SerializedName("spoken_languages")
  @Expose
  private List<SpokenLanguages> spokenLanguages;
  @SerializedName("production_companies")
  @Expose
  private List<ProductionCompanies> productionCompanies;
  @SerializedName("release_date")
  @Expose
  private String releaseDate;
  @SerializedName("vote_average")
  @Expose
  private Integer voteAverage;
  @SerializedName("belongs_to_collection")
  @Expose
  private BelongsToCollection belongsToCollection;
  @SerializedName("tagline")
  @Expose
  private String tagline;
  @SerializedName("adult")
  @Expose
  private Boolean adult;
  @SerializedName("homepage")
  @Expose
  private String homepage;
  @SerializedName("status")
  @Expose
  private String status;

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public List<ProductionCountries> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountries> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<SpokenLanguages> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguages> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public List<ProductionCompanies> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompanies> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}