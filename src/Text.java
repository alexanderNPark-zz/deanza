// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Text.java

//  Program purpose: Item specific data pertaining if the item is of Text format

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/25/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
class Text {
    private String content;

    public Text () { content = ""; }
    public Text (String text) { content = text; }

    public String toString () {
        return "\tTEXT: " + content;
    }

    //getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

