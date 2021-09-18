public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        if(this.awardChecker()){
            return true;
        }
        System.out.println("Güvenli evdesiniz !");
        System.out.println("Canınız yenilendi !");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }

    public boolean awardChecker() {
        if (this.getPlayer().getInventory().isFood() &&
                this.getPlayer().getInventory().isWater() &&
                this.getPlayer().getInventory().isFirewood()) {
            return true;
        } else {
            return false;
        }
    }
}
