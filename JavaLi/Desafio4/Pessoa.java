package Desafio4;

abstract class Pessoa 
{
    protected Boolean flag = false;
    protected int moedas = 10;
    abstract Boolean decisao();
    protected abstract Pessoa clone();
    
    public int getMoedas() {
        return moedas;
    }
    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }
    public int addMoedas(int moedas){
        return this.moedas += moedas;
    }
    
    public Boolean setFlag(Boolean flag){
        return this.flag = flag;
    }
    public Boolean getFlag(){
        return flag;
    }
}
