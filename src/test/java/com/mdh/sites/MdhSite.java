package com.mdh.sites;

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
    private String criterioBusqueda = "M1 Helmet";
    private Producto producto = new Producto();

    public HomePage getHome() {

        return new HomePage(driver, criterioBusqueda);
    }

    public ResultsPage getResults() {

        return new ResultsPage(driver, criterioBusqueda, producto);
    }

    public ProductPage getProductInfo() {
        return new ProductPage(driver, producto);
    }

    public MdhSite(WebDriver driver) {
        this.driver = driver;
    }
}