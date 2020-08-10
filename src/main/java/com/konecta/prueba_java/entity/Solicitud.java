package com.konecta.prueba_java.entity;

import javax.persistence.*;


@Entity
@Table(name="solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "resumen")
    private String resumen;

    @ManyToOne
    @Column(name = "id_empleado")
    private int idEmpleado;

    public Solicitud() {
    }

    public Solicitud(int id, String codigo, String descripcion, String resumen) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.resumen = resumen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", resumen='" + resumen + '\'' +
                ", idEmpleado=" + idEmpleado +
                '}';
    }
}
