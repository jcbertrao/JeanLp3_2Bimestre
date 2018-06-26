package DAOs;


import Entidades.Modelo;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOModelo extends DAOGenerico<Modelo> {

    public DAOModelo() {
        super(Modelo.class);
    }

    public int autoIdModelo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idModelo) FROM Modelo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Modelo> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Modelo e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Modelo> listById(int id) {
        return em.createQuery("SELECT e FROM Modelo e WHERE e.idModelo = :id").setParameter("id", id).getResultList();
    }

    public List<Modelo> listInOrderNome() {
        return em.createQuery("SELECT e FROM Modelo e ORDER BY e.nome").getResultList();
    }

    public List<Modelo> listInOrderId() {
        return em.createQuery("SELECT e FROM Modelo e ORDER BY e.idModelo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Modelo> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdModelo() + "-" + lf.get(i).getNome());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOModelo daoModelo = new DAOModelo();
        List<Modelo> listaModelo = daoModelo.list();
        for (Modelo modelo : listaModelo) {
            System.out.println(modelo.getIdModelo() + "-" + modelo.getNome());
        }
    }}
