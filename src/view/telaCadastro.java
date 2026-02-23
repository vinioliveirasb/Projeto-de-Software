package view;

import model.Produto;
import dao.ProdutoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaCadastro extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JButton btnSalvar;

    public telaCadastro() {

        setTitle("Cadastro de Produtos");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 200, 25);
        add(txtCodigo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 60, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 60, 200, 25);
        add(txtNome);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(20, 100, 100, 25);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(120, 100, 200, 25);
        add(txtDescricao);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(20, 140, 100, 25);
        add(lblPreco);

        txtPreco = new JTextField();
        txtPreco.setBounds(120, 140, 200, 25);
        add(txtPreco);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(20, 180, 100, 25);
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(120, 180, 200, 25);
        add(txtQuantidade);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 230, 120, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Produto produto = new Produto(
                            txtCodigo.getText(),
                            txtNome.getText(),
                            txtDescricao.getText(),
                            Double.parseDouble(txtPreco.getText()),
                            Integer.parseInt(txtQuantidade.getText())
                    );

                    ProdutoDAO dao = new ProdutoDAO();
                    dao.salvarProduto(produto);

                    JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");

                    limparCampos();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Preço ou quantidade inválidos!");
                }
            }
        });

        setVisible(true);
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
    }
}