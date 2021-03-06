/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hm.ba.kongo.infrastructure.auth.entities;

import de.muenchen.service.BaseEntity;
import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "_PERMISSIONS")
public class Permission extends BaseEntity {

    @Field
    @Column(name = "PERM_PERMISSION")
    private String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Permission that = (Permission) o;

        return getPermission() != null ? getPermission().equals(that.getPermission()) : that.getPermission() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPermission() != null ? getPermission().hashCode() : 0);
        return result;
    }
}
