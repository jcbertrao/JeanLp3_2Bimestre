/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author a1712020
 */
@Entity
@Table(name = "itens_da_venda")
@NamedQueries({
    @NamedQuery(name = "ItensDaVenda.findAll", query = "SELECT i FROM ItensDaVenda i")})
public class ItensDaVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItensDaVendaPK itensDaVendaPK;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @JoinColumn(name = "id_produto", referencedColumnName = "cod_produto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "id_venda", referencedColumnName = "cod_venda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public ItensDaVenda() {
    }

    public ItensDaVenda(ItensDaVendaPK itensDaVendaPK) {
        this.itensDaVendaPK = itensDaVendaPK;
    }

    public ItensDaVenda(ItensDaVendaPK itensDaVendaPK, int quantidade, double valor) {
        this.itensDaVendaPK = itensDaVendaPK;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public ItensDaVenda(int idVenda, int idProduto) {
        this.itensDaVendaPK = new ItensDaVendaPK(idVenda, idProduto);
    }

    public ItensDaVendaPK getItensDaVendaPK() {
        return itensDaVendaPK;
    }

    public void setItensDaVendaPK(ItensDaVendaPK itensDaVendaPK) {
        this.itensDaVendaPK = itensDaVendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itensDaVendaPK != null ? itensDaVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensDaVenda)) {
            return false;
        }
        ItensDaVenda other = (ItensDaVenda) object;
        if ((this.itensDaVendaPK == null && other.itensDaVendaPK != null) || (this.itensDaVendaPK != null && !this.itensDaVendaPK.equals(other.itensDaVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ItensDaVenda[ itensDaVendaPK=" + itensDaVendaPK + " ]";
    }
    
}
