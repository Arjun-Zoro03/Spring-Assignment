package com.zemoso.springboot.gymmanagementsystem.converter;

import com.zemoso.springboot.gymmanagementsystem.dto.TrainerDTO;
import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TrainerConverter {

    private ModelMapper mapper = new ModelMapper();

    public Trainer dtoToEntity(TrainerDTO trainerDTO){
        return mapper.map(trainerDTO, Trainer.class);
    }

    public TrainerDTO entityToDto(Trainer trainer) {
        return mapper.map(trainer, TrainerDTO.class);
    }
}
