package com.mdh.pages;

import com.mdh.sites.MdhSite;
import com.mdh.utils.Producto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class CartPage extends BasePage {

    @FindBy(css="div.header.noMovible div.logo > a > img")
    WebElement logoMdh;

    @FindBy(css="div.desktopMaster table td.colModelo")
    WebElement nombreArticuloAgregado;

    @FindBy(css="div.desktopMaster table tr.bordeDebajo td:nth-child(3)")
    WebElement precioArtAgregado;

    @FindBy(css = "div.header.noMovible a span.contadorCarrito")
    WebElement iconoContadorCarrito;

    public CartPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    public void validarPagina(){
        assertTrue(wait.until(ExpectedConditions.visibilityOf(logoMdh)).isDisplayed());
    }

    public void verificarContadorCarrito(int contadorCarrito){
        int contadorCarritoActualizado = Integer.parseInt(iconoContadorCarrito.getText());
        System.out.println("Contador carrito actualizado = " + contadorCarritoActualizado);
        assertTrue(contadorCarritoActualizado == contadorCarrito + 1);
        System.out.println("El contador del carrito se incrementó correctamente");
    }

    public void verificarInformacionProducto(Producto producto) {
        wait.until(ExpectedConditions.visibilityOf(nombreArticuloAgregado));
        String nombre = nombreArticuloAgregado.getText();
        String precioText = precioArtAgregado.getText();
        precioText = precioText.replace(",","");
        precioText = precioText.replace("$","");
        double precio = Double.parseDouble(precioText);

        if(nombre.contains(producto.getNombre()) && precio == producto.getPrecio()) {
            System.out.println("La información del producto en el carrito coincide con el producto seleccionado");
        }
        else {
            System.out.println("La información del producto en el carrito no coinciden con el criterio de búsqueda");
            System.exit(-1);

        }
    }

}
