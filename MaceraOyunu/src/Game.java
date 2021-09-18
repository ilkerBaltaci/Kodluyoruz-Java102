import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){

        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = "Mustafa"; //input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın "+ player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz. Burada yaşananların hepsi gerçek !");
        System.out.println("Lütfen bir karakter seçiniz !");
        player.selectChar();

        Location location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("----------Bölgeler---------");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yoktur !");
            System.out.println("2 - Eşya Dükkanı --> Silah veya zırh satın alabilirsiniz !");
            System.out.println("3 - Mağara --> Ödül <Yemek>, dikkatli ol karşına zombi çıkabilir !");
            System.out.println("4 - Orman --> Ödül <Odun>, dikkatli ol karşına vampir çıkabilir !");
            System.out.println("5 - Nehir --> Ödül <Su>, dikkatli ol karşına ayı çıkabilir !");
            System.out.println("6 - Maden --> Ödül <Rastgele eşya>, dikkatli ol karşına yılan çıkabilir !");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır !");

            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();
            boolean winChecker = false;
            switch(selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    if(player.getInventory().isWater() &&
                            player.getInventory().isFirewood() &&
                            player.getInventory().isFood()){
                        winChecker = true;
                        location = new SafeHouse(player);
                    } else {
                        location = new SafeHouse(player);
                    }
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if(player.getInventory().isFood()){
                        System.out.println("-- Buradaki tüm düşmanları zaten yok ettiniz. --");
                    } else {
                        location = new Cave(player);
                    }
                    break;
                case 4:
                    if(player.getInventory().isFirewood()){
                        System.out.println("-- Buradaki tüm düşmanları zaten yok ettiniz. --");
                    } else {
                        location = new Forest(player);
                    }
                    break;
                case 5:
                    if(player.getInventory().isWater()){
                        System.out.println("-- Buradaki tüm düşmanları zaten yok ettiniz. --");
                    } else {
                        location = new River(player);
                    }
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir ifade giriniz !");
                    break;
            }
            if(location == null) {
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin !");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("Öldünüz GAME OVER!");
                break;
            }

            if (winChecker == true) {
                System.out.println("Ne kadar yaman bir savaşçı olduğunu gösterdin !");
                System.out.println("Tebrikler !!!");
                break;
            }

        }

    }
}
