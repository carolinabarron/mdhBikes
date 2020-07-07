package com.mdh.pages;

import com.mdh.utils.Producto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class ProductPage extends BasePage{

    @FindBy(css="div.header.noMovible div.logo > a > img")
    WebElement logoMdh;

    @FindBy(css="div.commonContainer.menuVisible h1")
    WebElement nombreArticulo;

    @FindBy(css="div.commonContainer.menuVisible > div.descripcion > div:nth-child(2)")
    WebElement descripcionArticulo;

    @FindBy(css="div.commonContainer > div.colContainer div.precio")
    WebElement precioArticulo;

    @FindBy(id = "carrito")
    WebElement botonAgregarCarrito;

    @FindBy(css = "div.header.noMovible a span.contadorCarrito")
    WebElement iconoContadorCarrito;

    @FindBy(css = "div.desktopMaster > div.header.noMovible a i.fa.fa-shopping-cart")
    WebElement iconoCarrito;

     public ProductPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    public void validarPagina(){
         assertTrue(wait.until(ExpectedConditions.visibilityOf(logoMdh)).isDisplayed());
    }

    public void validarDetallesProducto(Producto producto){
        String nombre = nombreArticulo.getText();
        String descripcion = descripcionArticulo.getText();
        String precioText = precioArticulo.getText();
        precioText = precioText.replace(",","");
        precioText = precioText.replace("$","");
        double precio = Double.parseDouble(precioText);

        if(nombre.equals(producto.getNombre()) && descripcion.equals(producto.getDescripcion())
                && precio == producto.getPrecio()) {
            System.out.println("El criterio de búsqueda coincide con el producto seleccionado");
        }
         else {
            System.out.println("Los detalles de la página del producto no coinciden con el criterio de búsqueda");
             System.exit(-1);
        }

    }

    public int clickAgregarArticuloCarrito(){
         assertTrue(botonAgregarCarrito.isEnabled());
         int contadorCarrito = Integer.parseInt(iconoContadorCarrito.getText());
         System.out.println("Contador carrito = " + contadorCarrito);
         wait.until(ExpectedConditions.elementToBeClickable(botonAgregarCarrito));
         botonAgregarCarrito.click();
         return contadorCarrito;
    }

    public void clickIconoCarrito(){
         wait.until(ExpectedConditions.elementToBeClickable(iconoCarrito));
         iconoCarrito.click();
         System.out.println("Se dio click al icono del carrito");
    }

}
