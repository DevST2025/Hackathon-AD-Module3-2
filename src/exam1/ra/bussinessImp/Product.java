package exam1.ra.bussinessImp;

import exam1.ra.bussiness.IShop;
import exam1.ra.util.InputMethods;

import java.util.List;

public class Product implements IShop, Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;
    static int idMaxProduct = 0;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {

    }

    public void inputData(List<Catalog> list) {
        //Product ID
        this.productId = idMaxProduct + 1;
        System.out.println("Mã sản phẩm: " + this.productId);
        idMaxProduct = this.productId;

        //Product Name
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = InputMethods.getString();

        //Title
        System.out.print("Nhập tiêu đề sản phẩm: ");
        this.title = InputMethods.getString();

        //Descriptions
        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = InputMethods.getString();

        //Catalog
        for (Catalog c : list) {
            System.out.printf("Mã danh mục: %d | Tên danh muc: %s\n",c.getCatalogId(), c.getCatalogName());
        }
        boolean isChecked = false;
        while (true) {
            System.out.print("Vui lòng chọn ID danh mục: ");
            int id = InputMethods.getInteger();
            for (Catalog c : list) {
                if (c.getCatalogId() == id) {
                    this.catalog = c;
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) {
                break;
            } else {
                System.err.println("Không tìm thấy mã danh mục, Vui lòng nhập lại mã danh mục: ");
                isChecked = false;
            }
        }

        //Import Price
        System.out.print("Nhập giá nhập sản phẩm: ");
        this.importPrice = InputMethods.getInteger();

        //Export Price
        this.exportPrice = this.importPrice * RATE;

        //Product Status
        boolean isExist = true;
        System.out.println("Chọn trạng thái: ");
        System.out.println("1. Còn hàng");
        System.out.println("2. Hết hàng");
        System.out.print("Trạng thái: ");
        do {
            int choise = InputMethods.getInteger();
            switch (choise) {
                case 1:
                    this.productStatus = true;
                    isExist = false;
                    break;
                case 2:
                    this.productStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);
    }

    @Override
    public void displayData() {
        System.out.println("Mã: "+ productId + " | Tên: " + productName);
        System.out.println("Tiêu đề: " + title + " | Mô tả: " + descriptions);
        System.out.println("Danh mục: " + catalog.getCatalogName());
        System.out.println("Giá nhập hàng: " + importPrice + " | Giá xuất hàng: " + exportPrice);
        System.out.println("Trạng thái: " + (productStatus ? "Còn hàng":"Hết hàng"));
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.exportPrice - o.getExportPrice());
    }
}
