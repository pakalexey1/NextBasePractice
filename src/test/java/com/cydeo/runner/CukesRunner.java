package com.cydeo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
//                "junit:target/junit/junit-report.xml",
                "pretty",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = true,
        tags = ""
)
public class CukesRunner {
}
