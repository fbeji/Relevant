/*
 *  Copyright 2019 Faycel B. Beji & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package edu.cnm.deepdive.relevant.model.entity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.cnm.deepdive.relevant.model.entity.MostPopular.Result.MediaMetadata;
import java.util.Date;


public class MostPopular extends ViewHolder {

  /**
   * Returns the status of this instance.
   *
   * @return Search status.
   */
  @Expose
  private String status;

  /**
   * Returns the copyright of this instance.
   *
   * @return Search copyright.
   */
  @Expose
  private String copyright;

  /**
   * Returns the search results of this instance.
   *
   * @return Search results.
   */
  @Expose
  private Result[] results;

  @Expose
  private MediaMetadata mediametadata;

  /**
   * Returns the Most popular search of this instance.
   */

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

    /**
     * Returns the URL of the media content of this instance.
     *
     * @return Search media content URL.
     */
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

    /**
     * Sets the published date of this instance. This method is invoked by Room and GSon after loading from the
     * database and JSON deserialization, respectively.
     *
     * @param published_date
     */

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
