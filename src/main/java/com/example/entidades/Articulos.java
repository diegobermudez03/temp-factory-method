package com.example.entidades;

public class Articulos {
    private Long idarticulo;
    private String nombrearticulo;
    private double valor;

    public Articulos(Long idarticulo, String nombrearticulo, double valor) {
        this.idarticulo = idarticulo;
        this.nombrearticulo = nombrearticulo;
        this.valor = valor;
    }

    public Articulos() {
    }


    public Long getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Long idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getNombrearticulo() {
        return nombrearticulo;
    }

    public void setNombrearticulo(String nombrearticulo) {
        this.nombrearticulo = nombrearticulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idarticulo=" + idarticulo + ", nombrearticulo=" + nombrearticulo + ", valor=" + valor + '}';
    }
}