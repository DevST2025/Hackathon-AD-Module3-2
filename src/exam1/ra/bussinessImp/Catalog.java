package exam1.ra.bussinessImp;

import exam1.ra.bussiness.IShop;
import exam1.ra.util.InputMethods;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;
    static int idMaxCatalog = 0;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        //Catalog ID
        this.catalogId = idMaxCatalog + 1;
        System.out.println("Mã danh mục: " + this.catalogId);
        idMaxCatalog = this.catalogId;

        //Catalog Name
        System.out.print("Nhập tên danh mục: ");
        this.catalogName = InputMethods.getString();

        //Priority
        System.out.print("Nhập độ ưu tiên danh mục: ");
        this.priority = InputMethods.getInteger();

        //Descriptions
        System.out.print("Nhập mô tả danh mục: ");
        this.descriptions = InputMethods.getString();

        //Song Status
        boolean isExist = true;
        System.out.println("Chọn trạng thái: ");
        System.out.println("1. Đang hoạt động");
        System.out.println("2. Không hoạt động");
        System.out.print("Trạng thái: ");
        do {
            int choise = InputMethods.getInteger();
            switch (choise) {
                case 1:
                    this.catalogStatus = true;
                    isExist = false;
                    break;
                case 2:
                    this.catalogStatus = false;
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1 trong 2 option trên");
            }
        } while (isExist);
    }

    @Override
    public void displayData() {
        System.out.println("Mã: "+ catalogId + " | Tên: " + catalogName);
        System.out.println("Độ ưu tiên: " + priority + " |Mô tả: " + descriptions);
        System.out.println("Trạng thái: " + (catalogStatus ? "Đang hoạt động":"Không hoạt động"));
    }
}
