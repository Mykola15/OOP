package lab_3;

import java.util.Date;

public class DatesInPrison {
    private Date getIn;
    private Date getOut;


    public Date getGetOut() {
        return getOut;
    }

    public Date getGetIn() {
        return getIn;
    }

    public void setGetOut(Date getOut) {
        this.getOut = getOut;
    }

    public void setGetIn(Date getIn) {
        this.getIn = getIn;
    }


    public String toString() {
        return new String("Сів: " + getIn + ", Вийшов: " + getOut);
    }
}

