package com.qa.project.utilities;


// import java.time.Duration;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Random;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
// import com.microsoft.playwright.Page;
// import com.qa.opencart.factory.PlaywrightFactory;
// import jline.internal.Log;

// public class HelperMethods{
// 	Page page;

//     public void waitInSeconds(double d) {
//         try {
//             Thread.sleep((long) (d * 1000));
//             Log.info("Waited " + d + " seconds deliberately" + "\n");
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
    
//     public void waitUntilElementTextIsVisibleIfStale(WebElementFacade webElement, String text, int maxAttempts) {
//         int attempt = 1;
//         WebElementFacade element = webElement;
        
//         while (attempt <= maxAttempts) {
//             // waitInSeconds(1);
//             try {
//                 waitForCondition()
//                     .withTimeout(Duration.ofMillis(250))
//                     .until(ExpectedConditions.textToBePresentInElementValue(element, text));
//                     Log.info("Element Text is visible...");  
//                 break;
//             } catch (Exception e) {
//                 Log.info("Attempt " + attempt + " of " + maxAttempts + ": Element Text is not found. Retrying...");

//                     if(attempt ==  maxAttempts){
//                     throw new RuntimeException("Tried for maximum attempts...................................." + maxAttempts);
//                 }

//                 attempt++;
//                 waitInSeconds(1);
//                 continue;
//             }
//         }
//     }

//     public void waitUntilElementsCountIsMoreThanGiven(By locators, int count, int maxAttempts) {
//         int attempt = 1;
//         while (attempt <= maxAttempts) {
//             // waitInSeconds(1);
//             try {
//                 waitForCondition()
//                     .withTimeout(Duration.ofMillis(250))
//                     .until(ExpectedConditions.numberOfElementsToBeMoreThan(locators, count));
//                     Log.info("Element is visible...");
//                 break;
//             } catch (Exception e) {
//                 Log.info("Attempt " + attempt + " of " + maxAttempts + ": Elements count is not more than " + count + " . Retrying...");

//                     if(attempt ==  maxAttempts){
//                     throw new RuntimeException("Tried for maximum attempts...................................." + maxAttempts);
//                 }

//                 attempt++;
//                 waitInSeconds(1);
//                 continue;
//             }
//         }
//     }
    
//     public void waitUntilElementsCountIsLessThanGiven(By locator, int count, int maxAttempts) {
//         int attempt = 1;
//         while (attempt <= maxAttempts) {
//             // waitInSeconds(1);
//             try {
//                 waitForCondition()
//                     .withTimeout(Duration.ofMillis(250))
//                     .until(ExpectedConditions.numberOfElementsToBeLessThan(locator, count));
//                     Log.info("Element is visible...");
//                 break;
//             } catch (Exception e) {
//                 Log.info("Attempt " + attempt + " of " + maxAttempts + ": Elements count is not less than " + count + " . Retrying...");

//                     if(attempt ==  maxAttempts){
//                     throw new RuntimeException("Tried for maximum attempts...................................." + maxAttempts);
//                 }

//                 attempt++;
//                 waitInSeconds(1);
//                 continue;
//             }
//         }
//     }

//     public void waitUntilElementIsVisibleIfStale(WebElementFacade webElement, int maxAttempts) {

//         int attempt = 1;
//         WebElementFacade element = webElement;
        
//         while (attempt <= maxAttempts) {
//             // waitInSeconds(1);
//             try {
//                 waitForCondition()
//                     .withTimeout(Duration.ofMillis(250))
//                     .until(ExpectedConditions.visibilityOf(element));
//                     Log.info("Element is visible...");
//                 break;
//             } catch (Exception e) {
//                 Log.info("Attempt " + attempt + " of " + maxAttempts + ": Element not found. Retrying...");

//                     if(attempt ==  maxAttempts){
//                     throw new RuntimeException("Tried for maximum attempts...................................." + maxAttempts);
//                 }

//                 attempt++;
//                 waitInSeconds(1);
//                 continue;
//             }
//         }
//     }
    
//     public void waitUntilElementsAreVisibleIfStale(List<WebElementFacade> webelements, int maxAttempts) {

//         int attempt = 1;
//         List<WebElementFacade> elements = webelements;
        
//         while (attempt <= maxAttempts) {
//             // waitInSeconds(1);
//             try {
//                 waitForCondition()
//                     .withTimeout(Duration.ofMillis(250))
//                     .until(ExpectedConditions.visibilityOf(elements.get(0)));
//                 break;
//             } catch (Exception e) {
//                 Log.info("Attempt " + attempt + " of " + maxAttempts + ": Element not found. Retrying...");
                
