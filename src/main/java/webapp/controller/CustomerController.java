package webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import webapp.model.Customer;
import webapp.model.CustomerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.util.*;

@Controller
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    final int PageSize = 50;

    @GetMapping("/customer/{page}")
    public String index(@PathVariable("page") int page, Model model) {
        int pageIndex = (page > 0) ? page - 1 : 0;
        PageRequest pageRequest = PageRequest.of(page - 1, PageSize);
        model.addAttribute("list", customerRepository.findAll(pageRequest));
        return "customer/index";
    }

    @GetMapping("/customer")
    public String index(Model model) {
        return index(1, model);
    }

    @GetMapping("/customer/import")
    public String imported(){
        return "customer/import";
    }

    @PostMapping("/customer/import")
    public String imported(MultipartFile f){
        try {
            InputStream is = f.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            //bo header
            String line = br.readLine();
            Pattern pattern = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            List<Customer> list = new ArrayList<>();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            while((line = br.readLine()) != null){
                String[] arr = pattern.split(line);
                Customer obj = new Customer(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9],format.parse(arr[10]), arr[11]);
                list.add(obj);
            }
            customerRepository.saveAll(list);
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/customer";
    }
}
