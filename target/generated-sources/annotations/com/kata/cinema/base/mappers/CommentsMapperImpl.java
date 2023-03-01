package com.kata.cinema.base.mappers;

import com.kata.cinema.base.models.dto.response.CommentsResponseDto;
import com.kata.cinema.base.models.entity.Comments;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-11T11:23:50+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class CommentsMapperImpl implements CommentsMapper {

    @Override
    public CommentsResponseDto toDTO(Comments comments) {
        if ( comments == null ) {
            return null;
        }

        CommentsResponseDto commentsResponseDto = new CommentsResponseDto();

        commentsResponseDto.setText( comments.getText() );
        commentsResponseDto.setDate( comments.getDate() );

        return commentsResponseDto;
    }

    @Override
    public List<CommentsResponseDto> modelsToDTO(List<Comments> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentsResponseDto> list = new ArrayList<CommentsResponseDto>( comments.size() );
        for ( Comments comments1 : comments ) {
            list.add( toDTO( comments1 ) );
        }

        return list;
    }

    @Override
    public Comments toEntity(CommentsResponseDto commentsResponseDto) {
        if ( commentsResponseDto == null ) {
            return null;
        }

        Comments comments = new Comments();

        comments.setText( commentsResponseDto.getText() );
        comments.setDate( commentsResponseDto.getDate() );

        return comments;
    }
}
