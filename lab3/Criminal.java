import java.util.ArrayList;

public class Criminal{
    private static int counter = 0;
    private int id;
    private String doc;
    private String birthday;
    private String in;
    private String out;
    private ArrayList<DatesInPrison> dates;

    public Criminal(){
        dates = new ArrayList<>();
        id = counter++;
    }
    public static void cleanVacancy(){
        counter = 0;
    }
    public void addDates(DatesInPrison dattes){
        dates.add(dattes);
    }
    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("-----------------------------------------\n");
        str.append("ID: ").append(id).append("\n");
        str.append("Досьє: ").append(doc).append("\n");
        str.append("Дата народження: ").append(birthday).append("\n");
        str.append("Дата ув'язнення: ").append(in).append("\n");
        str.append("Дата звільнення: ").append(out).append("\n");
        str.append("Терміни у тюрмі:\n");
        int count = 0;
        for(DatesInPrison pref : dates){
            str.append("\t").append(count).append(". ").append(pref.toString()).append("\n");
        }
        str.append("-----------------------------------------");
        return str.toString();
    }
}