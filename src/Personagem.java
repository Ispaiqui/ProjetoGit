public class Personagem {
    private String name;
    private int attack;
    private int life;

    public Personagem(){
        this.name = "NPC";
        this.attack = 10;
        this.life = 100;
    }
    public Personagem(String name, int attack, int life){
        this.name = name;
        this.attack = attack;
        this.life = life;
    }
    public void doDamage(Personagem target){
            target.receiveDamage(this.attack);
            System.out.println(this.name + " atacou o " + target.getName() + ", dando um total de " + this.attack + " dano!");
    }
    public void critDamage(Personagem target){
        int critDamage = (int)(Math.random() * 11);
        if (critDamage > 7) {
            target.receiveDamage(this.attack * 2);
            System.out.println(this.name + " acertou um ataque critico, dando um total de " + (this.attack*2) + " de dano!" );
        }else {
            System.out.println(this.name + " errou o ataque critico!");
        }
    }
    public void receiveDamage(int attack){
        this.life = life - attack;
        if (life < 0){
            this.life = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack() {
        this.attack = attack;
    }

    public int getLife() {
        return life;
    }

    public void setLife() {
        this.life = life;
    }
}
