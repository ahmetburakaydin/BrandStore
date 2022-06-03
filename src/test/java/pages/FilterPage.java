package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;
import java.util.Random;

public class FilterPage extends ParentClass {

    String minPrice;
    String maxPrice;
    String randomColorText;
    String randomSizeText;
    String randomMaterialText;
    String randomGenderText;

    public void clickProdukteFilterButton(){

        clickTo(Locater.alleProdukteProduteFilterButton);
        Assert.assertTrue(getElement(Locater.produkteFilterAlleFilterButton).isDisplayed());

    }

    public void selectRandomlyFilterKeyWordsFromDropdown(String keyword){
        switch (keyword.toLowerCase()){
            case "price" : {

                Actions builder = new Actions(driver);
                builder.dragAndDropBy(getElement(Locater.filterByPriceSlider),+10,0).perform();
                minPrice=getText(Locater.filterAfterSlidingMinPriceText);
                maxPrice=getText(Locater.filterAfterSlidingMaxPriceText);
                clickTo(Locater.filterByPriceButton);
                break;

            }
            case "color" : {

                Select select = new Select(getElement(Locater.filterByColorSelectDropdown));
                int randomIndex = new Random().nextInt(16)+1;
                randomColorText = select.getOptions().get(randomIndex).getText();
                select.selectByIndex(randomIndex);
                clickTo(Locater.filterByColorFilterNowButton);
                break;

            }
            case "size" : {

                Select select = new Select(getElement(Locater.filterBySizeSelectDropdown));
                int randomIndex = new Random().nextInt(18)+1;
                randomSizeText = select.getOptions().get(randomIndex).getText();
                System.out.println(randomSizeText);
                select.selectByIndex(randomIndex);
                clickTo(Locater.filterBySizeFilterNowButton);
                break;

            }
            case "material" : {

                Select select = new Select(getElement(Locater.filterByMaterialSelectDropdown));
                int randomIndex = new Random().nextInt(11)+1;
                randomMaterialText = select.getOptions().get(randomIndex).getText();
                System.out.println(randomMaterialText);
                select.selectByIndex(randomIndex);
                clickTo(Locater.filterByMaterialFilterNowButton);
                break;

            }
            case "gender" : {

                Select select = new Select(getElement(Locater.filterByGenderSelectDropdown));
                int randomIndex = new Random().nextInt(3)+1;
                randomGenderText = select.getOptions().get(randomIndex).getText();
                System.out.println(randomGenderText);
                select.selectByIndex(randomIndex);
                clickTo(Locater.filterByGenderFilterNowButton);
                break;

            }
        }
    }

