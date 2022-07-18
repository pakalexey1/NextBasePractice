package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //here no need to run feature files
        features = "@target/rerun.txt",
        //location of my selenium java codes
        glue = "com/cydeo/step_definitions"
)
public class FailedRunner {
}