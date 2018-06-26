// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Media.java

//  Program purpose: Item specific data pertaining if the item is of Media format

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/25/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
class Media {
    private double size ;
    private String format;

    public Media () {
        size = 0;
        format = "";
    }
    public Media (double size, String format) {
        this.size = size;
        this.format = format;
    }
    public String toString () {
        return new String ("\tMEDIA: Size:" + size + " MB, Format: " + format);
    }

    //getters and setters
    public double getSize() {
        return size;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

