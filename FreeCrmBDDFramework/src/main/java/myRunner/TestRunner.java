package myRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"\\Users\\Sampurna_Gadipudi\\eclipse-workspace\\FreeCrmBDDFramework\\src\\main\\java\\Features\\login.feature"}
,glue={"stepDefinations"},
monochrome=true,
dryRun=false

		)
public class TestRunner {

}
