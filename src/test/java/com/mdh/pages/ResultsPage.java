package com.mdh.pages;

import com.mdh.utils.Producto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResultsPage extends BasePage {

    @FindBy(css="div.header.noMovible div.logo > a > img")
    WebElement logoMdh;

    @FindBy(css="div.desktopMaster div.bannerInicio > span")
    WebElement categoriaBusqueda;

    @FindBy(css="[class*=resultado]")
    List<WebElement> listaProductos;

    @FindBy(css="div.desktopMaster a[href='producto/1209'] > div")
    WebElement linkPrimerArticulo;

    @FindBy(css="div.desktopMaster a[href='producto/1209'] > div > div.izquierda > h3")
    WebElement nombrePrimerArticulo;

    @FindBy(css="div.desktopMaster a[href='producto/1209'] > div > div.derecha > p")
    WebElement descripcionPrimerArticulo;

    @FindBy(css="div.desktopMaster a[href='producto/1209'] > div > div.izquierda > p.precio")
    WebElement precioPrimerArticulo;

    public ResultsPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    public void verificarPagina(){
        assertTrue(wait.until(ExpectedConditions.visibilityOf(logoMdh)).isDisplayed());
        assertTrue(categoriaBusqueda.isDisplayed());
        assertTrue(listaProductos.size() > 0);
        System.out.println("Página de resultados verificada");

    }

    public void verificarResultados(String criterioBusqueda){
        assertTrue(linkPrimerArticulo.isDisplayed());
        assertTrue(nombrePrimerArticulo.isDisplayed());
        assertTrue(descripcionPrimerArticulo.isDisplayed());
        assertTrue(nombrePrimerArticulo.getText().toLowerCase().contains(criterioBusqueda.toLowerCase())
                || descripcionPrimerArticulo.getText().toLowerCase().contains(criterioBusqueda.toLowerCase()));
        System.out.println("Búsqueda verificada");
    }

    public Producto guardarInfoProducto(){

        String nombre = nombrePrimerArticulo.getText();
        String descripcion = descripcionPrimerArticulo.getText();
        String precioText = precioPrimerArticulo.getText();
        precioText = precioText.replace(",","");
        precioText = precioText.replace("PRECIO - $","");
        double precio = Double.parseDouble(precioText);
        Producto prod = new Producto(nombre, descripcion, precio);
        System.out.println("Nombre: " + prod.getNombre() + " /// Descripcion: " + prod.getDescripcion()
                + " /// Precio: " + prod.getPrecio());
        return prod;
    }

    public void clickProducto(){
        linkPrimerArticulo.click();
    }
}
