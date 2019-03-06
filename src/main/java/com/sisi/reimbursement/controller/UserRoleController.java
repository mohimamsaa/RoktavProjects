package com.sisi.reimbursement.controller;

import com.sisi.reimbursement.model.UserRoleModel;
import com.sisi.reimbursement.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user, Model model, @RequestParam(value = "username") String username) {
		List<UserRoleModel> userRoleModelList = userService.getUserRoleList();
		for (UserRoleModel users : userRoleModelList) {
			if (users.getUsername().equals(username)) {
				return "register-error";
			}
		}
		userService.addUser(user);
		return "login";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	private String changePassword(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		UserRoleModel user = userService.getUserByUsername(username);
		model.addAttribute("user", user);
		return "change-password";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	private String changePasswordSubmit(RedirectAttributes redirAttr, Model model,
                                        @RequestParam(value = "passwordBaru") String passwordBaru,
                                        @RequestParam(value = "passwordLama") String passwordLama,
                                        @RequestParam(value = "passwordBaruUlang") String passwordBaruUlang) {
		System.out.println(passwordBaru);
		System.out.println(passwordBaruUlang);
		System.out.println(passwordLama);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		UserRoleModel user = userService.getUserByUsername(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (passwordEncoder.matches(passwordLama, user.getPassword())) {

		} else {
			redirAttr.addFlashAttribute("pesan", "Password Lama Anda Tidak Sesuai");
			return "redirect:/user/changePassword";
		}
		if (passwordBaru.equals(passwordBaruUlang)) {

		} else {
			redirAttr.addFlashAttribute("pesan", "Password Baru Dengan Pengulangan Tidak Cocok");
			return "redirect:/user/changePassword";
		}
		if (confirmPassword(passwordBaru)) {

		} else {
			redirAttr.addFlashAttribute("pesan", "Password Baru Tidak Memenuhi Syarat");
			return "redirect:/user/changePassword";
		}
		user.setPassword(passwordBaru);
		userService.addUser(user);
		model.addAttribute("pesan", "Password Berhasil Diubah");
		return "home";
	}

	public boolean confirmPassword(String password) {
		boolean passwordLength = false;
		boolean passwordContainsDigit = false;
		boolean passwordContainsLetter = false;

		if (password.length() >= 8)
			passwordLength = true;

		for (char c : password.toCharArray()) {
			if (Character.isDigit(c))
				passwordContainsDigit = true;
		}

		passwordContainsLetter = password.matches(".*[a-zA-Z]+.*");

		return (passwordLength && passwordContainsDigit && passwordContainsLetter);
	}

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    private String profile(Model model, Principal principal) {
        UserRoleModel user = new UserRoleModel();
        for (UserRoleModel a : userService.getUserRoleList()) {
            if (principal.getName().equals(a.getUsername())) {
                user = a;
            }
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = "/profile/change", method = RequestMethod.POST)
    private String profileChange(@RequestParam(value = "contacts") String contacts, @RequestParam(value = "prefferedBank") String prefferedBank,
                                 @RequestParam(value = "accNumber") String accNumber, @RequestParam(value = "id") long id) {
        UserRoleModel user = userService.getUserById(id);
        user.setContacts(contacts);
        user.setBank(prefferedBank);
        user.setAcc(accNumber);

        userService.addUser(user);
        return "profile-sukses";
    }

	public static boolean findDuplicates(List<String> listContainingDuplicates) {

		final Set<String> setToReturn = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();

		for (String yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				return true;
			}
		}
		return false;
	}

/*	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
    private String forgotPass(Model model) {
	    return "forgot-password";
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    private String forgotPassRev(Model model, @RequestParam("acc") String acc, @RequestParam("newPass") String newPass, RedirectAttributes redirectAttributes) {
	    Optional<UserRoleModel> optinal = userService.findUserByAcc(acc);

	    if (optinal != null) {
	        UserRoleModel resetUser = optinal.get();

	        resetUser.setPassword(bCryptPasswordEncoder.encode("newPass"));
	        userService.addUser(resetUser);
	        return "forgot-password-berhasil";
        }
        redirectAttributes.addFlashAttribute("pesan", "Account number is not yet");
        return "redirect:/user/forgot";
    }*/
}
