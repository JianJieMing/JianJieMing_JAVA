import java.io.File;

public class remove {
    public static void main(String[] args) {
//        Translation,
        String path = "C:\\Users\\Administrator\\Desktop\\apache-tomcat-7.0.86";
        File rootDir = new File(path);
        listFile(rootDir);
    }

    public static void listFile(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listFile(file);
            } else {
                String name = file.getName();
                if (name.startsWith(".")) {
                    System.out.println(name);
                }
            }
        }
    }
}

