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
@Table(name = "coupon")
@NamedQueries({
    @NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c"),
    @NamedQuery(name = "Coupon.findById", query = "SELECT c FROM Coupon c WHERE c.id = :id"),
    @NamedQuery(name = "Coupon.findByCouponCode", query = "SELECT c FROM Coupon c WHERE c.couponCode = :couponCode"),
    @NamedQuery(name = "Coupon.findByCreatedAt", query = "SELECT c FROM Coupon c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Coupon.findByExpiredAt", query = "SELECT c FROM Coupon c WHERE c.expiredAt = :expiredAt"),
    @NamedQuery(name = "Coupon.findByStatus", query = "SELECT c FROM Coupon c WHERE c.status = :status")})
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "couponCode")
    private String couponCode;
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "expiredAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredAt;
    @Column(name = "status")
    private Boolean status;

    public Coupon() {
    }

    public Coupon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        if (!(object instanceof Coupon)) {
            return false;
        }
        Coupon other = (Coupon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webshop.Coupon[ id=" + id + " ]";
    }
    
}
