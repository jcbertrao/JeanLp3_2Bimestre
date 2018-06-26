package DAOs;


import Entidades.Marca;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOMarca extends DAOGenerico<Marca> {

    public DAOMarca() {
        super(Marca.class);
    }

    public int autoIdMarca() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.codMarca) FROM Marca e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Marca> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Marca e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Marca> listById(int id) {
        return em.createQuery("SELECT e FROM Marca e WHERE e.codMarca = :id").setParameter("id", id).getResultList();
    }

    public List<Marca> listInOrderNome() {
        return em.createQuery("SELECT e FROM Marca e ORDER BY e.nome").getResultList();
    }

    public List<Marca> listInOrderId() {
        return em.createQuery("SELECT e FROM Marca e ORDER BY e.codMarca").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Marca> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getCodMarca() + "-" + lf.get(i).getNome());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOMarca daoMarca = new DAOMarca();
        List<Marca> listaMarca = daoMarca.list();
        for (Marca marca : listaMarca) {
            System.out.println(marca.getCodMarca() + "-" + marca.getNome());
        }
    }}
