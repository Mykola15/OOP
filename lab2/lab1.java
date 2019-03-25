import java.util.ArrayList;
import java.util.Scanner;

    public class lab1 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("hi!");
            ArrayList<MyContainer> listOfContainers = new ArrayList<>();
            byte command;
            while (true) {
                System.out.println("///==---==\\\\\\");
                System.out.println("1 - make container");
                System.out.println("2 - fill container");
                System.out.println("3 - clear container");
                System.out.println("4 - show container");
                System.out.println("5 - containers' list");
                System.out.println("6 - container menu");
                System.out.println("7 - exit");
                command = in.nextByte();
                switch (command) {
                    case 1:
                        System.out.print("enter container's max length: ");
                        listOfContainers.add(new MyContainer(in.nextInt()));
                        System.out.println("succes! your container's index is [" + listOfContainers.size() + "]");
                        break;
                    case 2:
                        System.out.print("enter container's index: ");
                        int index = in.nextInt();
                        if (index > listOfContainers.size() || index < 0) {
                            System.out.println("error! not found");
                            break;
                        }
                        System.out.println("Enter " + listOfContainers.get(index-1).maxSize() + " strings one by one:");
                        in.nextLine();
                        for (int i = 0, n = listOfContainers.get(index-1).maxSize(); i < n; i++) {
                            listOfContainers.get(index-1).add(in.nextLine());
                        }
                        break;
                    case 3:
                        System.out.print("enter container's index: ");
                        int delIndex = in.nextInt();
                        if (delIndex > listOfContainers.size() || delIndex < 1) {
                            System.out.println("error! not found");
                            break;
                        }
                        listOfContainers.get(delIndex-1).clear();
                        System.out.println("done!");
                        break;
                    case 4:
                        System.out.print("enter container's index: ");
                        int showIndex = in.nextInt();
                        if (showIndex > listOfContainers.size() || showIndex < 1) {
                            System.out.println("error! not found");
                            break;
                        }
                        System.out.println(listOfContainers.get(showIndex-1).toString());
                        break;
                    case 5:
                        for (int i = 0; i < listOfContainers.size(); i++) {
                            System.out.println("[" + (i+1) + "] - data: [" + listOfContainers.get(i).size() +
                                    "/" + listOfContainers.get(i).maxSize() + "]");
                        }
                        break;
                    case 6:
                        System.out.print("enter container's index: ");
                        int menuIndex = in.nextInt();
                        if (menuIndex > listOfContainers.size() || menuIndex < 1) {
                            System.out.println("error! not found");
                            break;
                        }
                        System.out.println("-~~~-");
                        System.out.println("1 - add element");
                        System.out.println("2 - remove element");
                        System.out.println("3 - convert to array and iterate through");
                        System.out.println("4 - current size");
                        System.out.println("5 - max size");
                        System.out.println("6 - check string");
                        System.out.println("7 - check sub container");
                        System.out.println("8 - write to file (serialize)");
                        System.out.println("9 - read from file (deserialize)");
                        System.out.println("10 - get element by index");
                        System.out.println("11 - get element's index");
                        System.out.println("12 - sort");
                        System.out.println("13 - iterate through container (foreach)");
                        System.out.println("14 - iterate through container (while)");
                        System.out.println("15 - lab1");
                        System.out.println("16-return");
                        command = in.nextByte();
                        switch (command) {
                            case 1:
                                System.out.println("enter element:");
                                in.nextLine();
                                listOfContainers.get(menuIndex-1).add(in.nextLine());
                                break;
                            case 2:
                                System.out.println("enter element:");
                                in.nextLine();
                                listOfContainers.get(menuIndex-1).remove(in.nextLine());
                                break;
                            case 3:
                                for (String i : listOfContainers.get(menuIndex-1).toArray()) {
                                    System.out.println(i);
                                }
                                break;
                            case 4:
                                System.out.println(listOfContainers.get(menuIndex-1).size());
                                break;
                            case 5:
                                System.out.println(listOfContainers.get(menuIndex-1).maxSize());
                                break;
                            case 6:
                                System.out.println("enter string to check if it exist in container:");
                                in.nextLine();
                                System.out.println(listOfContainers.get(menuIndex-1).contains(in.nextLine()));
                                break;
                            case 7:
                                System.out.print("enter index: ");
                                int subContainerIndex = in.nextInt();
                                if (subContainerIndex > listOfContainers.size() || subContainerIndex < 1) {
                                    System.out.println("not found!");
                                    break;
                                }
                                System.out.println("[" + subContainerIndex + "] is sub container of [" + menuIndex +
                                        "] - " + listOfContainers.get(menuIndex-1).containsAll(listOfContainers
                                        .get(subContainerIndex-1)));
                                break;
                            case 8:
                                System.out.println("enter file name(name.format): ");
                                in.nextLine();
                                listOfContainers.get(menuIndex-1).serialize(in.nextLine());
                                break;
                            case 9:
                                System.out.println("enter file name(name.format): ");
                                in.nextLine();
                                listOfContainers.get(menuIndex-1).deserialize(in.nextLine());
                                break;
                            case 10:
                                System.out.print("enter index: ");
                                System.out.println(listOfContainers.get(menuIndex-1).get(in.nextInt()-1));
                                break;
                            case 11:
                                System.out.println("enter element:");
                                in.nextLine();
                                System.out.println(listOfContainers.get(menuIndex-1).indexOf(in.nextLine())-1);
                                break;
                            case 12:
                                listOfContainers.get(menuIndex-1).sort();
                                System.out.println("done!");
                            case 13:
                                for (String i : listOfContainers.get(menuIndex-1)) {
                                    System.out.println(i);
                                }
                                break;
                            case 14:
                                MyIterator i = (MyIterator) listOfContainers.get(menuIndex-1).iterator();
                                while (i.hasNext()) {
                                    System.out.println(i.next());
                                }
                                break;
                            case 15:
                                Lab2.lab2(null);
                            case 16:
                                break;
                            default:
                                System.out.println("command not found!");
                        }
                        break;
                    case 7:
                        System.out.println("bye!");
                        System.exit(0);
                    default:
                        System.out.println("command not found");
                }
            }
        }


}
