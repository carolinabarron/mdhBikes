package com.mdh.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/features/searchModule/searchItem.feature"
},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/searchItem.json",
        "html:target/searchItem-html"},
        glue = {"com.mdh.sites",
                "com.mdh.pages",
                "com.mdh.steps",
                "com.mdh.utils",
                "com.mdh.hooks"})


public class SearchRunner {

}
