package com.example.servingwebcontent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import com.example.servingwebcontent.models.Product;

@Controller
public class ProductsController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @GetMapping("/products")
    public String index(Model model) {

        String sql = "SELECT * FROM products";
        List<Product> products = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Product.class));

        model.addAttribute("products", products);
        return "products/index";
    }
}