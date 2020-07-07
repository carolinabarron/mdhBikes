package com.mdh.sites;

import com.mdh.pages.CartPage;
import com.mdh.pages.HomePage;
import com.mdh.pages.ProductPage;
import com.mdh.pages.ResultsPage;
import com.mdh.utils.Producto;
import org.openqa.selenium.WebDriver;

public class MdhSite {

    private final WebDriver driver;
    private HomePage home;
    private ResultsPage results;
    private ProductPage product;
    private String criterioBusqueda;
    private Producto producto;
    private int contadorCarrito;

    public HomePage getHome() {
        return new HomePage(driver);
    }

    public ResultsPage getResults() {
        return new ResultsPage(driver);
    }

    public ProductPage getProductInfo() {
        return new ProductPage(driver);
    }

    public CartPage getCartProdInfo() {
        return new CartPage(driver);
    }

    public MdhSite(WebDriver driver) {
        this.driver = driver;
    }

    public void saveProduct(Producto producto){
        this.producto = producto;
    }

    public Producto retrieveProducto(){
        return this.producto;
    }

    public void saveCriterioBusqueda(String criterioBusqueda){
        this.criterioBusqueda = criterioBusqueda;
    }

    public String retrieveCriterioBusqueda(){
        return this.criterioBusqueda;
    }

    public void saveContadorCarrito(int contadorCarrito){
        this.contadorCarrito = contadorCarrito;
    }

    public int retrieveContadorCarrito(){
        return this.contadorCarrito;
    }


}