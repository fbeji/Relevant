package edu.cnm.deepdive.relevant.model.entity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class SearchResponse extends ViewHolder {

  @Expose
  private String status;

  @Expose
  private String copyright;

  @Expose
  private Response response;

  public SearchResponse(@NonNull View itemView) {
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

  public Response getResponse() {
    return response;
  }

  public void setResponse(Response response) {
    this.response = response;
  }

  public static class Response {

    @Expose
    private Document[] docs;

    @Expose
    private Meta meta;

    public Document[] getDocs() {
      return docs;
    }

    public void setDocs(Document[] docs) {
      this.docs = docs;
    }

    public Meta getMeta() {
      return meta;
    }

    public void setMeta(Meta meta) {
      this.meta = meta;
    }

  }

  public static class Meta {

    @Expose
    private int hits;

    @Expose
    private int offset;

    @Expose
    private int time;

    public int getHits() {
      return hits;
    }

    public void setHits(int hits) {
      this.hits = hits;
    }

    public int getOffset() {
      return offset;
    }

    public void setOffset(int offset) {
      this.offset = offset;
    }

    public int getTime() {
      return time;
    }

    public void setTime(int time) {
      this.time = time;
    }

  }

  public static class Document {

    @Expose
    @SerializedName("web_url")
    private String webUrl;

    @Expose
    private String snippet;

    @Expose
    @SerializedName("lead_paragraph")
    private String leadParagraph;

    @Expose
    private Headline headline;

    @Expose
    @SerializedName("pub_date")
    private Date publicationDate;

    public String getWebUrl() {
      return webUrl;
    }

    public void setWebUrl(String webUrl) {
      this.webUrl = webUrl;
    }

    public String getSnippet() {
      return snippet;
    }

    public void setSnippet(String snippet) {
      this.snippet = snippet;
    }

    public String getLeadParagraph() {
      return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
      this.leadParagraph = leadParagraph;
    }

    public Headline getHeadline() {
      return headline;
    }

    public void setHeadline(Headline headline) {
      this.headline = headline;
    }

    public Date getPublicationDate() {
      return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
      this.publicationDate = publicationDate;
    }

  }

  public static class Headline {

    @Expose
    private String main;

    @Expose
    @SerializedName("print_headline")
    private String print;

    public String getMain() {
      return main;
    }

    public void setMain(String main) {
      this.main = main;
    }

    public String getPrint() {
      return print;
    }

    public void setPrint(String print) {
      this.print = print;
    }
  }

}
