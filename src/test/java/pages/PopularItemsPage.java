package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PopularItemsPage extends BasePage{

    public PopularItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#homefeatured .prouct-name")
    List<WebElement> productNamesByCss;

    public List<String> getProductNamesByCss() {
       return productNamesByCss.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    @FindBy(xpath = "//*[@id='homefeatured']//*[@class='product-name']")
    List<WebElement> productNamesByXPath;

    public List<String> getProductNamesByXpath() {
        return productNamesByXPath.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }
}
