package com.mariem.type.service;

import com.mariem.type.dto.TypeDto;
import com.mariem.type.entities.Type;
import com.mariem.type.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Override
    public TypeDto getTypeByCode(String code) {
        Type type = typeRepository.findByCodeType(code);
        TypeDto typeDto = new TypeDto(
                type.getIdType(),
                type.getNomType(),
                type.getCodeType()
        );
        return typeDto;
    }
}
