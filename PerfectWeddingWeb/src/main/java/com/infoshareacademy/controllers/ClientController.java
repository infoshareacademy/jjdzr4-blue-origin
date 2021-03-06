package com.infoshareacademy.controllers;

import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.dto.EmailRequestDto;
import com.infoshareacademy.dto.ServiceEditProviderDto;
import com.infoshareacademy.dto.ServiceSearchProviderDto;
import com.infoshareacademy.email.EmailServiceImpl;
import com.infoshareacademy.mapper.ServiceProviderMapper;
import com.infoshareacademy.services.ServiceProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller

public class ClientController {

    private ServiceProviderService serviceProviderService;
    private ServiceProviderMapper serviceProviderMapper;
    private EmailServiceImpl emailService;

    public ClientController(ServiceProviderService serviceProviderService, ServiceProviderMapper serviceProviderMapper, EmailServiceImpl emailService) {
        this.serviceProviderService = serviceProviderService;
        this.serviceProviderMapper = serviceProviderMapper;
        this.emailService = emailService;
    }


    @PostMapping("/find")
    public String findByTypeOfService(Model modelOfFoundProviders, ServiceSearchProviderDto serviceSearchProviderDto) {
        modelOfFoundProviders
                .addAttribute("providersByServiceTH", serviceProviderService.findProviders(serviceSearchProviderDto.getServiceType(), serviceSearchProviderDto.getCity(), serviceSearchProviderDto.getDate(), true))
                .addAttribute("toggleDeactivateEdit", "rate");
        return "FoundProviders";
    }

    @GetMapping("/providers/rated/{id}")
    public String ratedProvider(Model model, @PathVariable Integer id) {
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        serviceProviderList.add(serviceProviderService.findById(id));
        model
                .addAttribute("providersByServiceTH", serviceProviderList)
                .addAttribute("toggleDeactivateEdit", "rated");
        return "FoundProviders";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@Valid EmailRequestDto emailRequestDto, BindingResult bindingResult, Model model) {
        ServiceProvider serviceProvider = serviceProviderService.findByEmail(emailRequestDto.getProviderEmail());
        ServiceEditProviderDto serviceEditProviderDto = serviceProviderMapper.mapToServiceEditProviderDto(serviceProvider);
        model.addAttribute("provider", serviceEditProviderDto);
        if (bindingResult.hasErrors()) {
            return "ProviderSendEmail";
        }
        emailService.sendMessage(emailRequestDto.getProviderEmail(), emailRequestDto.getClientEmail() + "- Zapytanie", emailRequestDto.getQueryMessage());
        return "redirect:/emailSent";
    }

    @GetMapping("/sendEmail/{id}")
    public String createEmail(@PathVariable Integer id, Model model) {
        ServiceProvider serviceProvider = serviceProviderService.findById(id);
        ServiceEditProviderDto serviceEditProviderDto = serviceProviderMapper.mapToServiceEditProviderDto(serviceProvider);
        EmailRequestDto emailRequestDto = new EmailRequestDto();
        emailRequestDto.setProviderEmail(serviceProvider.getEmail());
        model.addAttribute("emailRequestDto", emailRequestDto);
        model.addAttribute("provider", serviceEditProviderDto);
        return "ProviderSendEmail";
    }

    @GetMapping("/emailSent")
    public String emailSentConfirmation() {
        return "EmailSent";
    }
}
