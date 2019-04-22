package lab_3;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Main {
    public static Dossier docFind(int id,ArrayList<Dossier> vac){
        Iterator<Dossier> myItr = vac.iterator();
        while(myItr.hasNext()){
            Dossier t = myItr.next();
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    public static void main(String[] args) {
try(Scanner scan = new Scanner(System.in)){
    ArrayList<Dossier> dossiers = new ArrayList<>();
    String dateFormat = "dd/MM/yyyy";
        int command,id;
        while(true){
            System.out.println("1 - додати досьє");
            System.out.println("2 - видалити досьє");
            System.out.println("3 - переглянути список досьє");
            System.out.println("4 - меню досьє");
            System.out.println("5 - записати досьє в XML-файл");
            System.out.println("6 - витягти досьє з XML-файлу");
            System.out.println("7 - вийти");
            command = scan.nextInt();
            switch(command){
                case 1:
                    System.out.println("Введіть ім'я злочинця:");
                    scan.nextLine();
                    Dossier doc = new Dossier();
                    doc.setFirstName(scan.next());
                    dossiers.add(doc);
                    System.out.println("Досьє '"+doc.getFirstName()+"' додано з ідентифікатором: "+doc.getId());
                    break;
                case 2:
                    System.out.println("Введіть ідентифікатор досьє, щоб видалити:");
                    id = scan.nextInt();
                    Iterator<Dossier> myItr = dossiers.iterator();
                    boolean isFound = false;
                    while(myItr.hasNext()){
                        Dossier t = myItr.next();
                        if(t.getId() == id){
                            myItr.remove();
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound){
                        System.err.println("Такого елемента не знайдено!");
                    }
                    else{
                        System.out.println("Елемент видалено!");
                    }
                    break;
                case 3:
                    Iterator<Dossier> myItr1 = dossiers.iterator();
                    while(myItr1.hasNext()){
                        Dossier t = myItr1.next();
                        System.out.println(t.toString());
                    }
                    break;
                case 4:
                    System.out.println("Введіть ID досьє, щоб її редагувати: ");
                    id = scan.nextInt();
                    Dossier temp = docFind(id,dossiers);
                    if(temp != null){
                        System.out.println("Досьє знайдено!");
                        boolean exit = false;
                        while(!exit) {
                            System.out.println(temp.toString());
                            System.out.println("1 - Змінити ім'я");
                            System.out.println("2 - Змінити дату народження");
                            System.out.println("3 - Змінити дату ув'язнення");
                            System.out.println("4 - Змінити дату звільнення");
                            System.out.println("5 - Додати термін у тюрмі");
                            System.out.println("6 - Повернутись до гол. меню");
                            command  = scan.nextInt();
                            switch(command){
                                case 1:
                                    System.out.println("Введіть нове ім'я:");
                                    scan.nextLine();
                                    temp.setFirstName(scan.nextLine());
                                    System.out.println("Успішно змінено!");
                                    break;
                                case 2:
                                    System.out.println("Введіть нове ім'я:");
                                    scan.nextLine();
                                    temp.setFirstName(scan.nextLine());
                                    System.out.println("Успішно змінено!");
                                case 3:
                                    System.out.println("Введіть нову дату народження:");
                                    scan.nextLine();
                                    try {


                                        temp.setBirthDate(new SimpleDateFormat(dateFormat).parse(scan.nextLine()));
                                        System.out.println("Успішно змінено!");
                                    }catch(Exception e)
                                    {
                                        System.out.println("Error");
                                    }
                                    break;
                                case 4:
                                    try{
                                    System.out.println("Введіть нову дату ув'язнення:");
                                    scan.nextLine();
                                    temp.setDateOfImprisonment(new SimpleDateFormat(dateFormat).parse(scan.nextLine()));
                                    System.out.println("Успішно змінено!");
                                    }catch(Exception e)
                                    {
                                          System.out.println("Error");
                                    }
                                case 5:
                                    try{
                                    System.out.println("Введіть нову дату звільнення:");
                                    temp.setDateOfRelease(new SimpleDateFormat(dateFormat).parse(scan.nextLine()));
                                    System.out.println("Успішно змінено!");
                                    }catch(Exception e)
                                    {
                                        System.out.println("Error");
                                    }
                                case 6:
                                    try{
                                    System.out.println("Додавання нового терміну в тюрмі:");
                                    scan.nextLine();
                                    DatesInPrison dates = new DatesInPrison();
                                    System.out.println("Сів:");
                                    dates.setGetOut(new SimpleDateFormat(dateFormat).parse(scan.nextLine())));
                                    System.out.println("Вийшов:");
                                    dates.setGetOut(new SimpleDateFormat(dateFormat).parse(scan.nextLine()));
                                    System.out.println("Успішно змінено!");
                                    }catch(Exception e)
                                    {
                                        System.out.println("Error");
                                    }
                                case 7:
                                    exit = true;
                                    break;
                            }
                        }
                    }
                    else{
                        System.out.println("Досьє не знайдено!");
                    }
                    break;
                case 5:
                    FileOutputStream fos;
                    System.out.println("----Введіть назву файлу:");
                    scan.nextLine();
                    String file_name = scan.nextLine();
                    System.out.println("----Виберіть потрібну директорію, щоб зберегти файл:");
                    String path = FileManager.selectDir(scan.next()) + "\\" + file_name;
                    if (!(new File(path)).exists()) {
                        File newFile = new File(path);
                        try
                        {
                            if(newFile.createNewFile())
                                System.out.println("***Файл '"+file_name+"' було створено!");
                        }
                        catch(IOException ex){
                            System.out.println(ex.getMessage());
                            break;
                        }
                    }
                    try {
                        fos = new FileOutputStream( path);
                    }catch(FileNotFoundException ex){
                        System.err.println("Файл не знайдено!");
                        break;
                    }
                    XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fos));
                    encoder.writeObject((Integer) dossiers.size());
                    for(Dossier one : dossiers){
                        encoder.writeObject(one);
                    }
                    encoder.close();
                    System.out.println("Успішно записано!");
                    break;
                case 6:
                    System.out.println("1 - Створити новий список(не зберігається попередній)");
                    System.out.println("2 - Додати до поточного списку");
                    command = scan.nextInt();
                    switch(command){
                        case 1:
                            System.out.println("----Виберіть файл:");
                            scan.nextLine();
                            String path_ = FileManager.selectFile(scan);
                            FileInputStream fis;
                            try {
                                fis = new FileInputStream(path_);
                            }catch(FileNotFoundException ex){
                                System.err.println("FileNotFound");
                                break;
                            }
                            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fis));
                            Integer size = (Integer) decoder.readObject();
                           dossiers = new ArrayList<>() ;
                            Dossier.cleanDossier();
                            for (int i = 0; i < size; i++) {
                                dossiers.add((Dossier) decoder.readObject());
                            }
                            decoder.close();

                            break;
                        case 2:
                            System.out.println("----Виберіть файл:");
                            scan.nextLine();
                            String path__ = FileManager.selectFile(scan);
                            FileInputStream fis_;
                            try {
                                fis_ = new FileInputStream(path__);
                            }catch(FileNotFoundException ex){
                                System.err.println("FileNotFound");
                                break;
                            }
                            XMLDecoder decoder_ = new XMLDecoder(new BufferedInputStream(fis_));
                            Integer size_ = (Integer) decoder_.readObject();
                            for (int i = 0; i < size_; i++) {
                                dossiers.add((Dossier) decoder_.readObject());
                            }
                            decoder_.close();
                            break;
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;

            }
        }
    }

