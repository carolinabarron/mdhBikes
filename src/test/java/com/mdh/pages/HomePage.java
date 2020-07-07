package com.mdh.pages;

import com.mdh.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {

    @FindBy(css="div.header.noMovible div.logo > a > img")
    WebElement logoMdh;
    @FindBy(css="div.header.noMovible [name='q']")
    WebElement campoBusqueda;
    @FindBy(css="div.header.noMovible div.busqueda button")
    WebElement botonBusqueda;
    String criterioBusqueda;

    public HomePage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }


    public void navegarSitio() {
        driver.get(Properties.URL);
    }

    public void verificarPagina() {
        assertTrue(wait.until(ExpectedConditions.visibilityOf(logoMdh)).isDisplayed());
        assertTrue(campoBusqueda.isEnabled());
        assertTrue(botonBusqueda.isDisplayed());
        System.out.println("Home page verificado");
    }

    public void buscarProducto(String criterioBusqueda){
        campoBusqueda.sendKeys(criterioBusqueda);
        botonBusqueda.click();
        System.out.println("Búsqueda ingresada");
    }
}
