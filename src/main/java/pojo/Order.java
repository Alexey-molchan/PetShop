package pojo;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_items")
    private Long idItems;

    @Column(name = "order_status")
    private Integer orerStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_items", insertable = false, updatable = false)
    private Items items;

    public Order() {
    }

    public Order(Long idUser, Long idItems, Integer orderStatus) {
        this.idUser = idUser;
        this.idItems = idItems;
        this.orerStatus = orderStatus;
    }

    public Order(Long idUser, Long idItems) {
        this.idUser = idUser;
        this.idItems = idItems;
        this.orerStatus = 1;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdItems() {
        return idItems;
    }

    public void setIdItems(Long idItems) {
        this.idItems = idItems;
    }

    public Integer getStatus() {
        return orerStatus;
    }

    public void setStatus(Integer orerStatus) {
        this.orerStatus = orerStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idItems=" + idItems +
                ", orderStatus='" + orerStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (getIdOrder() != null ? !getIdOrder().equals(order.getIdOrder()) : order.getIdOrder() != null)
            return false;
        if (getIdUser() != null ? !getIdUser().equals(order.getIdUser()) : order.getIdUser() != null) return false;
        if (getIdItems() != null ? !getIdItems().equals(order.getIdItems()) : order.getIdItems() != null)
            return false;
        return getStatus() != null ? getStatus().equals(order.getStatus()) : order.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdOrder() != null ? getIdOrder().hashCode() : 0;
        result = 31 * result + (getIdUser() != null ? getIdUser().hashCode() : 0);
        result = 31 * result + (getIdItems() != null ? getIdItems().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
}