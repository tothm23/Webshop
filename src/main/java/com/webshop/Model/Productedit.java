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
import javax.persistence.Lob;
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
@Table(name = "productedit")
@NamedQueries({
    @NamedQuery(name = "Productedit.findAll", query = "SELECT p FROM Productedit p"),
    @NamedQuery(name = "Productedit.findById", query = "SELECT p FROM Productedit p WHERE p.id = :id"),
    @NamedQuery(name = "Productedit.findByProductId", query = "SELECT p FROM Productedit p WHERE p.productId = :productId"),
    @NamedQuery(name = "Productedit.findByOldPrice", query = "SELECT p FROM Productedit p WHERE p.oldPrice = :oldPrice"),
    @NamedQuery(name = "Productedit.findByOldName", query = "SELECT p FROM Productedit p WHERE p.oldName = :oldName"),
    @NamedQuery(name = "Productedit.findByOldCategoryId", query = "SELECT p FROM Productedit p WHERE p.oldCategoryId = :oldCategoryId"),
    @NamedQuery(name = "Productedit.findByOldDescription", query = "SELECT p FROM Productedit p WHERE p.oldDescription = :oldDescription"),
    @NamedQuery(name = "Productedit.findByOldStock", query = "SELECT p FROM Productedit p WHERE p.oldStock = :oldStock"),
    @NamedQuery(name = "Productedit.findByNewPrice", query = "SELECT p FROM Productedit p WHERE p.newPrice = :newPrice"),
    @NamedQuery(name = "Productedit.findByNewName", query = "SELECT p FROM Productedit p WHERE p.newName = :newName"),
    @NamedQuery(name = "Productedit.findByNewCategoryId", query = "SELECT p FROM Productedit p WHERE p.newCategoryId = :newCategoryId"),
    @NamedQuery(name = "Productedit.findByNewDescription", query = "SELECT p FROM Productedit p WHERE p.newDescription = :newDescription"),
    @NamedQuery(name = "Productedit.findByNewStock", query = "SELECT p FROM Productedit p WHERE p.newStock = :newStock"),
    @NamedQuery(name = "Productedit.findByModifyerId", query = "SELECT p FROM Productedit p WHERE p.modifyerId = :modifyerId"),
    @NamedQuery(name = "Productedit.findByModifiedAt", query = "SELECT p FROM Productedit p WHERE p.modifiedAt = :modifiedAt")})
public class Productedit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "oldPrice")
    private Integer oldPrice;
    @Size(max = 100)
    @Column(name = "oldName")
    private String oldName;
    @Column(name = "oldCategoryId")
    private Integer oldCategoryId;
    @Lob
    @Column(name = "oldImage")
    private byte[] oldImage;
    @Size(max = 100)
    @Column(name = "oldDescription")
    private String oldDescription;
    @Column(name = "oldStock")
    private Integer oldStock;
    @Column(name = "newPrice")
    private Integer newPrice;
    @Size(max = 100)
    @Column(name = "newName")
    private String newName;
    @Column(name = "newCategoryId")
    private Integer newCategoryId;
    @Lob
    @Column(name = "newImgage")
    private byte[] newImgage;
    @Size(max = 100)
    @Column(name = "newDescription")
    private String newDescription;
    @Column(name = "newStock")
    private Integer newStock;
    @Column(name = "modifyerId")
    private Integer modifyerId;
    @Column(name = "modifiedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    public Productedit() {
    }

    public Productedit(Integer id) {
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

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public Integer getOldCategoryId() {
        return oldCategoryId;
    }

    public void setOldCategoryId(Integer oldCategoryId) {
        this.oldCategoryId = oldCategoryId;
    }

    public byte[] getOldImage() {
        return oldImage;
    }

    public void setOldImage(byte[] oldImage) {
        this.oldImage = oldImage;
    }

    public String getOldDescription() {
        return oldDescription;
    }

    public void setOldDescription(String oldDescription) {
        this.oldDescription = oldDescription;
    }

    public Integer getOldStock() {
        return oldStock;
    }

    public void setOldStock(Integer oldStock) {
        this.oldStock = oldStock;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Integer getNewCategoryId() {
        return newCategoryId;
    }

    public void setNewCategoryId(Integer newCategoryId) {
        this.newCategoryId = newCategoryId;
    }

    public byte[] getNewImgage() {
        return newImgage;
    }

    public void setNewImgage(byte[] newImgage) {
        this.newImgage = newImgage;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public Integer getNewStock() {
        return newStock;
    }

    public void setNewStock(Integer newStock) {
        this.newStock = newStock;
    }

    public Integer getModifyerId() {
        return modifyerId;
    }

    public void setModifyerId(Integer modifyerId) {
        this.modifyerId = modifyerId;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
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
        if (!(object instanceof Productedit)) {
            return false;
        }
        Productedit other = (Productedit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.webshop.Productedit[ id=" + id + " ]";
    }
    
}
