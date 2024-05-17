package org.ie.mizdooni.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class GlobalData {
    @Id
    public Integer id;
    public Boolean isUserLoginned;
    public String version;

    @Column(name = "loginnedUsername", nullable = true)
    String loginnedUsername;

    public String getLoginnedUsername() {
        return loginnedUsername;
    }

    public void setLoginnedUsername(String loginnedUsername) {
        this.loginnedUsername = loginnedUsername;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loginnedUsername", referencedColumnName = "username", insertable = false, updatable = false)
    private UserModel loginnedUser;

    public UserModel getLoginnedUser() {
        return loginnedUser;
    }

    public void setLoginnedUser(UserModel loginnedUser) {
        this.loginnedUser = loginnedUser;
    }

    public GlobalData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsUserLoginned() {
        return isUserLoginned;
    }

    public void setIsUserLoginned(Boolean isUserLoginned) {
        this.isUserLoginned = isUserLoginned;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
