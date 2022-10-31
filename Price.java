package CollectionLesson.File.IoFiles;

import java.util.Objects;

    public class Price {
        private int id;
        private double price;

        public Price(int id, double price) {
            this.id = id;
            this.price = price;
        }

        public Price(int id, String s, String s1) {
        }

        @Override
        public String toString() {
            return "Price{" +
                    "id=" + id +
                    ", price=" + price +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Price price1 = (Price) o;
            return id == price1.id && Double.compare(price1.price, price) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, price);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

