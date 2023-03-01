package com.kata.cinema.base.mappers;

import com.kata.cinema.base.models.dto.response.UserResponseDto;
import com.kata.cinema.base.models.entity.User;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-11T11:23:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDto toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( user.getId() );
        userResponseDto.setEmail( user.getEmail() );
        if ( user.getBirthday() != null ) {
            userResponseDto.setBirthday( DateTimeFormatter.ISO_LOCAL_DATE.format( user.getBirthday() ) );
        }

        setFullName( userResponseDto, user );

        return userResponseDto;
    }
}
