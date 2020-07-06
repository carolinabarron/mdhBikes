package com.mdh.steps;

import com.mdh.hooks.Hooks;
import com.mdh.sites.MdhSite;
import cucumber.api.java.en.Then;

public class ProdPageStepDefs {

    public MdhSite mdhSite;

    public ProdPageStepDefs(Hooks h) {
        this.mdhSite = h.getMdhSite();
    }

    @Then("El usario accede a los detalles del producto buscado")
    public void elUsarioAccedeALosDetallesDelProductoBuscado() {
        mdhSite.getProductInfo().validarPagina();
        mdhSite.getProductInfo().validarDetallesProducto();
    }
}
