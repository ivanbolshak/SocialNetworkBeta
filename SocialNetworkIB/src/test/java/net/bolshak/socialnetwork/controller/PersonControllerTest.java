package net.bolshak.socialnetwork.controller;

import net.bolshak.socialnetwork.entity.Person;
import net.bolshak.socialnetwork.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

/**
 * Created by Ivan on 23.07.2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonService personService;

    @Test
    public void testFindByNickName() throws Exception {
//        подготовка даных для метода
        final String nickname = "crack";
        final ModelMap model = Mockito.mock(ModelMap.class);
        Person person = new Person("Igor", "Mazepa", "12/12/12", "mazer");
        Mockito.doReturn(person).when(personService).findByNickname(Matchers.eq(nickname));

        String result = personController.findByNickName(nickname, model);

        Assert.assertEquals("check findByNickname", "userpage", result);

        Mockito.verify(model, times(1)).addAttribute(Mockito.eq("first_name"),Mockito.eq(person.getFirstName()));





    }
}


//    @RequestMapping(value = "/loginByNickName", method = RequestMethod.GET)
//    public String findByNickName(@RequestParam("nickname") String nickname, ModelMap model){
//
//        Person person = personService.findByNickname(nickname);
//
//        model.addAttribute("id", person.getId());
//        model.addAttribute("first_name", person.getFirstName());
//        model.addAttribute("last_name", person.getLastName());
//        model.addAttribute("birthday", person.getBirthday());
//        model.addAttribute("nickname", person.getNickname());
//
//        List<Post> postList = personService.listPosts(person.getId());
//        model.addAttribute("usersPosts", postList);
//
//        return "userpage";
//    }