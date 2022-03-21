package PatikaStore;

import PatikaStore.Models.Brand;
import PatikaStore.Models.Product.IProduct;
import PatikaStore.Models.Product.MobilePhone;
import PatikaStore.Models.Product.Notebook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PatikaStore {
    private static List<IProduct> products;
    private static List<Brand> brands;
    static {
        products = new ArrayList<>();
        brands = new ArrayList<>();
    }
    public static void main(String[] args) {

    }

    public void showNotebookList(List<Notebook> notebooks)
    {

    }

    public void showMobilePhoneList(List<IProduct> products)
    {
        List<MobilePhone> mobilePhones = products.stream().filter(product -> product.getClass() == MobilePhone.class).map(e -> (MobilePhone) e).toList();
        System.out.println();
        System.out.println("Cep Telefonu Listesi");
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("| ID | " + "Ürün Adı" + "\t\t" + " | Fiyat " + "\t" + "| Marka " + "\t" + " | Depolama " + "\t" + "| Ekran " + "\t" + "| Kamera " + "\t" + "| Pil " + "\t" + "| RAM " + "\t" + "| Renk \t|");
        System.out.println("---------------------------------------------------------------------------------------");
        for(MobilePhone mobilePhone : mobilePhones){
            BigDecimal discountedPrice = BigDecimal.valueOf(mobilePhone.getUnitPrice().doubleValue() * (100 - mobilePhone.getDiscountRate()) / 100);
            System.out.println("| " + mobilePhone.getId() + " | " + mobilePhone.getName() + " \t\t | " +  discountedPrice + " | " + mobilePhone.getBrand().getName() + " \t| " + mobilePhone.getMemory() + " \t | " + mobilePhone.getScreenSizeInch() + " \t | " + mobilePhone.getCamera() + " \t | " + mobilePhone.getBattery() + " \t | " + mobilePhone.getRam() + " \t | " + mobilePhone.getColor() + " \t |");
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
