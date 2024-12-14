package webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import webapp.model.*;

@Controller
public class HomeController {
    private final int Size = 30;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        var pageable = PageRequest.of(1, Size);
        model.addAttribute("list", productRepository.findAll(pageable));
        return "home/index";
    }

    @GetMapping("/home/category/{id}")
    public String category(@PathVariable("id") short id, Model model) {
        //findAllByCategory
        model.addAttribute("categories", categoryRepository.findAll());
        var pageable = PageRequest.of(1, Size);
        Category obj = categoryRepository.findById(id).get();
        model.addAttribute("obj", obj);
        model.addAttribute("list", productRepository.findAllByCategory(id, pageable));
        return "home/sub";
    }

    @GetMapping("/home/sub/{id}")
    public String sub(@PathVariable("id") short id, Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        var pageable = PageRequest.of(1, Size);
        SubCategory obj = subcategoryRepository.findById(id).get();
        model.addAttribute("obj", obj);
        model.addAttribute("list", productRepository.findAllBySubCategory(obj, pageable));
        return "home/sub";
    }

    @GetMapping("/home/details/{id}")
    public String details(@PathVariable("id") int id, Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        var pageable = PageRequest.of(1, Size);
        Product obj = productRepository.findById(id).get();
        model.addAttribute("obj", obj);
        model.addAttribute("list", productRepository.findAllBySubCategoryAndIdNot(obj.getSubCategory(), id, pageable));
        return "home/details";
    }

}