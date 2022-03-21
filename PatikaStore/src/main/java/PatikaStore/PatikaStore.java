package PatikaStore;

import PatikaStore.Models.Brand;
import PatikaStore.Models.Product.IProduct;
import PatikaStore.Models.Product.MobilePhone;
import PatikaStore.Models.Product.Notebook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class PatikaStore {
    private static List<IProduct> products;
    private static List<Brand> brands;
    static {
        products = new ArrayList<>();
        brands = new ArrayList<>();
    }
    public static void main(String[] args) {
        TreeSet<Integer> brandIDs = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        });

        brandIDs.add(3);
        brandIDs.add(1);
        brandIDs.add(7);
        brandIDs.add(9);
        brandIDs.add(31);

        for(Integer Id : brandIDs){
            System.out.println(Id);
        }
    }

    private int AddingBrandToListIncrementId(List<Brand> brandList, Brand brand)
    {
        TreeSet<Integer> brandIDs = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        });
        int listLength = brandList.size();
        int id = 1;
        int index = 0;
        if(listLength == 0){
            brand.setId(1);
            brandList.add(brand);
            return id;
        }

        if(brandList.get(0).getId() != 1)
        {
            brand.setId(1);
            brandList.add(brand);
            return id;
        }
        id = 0;
        for(Brand brand2 : brandList){
            if(brand2.getId() - id != 1)
            {
                brand.setId(id + 1);
                brandList.add(brand);
                return id + 1;
            }
        }
        brand.setId(brandList.size());
        brandList.add(brand);
        return 1;
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
