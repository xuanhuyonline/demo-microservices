package s3.corp.userdetailservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import s3.corp.userdetailservice.dto.AddressDto;
import s3.corp.userdetailservice.entity.Address;
import s3.corp.userdetailservice.exception.ResourceNotFoundException;
import s3.corp.userdetailservice.repository.AddressRepository;
import s3.corp.userdetailservice.service.AddressService;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;


    @Override
    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Address not exist with id :" +  id));
        AddressDto addressDto = modelMapper.map(address, AddressDto.class);
        return  addressDto;
    }
}
