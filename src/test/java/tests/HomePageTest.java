package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }

    @Test
    public void shouldSeePopularItemOnHomePageCss() {
        List<String> productNamesByCss = popularItemsPage.getProductNamesByCss();

        List<String> productsWithEmptyNames = productNamesByCss.stream()
                .filter(el -> el.isEmpty())
                .collect(Collectors.toList());
        Assertions.assertThat(productsWithEmptyNames).isEmpty();
    }

    @Test
    public void shouldSeePopularItemOnHomePageXpath() {
        List<String> productNamesByXpath = popularItemsPage.getProductNamesByXpath();

        List<String> productsWithEmptyNames = productNamesByXpath.stream()
                .filter(el -> el.isEmpty())
                .collect(Collectors.toList());
        Assertions.assertThat(productsWithEmptyNames).isEmpty();
    }
}
