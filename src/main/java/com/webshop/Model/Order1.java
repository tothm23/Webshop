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
@Table(name = "order")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByUserId", query = "SELECT o FROM Order1 o WHERE o.userId = :userId"),
    @NamedQuery(name = "Order1.findByDate", query = "SELECT o FROM Order1 o WHERE o.date = :date"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findByTotalAmount", query = "SELECT o FROM Order1 o WHERE o.totalAmount = :totalAmount"),
    @NamedQuery(name = "Order1.findByAddresId", query = "SELECT o FROM Order1 o WHERE o.addresId = :addresId"),
    @NamedQuery(name = "Order1.findByChange", query = "SELECT o FROM Order1 o WHERE o.change = :change"),
    @NamedQuery(name = "Order1.findByChangeDate", query = "SELECT o FROM Order1 o WHERE o.changeDate = :changeDate"),
    @NamedQuery(name = "Order1.findByCouponId", query = "SELECT o FROM Order1 o WHERE o.couponId = :couponId")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 16)
    @Column(name = "status")
    private String status;
    @Column(name = "totalAmount")
    private Integer totalAmount;
    @Column(name = "addresId")
    private Integer addresId;
    @Size(max = 100)
    @Column(name = "change")
    private String change;
    @Column(name = "changeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;
    @Column(name = "couponId")
    private Integer couponId;

    public Order1() {
    }

    public Order1(Integer id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getAddresId() {
        return addresId;
    }

    public void setAddresId(Integer addresId) {
        this.addresId = addresId;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webshop.Order1[ id=" + id + " ]";
    }
    
}
