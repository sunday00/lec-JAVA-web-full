package lec.sunday00.reservation.controller;

import lec.sunday00.reservation.model.Display;
import lec.sunday00.reservation.model.ImageFile;
import lec.sunday00.reservation.service.DisplayServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/display")
public class WebDisplayController {

    @Autowired
    DisplayServiceInterface displayServiceInterface;

    @GetMapping("/show/{displayId}")
    public String index (@PathVariable(name = "displayId", required = true) int displayId, ModelMap model) {
        Display display = displayServiceInterface.selectOne(displayId);
        model.addAttribute("displayInfo", display);

        List<ImageFile> mainImages = new ArrayList<ImageFile>();
        display.getImages().forEach( imageFile -> {
            if( imageFile.getType().equals("ma") || imageFile.getType().equals("et") ) mainImages.add(imageFile);
        });

        model.addAttribute("mainImages", mainImages);

        return "detail";
    }
}
