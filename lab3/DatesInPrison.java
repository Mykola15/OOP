public class DatesInPrison {
    private String getIn;
    private String getOut;


    public String getGetIn() {
        return getIn;
    }

    public void setGetIn(String getIn) {
        this.getIn = getIn;
    }

    public String getGetOut() {
        return getOut;
    }

    public void setGetOut(String getOut) {
        this.getOut = getOut;
    }

    public String toString() {
        return new String("Сів: " + getIn + ", Вийшов: " + getOut);
    }
}

