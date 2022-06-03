package pages;

import org.openqa.selenium.By;

public interface Locater {
    String url = "https://brandstore.e-shopland.ch/";

    String username = "kursjava@gmail.com";

    String password = "kurs.java.123";
    By noticeAlertAusBlendenButton = By.xpath("//a[text()='Ausblenden']");
    By mainMenuLoginLink  = By.cssSelector("li#menu-item-825");
    By loginPageEmailInput = By.cssSelector("input#username");
    By loginPagePasswordInput = By.cssSelector("input#password");
    By loginPageSubmitButton = By.cssSelector("button[name='login']");

    By meinKontoonMainMenuBar = By.cssSelector("li#menu-item-3194");
    By homeButtonMainMenuBar= By.cssSelector("li#menu-item-381");
    By mainPageAllImages = By.cssSelector("html img");
    By mainPageProductImages = By.cssSelector("div.astra-shop-thumbnail-wrap a img");
    By mainMenuAlleProdukteLink = By.xpath("(//span[text()='Alle Produkte'])[1]");

    By listAllProductFilterButton = By.cssSelector("a[data-type='all']");
    By allProductImagesList = By.cssSelector("div.astra-shop-thumbnail-wrap img");

    By allProductPriceList=By.cssSelector("div.astra-shop-summary-wrap span.price bdi:not(del bdi)");

    By alleProdukteKatagorienSelect = By.cssSelector("select#product_cat");

    By selectedDropDownMenu = By.cssSelector("span.select2-selection__rendered");

    By selectedMenuHeader = By.cssSelector("header.woocommerce-products-header h1");

    By sortingCriteriasSelect = By.cssSelector("select.orderby");

    By ratingStarOnProductInfo = By.cssSelector("div.astra-shop-summary-wrap div.star-rating");
    By ratingStarSortingByRatingTextList = By.cssSelector("div.astra-shop-summary-wrap div.star-rating span");

    By alleProdukteProduteFilterButton = By.cssSelector("button.button.astra-shop-filter-button");

    By produkteFilterAlleFilterButton = By.cssSelector("div.wp-block-button");

