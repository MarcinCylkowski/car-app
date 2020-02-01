package akademia.mapper;

import akademia.model.Car;
import akademia.model.dto.CarDto;

public class CarMapper implements Mapper<Car, CarDto>{

    @Override
    public CarDto map(Car from) {
        return new CarDto
                .Builder()
                .brand(from.getBrand())
                .describe(from.getDescribe())
                .model(from.getModel())
                .productionYear(from.getProductionYear())
                .build();
    }
}
