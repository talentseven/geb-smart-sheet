package GebPages

import GebModules.HomePageModule
import geb.Page
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebElement

class HomePage extends Page{

    // Sheets - Smartsheet.com
    static at = { title.startsWith("Sheets - Smartsheet.com") }

    static content = {
        homePage { module ( HomePageModule) }
    }

    /**ß
     * This method execute javascript in the browser console
     * @param script - Script to be run
     * @return
     */

    def js(String script, target = null) {
        def value;
        waitFor {
            try {
                if (target){
                    value = (driver as JavascriptExecutor).executeScript(script, target)
                }else{
                    value = (driver as JavascriptExecutor).executeScript(script)
                }

                true
            } catch (WebDriverException) {
                //Skipping the exception
                false
            }
        }
        return value
    }

    /**
     * This method is used to simulate mouse RightClick
     * @param object
     * @return
     */
    def rightClick( def object ){
        interact {
            contextClick(object).perform()
        }
    }

    /**
     * This method is used to set new column's name
     * @param columnName
     * @return
     */
    def setNewColumnName (String columnName){
        return  js("arguments[0].setAttribute('value', '" + columnName +"')", homePage.inputColumnName)
    }


    /**
     * This method is used to verifyUtil current test status
     * @param condition
     * @param message
     */
    def verifyUtil(boolean condition, String message){
        if(!condition) {
            println(message)
        }
        return this
    }

    /**
     * Verifies whether the element is present or not.
     * @param Closure block that returns a navigator object
     * @return true or false depending upon the result
     */
    boolean verifyElementPresent(WebElement element) {
        try {
            element.isDisplayed()
            return true
        }
        catch (StaleElementReferenceException e) {
            return false

        } catch (NoSuchElementException e){
            return false
        }
    }



}
