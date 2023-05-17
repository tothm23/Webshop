/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webshop.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author tothm23
 */
@Entity
@Table(name = "basket")
@NamedQueries({
    @NamedQuery(name = "Basket.findAll", query = "SELECT b FROM Basket b"),
    @NamedQuery(name = "Basket.findById", query = "SELECT b FROM Basket b WHERE b.id = :id"),
    @NamedQuery(name = "Basket.findByUserId", query = "SELECT b FROM Basket b WHERE b.userId = :userId"),
    @NamedQuery(name = "Basket.findByProductId", query = "SELECT b FROM Basket b WHERE b.productId = :productId"),
    @NamedQuery(name = "Basket.findByAmount", query = "SELECT b FROM Basket b WHERE b.amount = :amount"),
    @NamedQuery(name = "Basket.findByUpdatedAt", query = "SELECT b FROM Basket b WHERE b.updatedAt = :updatedAt"),
    @NamedQuery(name = "Basket.findByStatus", query = "SELECT b FROM Basket b WHERE b.status = :status"),
    @NamedQuery(name = "Basket.findByDeletedAt", query = "SELECT b FROM Basket b WHERE b.deletedAt = :deletedAt")})
public class Basket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Size(max = 8)
    @Column(name = "status")
    private String status;
    @Column(name = "deletedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public Basket() {
    }

    public Basket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
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
        if (!(object instanceof Basket)) {
            return false;
        }
        Basket other = (Basket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webshop.Basket[ id=" + id + " ]";
    }
    
}
