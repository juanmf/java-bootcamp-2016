/**
 * Created by choco on 29/02/16.
 */

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("/home/choco/test/file1");
        File file2 = new File("/home/choco/test/file2");

        RecentFile recent = new RecentFile();
        recent.addRecentFile(file1);
        recent.addRecentFile(file2);


    }
}
