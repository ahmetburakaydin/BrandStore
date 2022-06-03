package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;
import java.util.Random;

public class AllProductsPage extends ParentClass {

    public void clickToAllProductsAndShowAll() {
        clickTo(Locater.mainMenuAlleProdukteLink);
        clickTo(Locater.listAllProductFilterButton);
    }

    public void validateAllImagesandPrices() {
        List<WebElement> listOfImages = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(Locater.allProductImagesList));
        List<WebElement> listOfPrice = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(Locater.allProductPriceList));

        for (int i = 0; i < listOfImages.size(); i++) {
            scrollIntoView(listOfImages.get(i));
            Assert.assertTrue(listOfImages.get(i).isDisplayed());
            Assert.assertTrue(listOfPrice.get(i).isDisplayed());
        }


    }

    int randomNum;
    String randomMenuText;

    public void selectFromDropdownMenu() {

        Select select = new Select(getElement(Locater.alleProdukteKatagorienSelect));

        randomNum = (new Random().nextInt(10) + 1);

        randomMenuText = select.getOptions().get(randomNum).getText().trim();

        select.selectByIndex(randomNum);

    }

    public void validateDropDownMenuNameOnResult() {

        String text = getElement(Locater.selectedMenuHeader).getText();
        System.out.println(text);
        System.out.println(randomMenuText);
        Assert.assertTrue(randomMenuText.contains(text));

    }

    int randomIndex;
    String selectedValue;

    public void selectFromSortingCriterias() {
        randomIndex = (new Random().nextInt(5));

        Select select = new Select(getElement(Locater.sortingCriteriasSelect));
        selectedValue = select.getOptions().get(randomIndex).getAttribute("value");

        System.out.println(selectedValue);
        select.selectByIndex(randomIndex);


    }

    public void validateSelectingCriteriaResult() {
        switch (selectedValue) {
            case "popularity":
                System.out.println("sorting by popularity");
                break;
            case "rating":
                List<WebElement> listofRatingPoints = wait.until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(Locater.ratingStarSortingByRatingTextList));

                for (int i = 0; i < listofRatingPoints.size(); i++) {
                    if (listofRatingPoints.get(i).getAttribute("aria-label") != null) {
                        if (i == listofRatingPoints.size() - 1) break;
                        Assert.assertTrue(getIntStarPoint(listofRatingPoints.get(i).getAttribute("aria-label")) >
                                getIntStarPoint(listofRatingPoints.get(i + 1).getAttribute("aria-label")));
                    }
                }
                break;
            case "date":
                System.out.println("sorting by date");
                break;
            case "price":
                List<WebElement> listOfPrices = wait.until(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(Locater.allProductPriceList));
                for (int i = 0; i < listOfPrices.size(); i++) {
                    if (i == listOfPrices.size() - 1) break;
                    scrollIntoView(listOfPrices.get(i));
                    Assert.assertTrue(getIntPrice(listOfPrices.get(i).getText()) <= getIntPrice(listOfPrices.get(i + 1).getText()));

                }
                break;
            case "price-desc":
                List<WebElement> listOfPrices2 = wait.until(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(Locater.allProductPriceList));
                for (int i = 0; i < listOfPrices2.size(); i++) {
                    if (i == listOfPrices2.size() - 1) break;
                    scrollIntoView(listOfPrices2.get(i));
                    Assert.assertTrue(getIntPrice(listOfPrices2.get(i).getText()) >= getIntPrice(listOfPrices2.get(i + 1).getText()));
                }
                break;
        }

        selectedValue=null;


    }
}
