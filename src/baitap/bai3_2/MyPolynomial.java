package bai3_2;


    public class MyPolynomial {
        private double[] coeffs;

        // Constructor nhận một mảng các hệ số
        public MyPolynomial(double... coeffs) {
            this.coeffs = coeffs;
        }

        // Lấy bậc của đa thức
        public int getDegree() {
            return coeffs.length - 1;
        }

        // Tính giá trị của đa thức tại giá trị x cho trước
        public double evaluate(double x) {
            double result = 0.0;
            for (int i = coeffs.length - 1; i >= 0; i--) {
                result = result * x + coeffs[i];
            }
            return result;
        }

        // Cộng hai đa thức
        public MyPolynomial add(MyPolynomial another) {
            int maxDegree = Math.max(this.getDegree(), another.getDegree());
            double[] resultCoeffs = new double[maxDegree + 1];

            for (int i = 0; i <= this.getDegree(); i++) {
                resultCoeffs[i] += this.coeffs[i];
            }

            for (int i = 0; i <= another.getDegree(); i++) {
                resultCoeffs[i] += another.coeffs[i];
            }

            return new MyPolynomial(resultCoeffs);
        }

        // Nhân hai đa thức
        public MyPolynomial multiply(MyPolynomial another) {
            int newDegree = this.getDegree() + another.getDegree();
            double[] resultCoeffs = new double[newDegree + 1];

            for (int i = 0; i <= this.getDegree(); i++) {
                for (int j = 0; j <= another.getDegree(); j++) {
                    resultCoeffs[i + j] += this.coeffs[i] * another.coeffs[j];
                }
            }

            return new MyPolynomial(resultCoeffs);
        }

        // Chuyển đổi đối tượng thành chuỗi ký tự
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = getDegree(); i >= 0; i--) {
                if (coeffs[i] != 0) {
                    if (sb.length() > 0 && coeffs[i] > 0) {
                        sb.append(" + ");
                    } else if (coeffs[i] < 0) {
                        sb.append(" - ");
                        coeffs[i] = -coeffs[i];
                    }
                    if (i == 0 || coeffs[i] != 1) {
                        sb.append(coeffs[i]);
                    }
                    if (i > 0) {
                        sb.append("x");
                        if (i > 1) {
                            sb.append("^").append(i);
                        }
                    }
                }
            }
            return sb.toString();
        }

        // Phương thức main để kiểm thử lớp MyPolynomial
        public static void main(String[] args) {
            MyPolynomial p1 = new MyPolynomial(1.0, -3.0, 2.0); // 2.0x^2 - 3.0x + 1.0
            MyPolynomial p2 = new MyPolynomial(0.0, 2.0, 1.0);  // 1.0x^2 + 2.0x

            System.out.println("Đa thức p1: " + p1);
            System.out.println("Đa thức p2: " + p2);

            MyPolynomial p3 = p1.add(p2);
            System.out.println("p1 + p2 = " + p3);

            MyPolynomial p4 = p1.multiply(p2);
            System.out.println("p1 * p2 = " + p4);

            double x = 2.0;
            System.out.println("Giá trị của p1 tại x = " + x + " là " + p1.evaluate(x));
        }
    }


