// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  MSListingApp.java

//  Program purpose: A class starting the program that launches MSListingView and initializes PropertyList

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/1/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
import java.awt.*;

/**
 * Created by AlexP on 6/1/2018.
 */
public class MSListingApp {

    public static void main(String[] arg) {
        PropertyList props = new PropertyList();
        props.initialize();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MSListingView view = new MSListingView();
                view.setProperty(props);
                view.setVisible(true);
            }

        });
    }
}
