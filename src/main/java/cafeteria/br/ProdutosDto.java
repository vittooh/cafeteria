package cafeteria.br;

import java.math.BigDecimal;

public class ProdutosDto {

    public String nome;

    public Long qt;

    public BigDecimal valor;

    public ProdutosDto() {
    }

    public ProdutosDto(String nome, Long qt, BigDecimal valor) {
        this.nome = nome;
        this.qt = qt;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQt() {
        return qt;
    }

    public void setQt(Long qt) {
        this.qt = qt;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
