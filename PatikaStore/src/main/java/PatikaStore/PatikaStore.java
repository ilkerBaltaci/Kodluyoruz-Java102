package PatikaStore;

import PatikaStore.Models.Brand;
import PatikaStore.Models.Product.IProduct;
import PatikaStore.Models.Product.MobilePhone;
import PatikaStore.Models.Product.Notebook;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;

public class PatikaStore {
    private static List<IProduct> products;
    private static List<Brand> brands;
    static {
        products = new ArrayList<>();
        brands = new ArrayList<>();
        PatikaStore patikaStore = new PatikaStore();
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Samsung"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Lenovo"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Apple"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Huawei"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Casper"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Asus"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("HP"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Xiaomi"));
        patikaStore.AddingBrandToListIncrementId(brands, new Brand("Monster"));

        patikaStore.AddingProductToListIncrementId(products, new Notebook("HUAWEI Matebook 14", BigDecimal.valueOf(7000.0), 0, brands.stream().filter(e -> e.getName().contains("Huawei")).toList().get(0), "14.0", "512", "16"));
        patikaStore.AddingProductToListIncrementId(products, new Notebook("LENOVO V14 IGL", BigDecimal.valueOf(3699.0), 0, brands.stream().filter(e -> e.getName().contains("Lenovo")).toList().get(0), "14.0", "1024", "8"));
        patikaStore.AddingProductToListIncrementId(products, new Notebook("ASUS Tuf Gaming", BigDecimal.valueOf(8199.0), 0, brands.stream().filter(e -> e.getName().contains("Asus")).toList().get(0), "15.6", "2048", "32"));


        patikaStore.AddingProductToListIncrementId(products, new MobilePhone("SAMSUNG GALAXY A51", BigDecimal.valueOf(3199.0), 0, brands.stream().filter(e -> e.getName().contains("Samsung")).toList().get(0), "6.5", "32", "128", "4000.0", "6", "Siyah"));
        patikaStore.AddingProductToListIncrementId(products, new MobilePhone("iPhone 11 64 GB", BigDecimal.valueOf(7379.0), 0, brands.stream().filter(e -> e.getName().contains("Apple")).toList().get(0), "6.1", "5", "64", "3046.0", "6", "Mavi"));
        patikaStore.AddingProductToListIncrementId(products, new MobilePhone("Redmi Note 10 Pro 8GB", BigDecimal.valueOf(4012.0), 0, brands.stream().filter(e -> e.getName().contains("Xiaomi")).toList().get(0), "6.5", "35", "128", "4000.0", "12", "Beyaz"));
    }

    public static void main(String[] args) {
        PatikaStore patikaStore = new PatikaStore();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            boolean exit = false;
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    patikaStore.showNotebookList(products);
                    break;
                case 2:
                    patikaStore.showMobilePhoneList(products);
                    break;
                case 3:
                    patikaStore.showBrands();
                    break;
                case 0:
                    System.out.println("Yine bekleriz :)");
                    exit = true;
                    break;
                default:
                    System.out.println("Yanlış tercih yaptınız.");
                    break;
            }

            if(exit) break;

        }

    }
    private int AddingProductToListIncrementId(List<IProduct> productList, IProduct product)
    {
        int listLength = productList.size();
        int id = 1;
        int index = 0;
        if(listLength == 0){
            product.setId(1);
            productList.add(product);
            return id;
        }

        id = 0;
        for(IProduct brand2 : productList){
            if(brand2.getId() - id == 1)
            {
                id++;
                continue;
            } else {
                product.setId(id + 1);
                productList.add(product);
                return product.getId();
            }
        }
        product.setId(productList.size()+1);
        productList.add(product);
        return product.getId();
    }
    private int AddingBrandToListIncrementId(List<Brand> brandList, Brand brand)
    {
        int listLength = brandList.size();
        int id = 1;
        int index = 0;
        if(listLength == 0){
            brand.setId(1);
            brandList.add(brand);
            return id;
        }

        id = 0;
        for(Brand brand2 : brandList){
            if(brand2.getId() - id == 1)
            {
                id++;
                continue;
            } else {
                brand.setId(id + 1);
                brandList.add(brand);
                return brand.getId();
            }
        }
        brand.setId(brandList.size()+1);
        brandList.add(brand);
        return brand.getId();
    }

    public void showNotebookList(List<IProduct> products)
    {
        List<Notebook> notebooks = products.stream().filter(product -> product instanceof Notebook).map(e -> (Notebook) e).toList();

        System.out.println();
        System.out.println("Notebook Listesi");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("| ID | " + "Ürün Adı" + "\t\t" + " | Fiyat " + "\t" + "| Marka " + "\t" + " | Depolama " + "\t" + "| Ekran " + "\t" + "| RAM " + "\t\t|");
        System.out.println("---------------------------------------------------------------------------------------");
        for(Notebook notebook : notebooks)
        {
            BigDecimal discountedPrice = BigDecimal.valueOf(notebook.getUnitPrice().doubleValue() * (100 - notebook.getDiscountRate()) / 100);
            System.out.println("| " + notebook.getId() + " | " + notebook.getName() + " \t\t | " +  discountedPrice + " TL" + " | " + notebook.getBrand().getName() + " \t| " + notebook.getMemory() + " \t | " + notebook.getScreenSizeInch() + " \t | " + notebook.getRam() + " \t | ");
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
    public void showBrands(){
        System.out.println("Markalarımız");
        System.out.println("----------------");

        for(Brand brand : brands){
            System.out.println("- " + brand.getName());
        }
    }
    public void showMobilePhoneList(List<IProduct> products)
    {
        List<MobilePhone> mobilePhones = products.stream().filter(product -> product instanceof MobilePhone).map(e -> (MobilePhone) e).toList();
        System.out.println();
        System.out.println("Cep Telefonu Listesi");
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("| ID | " + "Ürün Adı" + "\t\t" + " | Fiyat " + "\t" + "| Marka " + "\t" + " | Depolama " + "\t" + "| Ekran " + "\t" + "| Kamera " + "\t" + "| Pil " + "\t" + "| RAM " + "\t" + "| Renk \t|");
        System.out.println("---------------------------------------------------------------------------------------");
        for(MobilePhone mobilePhone : mobilePhones){
            BigDecimal discountedPrice = BigDecimal.valueOf(mobilePhone.getUnitPrice().doubleValue() * (100 - mobilePhone.getDiscountRate()) / 100);
            System.out.println("| " + mobilePhone.getId() + " | " + mobilePhone.getName() + " \t\t | " +  discountedPrice + " TL" + " | " + mobilePhone.getBrand().getName() + " \t| " + mobilePhone.getMemory() + " \t | " + mobilePhone.getScreenSizeInch() + " \t | " + mobilePhone.getCamera() + " \t | " + mobilePhone.getBattery() + " \t | " + mobilePhone.getRam() + " \t | " + mobilePhone.getColor() + " \t |");
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
