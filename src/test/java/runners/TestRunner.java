package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //console renkli yazdirmak icin
                "html:TestOutput/htmlReport/cucumberHooks.html", //html report için
                "json:target/json-reports/cucumber1.json",  //cucumber report için
                "junit:TestOutput/htmlReport/cucumber.xml",//xml report için
                "rerun:TestOutput/failed_scenario.txt",//rerun hata veren testleri kaydedip yeniden otomatik kosmak icin
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},//spark report icin
        features = "src/test/resources/features",
        glue = {"stepDefinitions","runners"},
        tags = "@kitapYurduCokSatanEdebiyat",
        dryRun = false,
        monochrome = false //false scenario adimlarini renkli gosterir

)
public class TestRunner {
}
