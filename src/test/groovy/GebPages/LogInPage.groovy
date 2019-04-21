package GebPages

import GebModules.LogInPageModule
import geb.Page

class LogInPage extends Page{

    static at = { title.startsWith("Log In | Smartsheet") }

    static url = "https://app.smartsheet.com"


    static content = {
        logInPage { module(LogInPageModule)}
    }

    /**
     * This is method is used to login Smart Sheet
     * @param username
     * @param password
     * @return
     */
    def logInSmartSheet(String username, String password){

        waitFor { logInPage.username.displayed}
        waitFor { logInPage.username << username}
        waitFor { logInPage.continueButton.displayed}
        waitFor { logInPage.continueButton.click()}
        waitFor { logInPage.password.displayed}
        waitFor { logInPage.password << password}
        waitFor { logInPage.logInButton.displayed}
        waitFor { logInPage.logInButton.click()}
    }

}
