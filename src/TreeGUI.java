import javax.swing.*;
import java.awt.*;

public class TreeGUI extends JFrame {

    // ====================
    // TREES
    // ====================
    BinarySearchTree bst = new BinarySearchTree();
    AVLTree avl = new AVLTree();
    boolean useAVL = false;

    // ====================
    // UI COMPONENTS
    // ====================
    JTextField valueField = new JTextField(8);
    JTextArea outputArea = new JTextArea();

    JCheckBox inorderCheck = new JCheckBox("Inorder");
    JCheckBox preorderCheck = new JCheckBox("Preorder");
    JCheckBox postorderCheck = new JCheckBox("Postorder");

    public TreeGUI() {
        setTitle("Ağaç Veri Yapıları Projesi (BST / AVL)");
        setSize(800, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ====================
        // LEFT PANEL (COMMANDS)
        // ====================
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createTitledBorder("İşlemler"));

        JPanel valuePanel = new JPanel();
        valuePanel.add(new JLabel("Değer:"));
        valuePanel.add(valueField);

        JButton insertBtn = new JButton("Düğüm Ekle");
        JButton deleteBtn = new JButton("Düğüm Sil (BST)");
        JButton searchBtn = new JButton("Düğüm Bul");
        JButton clearBtn = new JButton("Ağacı Temizle");

        leftPanel.add(valuePanel);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(insertBtn);
        leftPanel.add(deleteBtn);
        leftPanel.add(searchBtn);
        leftPanel.add(clearBtn);

        leftPanel.add(Box.createVerticalStrut(15));

        JRadioButton bstBtn = new JRadioButton("Binary Search Tree", true);
        JRadioButton avlBtn = new JRadioButton("AVL Tree (Bonus)");

        ButtonGroup group = new ButtonGroup();
        group.add(bstBtn);
        group.add(avlBtn);

        leftPanel.add(bstBtn);
        leftPanel.add(avlBtn);

        add(leftPanel, BorderLayout.WEST);

        // ====================
        // RIGHT PANEL (OUTPUT)
        // ====================
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Sonuçlar"));

        // Checkbox panel (tick-tick)
        JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkPanel.add(inorderCheck);
        checkPanel.add(preorderCheck);
        checkPanel.add(postorderCheck);

        JButton showBtn = new JButton("Göster");
        JButton infoBtn = new JButton("Ağaç Bilgileri");

        checkPanel.add(showBtn);
        checkPanel.add(infoBtn);

        rightPanel.add(checkPanel, BorderLayout.NORTH);

        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        rightPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        add(rightPanel, BorderLayout.CENTER);

        // ====================
        // ACTIONS
        // ====================
        bstBtn.addActionListener(e -> {
            useAVL = false;
            outputArea.setText("BST modu seçildi.");
        });

        avlBtn.addActionListener(e -> {
            useAVL = true;
            outputArea.setText("AVL (Bonus) modu seçildi.");
        });

        insertBtn.addActionListener(e -> {
            int val = Integer.parseInt(valueField.getText());
            if (useAVL)
                avl.insert(val);
            else
                bst.insert(val);

            outputArea.setText("Eklendi: " + val);
        });

        deleteBtn.addActionListener(e -> {
            if (useAVL) {
                outputArea.setText("AVL için silme uygulanmadı.");
            } else {
                outputArea.setText("BST silme opsiyonel (derste yoksa eklenmedi).");
            }
        });

        searchBtn.addActionListener(e -> {
            int val = Integer.parseInt(valueField.getText());
            boolean found = useAVL ? avl.search(val) : bst.search(val);
            outputArea.setText(found ? "Bulundu" : "Bulunamadı");
        });

        clearBtn.addActionListener(e -> {
            bst = new BinarySearchTree();
            avl = new AVLTree();
            outputArea.setText("Ağaç temizlendi.");
        });

        showBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            if (inorderCheck.isSelected()) {
                sb.append("Inorder:\n")
                  .append(useAVL ? avl.getInorder() : bst.getInorder())
                  .append("\n\n");
            }

            if (preorderCheck.isSelected()) {
                if (useAVL)
                    sb.append("AVL için Preorder yok.\n\n");
                else
                    sb.append("Preorder:\n").append(bst.getPreorder()).append("\n\n");
            }

            if (postorderCheck.isSelected()) {
                if (useAVL)
                    sb.append("AVL için Postorder yok.\n\n");
                else
                    sb.append("Postorder:\n").append(bst.getPostorder()).append("\n\n");
            }

            outputArea.setText(sb.toString());
        });

        infoBtn.addActionListener(e -> {
            outputArea.setText(
                "Ağaç Türü: " + (useAVL ? "AVL (Bonus)" : "BST") +
                "\nYükseklik: " + (useAVL ? avl.getHeight() : bst.getHeight()) +
                "\nToplam Düğüm: " + (useAVL ? "—" : bst.getNodeCount()) +
                "\nYapraklar: " + (useAVL ? "—" : bst.getLeaves())
            );
        });
    }

    public static void main(String[] args) {

    javax.swing.SwingUtilities.invokeLater(() -> {
        new TreeGUI();
    });
}

    }
}