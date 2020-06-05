package lec.sunday00.reservation.controller;

import lec.sunday00.reservation.model.Display;
import lec.sunday00.reservation.service.DisplayServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/display")
public class ApiDisplayController {

    @Autowired
    DisplayServiceInterface displayServiceInterface;

    @GetMapping("/count/{category}")
    public int selectCount( @PathVariable(name = "category") String category ){
        return displayServiceInterface.selectCount(category);
    }

    @GetMapping("/{category}/{page}")
    public List<Display> select (@PathVariable(name = "category") String category,
                                 @PathVariable(name = "page", required = false) Integer page ) {

        if( page == null ) page = 1;
        return displayServiceInterface.select(category, page);
    }
}
