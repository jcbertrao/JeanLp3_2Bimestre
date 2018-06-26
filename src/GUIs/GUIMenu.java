
package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tools.CentroDoMonitorMaior;

/**
 *
 * @author Sandro
 */
public class GUIMenu extends JFrame {

    ImageIcon iconeLogo = new ImageIcon(getClass().getResource("/icones/logo.png"));
    JLabel logo = new JLabel(iconeLogo);

    public GUIMenu() {
        setTitle("Menu Example");
        Container cp = getContentPane();
        cp = getContentPane();
        cp.add(logo);
        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menus
        JMenu fileMenu = new JMenu("GUIs");
        menuBar.add(fileMenu);

        // Cria e adiciona um item simples para o menu
        JMenuItem marca = new JMenuItem("GUIMarca");
        JMenuItem cor = new JMenuItem("GUICor");
        JMenuItem produto = new JMenuItem("GUIProduto");
        JMenuItem cliente = new JMenuItem("GUICliente");
        JMenuItem venda = new JMenuItem("GUIVenda");
        JMenuItem modelo = new JMenuItem("GUIModelo");
        //JMenuItem vendaproduto = new JMenuItem("GUIVendaProduto");

        
        fileMenu.add(produto);
        fileMenu.add(marca);
        fileMenu.add(cor);
        fileMenu.add(modelo);
        fileMenu.add(cliente);
        fileMenu.add(venda);
        //fileMenu.add(vendaproduto);
        setVisible(true);

        produto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIProduto guiProduto = new GUIProduto();
            }
        });

        marca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIMarca guiMarca = new GUIMarca();
            }
        });

        cor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICor guiCor = new GUICor();
            }
        });

        cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICliente guiCliente = new GUICliente();
            }
        });

        venda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIVenda guiVenda = new GUIVenda();
                //GUIVendaProdutoPK guiVendaProdutoPK = new GUIVendaProdutoPK();
            }
        });
        modelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIModelo guiModelo = new GUIModelo();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            }
        });

//        vendaproduto.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                dispose();
//            }
//        });
        
        pack();
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
    }
}
