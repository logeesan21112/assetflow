package com.group8.assetflow.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.group8.assetflow.model.DigitalVendor;
import com.group8.assetflow.service.CategoryService;
import com.group8.assetflow.service.DigitalVendorService;
import com.group8.assetflow.service.FileUploadService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class DigitalVendorController {

    private final DigitalVendorService digitalVendorService;
    private final CategoryService categoryService;

    public DigitalVendorController(DigitalVendorService digitalVendorService,
                                   CategoryService categoryService) {
        this.digitalVendorService = digitalVendorService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<DigitalVendor> vendorList = digitalVendorService.getAllVendors();
        model.addAttribute("vendorList", vendorList);
        return "dashboard";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("vendor", new DigitalVendor());
        model.addAttribute("categoryList", categoryService.getAll());
        return "vendor/form";
    }

    @GetMapping("/vendor/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        DigitalVendor digitalVendor = digitalVendorService.findById(id).orElse(null);
        model.addAttribute("vendor", digitalVendor);
        model.addAttribute("categoryList", categoryService.getAll());
        return "vendor/form";
    }

    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute("vendor") DigitalVendor digitalVendor,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getAll());
            return "vendor/form";
        }

        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            digitalVendor.setPhoto(fileName);
            DigitalVendor savedVendor = digitalVendorService.save(digitalVendor);
            String uploadDir = "vendor-photos/" + savedVendor.getId();
            FileUploadService.saveFile(uploadDir, fileName, multipartFile);
        } else {
            if (digitalVendor.getId() != null) {
                digitalVendorService.findById(digitalVendor.getId()).ifPresent(existing -> {
                    digitalVendor.setPhoto(existing.getPhoto());
                });
            }
            digitalVendorService.save(digitalVendor);
        }

        redirectAttributes.addFlashAttribute("message", "Vendor saved successfully");
        return "redirect:/";
    }

    @GetMapping("/vendor/{id}")
    public String viewVendor(@PathVariable Long id, Model model) {
        Optional<DigitalVendor> digitalVendor = digitalVendorService.findById(id);
        digitalVendor.ifPresent(vendor -> model.addAttribute("vendor", vendor));
        return "vendor/details";
    }

    @GetMapping("/vendor/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        digitalVendorService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Vendor deleted successfully");
        return "redirect:/";
    }
}