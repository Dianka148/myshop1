package ua.com.dribnichki.entity;

import javax.persistence.*;

@Entity
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String optionName;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Product product;

    public ProductOption(Product product) {
        this.product = product;
    }

    //    public ProductOption(String optionName) {
//        this.optionName = optionName;
//    }

    public ProductOption(String optionName, Product product) {

        this.optionName = optionName;
        this.product = product;
    }

    @Override

    public String toString() {
        return "ProductOption{" +
                "id=" + id +
                ", option='" + optionName + '\'' +
                '}';
    }

    public ProductOption() {
    }

    public void addProduct(Product product) {
        //prevent endless loop
        if (this.getProduct().equals(product))
            return ;
        Product oldProduct = this.product;
        this.product = product;
        //remove from the old product
        if (oldProduct!=null)
            oldProduct.removeOption(this);
        if (product!=null)
            product.addOption(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String option) {
        this.optionName = option;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

