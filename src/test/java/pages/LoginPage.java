package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;
import static utils.Logger1.*;

public class LoginPage extends ParentClass {

    public void acceptCookiesAlert(){
        clickTo(Locater.noticeAlertAusBlendenButton);
        //getLogger().info("notice has accepted");

    }


    public void loginwithValidEmailandPassword(String username,String password){


        clickTo(Locater.mainMenuLoginLink);
        //getLogger().info("user goes to login page");

        sendkeysTo(Locater.loginPageEmailInput,username);
        //getLogger().info("user writes "+username);

        sendkeysTo(Locater.loginPagePasswordInput,password);
        //getLogger().info("user writes "+password);

        clickTo(Locater.loginPageSubmitButton);
        //getLogger().info("user click submit button");


    }
    public void validateLoggingInSite(){

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(Locater.meinKontoonMainMenuBar)).isDisplayed());
        //getLogger().info("My Account Section is verified after is logged in ");

    }
}
