package spring.thymeleaf.controller;

import icon.treasury.entity.Rekening;
import icon.treasury.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by f.putra on 10/16/17.
 */
@Controller
public class DashboardController {

    @Autowired
    private RekeningService rekeningService;

    @GetMapping(value = {"/", "/dashboard", "dashboard.html"})
    public String dashboard(Model model) {
        return "dashboard";
    }
}
