package com.app.backend.models.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo no puede estar vacio")
    @Size(min = 1, max = 25, message = "Numero de caracteres invalido. Min 1 - Max 25")
    private String nombre;
    @NotEmpty(message = "Campo no puede estar vacio")
    @Size(min = 1, max = 25, message = "Numero de caracteres invalido. Min 1 - Max 25")
    private String apellido;
    @NotEmpty(message = "Campo no puede estar vacio")
    @Email(message = "Formato email incorrecto")
    private String email;

    @NotNull(message = "Fecha no puede ser vacio")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    private static final long serialVersionUID = 1L;

    /*@PrePersist
    public void prePersist(){
        createAt = new Date();
    }*/
}
