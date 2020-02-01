package akademia.model.dto;

public class CarDto {

    private String brand;
    private String model;
    private String productionYear;
    private String describe;


    private CarDto(Builder b) {
        this.brand = b.brand;
        this.model = b.model;
        this.productionYear = b.productionYear;
        this.describe = b.describe;

    }

    public static class Builder {
        private String brand;
        private String model;
        private String productionYear;
        private String describe;


        public Builder() {
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder productionYear(String productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder describe(String describe) {
            this.describe = describe;
            return this;
        }




        public CarDto build() {
            return new CarDto(this);
        }
    }


}
