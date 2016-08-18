package net.bolshak.socialnetwork.controller;

import com.sun.deploy.net.HttpResponse;
import net.bolshak.socialnetwork.entity.Person;
import net.bolshak.socialnetwork.entity.Post;
import net.bolshak.socialnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 03.07.2016.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String loginByNickName(){
        return ("login");
    }


    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logOut(){
        return ("login");
    }



    @RequestMapping(value = "/loginByNickName", method = RequestMethod.GET)
    public String findByNickName(@RequestParam("nickname") String nickname, ModelMap model){

        Person person = personService.findByNickname(nickname);

        model.addAttribute("id", person.getId());
        model.addAttribute("first_name", person.getFirstName());
        model.addAttribute("last_name", person.getLastName());
        model.addAttribute("birthday", person.getBirthday());
        model.addAttribute("nickname", person.getNickname());

        List<Post> postList = personService.listPosts(person.getId());
        model.addAttribute("usersPosts", postList);

        return "userpage";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addNewUser(@RequestParam("nickname") String nickname,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("birthday") String birthday,
                                 ModelMap model){

        Person person = new Person(firstName, lastName, birthday, nickname);
        personService.create(person);

        return "login_new_user";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.GET)
    public String addPost(@RequestParam("postTitle") String postTitle,
                          @RequestParam("postContent") String postContent,
                          @RequestParam("nickname") String nickname,
                          ModelMap model
                          ){
//        Post post = new Post(postTitle, postContent, personService.findByNickname(nickname).getId());
        Post post = new Post(postTitle, postContent, personService.findByNickname(nickname));
        personService.createPost(post);
        model.addAttribute("nickname", nickname);
        findByNickName(nickname, model);
        return "userpage";
    }

    @RequestMapping(value = "/deletepost", method = RequestMethod.GET)
    public String deletePostById(@RequestParam("postid") Integer postId,
                                 @RequestParam("nickname")String nickname,
                                 ModelMap model
                                 ){
        Post post = personService.getPostByPostId(postId);
        personService.deletePost(post);
        model.addAttribute("nickname", nickname);
        findByNickName(nickname, model);
        return "userpage";
    }

    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception ex) {

//        ModelAndView model = new ModelAndView("error");

        return "error";

    }

//    ---------------------------------
//    ---------------------------------
//    ---------------------------------
//    ---------------------------------
//    ---------------------------------
//    ---------------------------------

//    For example:


@RequestMapping(value = "/person", method = RequestMethod.GET)
public ModelAndView listPerson(){

    return new ModelAndView("person", "command", new Person());
}

//    @RequestMapping("/")
//    public String home(){
//        return "redirect:/index";
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("SpringWeb") Person person, ModelMap model){

        model.addAttribute("first_name", person.getFirstName());
        model.addAttribute("last_name", person.getLastName());
        model.addAttribute("birthday", person.getBirthday());
        model.addAttribute("nickname", person.getNickname());
        model.addAttribute("id", person.getId());
//        model.addAttribute("id", 1234567);
        return "result";
    }

    @RequestMapping(value="/persid",method = RequestMethod.GET)
    public String idPerson(){
        return ("persid");
    }

    @RequestMapping(value = "/findbyid", method = RequestMethod.GET)
    public String findByID(@RequestParam("id") Integer id, ModelMap model){
//    public String findByID(ModelMap model){

        Person person = personService.findByID(id);
//        ModelMap model = new ModelMap();
        model.addAttribute("id", person.getId());
        model.addAttribute("first_name", person.getFirstName());
        model.addAttribute("last_name", person.getLastName());
        model.addAttribute("birthday", person.getBirthday());
        model.addAttribute("nickname", person.getNickname());
//        return "/WEB-INF/jsp/resultid.jsp";
        return "resultid";
    }

    @RequestMapping(value = "/findallusers", method = RequestMethod.GET)
    public ModelAndView getAllPersons(){
        ModelAndView model = new ModelAndView("allusers");
        List<Person> listPerson = personService.listPerson();
        model.addObject("lists", listPerson);

        return model;
    }

}
