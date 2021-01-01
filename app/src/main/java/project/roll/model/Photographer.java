package project.roll.model;

public class Photographer {
  private int id;
  private String name;
  private String imgUrl;

  public Photographer(int id, String name, String imgUrl) {
    this.id = id;
    this.name = name;
    this.imgUrl = imgUrl;
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

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  @Override
  public String toString() {
    return "Photographer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", imgUrl='" + imgUrl + '\'' +
            '}';
  }
}
