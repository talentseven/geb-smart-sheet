package GebSpecs

import GebPages.HomePage
import GebPages.LogInPage
import geb.Browser
import geb.spock.GebSpec
import org.openqa.selenium.WebElement
import spock.lang.Shared

class GridSheetSpec extends GebSpec {

    @Shared String username  = "tianzi1007@gmail.com"
    @Shared String password  = "SmartSheet123"
    @Shared String sheetName  = "SmartSheetTest"
    @Shared String columnName  = "Column7"
    @Shared String baseUrl  = "https://app.smartsheet.com"


    def "Verify that as a user, I am able to add and delete Text/Number Columns in Grid Sheet"() {

        when:"Navigate to SmartSheet Login Page "
        Browser browser = new Browser()
        browser.go(baseUrl)
        waitFor { at LogInPage}
        logInSmartSheet(username, password)
        waitFor { at HomePage}

        then:"Verify that user has successfully login."
        verifyUtil( waitFor{ homePage.sheetOption.displayed} == true, "Login Failed: username "+ username)

        when:"Create a Grid Sheet"
        waitFor { homePage.sheetOption.click()}
        waitFor { homePage.createSheetButton.displayed}
        waitFor { homePage.createSheetButton.click()}
        waitFor { homePage.cridSheet.displayed}
        waitFor { homePage.cridSheet.click()}
        waitFor { homePage.sheetName.value(sheetName)}
        waitFor { homePage.okButton.displayed}
        waitFor { homePage.okButton.click()}

        then:"Verify that a Grid Sheet has been created."
        verifyUtil(waitFor { homePage.primaryColumn.displayed } == true, "Grid Sheet creation is Failed. ")

        when:"Add a new Text/Number Column in the Sheet"
        rightClick(homePage.primaryColumn)
        waitFor { homePage.insertColumnRight.click()}
        setNewColumnName(columnName)
        waitFor { homePage.okButton.click()}
        WebElement newColumnElement = homePage.findColumnByName(columnName).firstElement()

        then: "Verify that the 'New Column' has been added in the sheet"
        verifyUtil( verifyElementPresent(newColumnElement) == true, "New Column: " + columnName + " is not Displayed "  )

        when:"Delete Column "
        rightClick(homePage.findColumnByName(columnName))
        waitFor {homePage.deleteColumn.click()}

        then:"Verify that the 'New Column' has been Deleted"
        verifyUtil( verifyElementPresent(newColumnElement) == false, "Deleting "+columnName+ " Failed" )

        cleanup:"Clean up test data"
        waitFor { homePage.logoIcon.click()}
        rightClick(homePage.selectSheetByName(sheetName))
        waitFor { homePage.deleteSheet.click()}
        waitFor { homePage.deleteButton.click()}
        driver.quit()
    }
}
