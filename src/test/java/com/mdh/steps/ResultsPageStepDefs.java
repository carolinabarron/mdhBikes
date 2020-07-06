package com.mdh.steps;

import com.mdh.hooks.Hooks;
import com.mdh.sites.MdhSite;
import cucumber.api.java.en.When;

public class ResultsPageStepDefs {

    public MdhSite mdhSite;

    public ResultsPageStepDefs(Hooks h) {
        this.mdhSite = h.getMdhSite();
    }

    @When("Pagina de resultados es mostrada")
    public void paginaDeResultadosEsMostrada() {
        mdhSite.getResults().verificarPagina();
        mdhSite.getResults().verificarResultados();
        mdhSite.getResults().guardarInfoProducto();
        mdhSite.getResults().clickProducto();
    }

}
