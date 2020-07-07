package com.mdh.steps;

import com.mdh.hooks.Hooks;
import com.mdh.sites.MdhSite;
import com.mdh.utils.Producto;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MdhPageStepDefs {
    public MdhSite mdhSite;
    public MdhPageStepDefs(Hooks h) {
        this.mdhSite = h.getMdhSite();
    }

    //Scenario 1: Search
    @Given("El usuario introduce criterio de busqueda")
    public void elUsuarioIntroduceCriterioDeBusqueda() {
        mdhSite.getHome().navegarSitio();
        mdhSite.getHome().verificarPagina();
        mdhSite.getHome().buscarProducto();
    }

    @When("Pagina de resultados es mostrada")
    public void paginaDeResultadosEsMostrada() {
        mdhSite.getResults().verificarPagina();
        mdhSite.getResults().verificarResultados();
        Producto p = mdhSite.getResults().guardarInfoProducto();
        mdhSite.saveProduct(p);
        mdhSite.getResults().clickProducto();
    }

    @Then("El usario accede a los detalles del producto buscado")
    public void elUsarioAccedeALosDetallesDelProductoBuscado() {
        mdhSite.getProductInfo().validarPagina();
        Producto p = mdhSite.retrieveProducto();
        mdhSite.getProductInfo().validarDetallesProducto(p);
    }

    //Scenario 2 - Add to Cart
    @Given("El usuario selecciona un articulo")
    public void elUsuarioSeleccionaUnArticulo() {
        //Se ejecutan los steps del search
        elUsuarioIntroduceCriterioDeBusqueda();
        paginaDeResultadosEsMostrada();
        elUsarioAccedeALosDetallesDelProductoBuscado();

    }

    @When("Lo agrega al carrito")
    public void loAgregaAlCarrito() {
        mdhSite.getProductInfo().clickAgregarArticuloCarrito();
        mdhSite.getProductInfo().clickIconoCarrito();
    }

    @Then("El articulo es listado en la pagina de carrito")
    public void elArticuloEsListadoEnLaPaginaDeCarrito() {
        mdhSite.getCartProdInfo().validarPagina();
        mdhSite.getCartProdInfo().verificarContadorCarrito();
        mdhSite.getCartProdInfo().verificarInformacionProducto();
    }
}
