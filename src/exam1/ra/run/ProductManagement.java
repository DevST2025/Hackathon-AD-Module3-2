package exam1.ra.run;

import exam1.ra.bussinessImp.Catalog;
import exam1.ra.bussinessImp.Product;
import exam1.ra.util.InputMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    static List<Catalog> catalogsList = new ArrayList<>();
    static List<Product> productsList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                    "5. Thoát");
            System.out.print("Nhập vào  lựa chọn của bạn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    inputDataCatalog();
                    break;
                case 2:
                    inputDataProduct();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    findByCatalogName();
                    break;
                case 5:
                    System.out.println("******************END******************");
                    scanner.close();
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1 trong 4 option trên");
            }
        } while (true);
    }

    //1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục
    public static void inputDataCatalog() {
        System.out.print("Nhập số danh mục mà bạn muốn điền thông tin: ");
        int catalogSize = InputMethods.getInteger();

        for (int i = 0; i < catalogSize; i++) {
            System.out.printf("Nhập thông tin danh mục thứ %d: \n", i + 1);
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogsList.add(catalog);
            System.out.println("--------------------");
        }
    }

    //2. Nhập số sản phẩm và nhập thông tin các sản phẩm
    public static void inputDataProduct() {
        System.out.print("Nhập số lượng sản phẩm mà bạn muốn điền thông tin: ");
        int productSize = InputMethods.getInteger();

        for (int i = 0; i < productSize; i++) {
            System.out.printf("Nhập thông tin sản phẩm thứ %d: \n", i + 1);
            Product product = new Product();
            product.inputData(catalogsList);
            productsList.add(product);
            System.out.println("--------------------");
        }
    }

    //3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)
    public static void sortProductByPrice() {
        productsList.sort(Product::compareTo);
        System.out.println("Đã sắp xếp sản phẩm theo giá sản phẩm tăng dần");
        for (Product p: productsList) {
            p.displayData();
            System.out.println("------------------");
        }

    }

    //4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm
    public static void findByCatalogName() {
        boolean isChecked = true;
        System.out.print("Nhập tên danh mục sản phẩm mà bạn tìm kiếm sản phẩm tương ứng: ");
        String inputData = InputMethods.getString();

        for (Product p : productsList) {
            if (p.getCatalog().getCatalogName().equalsIgnoreCase(inputData)) {
                isChecked = false;
                p.displayData();
            }
        }
        if (isChecked) {
            System.out.printf("Không tìm thấy sản phẩm nào có tên danh mục là: %s\n", inputData);
        }
    }

}
