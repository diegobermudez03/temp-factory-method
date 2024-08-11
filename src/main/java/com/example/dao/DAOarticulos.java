package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.entidades.Articulos;
import com.example.patronfactorymethod.IntAdaptador;
import com.example.patronfactorymethod.FactoryBaseDatos;



public class DAOarticulos {
    private IntAdaptador dbAdapter;


    public DAOarticulos(){
        dbAdapter = FactoryBaseDatos.getDefaultDBAdapter();
    }

    public List<Articulos> findAllProducts(){
        Connection connection = dbAdapter.getConnection();
        List<Articulos> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT idarticulo ,nombrearticulo"
                            + ",valor FROM articulos");
            ResultSet results = statement.executeQuery();
            while(results.next()){
                productList.add(new Articulos(results.getLong(1),
                        results.getString(2), results.getDouble(3)));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }

    public boolean saveProduct(Articulos articulo){
        Connection connection = dbAdapter.getConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO articulos(idarticulo,"
                            + "nombrearticulo,valor) VALUES (?,?,?)");
            statement.setLong(1, articulo.getIdarticulo());
            statement.setString(2, articulo.getNombrearticulo());
            statement.setDouble(3, articulo.getValor());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                connection.close();
            } catch (Exception e) {}
        }
    }

}