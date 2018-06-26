/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author a1712020
 */
@Entity
@Table(name = "cor")
@NamedQueries({
    @NamedQuery(name = "Cor.findAll", query = "SELECT c FROM Cor c")})
public class Cor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_cor")
    private Integer codCor;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCor")
    private List<Produto> produtoList;

    public Cor() {
    }

    public Cor(Integer codCor) {
        this.codCor = codCor;
    }

    public Cor(Integer codCor, String nome) {
        this.codCor = codCor;
        this.nome = nome;
    }

    public Integer getCodCor() {
        return codCor;
    }

    public void setCodCor(Integer codCor) {
        this.codCor = codCor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCor != null ? codCor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cor)) {
            return false;
        }
        Cor other = (Cor) object;
        if ((this.codCor == null && other.codCor != null) || (this.codCor != null && !this.codCor.equals(other.codCor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codCor + "-"+nome;
    }
    
}
