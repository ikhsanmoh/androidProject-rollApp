package project.roll.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Photographer {
  private int id;
  private String name;
  private String imgUrl;
  private String[] imgUrlBestCaptures;
  private String rating;
  private String domicilie;
  private String price;
  private String categories;
  private String profession;
  private String status;

  public Photographer(int id, String name, String imgUrl, String[] imgUrlBestCaptures, String rating, String domicilie, String price, String categories, String profession, String status) {
    this.id = id;
    this.name = name;
    this.imgUrl = imgUrl;
    this.imgUrlBestCaptures = imgUrlBestCaptures;
    this.rating = rating;
    this.domicilie = domicilie;
    this.price = price;
    this.categories = categories;
    this.profession = profession;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public String[] getImgUrlBestCaptures() {
    return imgUrlBestCaptures;
  }

  public String getDomicilie() {
    return domicilie;
  }

  public void setDomicilie(String domicilie) {
    this.domicilie = domicilie;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getCategories() {
    return categories;
  }

  public void setCategories(String categories) {
    this.categories = categories;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  @Override
  public String toString() {
    return "Photographer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", imgUrl='" + imgUrl + '\'' +
            ", imgUrlBestCaptures=" + Arrays.toString(imgUrlBestCaptures) +
            ", rating='" + rating + '\'' +
            ", domicilie='" + domicilie + '\'' +
            ", price='" + price + '\'' +
            ", categories='" + categories + '\'' +
            ", profession='" + profession + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
