package lesson7.articletask.service;

import lesson7.articletask.entity.ApiResponse;
import lesson7.articletask.entity.Lavozim;
import lesson7.articletask.entity.enums.Huquq;
import lesson7.articletask.payload.LavozimDto;
import lesson7.articletask.repository.LavozimRepository;
import lesson7.articletask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LavozimService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LavozimRepository lavozimRepository;

    public ApiResponse addLavozim(LavozimDto lavozimDto) {
        boolean exists = lavozimRepository.existsByName(lavozimDto.getName());
        if (exists)
            return new ApiResponse(false, "Bunday lavozim mavjud");
        Lavozim lavozim = new Lavozim(
                lavozimDto.getName(),
                lavozimDto.getHuquqList(),
                lavozimDto.getDescription()
        );
        lavozimRepository.save(lavozim);

        return new ApiResponse(true, "saqlandi");
    }

    public ApiResponse editLavozim(Long id, LavozimDto lavozimDto) {
        Optional<Lavozim> optionalLavozim = lavozimRepository.findById(id);
        if (!optionalLavozim.isPresent()) {
            return new ApiResponse(false, "Bunday lavozim mavjud emas");
        }
            Lavozim lavozim = optionalLavozim.get();
            lavozim.setName(lavozimDto.getName());
            lavozim.setDescription(lavozimDto.getDescription());
        Huquq[] values = Huquq.values();
        for (Huquq value : values) {
            if (value.name().equals(lavozimDto.getHuquqList().toString()))
                return new ApiResponse(false,"bunday huquq mavjud emas");
        }
        lavozim.setHuquqList(lavozimDto.getHuquqList());
lavozimRepository.save(lavozim);


        return new ApiResponse();
    }
public List<Lavozim> getLavozimList(){
    return lavozimRepository.findAll();
}
public ApiResponse deleteLavozim(Long id){
    Optional<Lavozim> optionalLavozim = lavozimRepository.findById(id);
    if (!optionalLavozim.isPresent())
        return new ApiResponse(false,"bunday lavozim mavjud emas");
    Lavozim lavozim = optionalLavozim.get();
    lavozimRepository.delete(lavozim);
    return new ApiResponse(true,"Lavozim o'chirildi");
}

}