//                 if(attempt ==  maxAttempts){
//                     throw new RuntimeException("Tried for maximum attempts...................................." + maxAttempts);
//                 }
                
//                 attempt++;
//                 waitInSeconds(1);
//                 continue;
//             }
//         }
//     }

//     public int getRandomNumber(int start, int end) {
//         Random rand = new Random();
//         int num = rand.nextInt(end - start + 1) + start;
//         return num;
//     }

//     public void scrollIntoViewJS(WebElementFacade webElement) {
//         ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
//         Log.info("JS Scrolled into an Element" + "\n");
//     }
    
//     public void scrollIntoViewByAmount(int scrollAmount) {
//         ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, " + scrollAmount + ");");
//         Log.info("JS Scrolled for a specific amount: " + scrollAmount + "\n");
//     }

//     public void ignoreElementExeptionError(WebElementFacade webElement, long timeOutInSeconds) {
//         long time1 = System.currentTimeMillis();
//         try {
//             webElement.isCurrentlyEnabled();
//         } catch (Exception t) {
//             new WebDriverWait(getDriver(), Duration.ofSeconds(timeOutInSeconds))
//                 .ignoring(RuntimeException.class)
//                 .until(ExpectedConditions.elementToBeClickable(webElement));
//             boolean value = webElement.isCurrentlyEnabled();
//             Log.info("Ignored Exception and current element enability is: " + value + "\n");
//             long time2 = System.currentTimeMillis();
//             Log.info("Total time taken to Ignore Error is= " + (time2 - time1) / 1000 + " Seconds" + "\n");
//         }
//     }

//     public void clickOnElementJS(WebElementFacade webElement) {
//         JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//         executor.executeScript("arguments[0].click();", webElement);
//         Log.info("JS Clicked on an element: " + webElement + "\n");
//     }

//     public void doubleClickOnElementJS(WebElementFacade webElement) {
//         JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//         executor.executeScript("var evt = document.createEvent('MouseEvents');"+ 
//         		"evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"+ 
//         		"arguments[0].dispatchEvent(evt);", webElement);
//         Log.info("JS Double Clicked on an element: " + webElement + "\n");
//     }

//     public void sendKeysUsingJS(WebElementFacade webElement, String value) {
//         JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//         executor.executeScript("arguments[0].value='" + value + "'", webElement);
//     }

//     public String removeEmptyLinesWith(String actualLine, String replaceWith) {
//         return actualLine.replaceAll("[\\\r\\\n]+", replaceWith);
//     }

//     public String clickOnElementByTextfromListElements(List<WebElementFacade> webelements, String text) {
//         String value = null;

//         List<WebElementFacade> links = webelements;
//         for (int i = 0; i < links.size(); i++) {
//             links.get(i).waitUntilPresent();
//         	if(links.get(i).isPresent()) {
//                 if (links.get(i).getText().trim().toUpperCase().trim().contains(text.toUpperCase())) {
//                     value = links.get(i).getText().trim().toUpperCase();
// //                    links.get(i).waitUntilClickable();
//                     Serenity.takeScreenshot();
//                     links.get(i).waitUntilPresent();
//                     scrollIntoViewJS(links.get(i));
// //                    links.get(i).click();
//                     clickOnElementJS(links.get(i));

//                     Log.info(value + " => has been selected from the list" + "\n");
//                     break;
//                 }
//         	}
//         }
//         Serenity.takeScreenshot();
//         return value;
//     }
    
//     public String scrollOnElementByTextfromListElements(List<WebElementFacade> webelements, String text) {
//         String value = null;

//         List<WebElementFacade> links = webelements;
//         for (int i = 0; i < links.size(); i++) {
// //            links.get(i).waitUntilPresent();
//             if (links.get(i).getText().trim().toUpperCase().trim().contains(text.toUpperCase())) {
//                 value = links.get(i).getText().trim().toUpperCase();
// //                links.get(i).waitUntilClickable();
//                 Serenity.takeScreenshot();
//                 // waitInSeconds(.5);
//                 scrollIntoViewJS(links.get(i));

//                 Log.info(value + " => has been scrolled from the list" + "\n");
//                 break;
//             }
//         }
//         Serenity.takeScreenshot();
//         return value;
//     }

//     public List<String> getAllValuesFromListElements(List<WebElementFacade> webelements) {
//         List<String> values = new ArrayList<String>();
//         List<WebElementFacade> links = webelements;

//         for (int i = 0; i < links.size(); i++) {
//             links = webelements;

//             scrollIntoViewJS(links.get(i));
//             if(links.get(i).getTextValue() != ""){
//                 values.add(links.get(i).getTextValue());
//                 Log.info("Value" + i + " :"+ links.get(i).getTextValue() + "\n");
//             }
//         }
//         return values;
//     }

