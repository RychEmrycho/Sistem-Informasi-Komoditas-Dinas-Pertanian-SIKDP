package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.Bantuan;
import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.services.BantuanService;
import com.wearegroup11.pabwe.services.KelompokTaniService;
import com.wearegroup11.pabwe.services.UserService;
import com.wearegroup11.pabwe.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("bantuan")
public class BantuanController {

    private StorageService storageService;
	private BantuanService bantuanService;
	private KelompokTaniService kelompokTaniService;
    private UserService userService;

	@Autowired
    public void injectDependency(BantuanService bantuanService, KelompokTaniService kelompokTaniService, StorageService storageService, UserService userService) {
		this.bantuanService = bantuanService;
		this.kelompokTaniService = kelompokTaniService;
        this.storageService = storageService;
        this.userService = userService;
	}
	
	@RequestMapping("")
	public String ListBantuan(Model model) {
        model.addAttribute("kelompokService", kelompokTaniService);
		model.addAttribute("bantuan", bantuanService.listBantuan());
        return "/bantuan/index-bantuan";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {

		model.addAttribute("bantuan", new Bantuan());
		return "/bantuan/formBantuan";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addLaporan(Model model, final @ModelAttribute(value = "bantuan") @Valid Bantuan bantuan, BindingResult bindingResult, final @RequestParam(value = "proposal") MultipartFile uploadingFile) {
        storageService.store(uploadingFile);
        bantuan.setProposal(uploadingFile.getOriginalFilename());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KelompokTani kelompokTani = userService.findByEmail(auth.getName()).getKelompokTani();
        bantuan.setKelompokTani(kelompokTani);

        model.addAttribute("bantuan", bantuanService.saveOrUpdate(bantuan));
		return "redirect:/bantuan";
	}

	@RequestMapping("/edit/{id}")
    public String tampilkanFormUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("bantuan", bantuanService.getBantuanById(id));
		return "/bantuan/formBantuan";
	}

    @RequestMapping("/view/{id}")
	public String tampilkanDetail(@PathVariable("id") long id, Model model) {
		model.addAttribute("bantuan", bantuanService.getBantuanById(id));
		return "/bantuan/view-bantuan";
	}


    @RequestMapping("/hapus/{id}")
    public String deleteDataKelurahan(@PathVariable("id") int id) {
		bantuanService.delete(id);
		return "redirect:/bantuan";
	}

    private ModelAndView getModelAndView(@RequestParam(name = "id") long id, int i) {
        ModelAndView model = new ModelAndView();
        bantuanService.updateStatus(i, id);
        model.setViewName("redirect:/dashboard#bantuan");
        return model;
    }

    @RequestMapping(value = {"/accept"}, method = RequestMethod.POST)
    public ModelAndView accept(@RequestParam(name = "id") long id) {
        return getModelAndView(id, 1);
    }

    @RequestMapping(value = {"/reject"}, method = RequestMethod.POST)
    public ModelAndView reject(@RequestParam(name = "id") long id) {
        return getModelAndView(id, 2);
    }

}
