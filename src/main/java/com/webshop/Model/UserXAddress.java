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
@Table(name = "user_x_address")
@NamedQueries({
    @NamedQuery(name = "UserXAddress.findAll", query = "SELECT u FROM UserXAddress u"),
    @NamedQuery(name = "UserXAddress.findById", query = "SELECT u FROM UserXAddress u WHERE u.id = :id"),
    @NamedQuery(name = "UserXAddress.findByUserId", query = "SELECT u FROM UserXAddress u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserXAddress.findByAddressId", query = "SELECT u FROM UserXAddress u WHERE u.addressId = :addressId"),
    @NamedQuery(name = "UserXAddress.findByType", query = "SELECT u FROM UserXAddress u WHERE u.type = :type"),
    @NamedQuery(name = "UserXAddress.findByCreatedAt", query = "SELECT u FROM UserXAddress u WHERE u.createdAt = :createdAt")})
public class UserXAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "addressId")
    private Integer addressId;
    @Size(max = 100)
    @Column(name = "type")
    private String type;
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public UserXAddress() {
    }

    public UserXAddress(Integer id) {
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof UserXAddress)) {
            return false;
        }
        UserXAddress other = (UserXAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webshop.UserXAddress[ id=" + id + " ]";
    }
    
}
