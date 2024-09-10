package com.example.FLORERIA203140.model;

import javax.persistence.*;

@Entity
@Table(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombreCliente;
    private String florRequerida;
    private String fechaEntrega;
    private String  fechaPedido;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente= nombreCliente;
    }

    public String getFlorRequerida() {
        return florRequerida;
    }

    public void setFlorRequerida(String florRequerida){this.florRequerida = florRequerida;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaPedido(){
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido){
        this.fechaPedido = fechaPedido;
    }


}
