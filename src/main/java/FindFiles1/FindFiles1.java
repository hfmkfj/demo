package FindFiles1;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FindFiles1
 * Package: FindFiles1
 * Description:
 * 递归遍历一个目录，筛选出需要查找的文件类型
 *
 * @author : hj
 * @date : 2019-10-14 12:40
 */
public class FindFiles1 {

    public List<File> FindFiles(File folder, String suffix) {
        List<File> fileList = new ArrayList<>();
        if (folder.isFile()) {
            fileList.add(folder);
        }

        File[] subFolders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                if (file.getName().toLowerCase().endsWith(suffix)) {
                    return true;
                }
                return false;
            }
        });

        if (subFolders != null) {
            for (File file : subFolders) {
                if (file.isDirectory()){
                    fileList.addAll(FindFiles(file,suffix));
                }else {
                    fileList.add(file);
                }
            }
        }

        return fileList;
    }

    public static void main(String[] args) {
        FindFiles1 test1=new FindFiles1();
        List<File> fileList = test1.FindFiles(new File("C:\\Users\\fmkf\\Desktop"), "txt");
        for (File file:fileList){
            System.out.println(file.getName());
        }
        /*结果：
          2.txt
          3.txt
          你必须设置浏览器代理才能使用.txt
          1.txt
          面试.txt
         */
    }

}
