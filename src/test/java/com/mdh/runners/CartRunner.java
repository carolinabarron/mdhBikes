package com.mdh.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/features/cartModule/addToCart.feature"
},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/addToCart.json",
        "html:target/addToCart-html"},
        glue = {"com.mdh.sites",
                "com.mdh.pages",
                "com.mdh.steps",
                "com.mdh.utils",
                "com.mdh.hooks"})

public class CartRunner {

}