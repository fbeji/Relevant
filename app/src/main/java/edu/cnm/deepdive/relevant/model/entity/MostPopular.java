package edu.cnm.deepdive.relevant.model.entity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.cnm.deepdive.relevant.model.entity.MostPopular.Result.MediaMetadata;
import java.util.Date;


public class MostPopular extends ViewHolder {

  @Expose
  private String status;

  @Expose
  private String copyright;

  @Expose
  private Result[] results;

  @Expose
  private MediaMetadata mediametadata;

  public MostPopular(@NonNull View itemView) {
    super(itemView);
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public Result[] getResults() {
    return results;
  }

  public void setResults(Result[] results) {
    this.results = results;
  }

  public static class Result {


    @Expose
    @SerializedName("url")
    private String webUrl;

    @Expose
    private String adx_keywords;

    @Expose
    @SerializedName("abstract")
    private String leadParagraph;

    @Expose
    private String title;

//    @Expose
//    private Abstract abstract;

    @Expose
    @SerializedName("published_date")
    private Date publicationDate;

    public String getWebUrl() {
      return webUrl;
    }

    public void setWebUrl(String webUrl) {
      this.webUrl = webUrl;
    }

    public String getAdx_keywords() {
      return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
      this.adx_keywords = adx_keywords;
    }

    public String getLeadParagraph() {
      return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
      this.leadParagraph = leadParagraph;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public Date getPublicationDate() {
      return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
      this.publicationDate = publicationDate;
    }


    public static class MediaMetadata {

      @Expose
      @SerializedName("url")
      private String Url;

      public String getUrl() {
        return Url;
      }

      public void setUrl(String url) {
        Url = url;
      }
    }
  }
}
