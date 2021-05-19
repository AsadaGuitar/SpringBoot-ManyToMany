package com.example.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.UserForm;
import com.example.domain.entity.Place;
import com.example.domain.entity.User;
import com.example.repository.PlaceRepository;
import com.example.service.PlaceService;
import com.example.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PlaceService placeService;
	
	@ModelAttribute
	UserForm setUserForm() {
		return new UserForm();
	}

	@GetMapping
	public String viewMain(Model model) {
		return "Home";
	}
	
	
	@PostMapping(path="/post")
	@Transactional
	public String viewSub(@Validated UserForm userForm,
			BindingResult result, Model model) {
		
		if(result.hasErrors())
			return "redirect:/Home";
		
		
		Place placeA = new Place();
		placeA.setData("DataA");
		
		Place placeB = new Place();
		placeB.setData("DataB");
		
		Place C = placeService.create(placeA);
		Place D = placeService.create(placeB);
		
		User user = new User();
		user.setName(userForm.getName());
		user.setMark(10);
		user.setPlaceList(Arrays.asList(C,D));
		userService.create(user);
		
//		user.getPlaceList().addAll((Arrays.asList(placeA, placeB)));
//		User createdUser = userService.update(user);
		
		var createdUser = userService.findOneByMark(10);
		
		List<Place> placeList = placeService.findByUsers(user);
		
		System.out.println(createdUser.getPlaceList());
		System.out.println(placeList);

		model.addAttribute("model", createdUser.getPlaceList());
		
		return "Sub";
	}
	
	
	
	
	
	
	
	
	
	
}
