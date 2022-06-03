package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;

public class SearchPage extends ParentClass {
    public void searchOnHeaderSearchField(String text){

        clickTo(Locater.headerSearchFieldIcon);

        sendkeysTo(Locater.headerSearchFieldInput,text+ Keys.ENTER);


    }

    public void validateKeywordOnSearchResultProducts(String text){
        List<WebElement> listOfProductName = getListOfElements(Locater.searchResultProductNameList);

        for (int i = 0; i < listOfProductName.size()-1; i++) {
            Assert.assertTrue(listOfProductName.get(i).getText().toLowerCase().contains(text.toLowerCase()));
        }


    }

    public void searchOnLeftBottomSearchField(String text){
        sendkeysTo(Locater.leftBottomSearchInputAltCatagories, text + Keys.ENTER);
    }
}
