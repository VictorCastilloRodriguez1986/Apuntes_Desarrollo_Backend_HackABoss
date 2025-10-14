package com.hackaboss.patron_mvc.model;

import lombok.Data;

import java.util.List;

@Data
public class Pedido {
    private int id;
    private String cliente;
    private List<String> platos;
}