    public void validateFilterProductResultswithPrices(){

        List<WebElement> priceList= wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(Locater.filterByPricePricesResultList));
        for (WebElement element : priceList) {
            System.out.println(getIntPrice(element.getText()));
            Assert.assertTrue(getIntPrice(element.getText())<=getIntPrice(maxPrice));
            Assert.assertTrue(getIntPrice(element.getText())>=getIntPrice(minPrice));
        }

    }

    public void validateColorNameAfterFilterByColor(){

        List<WebElement> productCartSectionList = getListOfElements(Locater.filterResultProductCartSectionList);

        int matchingTextCount = 0;
        for (int i = 0; i < productCartSectionList.size(); i++) {
            productCartSectionList = getListOfElements(Locater.filterResultProductCartSectionList);
            System.out.println("---------");
            System.out.println(productCartSectionList.get(i).getText());
            System.out.println("---------");
            List<WebElement> productNameList=getListOfElements(Locater.filterResultProductsImages);

            if(productCartSectionList.get(i).getText().equalsIgnoreCase("Ausführung wählen")){
                hoverTo(productNameList.get(i));
                clickTo(productNameList.get(i).findElement(Locater.overviewButtonOnFilterResult));
                clickTo(Locater.overviewSelectBar);
                WebElement element2 = wait.until(ExpectedConditions.presenceOfElementLocated(Locater.overviewSelectedProductNameText));
                System.out.println(element2.getText());
                if(element2.getText().equalsIgnoreCase(randomColorText)){
                    matchingTextCount++;
                    scrollIntoViewFalse(getElement(Locater.overviewPageCloseButton));
                    clickTo(Locater.overviewPageCloseButton);

                }else {
                    scrollIntoViewFalse(getElement(Locater.overviewPageCloseButton));
                    clickTo(Locater.overviewPageCloseButton);
                }
            }
            else{
                System.out.println("---------");
                productCartSectionList = getListOfElements(Locater.filterResultProductCartSectionList);
                System.out.println(productCartSectionList.get(i).getText());
                System.out.println("---------");
                clickTo(productCartSectionList.get(i));
                productNameList = getListOfElements(Locater.filterResultProductsImages);


                clickTo(productNameList.get(i));
                scrollIntoViewFalse(getElement(Locater.eigenschaftenLink));
                clickTo(Locater.eigenschaftenLink);
                String colorText = getText(Locater.eigenschaftenFarbeText);
                if(colorText.equalsIgnoreCase(randomColorText)){
                    matchingTextCount++;
                }
                driver.navigate().back();
            }
        }
        System.out.println("********");
        System.out.println("eşleşen ürün sayısı :"+matchingTextCount);
        Assert.assertTrue(matchingTextCount>0);

    }

    public void validateSizeTextAfterFilterBySize(){

        List<WebElement> productImageList= getListOfElements(Locater.filterResultProductsImages);

        int matchingTextCount = 0;
        for (int i = 0; i < productImageList.size(); i++) {
            productImageList= getListOfElements(Locater.filterResultProductsImages);
            clickTo(productImageList.get(i));
            if(randomSizeText.equals("Onesize")){
                scrollIntoViewFalse(getElement(Locater.eigenschaftenLink));
                clickTo(Locater.eigenschaftenLink);
                String sizeText = getText(Locater.eigenschaftenSizeText);
                if(sizeText.contains(randomSizeText)){
                    matchingTextCount++;
                }
            }else {
                Select select1 = new Select(getElement(Locater.productDisplaySizeSelect));
                System.out.println(select1.getOptions().size() + " option size");
                for (int j = 1; j < select1.getOptions().size(); j++) {
                    //Select select2 = new Select(getElement(Locater.productDisplaySizeSelect));
                    clickTo(getElement(Locater.productDisplaySizeSelect));
                    sleep(200);
                    System.out.println("(" + j + ")" + select1.getOptions().get(j).getText());
                    if (select1.getOptions().get(j).getText().trim().equalsIgnoreCase(randomSizeText)) {
                        System.out.println("eşleşme var + " + select1.getOptions().get(j).getText());

                        matchingTextCount++;

                    }
                }

            }
            driver.navigate().back();
        }
        System.out.println("toplam eşleşen ürün sayısı : "+matchingTextCount);
        Assert.assertTrue(matchingTextCount>0);

    }

    public void validateMaterialTextAfterFilterByMaterial(){
        List<WebElement> productImageList= getListOfElements(Locater.filterResultProductsImages);

        int matchingTextCount = 0;

        for (int i = 0; i < productImageList.size(); i++) {
            productImageList= getListOfElements(Locater.filterResultProductsImages);
            clickTo(productImageList.get(i));

            scrollIntoViewFalse(getElement(Locater.eigenschaftenLink));
            clickTo(Locater.eigenschaftenLink);
            String materialText = getText(Locater.eigenschaftenMaterialText);


            if(materialText.contains(randomMaterialText)){
                matchingTextCount++;
            }
            driver.navigate().back();


        }
        Assert.assertTrue(matchingTextCount>0);
    }

    public void validateGenderTextAfterFilterByMaterial(){

        List<WebElement> productImageList= getListOfElements(Locater.filterResultProductsImages);

        int matchingTextCount = 0;

        for (int i = 0; i < productImageList.size(); i++) {
            productImageList= getListOfElements(Locater.filterResultProductsImages);
            clickTo(productImageList.get(i));

            scrollIntoViewFalse(getElement(Locater.eigenschaftenLink));
            clickTo(Locater.eigenschaftenLink);
            String genderText = getText(Locater.eigenschaftenGenderText);


            if(genderText.contains(randomGenderText)){
                matchingTextCount++;
            }
            driver.navigate().back();


        }
        Assert.assertTrue(matchingTextCount>0);


    }







}
