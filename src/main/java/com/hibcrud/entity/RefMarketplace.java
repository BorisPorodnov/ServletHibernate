package com.hibcrud.entity;

import org.jboss.logging.Field;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ref_marketplace",
        uniqueConstraints = @UniqueConstraint(name = "UQRefMarketplace", columnNames = "name"))
public class RefMarketplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", unique = true)
    private String name;

    @NotNull
    @Column(name = "editable")
    private boolean editable;

    @NotNull
    @Column(name = "deletable")
    private boolean deletable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }
}
