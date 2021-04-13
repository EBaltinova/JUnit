package generators;

import java.io.File;



public class FileGenerator {
    public static String create(String basePath) throws Exception {
        String test = basePath + "/test";
        String time = String.valueOf(System.currentTimeMillis());
        String pathname = test + time;
        File f = new File(pathname);

        if (!f.createNewFile()) {
            throw new Exception("Ошибка при создании файла");
        }

        return pathname;
    }

}
