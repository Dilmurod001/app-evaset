package uz.pdp.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springsecurity.annotations.CheckPermission;
import uz.pdp.springsecurity.entity.CustomerGroup;
import uz.pdp.springsecurity.payload.ApiResponse;
import uz.pdp.springsecurity.payload.CustomerGroupDto;
import uz.pdp.springsecurity.service.CustomerGroupService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customerGroup")
public class CustomerGroupController {
    @Autowired
    CustomerGroupService customerGroupService;

    @CheckPermission("ADD_CUSTOMER_GROUP")
    @PostMapping
    public HttpEntity<?> addCustomerGroup(@Valid @RequestBody CustomerGroupDto customerGroupDto){
        ApiResponse apiResponse = customerGroupService.addCustomerGroup(customerGroupDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @CheckPermission("VIEW_CUSTOMER_GROUP")
    @GetMapping
    public HttpEntity<List<CustomerGroup>> getAll(){
        List<CustomerGroup> customerGroups = customerGroupService.getAll();
        return ResponseEntity.ok(customerGroups);
    }

    @CheckPermission("DELETE_CUSTOMER_GROUP")
    @DeleteMapping
    public HttpEntity<?> deleteCustomerGroup(@RequestParam Integer id){
        ApiResponse apiResponse = customerGroupService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @CheckPermission("VIEW_CUSTOMER_GROUP")
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        ApiResponse apiResponse = customerGroupService.getById(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody CustomerGroupDto customerGroupDto){
        ApiResponse apiResponse = customerGroupService.edit(id, customerGroupDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
