package Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;
import java.time.Duration;


public class Methods {
    public static WebDriver driver = DriverManager.getDriver();
    static Actions actions = new Actions(DriverManager.getDriver());
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //By title = By.className("main-header");

    public static WebElement elementPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static WebElement element(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement elementByClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
//    public List<WebElement> elements(By locator){
//        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
//    }
    public static void sendKeys(By locator, String string){
        element(locator).sendKeys(string);
    }
    public static void sendKeysEnter(By locator, String string){
        sendKeys(locator, string);
        sendKeys(locator,""+ Keys.ENTER);
    }
    public static void click(By locator) {
        element(locator).click();
    }
//    public void clickWithIndex(By locator, int index) {
//        elements(locator).get(index).click();
//    }
    public static String getText(By locator) {
        return element(locator).getText();
    }
//    public String getTexts(By locator, int i) {
//        return elements(locator).get(i).getText();
//    }
//    public void clickActionsWithIndex(By locator, int i) {
//        actions.click(elements(locator).get(i)).build().perform();
//    }

//    public void clickActions(By locator) {
//        actions.click(element(locator)).build().perform();
//    }

    public static void doubleClick(By locator) {
        actions.doubleClick(element(locator)).build().perform();
    }

    public static void rightClick(By locator) {
        actions.contextClick(element(locator)).build().perform();
    }

//    public void moveToElement(By locator) {
//        actions.moveToElement(element(locator)).perform();
//    }
//    public void moveToElements(By locator, int index) {
//        actions.moveToElement(elements(locator).get(index)).perform();
//    }
//
//    public void javaExecutorScrollIntoView(By locator) {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView()", element(locator));
//    }

//    public void javaExecutorClick(By locator) {
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", element(locator));
//    }

//    public String getTitleName() {
//        return getText(title);
//    }
    /* SELECT_ */
//    public Select select(WebElement element) {
//        return new Select(element);
//    }

//    public void selectByVisibleText(By locator, String text) {
//        select(element(locator)).selectByVisibleText(text);
//    }
//
//    public void selectWithIndex(By locator, int index) {
//        select(element(locator)).selectByIndex(index);
//    }
//
//    public void selectByValue(By locator, String value) {
//        select(element(locator)).selectByValue(value);
//    }
//
//    public boolean selectIsMultiple(By locator) {
//        select(element(locator)).isMultiple();
//        return true;
//    }

//    public void deselectByValue(By locator, String value) {
//        select(element(locator)).deselectByValue(value);
//    }
//
//    public void deselectAll(By locator) {
//        select(element(locator)).deselectAll();
//    }

//    public void getOptions(By locator) {
//        List<WebElement> option = select(element(locator)).getOptions();
//        System.out.println("The options you can choose to select are: ");
//        for (WebElement options : option)
//            System.out.println(options.getText());
//    }
//    public void keyDownControlActions(By locator, int i) {
//        actions.keyDown(elements(locator).get(i), Keys.CONTROL).perform();
//    }
    /* ALERTS_FRAMES_ */
//    public WebDriver.TargetLocator switchTo() {
//        return driver.switchTo();
//    }

//    public Alert switchToAlert() {
//        return switchTo().alert();
//    }

//    public void acceptAlert() {
//        switchToAlert().accept();
//    }
//
//    public void alertIsPresent() {
//        wait.until(ExpectedConditions.alertIsPresent());
//    }
//
//    public void dismissAlert() {
//        switchToAlert().dismiss();
//    }
//
//    public String getCurrentTab() {
//        return driver.getWindowHandle();
//    }

//    public ArrayList<String> get_all_tabs() {
//        return new ArrayList<>(driver.getWindowHandles());
//    }
//
//    public void switch_to_tab(ArrayList<String> tab, int index) {
//        switchTo().window(tab.get(index));
//    }
//
//    public void switch_to_window(ArrayList<String> window, int index) {
//        switchTo().window(window.get(index));
//    }

//    public void switchToMainWindow() {
//        switchTo().defaultContent();
//    }
//
//    public void availableFrameAndSwitchToIt(By locator) {
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
//    }
//
//    public void switchToFrame(By locator) {
//        switchTo().frame(element(locator));
//    }
//
//    public void switchToFrameByIndex(int index) {
//        switchTo().frame(index);
//    }
//
//    public void switchToFrameByName(String name) {
//        switchTo().frame(name);
//    }

//    public void switchToParentFrame() {
//        switchTo().parentFrame();
//    }
//
//    //Slider & DragAndDrop
//    public int widthOfElement(By locator) {
//        return element(locator).getSize().getWidth();
//    }
//
//    public void clickAndHoldSlider(By locator, int x, int y, int x1, int y1) {
//        actions.clickAndHold(element(locator)).moveByOffset(x, y).moveByOffset(x1, y1).release().perform();
//    }
//
//    public void dragAndDropWebElements(By locator1, By locator2, int i, int j) {
//        actions.dragAndDrop(elements(locator1).get(i), elements(locator2).get(j)).build().perform();
//    }
//
//    public void dragAndDropElement(By locator1, By locator2) {
//        actions.dragAndDrop(element(locator1), element(locator2)).build().perform();
//    }
//
//    public void dragAndDropByOffset(By locator, int x, int y) {
//        actions.dragAndDropBy(element(locator), x, y).build().perform();
//    }
//
//    public void dragAndDropByOffsetWithIndex(By locator, int index, int x, int y) {
//        actions.dragAndDropBy(elements(locator).get(index), x, y).build().perform();
//    }

    //Loader
//    public void loader(By locator) {
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//    }
//
//    public void uploadFileWithAutoIt(By locator, String path) throws InterruptedException, IOException, IOException {
//        javaExecutorScrollIntoView(locator);
//        moveToElement(locator);
//        clickActions(locator);
//        Thread.sleep(5000);
//        Runtime.getRuntime().exec(path);
//    }


}
