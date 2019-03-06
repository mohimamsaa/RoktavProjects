package com.sisi.reimbursement.controller;

import com.sisi.reimbursement.model.BisulModel;
import com.sisi.reimbursement.model.UserRoleModel;
import com.sisi.reimbursement.service.BisulService;
import com.sisi.reimbursement.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Stack;

@Controller
@RequestMapping("/reimburse")
public class BisulController {

    @Autowired
    private BisulService bisulService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(method= RequestMethod.GET)
    private String homeReimburse(Model model, Principal principal) {
        UserRoleModel user = new UserRoleModel();
        for (UserRoleModel a : userRoleService.getUserRoleList()) {
            if (principal.getName().equals(a.getUsername())) {
                user = a;
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("home", true);
        return "home-reimburse";
    }

    @RequestMapping(method = RequestMethod.POST)
    private String addHomeSukses(@RequestParam(value = "name") String name, @RequestParam(value = "nominal") Double nominal,
                                 @RequestParam(value = "contacts") String contacts, @RequestParam(value = "division") String division,
                                 @RequestParam(value = "project") String project, @RequestParam(value = "dateOfTransaction") String dateOfTransaction,
                                 @RequestParam(value = "needs") String needs, @RequestParam(value = "status") String status, @RequestParam(value = "notes") String notes,
                                 @RequestParam(value = "item") String item, @RequestParam(value = "bank") String bank,
                                 @RequestParam(value = "acc") String acc) {

        BisulModel bisulModel = new BisulModel();
        bisulModel.setName(name);
        bisulModel.setNominal(nominal);
        bisulModel.setContacts(contacts);
        bisulModel.setDivision(division);
        bisulModel.setProject(project);

        bisulModel.setDateOfTransaction(dateOfTransaction);
        bisulModel.setNeeds(needs);
        bisulModel.setStatus(status);
        bisulModel.setNotes(notes);
        bisulModel.setItem(item);
        bisulModel.setPreferredBank(bank);
        bisulModel.setAccNumber(acc);
        bisulService.addBisul(bisulModel);


        return "home-reimburse-sukses";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewallPoli(Model model, Principal principal) {
        List<BisulModel> listBisul = bisulService.getBisulList();
        Stack<BisulModel> sortedBisul = new Stack<>();

        for (BisulModel a : listBisul) {
            sortedBisul.add(a);
        }

        UserRoleModel user = new UserRoleModel();
        for (UserRoleModel a : userRoleService.getUserRoleList()) {
            if (principal.getName().equals(a.getUsername())) {
                user = a;
            }
        }

        model.addAttribute("listReimburse", sortedBisul);
        if (user.getRole().equals("STAFF")) {
            return "lihat-reimburse-staff";
        }
        return "lihat-reimburse";
    }

    @RequestMapping(value = "/ubah", method = RequestMethod.GET)
    private String ubah(@RequestParam(value = "id") long id, Model model) {
        BisulModel bisul = bisulService.getBisulById(id);
        model.addAttribute("reimburse", bisul);
        return "ubah-reimburse";
    }

    @RequestMapping(value = "/ubah", method = RequestMethod.POST)
    private String ubahPoliSubmit(@RequestParam(value = "status") String status, @RequestParam(value = "id") long id,
                                  @RequestParam(value = "feedback") String feedback){

        BisulModel bisulModel = bisulService.getBisulById(id);
        bisulModel.setStatus(status);
        bisulModel.setFeedback(feedback);

        bisulService.addBisul(bisulModel);

        return "ubah-reimburse-sukses";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String viewReimburseDetail(@RequestParam(value = "id") long id, Model model) {
        BisulModel bisul = bisulService.getBisulById(id);
        model.addAttribute("reimburse", bisul);
        return "reimburse-detail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteReimburse(@RequestParam(value = "id") long id, Model model) {
        BisulModel bisulModel = bisulService.getBisulDetailById(id);
        bisulService.deleteBisul(id);
        model.addAttribute("reimburse", bisulModel);
        return "delete";
    }

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String viewMine(Principal principal, Model model) {
        Stack<BisulModel> bisulModelStack = new Stack<>();

        for (BisulModel a : bisulService.getBisulList()) {
            if (a.getName().equals(principal.getName())) {
                bisulModelStack.add(a);
            }
        }

        model.addAttribute("listReimburse", bisulModelStack);
        return "lihat-reimburse-saya";

    }

    @RequestMapping(value = "/proof", method = RequestMethod.GET)
    private String proof(@RequestParam(value = "id") long id, Model model) {
        BisulModel bisul = bisulService.getBisulById(id);
        model.addAttribute("reimburse", bisul);
        return "reimburse-proof";
    }

    @RequestMapping(value = "/proof", method = RequestMethod.POST)
    private String proofSubmit(@RequestParam(value = "status") String status, @RequestParam(value = "id") long id,
                                  @RequestParam(value = "feedback") String feedback, @RequestParam(value = "proof") String proof) {

        BisulModel bisulProof = bisulService.getBisulById(id);
        bisulProof.setStatus(status);
        bisulProof.setFeedback(feedback);
        bisulProof.setProof(proof);

        bisulService.addBisul(bisulProof);

        return "reimburse-proof-sukses";
    }

}
