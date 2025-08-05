public class CharacterGame {
    private int currentHealth;
    private String name;
    private String status;

    public CharacterGame (int initialHealth, String name){
        setCurrentHealth(initialHealth);
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (currentHealth > 0) {
            status = "alive";
        } else {
            status = "dead";
        }
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void takeDamage(int damageAmount) {
        setCurrentHealth(Math.max(currentHealth - damageAmount, 0));
    }

    public void receiveHealing(int healingAmount) {
        setCurrentHealth(Math.min(currentHealth + healingAmount, 100));
    }
}
