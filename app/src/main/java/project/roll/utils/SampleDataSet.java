package project.roll.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import project.roll.model.Photographer;

public class SampleDataSet {

  private static SampleDataSet instance;

  private static ArrayList<Photographer> allPhotographers;

  private SampleDataSet() {
    if (null == allPhotographers){
      allPhotographers = new ArrayList<>();
      initData();
    }
  }

  private void initData() {
    String[] sampleBestCapture1 = {
            "https://www.visitnewportbeach.com/wp-content/uploads/2018/04/pelican-courtyard-couple-700x400.jpg",
            "https://cdn.mhphoto.ie/wp-content/uploads/2019/03/088_ireland_bride_photography_groom_and_wedding-700x400.jpg"
    };
    String[] sampleBestCapture2 = {
            "https://cdn.mhphoto.ie/wp-content/uploads/2020/06/118_wedding_bride_photography_groom_and_portraits-700x400.jpg",
            "https://swanstudio.co.uk/images/layout/wedding-photography-london.jpg"
    };
    String[] sampleBestCapture3 = {
            "https://cdn.mhphoto.ie/wp-content/uploads/2020/02/106_house_wedding_photographer_ireland_ashley_park-700x400.jpg",
            "https://www.butler.ie/cmsListings/59693/5f4e7518e9949.jpg"
    };
    allPhotographers.add(new Photographer(
            1,
            "Dasya",
            "https://images.squarespace-cdn.com/content/v1/58febac49f7456d3c6db76d2/1502494345038-U5EHTN6D3RR91MCK0RNW/ke17ZwdGBToddI8pDm48kNO2SymwcR0CNt03aX8zdCd7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QHyNOqBUUEtDDsRWrJLTmyh-8_5GJNvrfz4o4yOfLS6zQbzUiTKHw9oGJVKerm66NTpMeMsHjVpXC93GFBavO/image-asset.jpeg",
            sampleBestCapture1,
            "4.5",
            "Bandung",
            "Rp. 250.000 / Hour",
            "Prewedding",
            "Photographer",
            "Available"
    ));
    allPhotographers.add(new Photographer(
            2,
            "Dave",
            "https://images.squarespace-cdn.com/content/v1/59d55d412aeba54362e00bb1/1547328988541-D732YCKXID8578E23KGT/ke17ZwdGBToddI8pDm48kIB81VOvDNGxlwJI2ZLVYNF7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QHyNOqBUUEtDDsRWrJLTm1v6GcKqh6mrhfxzW2tqo7zqSP1_RWubdYwvOv9fJrXjTUsmG1v8Fm830lrrc_XKd/_DSC7599ashleebrookecrop.jpg",
            sampleBestCapture2,
            "4.8",
            "Jakarta",
            "Rp. 350.000 / Hour",
            "Prewedding, Wedding",
            "Photographer, Videographer",
            "Available"
    ));
    allPhotographers.add(new Photographer(
            3,
            "Ryuji",
            "https://images.squarespace-cdn.com/content/v1/58809eab1e5b6c46d95f3e72/1569484495705-ENC3OCQ0Z7025ZSFBBEC/ke17ZwdGBToddI8pDm48kM19vGfAY4CpRvzWg9j4Rs97gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1Ucs6qC7sr7nMoIk6RghKQ5zqaVLBrlbIpJKi9eKqHOg0LjA7Zh6OR0YZYaXtoY39jA/Ryuji+Photo+My+Tokyo+photographer+profile+japan+photo+session+01.jpg",
            sampleBestCapture3,
            "4.1",
            "Malang",
            "Rp. 150.000 / Hour",
            "Wedding",
            "Photographer",
            "Unavailable"
    ));
  }

  public static SampleDataSet getInstance() {
    if (null != instance){
      return instance;
    } else {
      instance = new SampleDataSet();
      return instance;
    }
  }

  public static ArrayList<Photographer> getAllPhotographers() {
    return allPhotographers;
  }

  public Photographer getPhotographerById(int id){
    for (Photographer p: allPhotographers){
      if (p.getId() == id){
        return p;
      }
    }

    return null;
  }
}
