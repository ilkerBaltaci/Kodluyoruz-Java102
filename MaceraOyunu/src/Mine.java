import java.util.Random;

public class Mine extends BattleLoc{
    private Armor armor = null;
    private Weapon weapon = null;

    public Mine(Player player) {
        super(player, "Maden", new Snake(), "", 5, "",
                null, null, 0);
        randomItem();
    }

    public void randomItem () {
        Random r = new Random();
        int genreSelection = r.nextInt(100) + 1;
        int itemSelection = r.nextInt(100) + 1;

        if (genreSelection <= 15) { // Silah kazanma

            if (itemSelection <= 20) { // Tüfek kazanma
                this.setWeapon(new Weapon("Tüfek", 3, 7, 45));
                this.setAward("tüfek");
                this.setAwardName("Tüfek");
            } else if (itemSelection > 20 && itemSelection <= 50) { // Kılıç kazanma
                this.setWeapon(new Weapon("Kılıç", 2, 3, 35));
                this.setAward("kılıç");
                this.setAwardName("Kılıç");
            } else { // Tabanca Kazanma
                this.setWeapon(new Weapon("Tabanca", 1, 2, 15));
                this.setAward("tabanca");
                this.setAwardName("Tabanca");
            }
        } else if (genreSelection > 15 && genreSelection <= 30) { // Zırh kazanma

            if (itemSelection <= 20) { // Ağır zırh kazanma
                this.setArmor(new Armor(3, "Ağır", 5, 40));
                this.setAward("Ağır zırh ");
                this.setAwardName("Ağır zırh ");
            } else if (itemSelection > 20 && itemSelection <= 50) { // Orta zırh kazanma
                this.setArmor(new Armor(2, "Orta", 3, 25));
                this.setAward("Orta zırh ");
                this.setAwardName("Orta zırh ");
            } else { // Hafif zırh kazanma
                this.setArmor(new Armor(1, "Hafif", 1, 15));
                this.setAward("Hafif zırh ");
                this.setAwardName("Hafif zırh ");
            }

        } else if (genreSelection > 30 && genreSelection <= 55) { // Para kazanma

            if (itemSelection <= 20) { // 10 para kazanma
                this.setMapMoneyAward(10);
                this.setAward("10 para ");
                this.setAwardName("10 para ");
            } else if (itemSelection > 20 && itemSelection <= 50) { // 5 para kazanma
                this.setMapMoneyAward(5);
                this.setAward("5 para ");
                this.setAwardName("5 para ");
            } else { // 1 para kazanma
                this.setMapMoneyAward(1);
                this.setAward("1 para ");
                this.setAwardName("1 para ");
            }
        } else { // Hiçbir şey kazanamama
            this.setAward("Hiçbir şey");
            this.setAwardName("Hiçbir şey");
        }

    }
}
