package com.mdh.steps;

import com.mdh.hooks.Hooks;
import com.mdh.sites.MdhSite;
import cucumber.api.java.en.Given;

public class HomeStepDefs {

    public MdhSite mdhSite;
    public HomeStepDefs(Hooks h) {
        this.mdhSite = h.getMdhSite();
    }

    @Given("El usuario introduce criterio de busqueda")
    public void elUsuarioIntroduceCriterioDeBusqueda() {
        mdhSite.getHome().navegarSitio();
        mdhSite.getHome().verificarPagina();
        mdhSite.getHome().buscarProducto();

    }


}
