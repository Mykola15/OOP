package lab_3;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class FileManager {

    private String checkDir(String path) {
        String res = "";
        for (File f : Objects.requireNonNull(new File(path).listFiles())) {
            if (f.isDirectory()) {
                res += f.getName();
            } else {
                System.out.printf("Path -> %s + \n", f.getAbsolutePath());
            }
        }
        return res;
    }

    private void showDirs(String root, String s) {
        for (String sep : checkDir(root).split(s)) {
            System.out.printf("Names of files -> %s + \n", sep);
        }
    }

    public void selectDirectory(String p) {
        try (Scanner sc = new Scanner(System.in)) {
            label:
            while (true) {

                String separator = File.separator;
                if ("/" != separator) {
                    p = p.replace("/", separator);
                }
                String rootDir = System.getProperty("user.home");


                switch (p) {
                    case "/current":
                        showDirs(rootDir, separator);
                        new FileManager().selectDirectory(sc.next());
                        break label;
                    case "/prev":
                        String scan = sc.next();
                        if (scan.equals("/yes")) {
                            String parentPath = new File(rootDir).getParent();
                            showDirs(parentPath, checkDir(parentPath));
                            p = sc.next();
                        }
                        if (scan.equals("/no")) {
                            System.out.println("Next options");
                            p = sc.next();
                        }

                        break;
                    case "/out":
                        return;

                    default:
                        System.out.println("NO OPTIONS");
                        new FileManager().selectDirectory(sc.next());
                        break label;
                }

            }
        }
    }


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            new FileManager().selectDirectory(sc.next());
        }
    }
}
