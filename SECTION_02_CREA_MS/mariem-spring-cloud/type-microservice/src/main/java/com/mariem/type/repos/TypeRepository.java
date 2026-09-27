package com.mariem.type.repos;

import com.mariem.type.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByCodeType(String codeType);
}
