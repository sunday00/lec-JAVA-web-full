package lec.spring.layered.controllers;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/file")
public class FileController {

    private String dir = "/Users/sunday00/IdeaProjects/guest-book/target/guest-book/resources";

    @GetMapping(path = {"/", ""})
    public String index () {
        return "test/file";
    }

    @PostMapping(path = {"/", ""})
    public String upload (@RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
//        String path = "/img/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+file.getOriginalFilename();
        String path = "/img/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.")) + FilenameUtils.getExtension(file.getOriginalFilename());

        FileOutputStream fileSavePath = new FileOutputStream(this.dir + path);
        InputStream is = file.getInputStream();

        int readCount = 0;
        byte[] buffer = new byte[1024];
        while ((readCount = is.read(buffer)) != -1){
            fileSavePath.write(buffer, 0, readCount);
        }

        modelMap.addAttribute("src", path);

        // dir scan

        File folder = new File(dir + "/img/");
        File[] fileList = folder.listFiles();

        modelMap.addAttribute("images", fileList);

        return "test/gallery";
    }

    @GetMapping("/download/{filename:.+}")
    public String download (@PathVariable(name = "filename") String filename, HttpServletResponse response) throws IOException {

        System.out.println(filename);

        File file = FileUtils.getFile(this.dir + "/img/"+ filename);

        System.out.println(file);

        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", Files.probeContentType(file.toPath()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1;");

        FileInputStream fis = new FileInputStream(this.dir + "/img/" + filename);
        OutputStream os = response.getOutputStream();

        int readCount = 0;
        byte[] buffer = new byte[1024];
        while ( (readCount = fis.read(buffer)) != -1){
            os.write(buffer, 0, readCount);
        }

        return "redirect:/file";
    }
}
