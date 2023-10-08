package com.webshop.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webshop.Exception.PasswordException;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author tothm23
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByAdmin", query = "SELECT u FROM User u WHERE u.isAdmin = :isAdmin"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phoneNum = :phoneNum"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.fname = :fname"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lname = :lname"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByLastLogin", query = "SELECT u FROM User u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "User.findByRegisteredAt", query = "SELECT u FROM User u WHERE u.signTime = :signTime")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nickname")
    private String nickname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    @Column(name = "isAdmin")
    private Boolean isAdmin;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phoneNum/fax format, should be as xxx-xxx-xxxx")//if the field contains phoneNum or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(name = "phoneNum")
    private String phoneNum;
    @Size(max = 50)
    @Column(name = "fname")
    private String fname;
    @Size(max = 50)
    @Column(name = "lname")
    private String lname;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "lastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "signTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date signTime;

    public User() {

//        170 MB-os lag file-t generál tele hibával
//                
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Webshop_war_1.0-SNAPSHOTPU");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            User user = em.find(User.class, id);
//            
//            this.id = user.getId();
//            this.nickname = user.getNickname();
//            this.email = user.getEmail();
//            this.password = user.getPassword();
//            this.isAdmin = user.getIsAdmin();
//            this.phoneNum = user.getPhoneNum();
//            this.fname = user.getFname();
//            this.lname = user.getLname();
//            this.status = user.getStatus();
//            this.lastLogin = user.getLastLogin();
//            this.signTime = user.getSignTime();
//
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        } finally {
//            em.clear();
//            em.close();
//            emf.close();
//        }
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }

        User other = (User) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.webshop.User[ id=" + id + " ]";
    }

//    public static boolean checkName(String name) {
//        return !name.equalsIgnoreCase("");
//    }
    public static boolean checkEmail(String email) {
        // Az emailcím formailag helyes, gmail domain, és a @ előtt legalább 3 karakteres, érvényes "név" szerepel
        // Az emailcím nem lehet rövidebb 12 karakternél

//        Követelmény:
//        - Minimum 12 karakter hosszú
//        - @ előtt legalább 3 karakter szerepel
//        - van @ karkater
        if (email.length() >= 12 && email.contains("@")) {
            String[] pieces = email.split("@");

            if (pieces[0].length() >= 3 && pieces[1].startsWith("gmail")) {
                return true;
            }
        }

        return false;

    }

    public static boolean checkPassword(String pw) throws PasswordException {
        // jelszó vizsgálat
        // Jelszó hossza legalább 8 karakter, van benne 1-1 kis és nagybetű 1 szám, és 1 speciális karakter
        // + A jelszüban a speciális karakter nem lehet az első és az utolsó helyen

//        // 8 karakter
//        if (pw.length() < 8) {
//            throw new PasswordException("A jelszó nem elég hosszú");
//        } // kisbetűs
//        else if (!pw.matches(".[a-z],")) {
//            throw new PasswordException("Csak kisbetűs karakterek vannak!");
//        } // nagybetűs
//        else if (!pw.matches(".[A-z],")) {
//            throw new PasswordException("Csak nagybetűs karakterek vannak!");
//        } // számok
//        else if (!pw.matches(".[0-9],")) {
//            throw new PasswordException("Csak számok vannak!");
//        } // speciális karakterek
//        else if (!pw.matches(".*[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-].*")) {
//            throw new PasswordException("Lenni kell speciális karakternek!");
//        } else {
//            return true;
//        }
//        Követelmény:
//        - Minimum 1 nagy betű
//        - Minimum 1 szám
//        - Minimum 8 karakter hosszú
        return pw.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }

    public static boolean regisztracio(String name, String email, String pw, Boolean isAdmin) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("regisztracio");

            spq.registerStoredProcedureParameter("nicknameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("pwIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("isAdminIN", Boolean.class, ParameterMode.IN);

            spq.setParameter("nicknameIN", name);
            spq.setParameter("emailIN", email);
            spq.setParameter("pwIN", pw);
            spq.setParameter("isAdminIN", isAdmin);

            spq.execute();
            return true;

        } catch (Exception e) {

            System.err.println(e.getMessage());
            return false;

        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }

    public static User bejelentkezes(String email, String pw) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("bejelentkezes");

            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("idOUT", Integer.class, ParameterMode.OUT);

            spq.setParameter("emailIN", email);
            spq.setParameter("passwordIN", pw);

            spq.execute();
            Integer id = Integer.parseInt(spq.getOutputParameterValue("idOUT").toString());
            return new User(id);
        } catch (Exception e) {

            System.err.println(e.getMessage());
            return new User();

            //Saját exception-t kell írni, hogy a bejelentkezés sikertelen
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
}
