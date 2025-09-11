/**
 * App: Customer Registration
 * Package: com.bobwares.customer.registration.api
 * File: CustomerController.java
 * Version: 0.1.0
 * Turns: 2
 * Author: AI
 * Date: 2025-09-10T16:44:42Z
 * Exports: CustomerController
 * Description: REST controller exposing Customer CRUD endpoints.
 */

package com.bobwares.customer.registration.api;

import com.bobwares.customer.registration.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a customer")
    public CustomerDto.Response create(@Valid @RequestBody CustomerDto.CreateRequest request) {
        Customer saved = service.create(toEntity(request));
        return toResponse(saved);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer by id")
    public CustomerDto.Response get(@PathVariable UUID id) {
        return toResponse(service.get(id));
    }

    @GetMapping
    @Operation(summary = "List customers")
    public List<CustomerDto.Response> list() {
        return service.list().stream().map(this::toResponse).toList();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a customer")
    public CustomerDto.Response update(@PathVariable UUID id,
                                       @Valid @RequestBody CustomerDto.UpdateRequest request) {
        Customer updated = service.update(id, toEntity(request));
        return toResponse(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a customer")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    private Customer toEntity(CustomerDto.CreateRequest dto) {
        Customer c = new Customer();
        c.setFirstName(dto.getFirstName());
        c.setMiddleName(dto.getMiddleName());
        c.setLastName(dto.getLastName());

        PostalAddress addr = new PostalAddress();
        CustomerDto.Address a = dto.getAddress();
        addr.setLine1(a.getLine1());
        addr.setLine2(a.getLine2());
        addr.setCity(a.getCity());
        addr.setState(a.getState());
        addr.setPostalCode(a.getPostalCode());
        addr.setCountry(a.getCountry());
        c.setAddress(addr);

        PrivacySettings ps = new PrivacySettings();
        CustomerDto.Privacy p = dto.getPrivacySettings();
        ps.setMarketingEmailsEnabled(p.getMarketingEmailsEnabled());
        ps.setTwoFactorEnabled(p.getTwoFactorEnabled());
        c.setPrivacySettings(ps);

        for (String email : dto.getEmails()) {
            CustomerEmail ce = new CustomerEmail();
            ce.setEmail(email);
            ce.setCustomer(c);
            c.getEmails().add(ce);
        }
        for (CustomerDto.PhoneNumber pn : dto.getPhoneNumbers()) {
            CustomerPhoneNumber cp = new CustomerPhoneNumber();
            cp.setType(pn.getType());
            cp.setNumber(pn.getNumber());
            cp.setCustomer(c);
            c.getPhoneNumbers().add(cp);
        }
        return c;
    }

    private CustomerDto.Response toResponse(Customer c) {
        CustomerDto.Response r = new CustomerDto.Response();
        r.setId(c.getCustomerId());
        r.setFirstName(c.getFirstName());
        r.setMiddleName(c.getMiddleName());
        r.setLastName(c.getLastName());
        r.setEmails(c.getEmails().stream().map(CustomerEmail::getEmail).toList());
        if (c.getAddress() != null) {
            CustomerDto.Address a = new CustomerDto.Address();
            a.setLine1(c.getAddress().getLine1());
            a.setLine2(c.getAddress().getLine2());
            a.setCity(c.getAddress().getCity());
            a.setState(c.getAddress().getState());
            a.setPostalCode(c.getAddress().getPostalCode());
            a.setCountry(c.getAddress().getCountry());
            r.setAddress(a);
        }
        if (c.getPrivacySettings() != null) {
            CustomerDto.Privacy p = new CustomerDto.Privacy();
            p.setMarketingEmailsEnabled(c.getPrivacySettings().isMarketingEmailsEnabled());
            p.setTwoFactorEnabled(c.getPrivacySettings().isTwoFactorEnabled());
            r.setPrivacySettings(p);
        }
        List<CustomerDto.PhoneNumber> phones = new ArrayList<>();
        for (CustomerPhoneNumber pn : c.getPhoneNumbers()) {
            CustomerDto.PhoneNumber pd = new CustomerDto.PhoneNumber();
            pd.setType(pn.getType());
            pd.setNumber(pn.getNumber());
            phones.add(pd);
        }
        r.setPhoneNumbers(phones);
        return r;
    }
}
