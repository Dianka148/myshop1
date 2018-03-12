package ua.com.dribnichki.entity;


import javax.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Product product;
    private String pathToPhoto;

    public Photo(Product product) {
        this.product = product;
    }

    public Photo() {
    }

    public Photo(Product product, String pathToPhoto) {
        this.product = product;
        this.pathToPhoto = pathToPhoto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", pathToPhoto='" + pathToPhoto + '\'' +
                '}';
    }
}
