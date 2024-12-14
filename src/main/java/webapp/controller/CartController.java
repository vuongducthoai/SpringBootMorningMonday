package webapp.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import webapp.model.Cart;
import webapp.model.CartRepository;
import webapp.services.Helper;

@Controller
public class CartController {
    @Autowired
    CartRepository repository;
    @PostMapping("/cart/add")
    public String add(Cart obj, HttpServletResponse res, @CookieValue(name="cart", defaultValue = "") String code){
        //Cookie
        if(code.isBlank()){
            code = Helper.randomString(32);
            Cookie cookie = new Cookie("cart", code);
            res.addCookie(cookie);
        }
        obj.setCode(code);
        repository.saveCart(obj.getCode(), obj.getProduct().getId(), obj.getQuantity());
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String index(Model model, @CookieValue(name="cart", defaultValue = "") String code){
        if(code.isEmpty()){
            return "redirect:/";
        }
        model.addAttribute("list", repository.findAllByCode(code));
        return "cart/index";
    }

    @PostMapping("cart/edit")
    @ResponseBody public int edit(Cart obj) {
        try {
            repository.update(obj.getId(), obj.getQuantity());
            return 1;
        } catch (Exception ex){
            System.err.println(ex);
            return 0;
        }
    }
}
