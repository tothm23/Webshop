/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webshop.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tothm23
 */
@Entity
@Table(name = "orderedproducts")
@NamedQueries({
    @NamedQuery(name = "Orderedproducts.findAll", query = "SELECT o FROM Orderedproducts o"),
    @NamedQuery(name = "Orderedproducts.findById", query = "SELECT o FROM Orderedproducts o WHERE o.id = :id"),
    @NamedQuery(name = "Orderedproducts.findByProductId", query = "SELECT o FROM Orderedproducts o WHERE o.productId = :productId"),
    @NamedQuery(name = "Orderedproducts.findByProductStock", query = "SELECT o FROM Orderedproducts o WHERE o.productStock = :productStock"),
    @NamedQuery(name = "Orderedproducts.findByOrderId", query = "SELECT o FROM Orderedproducts o WHERE o.orderId = :orderId")})
public class Orderedproducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "productStock")
    private Integer productStock;
    @Column(name = "orderId")
    private Integer orderId;

    public Orderedproducts() {
    }

    public Orderedproducts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderedproducts)) {
            return false;
        }
        Orderedproducts other = (Orderedproducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webshop.Orderedproducts[ id=" + id + " ]";
    }
    
}
