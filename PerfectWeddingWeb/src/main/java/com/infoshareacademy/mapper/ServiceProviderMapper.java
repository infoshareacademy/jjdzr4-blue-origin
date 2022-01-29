package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Availability;
import com.infoshareacademy.domain.Location;
import com.infoshareacademy.domain.ServiceProvider;
import com.infoshareacademy.domain.ServiceType;
import com.infoshareacademy.dto.ServiceAddProviderDto;
import com.infoshareacademy.dto.ServiceDeActivateProviderDto;
import com.infoshareacademy.dto.ServiceEditProviderDto;
import com.infoshareacademy.dto.ServiceProviderDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ServiceProviderMapper {


    public ServiceProviderDto mapperToDto(ServiceProvider serviceProvider) {
        ServiceProviderDto serviceProviderDto = new ServiceProviderDto();
        serviceProviderDto.setActive(serviceProvider.isActive());
        serviceProviderDto.setAvailability(serviceProvider.getAvailability());
        serviceProviderDto.setLocation(serviceProvider.getLocation());
        serviceProviderDto.setServiceType(serviceProvider.getServiceType());
        serviceProviderDto.setAverageRating(serviceProvider.getAverageRating());
        serviceProviderDto.setCompanyName(serviceProvider.getCompanyName());
        serviceProviderDto.setEmail(serviceProvider.getEmail());
        serviceProviderDto.setOwnerName(serviceProvider.getOwnerName());
        serviceProviderDto.setOwnerSurname(serviceProvider.getOwnerSurname());
        serviceProviderDto.setPhone(serviceProvider.getPhone());
        serviceProviderDto.setCurrentID(serviceProvider.getCurrentID());
        serviceProviderDto.setWebsiteAddress(serviceProvider.getWebsiteAddress());
        serviceProviderDto.setRatingList(serviceProvider.getRatingList());
        return serviceProviderDto;
    }

    public ServiceProvider mapperFromDto(ServiceProviderDto serviceProviderDto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setActive(serviceProviderDto.isActive());
        serviceProvider.setAvailability(serviceProviderDto.getAvailability());
        serviceProvider.setLocation(serviceProviderDto.getLocation());
        serviceProvider.setServiceType(serviceProviderDto.getServiceType());
        serviceProvider.setAverageRating(serviceProviderDto.getAverageRating());
        serviceProvider.setCompanyName(serviceProviderDto.getCompanyName());
        serviceProvider.setEmail(serviceProviderDto.getEmail());
        serviceProvider.setOwnerName(serviceProviderDto.getOwnerName());
        serviceProvider.setOwnerSurname(serviceProviderDto.getOwnerSurname());
        serviceProvider.setPhone(serviceProviderDto.getPhone());
        serviceProvider.setCurrentID(serviceProviderDto.getCurrentID());
        serviceProvider.setWebsiteAddress(serviceProviderDto.getWebsiteAddress());
        serviceProvider.setRatingList(serviceProviderDto.getRatingList());
        return serviceProvider;
    }

    public ServiceProvider mapperFromAddDto(ServiceAddProviderDto serviceAddProviderDto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setActive(true);
        serviceProvider.setAvailability(new Availability(Arrays.asList(serviceAddProviderDto.getAvailability())));
        serviceProvider.setLocation(new Location(serviceAddProviderDto.getCity(), serviceAddProviderDto.getVoivodeship()));
        serviceProvider.setServiceType(new ServiceType(serviceAddProviderDto.getID(), serviceAddProviderDto.getDescription(), serviceAddProviderDto.getPrice(), serviceAddProviderDto.getTypesOfService()));
        serviceProvider.setAverageRating(serviceAddProviderDto.getAverageRating());
        serviceProvider.setCompanyName(serviceAddProviderDto.getCompanyName());
        serviceProvider.setEmail(serviceAddProviderDto.getEmail());
        serviceProvider.setOwnerName(serviceAddProviderDto.getOwnerName());
        serviceProvider.setOwnerSurname(serviceAddProviderDto.getOwnerSurname());
        serviceProvider.setPhone(serviceAddProviderDto.getPhone());
        serviceProvider.setCurrentID(serviceAddProviderDto.getCurrentID());
        serviceProvider.setWebsiteAddress(serviceAddProviderDto.getWebsiteAddress());
        return serviceProvider;
    }

    public ServiceProviderDto mapperToAddDto(ServiceProvider serviceProvider) {
//        ServiceAddProviderDto serviceAddProviderDto = new ServiceAddProviderDto();
//        serviceAddProviderDto.setActive(serviceProvider.isActive());
//        serviceAddProviderDto.setAvailability(serviceProvider.getAvailability().getDates().get(0));
//        serviceAddProviderDto.setLocation(new Location(serviceAddProviderDto.getCity(), serviceAddProviderDto.getVoivodeship()));
//        serviceAddProviderDto.setServiceType(new ServiceType(serviceAddProviderDto.getID(), serviceAddProviderDto.getDescription(), serviceAddProviderDto.getPrice(), serviceAddProviderDto.getTypesOfService()));
//        serviceAddProviderDto.setAverageRating(serviceAddProviderDto.getAverageRating());
//        serviceAddProviderDto.setCompanyName(serviceAddProviderDto.getCompanyName());
//        serviceAddProviderDto.setEmail(serviceAddProviderDto.getEmail());
//        serviceAddProviderDto.setOwnerName(serviceAddProviderDto.getOwnerName());
//        serviceAddProviderDto.setOwnerSurname(serviceAddProviderDto.getOwnerSurname());
//        serviceAddProviderDto.setPhone(serviceAddProviderDto.getPhone());
//        serviceAddProviderDto.setCurrentID(serviceAddProviderDto.getCurrentID());
//        serviceAddProviderDto.setWebsiteAddress(serviceAddProviderDto.getWebsiteAddress());
        return null;
    }
    /*public ServiceProvider mapperFromEditDto(ServiceEditProviderDto serviceEditProviderDto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setCompanyName(serviceEditProviderDto.getCompanyName());
        serviceProvider.setOwnerName(serviceEditProviderDto.getOwnerName());
        serviceProvider.setOwnerSurname(serviceEditProviderDto.getOwnerSurname());
        serviceProvider.setPhone(serviceEditProviderDto.getPhone());
        serviceProvider.setEmail(serviceEditProviderDto.getEmail());
        serviceProvider.setWebsiteAddress(serviceEditProviderDto.getWebsiteAddress());
        serviceProvider.setLocation(new Location(serviceEditProviderDto.getCity(), serviceEditProviderDto.getVoivodeship()));
        serviceProvider.setServiceType(new ServiceType(serviceEditProviderDto.getServiceType().getID(), serviceEditProviderDto.getServiceType().getDescription(), serviceEditProviderDto.getServiceType().getPrice(), serviceEditProviderDto.getServiceType().getTypesOfService()));
        serviceProvider.setActive(serviceEditProviderDto.isActive());
        serviceProvider.setAvailability(new Availability(Arrays.asList(serviceEditProviderDto.getAvailability())));

        return serviceProvider;
    }*/

    public ServiceEditProviderDto mapToServiceEditProviderDto(ServiceProvider serviceProvider) {
        ServiceEditProviderDto serviceEditProviderDto = new ServiceEditProviderDto();
        serviceEditProviderDto.setId(serviceProvider.getCurrentID());
        serviceEditProviderDto.setCompanyName(serviceProvider.getCompanyName());
        serviceEditProviderDto.setCity(serviceProvider.getLocation().getCity());
        serviceEditProviderDto.setVoivodeship(serviceProvider.getLocation().getVoivodeship());
        serviceEditProviderDto.setDescription(serviceProvider.getServiceType().getDescription());
        serviceEditProviderDto.setPrice(serviceProvider.getServiceType().getPrice());
        serviceEditProviderDto.setTypesOfService(serviceProvider.getServiceType().getTypesOfService());



        // ToDo add more fields
        return serviceEditProviderDto;
    }
    public ServiceDeActivateProviderDto mapToServiceDeActivateProviderDto(ServiceProvider serviceProvider) {
        ServiceDeActivateProviderDto serviceDeActivateProviderDto = new ServiceDeActivateProviderDto();
                serviceDeActivateProviderDto.setId(serviceProvider.getCurrentID());
        serviceDeActivateProviderDto.setActive(serviceProvider.isActive());
        return  serviceDeActivateProviderDto;}
}
