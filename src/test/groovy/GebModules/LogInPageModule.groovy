package GebModules

import geb.Module

class LogInPageModule extends Module {

    static content = {

        username {$("#loginEmail")}
        password {$("#loginPassword")}
        continueButton {$("#formControl")}
        logInButton {$("#formControl")}

    }

}
