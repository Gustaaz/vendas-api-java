package com.curso.java.vendasapi.service.products;

import com.curso.java.vendasapi.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductFormRequest {
    private Long id;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    public ProductFormRequest(){ super(); }
    public ProductFormRequest(Long id, String descricao, String nome, BigDecimal preco, String sku, LocalDate dataCadastro) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
        this.dataCadastro= dataCadastro;
    }

    public Product toModel(){
        return new Product(id, descricao, nome, preco, sku);
    }
    public static ProductFormRequest fromModel(Product product){
        return new ProductFormRequest(
                product.getId(),
                product.getDescricao(),
                product.getNome(),
                product.getPreco(),
                product.getSku(),
                product.getDataCadastro()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "ProductFormRequest{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", sku='" + sku + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
