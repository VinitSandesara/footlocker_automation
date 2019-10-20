package Rough;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Proxy;

public class ElementGuard {

    public static SelenideElement guard( SelenideElement element) {
        ElementProxy proxy = new ElementProxy(element);
        SelenideElement wrappdElement = (SelenideElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
                                                                       new Class[] { SelenideElement.class },
                                                                       proxy);
        return wrappdElement;
    }

}