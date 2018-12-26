package com.wearegroup11.pabwe.controllers;

import com.wearegroup11.pabwe.models.HasilPertanian;
import com.wearegroup11.pabwe.models.KelompokTani;
import com.wearegroup11.pabwe.models.User;
import com.wearegroup11.pabwe.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Controller
public class HomeController {

    private BeritaService beritaService;
    private PengumumanService pengumumanService;
    private KomoditiService komoditiService;
    private HargaKomoditiService hargaKomoditiService;
    private KecamatanService kecamatanService;
    private KelurahanService kelurahanService;

    private UserService userService;
    private KelompokTaniService kelompokTaniService;
    private BantuanService bantuanService;
    private HasilPertanianService hasilPertanianService;
    private LaporanKelompokService laporanKelompokService;

    @Autowired
    public HomeController(BeritaService beritaService, HargaKomoditiService hargaKomoditiService,
                          KomoditiService komoditiService, KelurahanService kelurahanService,
                          PengumumanService pengumumanService, UserService userService,
                          KelompokTaniService kelompokTaniService, KecamatanService kecamatanService,
                          BantuanService bantuanService, HasilPertanianService hasilPertanianService,
                          LaporanKelompokService laporanKelompokService) {
        this.beritaService = beritaService;
        this.hargaKomoditiService = hargaKomoditiService;
        this.pengumumanService = pengumumanService;
        this.userService = userService;
        this.kelompokTaniService = kelompokTaniService;
        this.komoditiService = komoditiService;
        this.kelurahanService = kelurahanService;
        this.kecamatanService = kecamatanService;
        this.bantuanService = bantuanService;
        this.hasilPertanianService = hasilPertanianService;
        this.laporanKelompokService = laporanKelompokService;
    }

    public final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("berita", beritaService.listBerita());
        model.addAttribute("hargaKomoditi", hargaKomoditiService.listHargaKomoditi());
        model.addAttribute("pengumuman", pengumumanService.listPengumuman());
        return "index";
    }

    @RequestMapping("dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userService.listUser());
        model.addAttribute("kelompok", kelompokTaniService.listKelompokTani());
        model.addAttribute("hasilPertanian", hasilPertanianService.listHasilPertanian());
        model.addAttribute("laporanKelompok", laporanKelompokService.listLaporanKelompok());
        model.addAttribute("bantuan", bantuanService.listBantuan());

//		model.addAttribute("berita", beritaService.listBerita());
//		model.addAttribute("pengumuman", pengumumanService.listPengumuman());
//		model.addAttribute("hargaKomoditi", hargaKomoditiService.listHargaKomoditi());
//		model.addAttribute("kecamatan", kecamatanService.listKecamatan());
//		model.addAttribute("kelurahan", kelurahanService.listKelurahan());

        //CART
        int uActive = 0, uWaiting = 0, uRejected = 0;
        for (User u : userService.listUser()) {
            switch (u.getActive()) {
                case 0:
                    uWaiting++;
                    break;
                case 1:
                    uActive++;
                    break;
                case 2:
                    uRejected++;
                    break;
            }
        }
        model.addAttribute("uActive", uActive);
        model.addAttribute("uWaiting", uWaiting);
        model.addAttribute("uRejected", uRejected);

        int kActive = 0, kWaiting = 0, kRejected = 0;
        for (KelompokTani k : kelompokTaniService.listKelompokTani()) {
            switch (k.getStatus()) {
                case 0:
                    kWaiting++;
                    break;
                case 1:
                    kActive++;
                    break;
                case 2:
                    kRejected++;
                    break;
            }
        }
        model.addAttribute("kActive", kActive);
        model.addAttribute("kWaiting", kWaiting);
        model.addAttribute("kRejected", kRejected);

        //CHART
        List<HasilPertanian> listHasilPertanian = hasilPertanianService.listHasilPertanian();
        int[] container = new int[12];
        for (HasilPertanian h : listHasilPertanian) {
            if (h != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
                String date = dateFormat.format((h.getBulan()));

                switch (Integer.parseInt(date)) {
                    case 1:
                        container[0] = container[0] + h.getJumlahHasilPanen();
                        break;
                    case 2:
                        container[1] = container[1] + h.getJumlahHasilPanen();
                        break;
                    case 3:
                        container[2] = container[2] + h.getJumlahHasilPanen();
                        break;
                    case 4:
                        container[3] = container[3] + h.getJumlahHasilPanen();
                        break;
                    case 5:
                        container[4] = container[4] + h.getJumlahHasilPanen();
                        break;
                    case 6:
                        container[5] = container[5] + h.getJumlahHasilPanen();
                        break;
                    case 7:
                        container[6] = container[6] + h.getJumlahHasilPanen();
                        break;
                    case 8:
                        container[7] = container[7] + h.getJumlahHasilPanen();
                        break;
                    case 9:
                        container[8] = container[8] + h.getJumlahHasilPanen();
                        break;
                    case 10:
                        container[9] = container[9] + h.getJumlahHasilPanen();
                        break;
                    case 11:
                        container[10] = container[10] + h.getJumlahHasilPanen();
                        break;
                    case 12:
                        container[11] = container[11] + h.getJumlahHasilPanen();
                        break;
                }
            }
        }
        model.addAttribute("dataHasilPertanian", container);

        HashMap<Long, HashSet<Long>> hash = new HashMap<>();
        for (HasilPertanian h : listHasilPertanian) {
            if (hash.containsKey(h.getKomoditi().getId())) {
                hash.get(h.getKomoditi().getId()).add(h.getKelompokTani().getId());
            } else {
                HashSet<Long> hashSet = new HashSet<>();
                hash.put(h.getKomoditi().getId(), hashSet);
                hash.get(h.getKomoditi().getId()).add(h.getKelompokTani().getId());
            }
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        hash.forEach((aLong, longs) -> hashMap.put(komoditiService.getById(aLong).getNamaKomoditi(), longs.size()));

        model.addAttribute("listKomoditi", hashMap.keySet().toArray());
        model.addAttribute("listJumlahKelompok", hashMap.values().toArray());
        return "dashboard/dashboard";
    }

}
