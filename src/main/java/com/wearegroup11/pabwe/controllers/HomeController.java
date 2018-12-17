package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.Berita;
import com.wearegroup11.pabwe.services.BeritaService;
import com.wearegroup11.pabwe.services.PengumumanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private BeritaService beritaService;
    private PengumumanService pengumumanService;

    @Autowired
    public HomeController(BeritaService beritaService, PengumumanService pengumumanService){
    	this.beritaService = beritaService;
    	this.pengumumanService = pengumumanService;
	}

    public final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("berita", beritaService.listBerita());
		model.addAttribute("pengumuman", pengumumanService.listPengumuman());
		return "index";
	}


}