//     public String getValueForDatatableKey(DataTable dtValues, String key){
//         Log.info("Key: " + key + ", Value: " + dtValues.asMap().get(key));
//         return dtValues.asMap().get(key);
//     }

//     public List<String> getAllKeysFromTable(DataTable dtValues){
//         List<String> keys = new ArrayList<String>();
//         for(String key : dtValues.asMap().keySet()){
//             keys.add(key);
//             Log.info("Datatable key: " + key + "\n");
//         }
//         return keys;
//     }

//     public boolean isListContainsString(List<String> list, String item) {
//         for (int i = 0; i < list.size(); i++) {

//             if (list.size() != 0) {
//                 String value = list.get(i).trim();
//                 if (value.contains(item.toLowerCase())) {
//                     return true;
//                 }
//             } else if (list.size() == 0) {
//                 Log.info("There is no data in the table" + "\n");
//             }
//         }
//         return false;
//     }

//     public int getIndexIfListContainsString(List<String> list, String item) {
//         for (int i = 0; i < list.size(); i++) {

//             if (list.size() != 0) {
//                 String value = list.get(i).trim();
//                 if (value.contains(item.toLowerCase())) {
//                     return i;
//                 }
//             } else if (list.size() == 0) {
//                 Log.info("There is no data in the table" + "\n");
//             }
//         }
//         return -1;
//     }

//     public int getIndexIfWebElementValueListContainsString(List<WebElementFacade> webelements, String item) {
//         List<WebElementFacade> links = webelements;

//         for (int i = 0; i < links.size(); i++) {

//             if (links.size() != 0) {
//                 scrollIntoViewJS(links.get(i));
//                 String value = links.get(i).getTextValue().trim();
//                 if (value.contains(item)) {
//                     return i;
//                 }
//             } else if (links.size() == 0) {
//                 Log.info("There is no data in the table" + "\n");
//             }
//         }
//         return -1;
//     }
    
//     public int getIndexIfWebElementContentListContainsString(List<WebElementFacade> webelements, String item) {
//         List<WebElementFacade> links = webelements;

//         for (int i = 0; i < links.size(); i++) {

//             if (links.size() != 0) {
// //                scrollIntoViewJS(links.get(i));
//                 String value = links.get(i).getTextContent().toString();
//                 if (value.contains(item)) {
//                     return i;
//                 }
//             } else if (links.size() == 0) {
//                 Log.info("There is no data in the table" + "\n");
//             }
//         }
//         return -1;
//     }

//     public int convertStringIntoInt(WebElementFacade webElement) {
//         String initialString = webElement.getTextValue();
//         String numberOnly= initialString.replaceAll("[^0-9]", "");
//         return Integer.parseInt(numberOnly);
//     }
    
//     public boolean patternMatch(String type, String value ) {
//         Pattern pattern = null;
        
//         switch(type.toLowerCase()) {
//             case "dtg":
//                 pattern = Pattern.compile("[0-9]{2}\\s.{3}\\s[0000-9999]{4}", Pattern.CASE_INSENSITIVE);  
//                 break;
//             case "degrees":
//                 pattern = Pattern.compile("-?[0-9]*.[0-9]*,-?[0-180]*.[0-9]*", Pattern.CASE_INSENSITIVE); 
//                 break;
//             case "deg, min, sec":
//                 pattern = Pattern.compile("(\\d+[NS])(\\d+[EW])", Pattern.CASE_INSENSITIVE);
//                 break;
//             case "symbols & spacing":
//                 pattern = Pattern.compile("([0-9.]+)[^NS]*([NS]),\\s*([0-9.]+)[^EW]*([EW])", Pattern.CASE_INSENSITIVE);
//                 break;
//             default:
//                 Log.info("Invalid match for type: " + type); 
//                 break;
//         }
        
//         Matcher matcher = pattern.matcher(value);
//         return matcher.find();
//     }

//     public String getFieldTextByFieldHeading(By fieldHeadings, By textContainer, String headingText) {
//         List<WebElementFacade> bballHeadings = findAll(fieldHeadings);
//         Log.info("Finding field headings, looking for heading text " + headingText);
//         for (WebElementFacade i : bballHeadings) {
//             if(i.getText().contains(headingText)) {
//                 Log.info("Text matched. Returning text " + i.getText());
//                return i.find(textContainer).withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().getText();
//             }    
//             else{Log.info("non matched headings detected " + i.getText());}
//         }   
//             return "empty";
//     }
// //  Serenity.setSessionVariable("id_session_var").to(value);
// //  String id_session_var = Serenity.sessionVariableCalled("id_session_var");
// }
