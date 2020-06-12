package lec.spring.layered.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/guess")
public class GuessController {

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index (HttpServletRequest req,
                         HttpServletResponse res,
                         ModelMap modelMap) {

        HttpSession session = req.getSession(false);
        int tryNumber = 0;
        List <Integer> history = new ArrayList<>();
        if( session == null || session.getAttribute("tryNumber") == null ){
            session.setAttribute("number", Math.round( Math.random() * 10));
            session.setAttribute("tryNumber", tryNumber + 1);
            session.setAttribute("history", history);
        } else {
            tryNumber = Integer.parseInt(session.getAttribute("tryNumber").toString());
            session.setAttribute("tryNumber", tryNumber + 1);
            history = (List) session.getAttribute("history");
            history.add(Integer.parseInt(req.getParameter("answer")));
            session.setAttribute("history", history);
        }

        System.out.println(session.getAttribute("number"));
        modelMap.addAttribute("tryNumber", tryNumber);
        modelMap.addAttribute("history", history);

        if( req.getParameter("answer") == ""){
            modelMap.addAttribute("notOk", "empty");
            return "guess";
        }

        if( req.getParameter("answer").equals(session.getAttribute("number").toString()) ){
            modelMap.addAttribute("ok", true);
            session.invalidate();
        } else {
            if( Integer.parseInt(req.getParameter("answer")) > Integer.parseInt(session.getAttribute("number").toString()) ){
                modelMap.addAttribute("notOk", "to big");
            } else {
                modelMap.addAttribute("notOk", "to small");
            }
        }

        return "guess";
    }
}