    By filterByPriceSliderLeft = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]");

    By filterByPriceSliderRight = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]");

    By filterByPriceSlider = By.cssSelector("div.price_slider");

    By filterAfterSlidingMinPriceText = By.cssSelector("div.price_label span.from");
    By filterAfterSlidingMaxPriceText = By.cssSelector("div.price_label span.to");
    By filterByPriceButton = By.cssSelector("div.price_slider_amount button");

    By  filterByPricePricesResultList = By.cssSelector("div.astra-shop-summary-wrap span.price bdi:not(del bdi)");

    By filterByColorSelectDropdown = By.cssSelector("select.woocommerce-widget-layered-nav-dropdown.dropdown_layered_nav_farbe");

    By filterByColorFilterNowButton = By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[1]");

    By filterResultProductCartSectionList= By.cssSelector("span.price +a");

    By filterResultProductNameList = By.cssSelector("div.astra-shop-summary-wrap h2");

    By filterResultProductsImages = By.cssSelector("div.astra-shop-thumbnail-wrap");

    By eigenschaftenLink = By.cssSelector("li.additional_information_tab");

    By eigenschaftenFarbeText=By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_farbe th");

    By overviewButtonOnFilterResult = By.cssSelector("div.astra-shop-thumbnail-wrap a.ast-quick-view-text");

    By overviewSelectBar = By.cssSelector("select#pa_farbe");

    By overviewPageCloseButton = By.cssSelector("a#ast-quick-view-close");
    By overviewSelectedProductNameText = By.cssSelector("table.variations select option[selected='selected']");

    By filterBySizeSelectDropdown = By.cssSelector("select.woocommerce-widget-layered-nav-dropdown.dropdown_layered_nav_groesse.select2-hidden-accessible");

    By filterBySizeFilterNowButton = By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[2]");

    By productDisplaySizeSelect = By.cssSelector("select#pa_groesse");

    By filterByMaterialSelectDropdown = By.cssSelector("select.woocommerce-widget-layered-nav-dropdown.dropdown_layered_nav_material.select2-hidden-accessible");

    By filterByMaterialFilterNowButton = By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[3]");

    By eigenschaftenMaterialText = By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_material p");

    By filterByGenderSelectDropdown = By.cssSelector("select.woocommerce-widget-layered-nav-dropdown.dropdown_layered_nav_gender.select2-hidden-accessible");

    By filterByGenderFilterNowButton = By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[4]");

    By eigenschaftenGenderText =By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_gender p");

    By eigenschaftenSizeText = By.cssSelector("tr.woocommerce-product-attributes-item.woocommerce-product-attributes-item--attribute_pa_groesse td p");

    By heartIconsMainPageList = By.cssSelector("div.yith-wcwl-add-button");

    By productsNameMainPageList = By.cssSelector("div.astra-shop-summary-wrap h2");

    By wishListOnHeadMenuLink = By.xpath("(//div[@class='ast-builder-layout-element site-header-focus-item ast-header-button-2']//a)[1]");

    By productNamesOnWishListList = By.cssSelector("tbody.wishlist-items-wrapper td.product-name");

    By heartIconsAllCatagoriesPageList = By.cssSelector("div.yith-wcwl-add-button i");

    By productsNameAllCatagoriesPageList = By.cssSelector("div.astra-shop-summary-wrap h2");


     By productDisplayPageAddtoWishListLink = By.cssSelector("div.summary div.yith-wcwl-add-button a");

     By addtoWishListLinkResultText= By.cssSelector("div.yith-wcwl-wishlistexistsbrowse span");

     By productPageViewWishlistLink = By.cssSelector("div.yith-wcwl-wishlistaddedbrowse a");

     By productHeartBeatIconLink = By.cssSelector("div.yith-wcwl-wishlistaddedbrowse");

     By heartBeatIconAfterClickinHeartIcon = By.cssSelector("div.yith-wcwl-wishlistaddedbrowse");

     By similarProductsHeartIconOnDisplayPage=By.cssSelector("section div.yith-wcwl-add-button");

     By wishListOnFooterMenuLink = By.cssSelector("li#menu-item-5896 a");

     By allRemoveIconsOnWishList = By.cssSelector("td.product-remove a");

     By noProductResultTextOnWishList = By.cssSelector("tbody.wishlist-items-wrapper tr td");

     By productNameOnDisplayPage = By.cssSelector("div.summary.entry-summary h1");

     By productNameOnRecentlyViewedPage = By.cssSelector("div#woocommerce_recently_viewed_products-3 span.product-title");

     By headerSearchFieldIcon = By.xpath("(//div[@class='ast-search-icon'])[1]");

     By headerSearchFieldInput = By.xpath("(//input[@class='search-field'])[1]");

     By leftBottomSearchInputAltCatagories = By.cssSelector("input#wp-block-search__input-1");

     By searchResultProductNameList = By.cssSelector("h2.entry-title a");

     By addtoCompareListLinkOnProductDisplayPage = By.cssSelector("a.compare");

     By comparisonListLinkOnHeaderMenu =By.xpath ("(//a[@class='ast-custom-button-link'])[3]");

     By comparisonListLinkOnFooterMenu = By.cssSelector("li#menu-item-5897 a");
     By productsNameOnComparisonPage=By.cssSelector("tr.title.odd td");

     By removeIconsOnComparisonList = By.cssSelector("tr.remove.odd a");

     By noProductsInComparisonListResultText=By.cssSelector("tr.no-products td");

     By miniCartProductsNameList = By.xpath("//*[@id='ast-site-header-cart']/div[2]/div/div/ul/li[1]/a[2]");

     By addtoCartButtonOnMainPage = By.cssSelector("div.astra-shop-summary-wrap>a:nth-of-type(2)");

     By addtoCartButtonOnDisplayPage = By.cssSelector("div[class$='add-to-cart-enabled'] button");

     By addtoCartButtonOnDisplayPageWithoutSelection = By.cssSelector("button.single_add_to_cart_button.button.alt");

     By farbeElementonDisplayPage= By.cssSelector("label[for='pa_farbe']");
     By mainCartLinkOnDisplayPage = By.cssSelector("a.added_to_cart.wc-forward");

     By mainCartPageLinkOnHeaderMenu = By.cssSelector("li#menu-item-3091 a");
     By mainCartPageLinkOnFooterMenu = By.cssSelector("li#menu-item-2886 a");

     By mainCartPageIconOnHeaderMenuBar = By.xpath("(//div[@class='ast-cart-menu-wrap'])[1]");

     By productsTextsOnImages = By.cssSelector("a[class$='woocommerce-loop-product__link']");


     By proceedtoCheckoutButtonOnCart = By.cssSelector("a.checkout-button.button.alt.wc-forward");

     By billingDetailsTextOnCheckOutPage =By.cssSelector("div.woocommerce-billing-fields h3");

     By orderReviewButtonOnCheckOutPage =By.cssSelector("li.flex-nav-next");
     By orderOverviewAndPaymentMethodTextonCheckOutPage2 =By.cssSelector("h1.entry-title");

     By creditCardPaymentMethodRadioButton = By.cssSelector("input#payment_method_woocommerce_payments");

     By firstSavedCreditCartOption =By.cssSelector("ul[class$='wc-saved-payment-methods']>li:nth-of-type(1)");

     By checkboxAboveSendOrderButton = By.xpath("(//input[@type='checkbox'])[3]");

     By sendOrderButtonOnCheckOutPage2 = By.cssSelector("div button.button.alt");

     By orderAllDetailsTextAfterCheckOut = By.cssSelector("section.woocommerce-order-details h2");

     By checkoutButtonOnHeaderMenuBar = By.cssSelector("li#menu-item-3093");

     By miniCartIcoOnHeaderMenu = By.xpath("(//div[@id='ast-site-header-cart'])[1]");

     By myAccountLinkOnHeaderMenu = By.cssSelector("li#menu-item-3194");

     By myAccountOrdersList = By.cssSelector("li[class$='MyAccount-navigation-link--orders']");

     By orderDetailsOrderNumberText = By.cssSelector("li.woocommerce-order-overview__order.order strong");

     By myAccountOrdersFirstOrderNumberText  = By.xpath("(//td[@class='woocommerce-orders-table__cell woocommerce-orders-table__cell-order-number'])[1]//a");
}
