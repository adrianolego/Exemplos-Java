package model;

import enuns.Cor;

public abstract class AbstractForma implements Forma {

    private Cor cor;

    public AbstractForma(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
