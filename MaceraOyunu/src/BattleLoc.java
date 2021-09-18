import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private String awardName;
    private Armor armor;
    private Weapon weapon;
    private int mapMoneyAward;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle,
                     String awardName, Armor armor, Weapon weapon, int mapMoneyAward) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.awardName = awardName;
        this.armor = armor;
        this.weapon = weapon;
        this.mapMoneyAward = mapMoneyAward;
    }

    @Override
    public boolean onLocation() {
        //int obsNumber = this.randomObstacleNumber();
        int obsNumber = 1;
        if (awardChecker()) {
            return true;
        }
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkali Ol! Burada " + obsNumber + " adet " + this.getObstacle().getName() + " yaşıyor !");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine().toUpperCase();
        if(selectCase.equals("S") && combat(obsNumber)){
            System.out.println(this.getName() + " tüm düşmanları yendiniz !");
            giveAward();
            return true;
        }

        if (this.getPlayer().getHealth() <= 0 ) {
            System.out.println("Öldünüz ! ");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
        for(int i=0; i < obsNumber; i++){
            Random number = new Random();
            int randomNumber = number.nextInt(2) + 1;
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i+1);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.println("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();

                if (randomNumber == 1) {
                    if(selectCombat.equals("V")){
                        System.out.println("Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage < 0 ) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                } else {
                    if(selectCombat.equals("V")){
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage < 0 ) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                        System.out.println("Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                    } else {
                        return false;
                    }
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz !");
                if ((this.getObstacle().getAward() != 0 || this.getArmor() != null || this.getWeapon() != null) &&
                        (!this.getAwardName().equals("Water") && !this.getAwardName().equals("Firewood") && !this.getAwardName().equals("Food")) ) {
                    while(true) {
                        System.out.println(this.getAwardName() + " kazandınız.");
                        if (this.getMapMoneyAward() != 0) {
                            this.getPlayer().setMoney(this.getMapMoneyAward());
                            break;
                        }
                        System.out.print("Bu eşyayı kullanmak istiyor musunuz (E/H) :");
                        String answer = input.nextLine().toUpperCase();
                        if (answer.equals("E") && this.getArmor() != null) {
                            this.getPlayer().getInventory().setArmor(this.getArmor());
                            System.out.println(this.getArmor().getName() + " eşyası kullanılıyor.");
                            break;
                        } else if (answer.equals("E") && this.getWeapon() != null) {
                            this.getPlayer().getInventory().setWeapon(this.getWeapon());
                            System.out.println(this.getWeapon().getName() + " eşyasını kullanılıyor.");
                            break;
                        } else if (answer.equals("H")) {
                            System.out.println("Eşyayı bıraktınız !");
                            break;
                        } else {
                            System.out.println("Lütfen geçerli bir komut giriniz.");
                        }
                    }


                } else if (this.getObstacle().getAward() == 0 && this.getArmor() == null && this.getWeapon() == null) {
                    System.out.println("Maalesef hiçbir eşya kazanamadınız !");
                }
                else {
                    System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward() + this.getMapMoneyAward());
                    System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
                }

            } else {
                return false;
            }
        }
        return true;
    }

    private void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }

    private void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + "Değerleri : ");
        System.out.println("--------------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Para : " + this.getObstacle().getAward());

    }

    private void playerStats() {
        System.out.println("Oyuncu Değerleri: ");
        System.out.println("--------------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println("");

    }

    public void giveAward(){
        if(this.getAwardName().equals("Food")){
            this.getPlayer().getInventory().setFood(true);
            System.out.println("Food kazandınız");
        } else if(this.getAwardName().equals("Firewood")){
            this.getPlayer().getInventory().setFirewood(true);
            System.out.println("Firewood kazandınız");
        } else if(this.getAwardName().equals("Water")) {
            this.getPlayer().getInventory().setWater(true);
            System.out.println("Water kazandınız");
        }
    }

    public boolean awardChecker(){
        if(this.getName() == "Mağara" && this.getPlayer().getInventory().isFood()) {
            return true;
        } else if (this.getName() == "Orman" && this.getPlayer().getInventory().isFirewood()) {
            return true;
        } else if (this.getName() == "Nehir" && this.getPlayer().getInventory().isWater()) {
            return true;
        } else {
            return false;
        }
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getMapMoneyAward() {
        return mapMoneyAward;
    }

    public void setMapMoneyAward(int mapMoneyAward) {
        this.mapMoneyAward = mapMoneyAward;
    }
}
