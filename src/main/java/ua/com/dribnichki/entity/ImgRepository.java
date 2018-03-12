package ua.com.dribnichki.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImgRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pathToImg;


    @Override
    public String toString() {
        return "ImgRepository{" +
                "id=" + id +
                ", pathToImg='" + pathToImg + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPathToImg() {
        return pathToImg;
    }

    public void setPathToImg(String pathToImg) {
        this.pathToImg = pathToImg;
    }

    public ImgRepository() {
    }

    public ImgRepository(String pathToImg) {
        this.pathToImg = pathToImg;
    }
}
