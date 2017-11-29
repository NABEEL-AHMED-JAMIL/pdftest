package com.ballistic.pdftest.mapper;

import com.ballistic.pdftest.dto.SimpleSource;
import com.ballistic.pdftest.entity.SimpleDestination;
import org.mapstruct.Mapper;

/**
 * Created by Nabeel on 11/29/2017.
 */
@Mapper
public interface SimpleSourceDestinationMapper {

    SimpleDestination sourceToDestination(SimpleSource source);

    SimpleSource destinationToSource(SimpleDestination destination);


}
