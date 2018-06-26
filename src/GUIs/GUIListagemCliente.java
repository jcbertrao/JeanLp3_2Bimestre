package GUIs;

import Entidades.Cliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import tools.CentroDoMonitorMaior;

public class GUIListagemCliente extends JDialog {

    JPanel painelTa = new JPanel();
    JScrollPane scroll = new JScrollPane();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

    public GUIListagemCliente(List<Cliente> texto) {
        setTitle("Listagem de Cliente");
        setSize(600, 300);//tamanho da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memÃ³ria a classe
        setLayout(new BorderLayout());//informa qual gerenciador de layout serÃ¡ usado
        setBackground(Color.CYAN);//cor do fundo da janela
        setModal(true);
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes
        JToolBar toolBar = new JToolBar();

        String[] colunas = new String[]{"Cpf", "Login", "Senha", "Nome", "Rua", "NumeroCasa", "Cep",};
        String[][] dados = new String[0][3];
        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        JTable tabela = new JTable(model);
        scroll.setViewportView(tabela);
        for (int i = 0; i < texto.size(); i++) {
            String[] linha = new String[]{String.valueOf(texto.get(i).getCpf()), String.valueOf(texto.get(i).getLogin()), String.valueOf(texto.get(i).getSenha()), String.valueOf(texto.get(i).getNome()), String.valueOf(texto.get(i).getRua()), String.valueOf(texto.get(i).getNumeroCasa()), String.valueOf(texto.get(i).getCep()),};
            model.addRow(linha);

        }
        painelTa.add(scroll);
        cp.add(toolBar, BorderLayout.NORTH);
        cp.add(scroll, BorderLayout.CENTER);
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
        setVisible(true);
    }
}
