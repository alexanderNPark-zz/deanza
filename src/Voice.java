// ----------------------------------------------------------------------------------------------

// @version1

// @author  Alexander Park

//  File name:  Voice.java

//  Program purpose: Item specific data pertaining if the item is of Voice format

//  Revision history:

//   Date                  Programmer               Change ID   Description

//   06/25/18            Alexander Park                     ME            Initial implementation

// ----------------------------------------------------------------------------------------------
class Voice {
    private int duration;
    private String format;

    public Voice () {
        duration = 0;
        format = "";
    }
    public Voice (int duration, String format) {
        this.duration = duration;
        this.format = format;
    }
    public String toString () {
        return new String ("\tVOICE: Duration:" + duration + " (sec), Format: " + format);
    }

    public int getDuration() {
        return duration;
    }

    public String getFormat() {
        return format;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}