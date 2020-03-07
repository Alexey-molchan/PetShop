package pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_items")
    private Long idItems;

    @Column(name = "items_name")
    private String itemsName;

    @Column(name = "items_price")
    private Double itemsPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    @Column(name = "items_image")
    private String itemsImage;

    @OneToMany(mappedBy = "items")
    private List<Order> orders;

    public Items() {
    }

    public Items(String itemsName, Double itemsPrice, String description, String country, String itemsImage) {
        this.itemsName = itemsName;
        this.itemsPrice = itemsPrice;
        this.description = description;
        this.country = country;
        this.itemsImage = itemsImage;
    }

    public Long getIdItems() {
        return idItems;
    }

    public void setIdItems(Long idItems) {
        this.idItems = idItems;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public Double getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(Double itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemsImage() {
        return itemsImage;
    }

    public void setItemsImage(String itemsImage) {
        this.itemsImage = itemsImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Items items = (Items) o;

        if (idItems != null ? !idItems.equals(items.idItems) : items.idItems != null) return false;
        if (itemsName != null ? !itemsName.equals(items.itemsName) : items.itemsName != null) return false;
        if (itemsPrice != null ? !itemsPrice.equals(items.itemsPrice) : items.itemsPrice != null) return false;
        if (description != null ? !description.equals(items.description) : items.description != null) return false;
        if (country != null ? !country.equals(items.country) : items.country != null) return false;
        return itemsImage != null ? itemsImage.equals(items.itemsImage) : items.itemsImage == null;
    }

    @Override
    public int hashCode() {
        int result = idItems != null ? idItems.hashCode() : 0;
        result = 31 * result + (itemsName != null ? itemsName.hashCode() : 0);
        result = 31 * result + (itemsPrice != null ? itemsPrice.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (itemsImage != null ? itemsImage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Items{" +
                "idItems=" + idItems +
                ", itemsName='" + itemsName + '\'' +
                ", itemsPrice=" + itemsPrice +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", itemsImage='" + itemsImage + '\'' +
                '}';
    }
}