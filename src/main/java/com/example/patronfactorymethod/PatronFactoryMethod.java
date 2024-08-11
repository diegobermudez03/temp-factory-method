package com.example.patronfactorymethod;

import java.sql.SQLException;
import java.util.List;

import com.example.dao.DAOarticulos;
import com.example.entidades.Articulos;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronFactoryMethod {


    public static void main(String[] args) throws SQLException {

        //Creation of the DAO instance
        DAOarticulos daoarticulos = new DAOarticulos();

        List<Articulos> art = daoarticulos.findAllProducts();
        long totalregistros=art.size()+1;
        //Creamos los nuevos productos a registrar
        Articulos elementoA = new Articulos(totalregistros, "Articulo A"+totalregistros, 120);
        totalregistros=totalregistros+1;
        Articulos elementoB = new Articulos(totalregistros, "Articulo B"+totalregistros, 130);
        // Product productA = new Product(1L, "Product A", 120);
        //Product productB = new Product(2L, "Product B", 130);


        //Product persist
        daoarticulos.saveProduct(elementoA);
        daoarticulos.saveProduct(elementoB);

        //Create the products
        List<Articulos> elementos = daoarticulos.findAllProducts();
        System.out.println("Cantidad Articulos ==> " + elementos.size());
        for(Articulos registro : elementos){
            System.out.println(registro);
        }

    }

}