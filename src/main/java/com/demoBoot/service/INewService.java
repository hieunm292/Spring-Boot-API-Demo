package com.demoBoot.service;

import com.demoBoot.dto.NewDTO;

public interface INewService {
    NewDTO save(NewDTO newDTO);
//    NewDTO update(NewDTO newDTO);
    void delete(long[] ids);

}
