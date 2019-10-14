package FindFiles2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: FIndFiles2
 * Package: FindFiles2
 * Description:
 *
 * @author : hj
 * @date : 2019-10-14 13:09
 */
public class FIndFiles2 {

    public List<File> FindFiles(File folder, String suffix) throws IOException {
        Path path = FileSystems.getDefault().getPath(folder.getAbsolutePath());
        /*List<File> fileList = Files.walk(path).filter(new Predicate<Path>() {
            @Override
            public boolean test(Path path) {
                return path.toFile().isFile();
            }
        }).filter(new Predicate<Path>() {
            @Override
            public boolean test(Path path) {
                return path.toString().endsWith(suffix);
            }
        }).map(new Function<Path, File>() {
            @Override
            public File apply(Path path) {
                return path.toFile();
            }
        }).collect(Collectors.toList());
        return fileList;*/
        /*
        return Files.walk(path).filter(
                (path1) -> path1.toFile().isFile()).filter(
                (path2) -> path2.toString().endsWith(suffix)).map(
                (path3) -> path3.toFile()).collect(Collectors.toList());
         */
        return Files.walk(path).filter(
                (path1) -> path1.toFile().isFile()).filter(
                (path2) -> path2.toString().endsWith(suffix)).map(
                Path::toFile).collect(Collectors.toList());
    }

}
