package com.demoBoot.service.impl;

import com.demoBoot.converter.NewConverter;
import com.demoBoot.dto.NewDTO;
import com.demoBoot.entity.CategoryEntity;
import com.demoBoot.entity.NewEntity;
import com.demoBoot.repository.CategoryRepository;
import com.demoBoot.repository.NewRepository;
import com.demoBoot.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewService implements INewService {
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity=new NewEntity();
        if(newDTO.getId()!=null){
            NewEntity oldNewEntity=newRepository.findOne(newDTO.getId());
            newEntity=newConverter.toEntity(newDTO,oldNewEntity);
        }else{
            newEntity= newConverter.toEntity(newDTO);
        }
        CategoryEntity categoryEntity=categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);//set de luu xuong db, ham set se tra ve entity
        newEntity=newRepository.save(newEntity);//override ngc lai

        return newConverter.toDTO(newEntity);
    }

//    @Override
//    public NewDTO update(NewDTO newDTO) {
//        NewEntity oldNewEntity=newRepository.findOne(newDTO.getId());
//        NewEntity newEntity=newConverter.toEntity(newDTO,oldNewEntity);
//        CategoryEntity categoryEntity=categoryRepository.findOneByCode(newDTO.getCategoryCode());
//        newEntity.setCategory(categoryEntity);//set de luu xuong db, ham set se tra ve entity
//        newEntity=newRepository.save(newEntity);//override ngc lai
//
//        return newConverter.toDTO(newEntity);
//    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            newRepository.delete(item);
        }
    }
}
