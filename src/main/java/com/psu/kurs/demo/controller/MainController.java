package com.psu.kurs.demo.controller;

import com.psu.kurs.demo.PoiTestExel;
import com.psu.kurs.demo.PoiTestWord;
import com.psu.kurs.demo.dao.*;
import com.psu.kurs.demo.entity.Address;
import com.psu.kurs.demo.entity.Platforms;
import com.psu.kurs.demo.entity.Products;
import com.psu.kurs.demo.entity.User;
import com.psu.kurs.demo.services.MediaTypeUtils;
import com.psu.kurs.demo.services.MenuService;
import com.psu.kurs.demo.services.OtherService;
import com.psu.kurs.demo.services.UserService;
//import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    PlatformsRepository platformsRepository;

    @Autowired
    GenresRepository genresRepository;

    @Autowired
    LanguagesRepository languagesRepository;

    @Autowired
    AgeLimitsRepository ageLimitsRepository;

    @Autowired
    PublishersRepository publishersRepository;

    @Autowired
    ImagesTRepository imagesTRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    @Autowired
    RequestsRepository requestsRepository;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    FinalOrderRepository finalOrderRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MenuService menuService;

    @Autowired
    OtherService otherService;

    @GetMapping("/errfind")
    public String errfind(Model model){
        model = menuService.getMenuItems(model); //get menu items
        return "errfind";
    }


    @GetMapping("/productq")
    public String getProductByName(@RequestParam(value = "productName", required = true) String productName,
                                   Model model) {
        if(productName==null||productName=="") {
            return "redirect:/index";
        }
        Products product = productsRepository.findByTitle(productName);
        if(product == null)
        {
            System.out.println("productnull");
//            Category category = null;
//            List<Category> categories = catRepository.findByNameContainsIgnoreCase(productName);
//            if(categories.size()>0)
//                category = categories.get(0);
//            if(category == null)
//            {
//                return "redirect:/index";
//            }
//            else {
//                return "redirect:/products?catId="+category.getId();
//            }

            return "redirect:/errfind";
        }


//        model.addAttribute("product", product);
        return "redirect:/game/"+product.getId();
    }


    @Autowired
    private ServletContext servletContext;

    @GetMapping("/downExel")
    public ResponseEntity<InputStreamResource> downloadExel() throws IOException, FileNotFoundException {

        PoiTestExel poiTestExel = new PoiTestExel();
        try {
            poiTestExel.run(productsRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = "products.xls";
        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        logger.info("  " + mediaType);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        File file = new File("D:\\demo_\\products.xls");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(mediaType)
                .contentLength(file.length())
                .body(resource);
    }

    @GetMapping("/downWord")
    public ResponseEntity<InputStreamResource> downloadWord() throws IOException, FileNotFoundException {

        PoiTestWord poiTestWord = new PoiTestWord();
        try {
            poiTestWord.run(productsRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = "products.docx";
        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        logger.info("  " + mediaType);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        File file = new File("D:\\demo_\\products.docx");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(mediaType)
                .contentLength(file.length())
                .body(resource);
    }

    @GetMapping("/e")
    public @ResponseBody
    String getWordExel() {

        PoiTestExel poiTestExel = new PoiTestExel();
        try {
            poiTestExel.run(productsRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "exel";
    }

    @GetMapping("/t")
    public @ResponseBody
    String getWordFile() {

        PoiTestWord poiTestWord = new PoiTestWord();
        try {
            poiTestWord.run(productsRepository);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "word";
    }

    @GetMapping(value = {"/"})
    public String index(Model model) {

        model = menuService.getMenuItems(model); //get menu items

        return "index";
    }

    @GetMapping(value = {"/getGameByPlatform/{id}"})
    public String getGameByPlatform(Model model, @PathVariable String id) {

        List<Products> newListProduct = new ArrayList<>();
        List<Products> productsList = productsRepository.findAll();

        for (Products prod : productsList) {
            System.out.println("idP:" + prod.getPlatforms().getId());
            if (prod.getPlatforms().getId() == Long.valueOf(id)) {
                newListProduct.add(prod);
            }
        }

        model = menuService.getMenuItems(model); //get menu items
        model.addAttribute("newListProduct", newListProduct);
        System.out.println("size prod:" + newListProduct.size());

        return "getGameByPlatform";
    }

    @GetMapping(value = {"/getGameByGenre/{id}"})
    public String getGameByGenre(Model model, @PathVariable String id) {

        List<Products> newListProduct = new ArrayList<>();
        List<Products> productsList = productsRepository.findAll();

        for (Products prod : productsList) {
//            System.out.println("idP:"+prod.getPlatforms().getId());
            if (prod.getGenres().getId() == Long.valueOf(id)) {
                newListProduct.add(prod);
            }
        }

        model = menuService.getMenuItems(model); //get menu items
        model.addAttribute("newListProduct", newListProduct);
        System.out.println("size prod:" + newListProduct.size());

        return "getGameByGenre";
    }


    @GetMapping("/game/{id}")
    public String game(@PathVariable String id, Model model, HttpServletRequest request) {

        model = menuService.getMenuItems(model); //get menu items

        logger.info("gameID");
        logger.info("game id: " + id);

        Products product;

//        String str = new String();
        try {
            product = productsRepository.findById(Long.parseLong(id)).get();
            model.addAttribute("product", product);
            logger.info("product #" + id + ": " + product.toString());

//            str = request.getRequestURL().toString();

            model.addAttribute("currentURL", otherService.getCurrentUrl(request));

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return "game";
    }


    @GetMapping("/genres")
    public String genres(Model model) {

        model = menuService.getMenuItems(model); //get menu items

        return "genres";
    }

    @GetMapping("/listplatforms")
    public String listplatforms(Model model) {

        model = menuService.getMenuItems(model); //get menu items

        return "listplatforms";
    }

    @GetMapping("/delivery")
    public String delivery(Model model) {

        model = menuService.getMenuItems(model); //get menu items

        return "delivery";
    }


    @GetMapping("/about")
    public String about(Model model) {

        model = menuService.getMenuItems(model); //get menu items

        return "about";
    }


    @GetMapping("/platform/{id}")
    public String getPlatformId(@PathVariable String id, Model model) {

        model = menuService.getMenuItems(model); //get menu items

        logger.info("id: " + id);

        Long idNew = 1L;

        if (id != null) {
            idNew = Long.valueOf(id);
        }

        Platforms platform;

        try {
            //для данных
            platform = platformsRepository.getOne(idNew);
            model.addAttribute("platform", platform);
            logger.info("platform");
        } catch (Exception ex) {

        }

        return "platform";
    }


    @GetMapping("/login")
    public String login(Model model) {

        model = menuService.getMenuItems(model); //get menu items
        return "login";
    }

    @GetMapping("/registration")
    public String reg(Model model) {
        logger.info("get registration");

        model = menuService.getMenuItems(model); //get menu items

        return "/registration";
    }

    @GetMapping("/delusr")
    public @ResponseBody
    String delUsr() {
        userService.deleteUserWithRole(4L);
        return "test del usr";
    }

    @PersistenceContext
    private EntityManager entityManager;

    //обработка регистрации
    @PostMapping("/registration")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("city") String city,
                          @RequestParam("street") String street,
                          @RequestParam("flatNumber") String flatNumber,
                          Model model) {
        logger.info("post reg");


        model = menuService.getMenuItems(model); //get menu items

        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Пользователь " + username + " уже зарегистрирован");
            return "/registration";
        }
        if (!(username.matches("^[a-zA-Z0-9]+$"))) {
            model.addAttribute("error", "Имя пользователя может содержать только латиницу и цифры");
            return "/registration";
        }
        User user = new User(1, username, password, Arrays.asList(roleRepository.findByName("ROLE_USER")));

        Address address = new Address();

        address.setCity(city);
        address.setStreet(street);
        address.setFlatNumber(flatNumber);
        addressRepository.save(address);

        user.setAddress(address);
        userService.save(user);


        model.addAttribute("error", "Всё хорошо");
        return "redirect:/";
    }


    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
