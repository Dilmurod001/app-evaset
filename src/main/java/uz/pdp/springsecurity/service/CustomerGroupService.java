package uz.pdp.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springsecurity.entity.CustomerGroup;
import uz.pdp.springsecurity.payload.ApiResponse;
import uz.pdp.springsecurity.payload.CustomerGroupDto;
import uz.pdp.springsecurity.repository.CustomerGroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class   CustomerGroupService {

    @Autowired
    CustomerGroupRepository customerGroupRepository;

    public ApiResponse addCustomerGroup(CustomerGroupDto customerGroupDto){
        CustomerGroup customerGroup=new CustomerGroup(
                customerGroupDto.getName(),
                customerGroupDto.getPercent()
        );
        customerGroupRepository.save(customerGroup);
        return new ApiResponse("ADDED", true);
    }

    public List<CustomerGroup> getAll(){
        return customerGroupRepository.findAll();
    }

    public ApiResponse delete(Integer id){
        if (!customerGroupRepository.existsById(id)) return new ApiResponse("NOT FOUND",false);
        customerGroupRepository.deleteById(id);
        return new ApiResponse("DELETED",true);
    }

    public ApiResponse getById(Integer id){
        if (!customerGroupRepository.existsById(id)) return new ApiResponse("NOT FOUND",false);
        return new ApiResponse("FOUND",true,customerGroupRepository.findById(id).get());
    }

    public ApiResponse edit(Integer id, CustomerGroupDto customerGroupDto){
        if (!customerGroupRepository.existsById(id)) return new ApiResponse("NOT FOUND",false);
        Optional<CustomerGroup> optionalCustomerGroup = customerGroupRepository.findById(id);
        if (!optionalCustomerGroup.isPresent()){
            return new ApiResponse("NOT FOUND",false);
        }
        CustomerGroup customerGroup = customerGroupRepository.getById(id);
        customerGroup.setName(customerGroupDto.getName());
        customerGroup.setPercent(customerGroupDto.getPercent());
        customerGroupRepository.save(customerGroup);
        return new ApiResponse("EDITED",false);
    }
}
