package DAOs;


import Entidades.Cor;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOCor extends DAOGenerico<Cor> {

    public DAOCor() {
        super(Cor.class);
    }

    public int autoIdCor() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.codCor) FROM Cor e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cor> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Cor e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Cor> listById(int id) {
        return em.createQuery("SELECT e FROM Cor e WHERE e.codCor = :id").setParameter("id", id).getResultList();
    }

    public List<Cor> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cor e ORDER BY e.nome").getResultList();
    }

    public List<Cor> listInOrderId() {
        return em.createQuery("SELECT e FROM Cor e ORDER BY e.codCor").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cor> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCodCor() + "-" + lf.get(i).getNome());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOCor daoCor = new DAOCor();
        List<Cor> listaCor = daoCor.list();
        for (Cor cor : listaCor) {
            System.out.println(cor.getCodCor() + "-" + cor.getNome());
        }
    }}
