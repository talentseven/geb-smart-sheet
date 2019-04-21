package GebModules

import geb.Module

class HomePageModule extends Module{

    static content = {

        homeButton { $('.button')}
        panelMenu { $('.leftNavToggle')}
        logoIcon { $('.clsLightLogo')}


        // Create Grid Sheet Section
        sheetOption { $('.clsHomePageDetailPane')}
        createSheetButton {$(".clsHomeFeatureAdActionLink")}
        cridSheet { $('.clsGalleryTilePlainTitle ', text:contains('Grid'))}
        sheetName { $('.clsBorderBox.clsUserEnteredText')}
        okButton { $('.clsButtonContent', text:contains('OK')) }
        cancelButton { $('.clsButtonContent span', text: contains('Cancel')) }
        deleteButton { $('.clsButtonContent span', text: contains('Delete')) }

        // Grid Sheet Elements
        countColumns { $('.clsGMO.clsTableHeading').size()}
        primaryColumn { $('.clsTableHeadingText.clsGridPrimaryColumnHeading', text:contains('Primary Column'))}
        insertColumnLeft { $('.clsStandardMenuText', text:contains('Insert Column Left'))}
        insertColumnRight { $('.clsStandardMenuText', text:contains('Insert Column Right'))}
        deleteColumn { $('.clsStandardMenuText', text: contains('Delete Column'))}
        deleteSheet { $('.clsStandardMenuText', text: contains('Delete...'))}

        inputColumnName { $('input.clsBorderBox.clsUserEnteredText').first().firstElement()}
        findColumnByName { String columnName -> $('.clsTableHeadingText', text:contains(columnName)).parent() }
        selectSheetByName { String sheetName -> $('.clsCellContent.clsDetailItemOpenable.clsImageRenderingOptimization', text: contains(sheetName))}





    }
}