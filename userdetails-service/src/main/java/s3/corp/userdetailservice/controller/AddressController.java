package s3.corp.userdetailservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import s3.corp.userdetailservice.dto.AddressDto;
import s3.corp.userdetailservice.service.AddressService;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }
}
