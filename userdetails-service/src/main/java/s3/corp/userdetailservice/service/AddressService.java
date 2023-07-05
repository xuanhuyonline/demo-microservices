package s3.corp.userdetailservice.service;

import s3.corp.userdetailservice.dto.AddressDto;

public interface AddressService {
    AddressDto getAddressById(Long id);
}
