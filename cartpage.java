
import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class cartpage extends JFrame implements ActionListener {
    String cName;
    JPanel topPanel, centerPanel, leftPanel, rightPanel, bottomPanel, cartPanel;
    JLabel customerlabel, customerimagelabel, plusminuslabel, Headlabel2;
    JButton back, cartbutton, plusbutton, checkout;
    ImageIcon customericon;
    JLabel sellerLabel, sellerimagelabel, p_idLabel, categoryLabel, productnameLabel, quantityLabel, HeadLabel,
            pricelabel, ProductsList, totalpriceLabel;
    JTextField p_idfield, categoryField, productnamefield, quantityfield, pricefield;
    JComboBox categoriesComboBox;
    JButton add, delete, clear, filter, plusButton, minusButton, Update, filter2, filter3, filter4;
    JTable stock, table, orderedtable;
    DefaultTableModel dt, dt2;
    String price, category, quantity, name, id;
    JScrollPane scrollpane;
    JScrollPane scrollpane2;
    ImageIcon sellericon;
    TableCellRenderer buttonRenderer;
    final TableRowSorter<DefaultTableModel> sorter;
    int c = 0, totalprice = 0, c_plus;

    public cartpage(String cName) {
        this.cName = cName;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1450, 600);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setTitle("Mart Managment System");

        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        topPanel.setPreferredSize(new DimensionUIResource(0, 30));
        topPanel.setLayout(null);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setPreferredSize(new DimensionUIResource(0, 100));
        centerPanel.setLayout(null);

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setPreferredSize(new DimensionUIResource(250, 0));
        leftPanel.setLayout(null);

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setPreferredSize(new DimensionUIResource(7, 0));
        rightPanel.setLayout(null);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setPreferredSize(new DimensionUIResource(0, 30));
        bottomPanel.setLayout(null);

        customerlabel = new JLabel();
        customerlabel.setText("<html> <p style='text-align:center;'>CUSTOMER<br/>SECTION</p> </html>");
        customerlabel.setFont(new FontUIResource("MV Boli", Font.ITALIC, 30));
        customerlabel.setBounds(40, 15, 300, 100);
        customerlabel.setForeground(Color.WHITE);

        customerimagelabel = new JLabel();
        customericon = new ImageIcon("customerimage.png");
        customerimagelabel.setIcon(customericon);
        customerimagelabel.setBounds(50, 115, 410, 400);

        back = new JButton();
        back.addActionListener(this);
        back.setBounds(0, 5, 35, 35);
        ImageIcon backimg = new ImageIcon("backimage.png");
        Image bgimg = backimg.getImage();
        Image newimg = bgimg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        backimg = new ImageIcon(newimg);
        back.setIcon(backimg);

        cartbutton = new JButton();
        cartbutton.setBounds(10, 507, 44, 45);
        cartbutton.addActionListener(this);
        ImageIcon cartlogo = new ImageIcon("cart2.jpeg");
        cartbutton.setIcon(cartlogo);
        // ////system.out.println(cartlogo.getIconWidth());
        // ////system.out.println(cartlogo.getIconHeight());
        // ImageIcon cartlogo = new ImageIcon("backimage.png");
        Image iconimg = cartlogo.getImage();
        Image newimgs = iconimg.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
        cartlogo = new ImageIcon(newimgs);

        cartbutton.setIcon(cartlogo);

        // ////system.out.println(customericon.getIconWidth());
        // //system.out.println(customericon.getIconHeight());

        Image image = customericon.getImage(); // transform it
        Image newimgg = image.getScaledInstance(114, 380,
                java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        customericon = new ImageIcon(newimgg); // transform it back

        customerimagelabel.setIcon(customericon);

        // =================CODE FOR RESIZING IMAGEICON=================================

        // ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image
        // to a imageIcon
        // Image image = customericon.getImage(); // transform it
        // Image newimg = image.getScaledInstance(250, 400,
        // java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        // customericon = new ImageIcon(newimg); // transform it back

        // customerlabel.setIcon(customericon);

        // customerimagelabel.setBackground(Color.GREEN);
        // customerimagelabel.setOpaque(true);

        HeadLabel = new JLabel();
        HeadLabel.setText("MANAGE ORDERS");
        HeadLabel.setFont(new FontUIResource("MV Noli", Font.ITALIC, 15));
        HeadLabel.setBounds(220, -5, 200, 28);
        // HeadLabel.setForeground(Color.WHITE);
        // HeadLabel.setBackground(Color.BLACK);
        // HeadLabel.setOpaque(true);

        p_idLabel = new JLabel();
        categoryLabel = new JLabel("Category");
        p_idfield = new JTextField("ID");
        p_idfield.setForeground(Color.gray);
        // categoryField = new JTextField("Categoddddry");
        // categoryField.setForeground(Color.gray);
        productnameLabel = new JLabel();
        productnamefield = new JTextField("Name");
        productnamefield.setForeground(Color.gray);
        // quantityLabel = new JLabel();
        // quantityfield = new JTextField("Qty");
        // quantityfield.setForeground(Color.gray);

        p_idLabel.setText("Product ID");
        p_idLabel.setBounds(20, 50, 100, 20);
        // p_idfield.setBackground(Color.yellow);

        p_idfield.setBounds(100, 45, 150, 30);

        productnameLabel.setText("Name");
        productnameLabel.setBounds(20, 100, 100, 20);
        // productnamefield.setBackground(Color.CYAN);
        productnamefield.setBounds(100, 95, 150, 30);

        // quantityLabel.setText("Quantity");
        // quantityLabel.setBounds(380, 50, 100, 20);
        // // quantityfield.setBackground(Color.CYAN);
        // quantityfield.setBounds(450, 45, 150, 30);

        pricelabel = new JLabel();
        pricelabel.setText("Price");
        pricelabel.setBounds(20, 205, 100, 20);

        pricefield = new JTextField("$");
        pricefield.setForeground(Color.gray);
        // pricefield.setBackground(Color.CYAN);
        pricefield.setBounds(100, 200, 150, 30);

        String categories[] = { "Cosmetics", "Dairy", "Kids", "Clothing", "Food", "Toy", "Drink", "Gadgets  " };
        categoriesComboBox = new JComboBox<>(categories);
        categoriesComboBox.setBounds(100, 145, 150, 30);
        categoryLabel.setBounds(20, 150, 100, 20);

        // add = new JButton();
        // add.setText("Add");
        // add.setBackground(Color.black);
        // add.setForeground(Color.WHITE);
        // add.setBounds(70, 200, 80, 40);
        // add.addActionListener(this);

        filter = new JButton();
        filter.setText("Filter");
        filter.setBackground(Color.black);
        filter.setForeground(Color.WHITE);
        filter.setBounds(255, 45, 100, 30);
        filter.addActionListener(this);

        filter2 = new JButton();
        filter2.setText("Filter");
        filter2.setBackground(Color.black);
        filter2.setForeground(Color.WHITE);
        filter2.setBounds(255, 95, 100, 30);
        filter2.addActionListener(this);

        filter3 = new JButton();
        filter3.setText("Filter");
        filter3.setBackground(Color.black);
        filter3.setForeground(Color.WHITE);
        filter3.setBounds(255, 145, 100, 30);
        filter3.addActionListener(this);

        filter4 = new JButton();
        filter4.setText("Filter");
        filter4.setBackground(Color.black);
        filter4.setForeground(Color.WHITE);
        filter4.setBounds(255, 199, 100, 30);
        filter4.addActionListener(this);

        delete = new JButton();
        delete.setText("Delete");
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.setBounds(440, 160, 80, 40);
        delete.addActionListener(this);

        // clear = new JButton();
        // clear.setText("Clear");
        // clear.setBackground(Color.black);
        // clear.setForeground(Color.WHITE);
        // clear.setBounds(440, 160, 80, 40);
        // clear.addActionListener(this);

        ProductsList = new JLabel();
        ProductsList.setFont(new FontUIResource("MV Boli", Font.ITALIC, 15));
        ProductsList.setText("Stock List");
        ProductsList.setBounds(250, 240, 200, 50);

        cartPanel = new JPanel();
        cartPanel.setBounds(640, 0, 640, 520);
        cartPanel.setBackground(Color.WHITE);
        cartPanel.setLayout(null);
        centerPanel.add(cartPanel);

        table = new JTable();
        dt = new DefaultTableModel(0, 0);
        String[] columns = { "ID", "Name", "Category", "Price Rs." };
        dt.setColumnIdentifiers(columns);
        table.setRowHeight(35);
        // table.setBackground(Color.lightGray);
        table.setModel(dt);
        scrollpane = new JScrollPane(table);
        scrollpane.setBounds(0, 290, 512, 222);
        // table.addMouseListener(this);
        // buttonRenderer = new JTableButtonRenderer();
        // table.getColumn("Button1").setCellRenderer(buttonRenderer);
        // table.getColumn("Button2").setCellRenderer(buttonRenderer);
        // table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        // table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));

        // dt.addRow(new Object[] { "0001", "Milk", "Dairy", "22" });
        // dt.addRow(new Object[] { "0002", "Small Shirt", "Kids", "50" });
        // dt.addRow(new Object[] { "0003", "ilk", "Dairy", "22" });
        // dt.addRow(new Object[] { "0004", "Small Shirt", "Kids", "50" });
        // dt.addRow(new Object[] { "0005", "Milk", "Dairy", "22" });
        // dt.addRow(new Object[] { "0006", "Small Shirt", "Kids", "50" });
        // dt.addRow(new Object[] { "0007", "Milk", "Dairy", "22" });
        // dt.addRow(new Object[] { "0008", "Small Shirt", "Kids", "50" });
        // dt.addRow(new Object[] { "0008", "Milk", "Dairy", "22" });
        // dt.addRow(new Object[] { "0010", "Small Shirt", "Kids", "50" });
        // // dt.addRow(new Object[] { "0012", "Small Shirt", "Kids", "50" });
        // dt.addRow(new Object[] { "0013", "Milk", "Dairy", "22" });
        // dt.addRow(new Object[] { "0014", "Small Shirt", "Kids", "50" });

        orderedtable = new JTable();
        dt2 = new DefaultTableModel(0, 0);
        String[] columns2 = { "ID", "Name", "Category", "Quantity", "Price Rs.", "Per Unit Price" };
        dt2.setColumnIdentifiers(columns2);
        orderedtable.setRowHeight(35);
        // table.setBackground(Color.lightGray);
        orderedtable.setModel(dt2);
        scrollpane2 = new JScrollPane(orderedtable);
        // scrollpane2.setBounds(640, 50, 640, 450);
        scrollpane2.setBounds(0, 50, 543, 350);
        orderedtable.setBackground(Color.lightGray);
        sorter = new TableRowSorter<DefaultTableModel>(dt);
        table.setRowSorter(sorter);

        // orderedtable.addMouseListener(this);

        // dt2.addRow(new Object[] { "0001", "Milk", "Dairy", "9", "22" });
        // dt2.addRow(new Object[] { "0002", "Small Shirt", "Kids", "7", "50" });
        // // dt2.addRow(new Object[] { "0001", "Milk", "Dairy", "22" });

        plusButton = new JButton("+");
        plusButton.setBounds(550, 360, 50, 30);
        plusButton.addActionListener(this);

        minusButton = new JButton("-");
        minusButton.setBounds(550, 420, 50, 30);
        minusButton.addActionListener(this);

        plusminuslabel = new JLabel("0");
        plusminuslabel.setBounds(569, 390, 50, 30);

        Headlabel2 = new JLabel();
        Headlabel2.setText("YOUR ORDER");
        Headlabel2.setFont(new FontUIResource("MV Noli", Font.ITALIC, 15));
        Headlabel2.setBounds(220, -5, 200, 50);

        totalpriceLabel = new JLabel("TOTAL PRICE: " + String.valueOf(totalprice));
        totalpriceLabel.setBounds(10, 400, 250, 100);
        totalpriceLabel.setFont(new FontUIResource("MV Boli", Font.ITALIC, 20));

        Update = new JButton();
        Update.setText("Update");
        Update.setBackground(Color.black);
        Update.setForeground(Color.WHITE);
        Update.setBounds(430, 260, 80, 30);
        Update.addActionListener(this);

        checkout = new JButton("Proceed to Checkout");
        checkout.setBounds(300, 430, 200, 40);
        checkout.addActionListener(this);

        Calculate_TotalPrice();

        // Update_Cart_Stock();
        // scrollpane.addMouseListener(this);
        cartPanel.add(checkout);
        cartPanel.add(totalpriceLabel);
        cartPanel.add(Headlabel2);
        cartPanel.setBackground(Color.WHITE);
        centerPanel.add(scrollpane);
        // centerPanel.add(scrollpane2);
        centerPanel.add(Update);
        cartPanel.add(scrollpane2);
        centerPanel.add(plusminuslabel);
        centerPanel.add(minusButton);
        centerPanel.add(plusButton);
        centerPanel.setBackground(new ColorUIResource(64, 64, 64));
        centerPanel.setBackground(Color.CYAN);
        this.add(cartbutton);
        table.setBackground(Color.LIGHT_GRAY);
        centerPanel.add(HeadLabel);
        centerPanel.add(filter);
        centerPanel.add(filter2);
        centerPanel.add(filter3);
        centerPanel.add(filter4);

        // centerPanel.add(add);
        centerPanel.add(ProductsList);
        centerPanel.add(categoriesComboBox);
        centerPanel.add(categoryLabel);

        // centerPanel.add(quantityLabel);
        // centerPanel.add(quantityfield);
        centerPanel.add(productnameLabel);
        centerPanel.add(productnamefield);
        centerPanel.add(p_idLabel);
        centerPanel.add(p_idfield);
        centerPanel.add(pricelabel);
        centerPanel.add(pricefield);
        centerPanel.add(delete);
        // centerPanel.add(clear);
        topPanel.add(back);
        leftPanel.add(customerimagelabel);
        leftPanel.add(customerlabel);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.NORTH);
        minusButton.setVisible(true);
        minusButton.setEnabled(false);
        this.setVisible(true);
    }

    private void newFilter(int x) {
        RowFilter<DefaultTableModel, Object> rf = null;
        // If current expression doesn't parse, don't update.
        if (x == 0) {
            try {
                this.dispose();
                ReadTheStockFile(x, String.valueOf(p_idfield.getText()));
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
        } else if (x == 1) {
            try {
                // rf = RowFilter.regexFilter(productnamefield.getText(), 1);
                this.dispose();
                ReadTheStockFile(x, String.valueOf(productnamefield.getText()));
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
        } else if (x == 2) {
            try {
                // rf =
                // RowFilter.regexFilter(String.valueOf(categoriesComboBox.getSelectedItem()),
                // 2);
                this.dispose();
                ReadTheStockFile(x, String.valueOf(categoriesComboBox.getSelectedItem()));
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
        } else if (x == 3) {
            try {
                // rf = RowFilter.regexFilter(String.valueOf(pricefield.getText()), 3);
                this.dispose();
                ReadTheStockFile(x, String.valueOf(pricefield.getText()));
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
        } else
            //// system.out.println("It was null");

            sorter.setRowFilter(rf);
    }
    // public void ScanCart(int x) {
    // for (int i = 0; i < Product.arrayProducts.size(); i++) {

    // if ((int) (orderedtable.getValueAt(i, 0)) == x) {
    // c = (int) orderedtable.getValueAt(i, 3);

    // }
    // }
    // ////system.out.println("Value of c is: " + c);
    // plusminuslabel.setText(String.valueOf(c));
    // }

    public int product_Quantity() {
        int id = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
        int x = table.getSelectedRow();
        credentials c3 = new credentials(cName);
        int y = c3.ReadTheStockFile("Get", "Quantity", x, id);

        return y;
    }

    public void Check_Existance() {
        int x = 0;
        for (int i = 0; i < orderedtable.getRowCount(); i++) {
            if (orderedtable.getValueAt(i, 0) == table.getValueAt(table.getSelectedRow(), 0)) {
                c = Integer.valueOf(orderedtable.getValueAt(i, 3).toString());
                c += 1;
                plusminuslabel.setText(String.valueOf(c));
                orderedtable.setValueAt(c, i, 3);
                int price = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 3).toString()) * c;
                // int price = Integer.parseInt( tableModel.getValueAt(i, 1).toString() );

                // ////system.out.println(price);
                orderedtable.setValueAt(price, i, 4);
                Calculate_TotalPrice();

            } else {
                x++;

            }

        }
        if (x == orderedtable.getRowCount()) {
            c = 1;
            plusminuslabel.setText(String.valueOf(c));
            dt2.addRow(new Object[] { table.getValueAt(table.getSelectedRow(), 0),
                    table.getValueAt(table.getSelectedRow(), 1),
                    table.getValueAt(table.getSelectedRow(), 2),
                    c, table.getValueAt(table.getSelectedRow(), 3), table.getValueAt(table.getSelectedRow(), 3) });
            Calculate_TotalPrice();
        }
    }

    public void Check_Existance2() {
        int x = 0;
        for (int i = 0; i < orderedtable.getRowCount(); i++) {
            if (orderedtable.getValueAt(i, 0) == table.getValueAt(table.getSelectedRow(), 0)) {
                orderedtable.setValueAt(c, i, 3);
                int price = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 3).toString()) * c;
                // int price = Integer.parseInt( tableModel.getValueAt(i, 1).toString() );

                // ////system.out.println(price);
                orderedtable.setValueAt(price, i, 4);
                Calculate_TotalPrice();

            }

        }

    }

    public void AddTableAfterRead(String a, String b, String c, String e) {
        dt.addRow(new Object[] { a, b, c, e });
    }

    public void Calculate_TotalPrice() {
        totalprice = 0;
        for (int i = 0; i < orderedtable.getRowCount(); i++) {
            totalprice = totalprice + (Integer.valueOf(orderedtable.getValueAt(i, 5).toString())
                    * Integer.valueOf(orderedtable.getValueAt(i, 3).toString()));
            totalpriceLabel.setText("TOTAL PRICE: " + String.valueOf(totalprice));

        }
        if (orderedtable.getRowCount() == 0) {
            totalprice = 0;
            totalpriceLabel.setText("TOTAL PRICE: " + String.valueOf(totalprice));
        }
    }

    public void Calculate_TotalPrice2() {
        for (int i = 0; i < orderedtable.getRowCount(); i++) {
            totalprice = totalprice - Integer.valueOf(table.getValueAt(table.getSelectedRow(), 3).toString());
            totalpriceLabel.setText("TOTAL PRICE: " + String.valueOf(totalprice));

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Myframe();
            this.dispose();

        } else if (e.getSource() == cartbutton) {
            new cartpage(cName);
            this.dispose();
        } else if (e.getSource() == filter) {
            if (p_idfield.getText() != "") {
                newFilter(0);
            }
        } else if (e.getSource() == filter2) {
            newFilter(1);
        } else if (e.getSource() == filter3) {
            newFilter(2);
        } else if (e.getSource() == filter4) {
            newFilter(3);
        }

        else if (e.getSource() == plusButton) {

            // ////system.out.println(table.getSelectedRow());
            c++;
            plusminuslabel.setText(String.valueOf(c));
            if (c > 0) {
                minusButton.setEnabled(true);
            }

            if (c >= product_Quantity()) {
                plusButton.setEnabled(false);
            }
            Check_Existance();
            // product_Quantity();

        } else if (e.getSource() == minusButton) {
            c--;
            plusminuslabel.setText(String.valueOf(c));

            if (c == 0) {
                minusButton.setEnabled(false);
            }
            if (c < product_Quantity()) {
                plusButton.setEnabled(true);
            }
            Check_Existance2();
        } else if (e.getSource() == delete) {
            dt2.removeRow(orderedtable.getSelectedRow());
            Calculate_TotalPrice();
        } else if (e.getSource() == Update) {
            credentials c3 = new credentials(cName);
            c3.ReadTheStockFile(1);
            this.dispose();

        } else if (e.getSource() == checkout) {
            String x;
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            String strDate = dateFormat.format(date);
            x = "<!DOCTYPE html><html lang='en'><head><link rel='stylesheet' href='style.css' ><title>invoice order receipt</title><script src='https://code.jquery.com/jquery-1.10.2.min.js'></script><link href='https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css' rel='stylesheet'><script src='https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script></head><body><div class='container'><div class='row'><!-- BEGIN INVOICE --><div class='col-xs-12'><div class='grid invoice'><div class='grid-body'><div class='invoice-title'><div class='row'><div class='col-xs-12'><p></p></div></div><br><div class='row'><div class='col-xs-12'><h2>invoice<br><span class='small'>order #1082</span></h2></div></div></div><hr><div class='row'><div class='col-xs-6'><address><strong>Billed To:</strong><br>"
                    + cName
                    + "<br></address></div><div class='col-xs-6 text-right'><address><strong>Order Time:</strong><br>"
                    + strDate
                    + "</address></div></div><div class='row'><div class='col-md-12'><h3>ORDER SUMMARY</h3><table class='table table-striped'><thead><tr class='line'><td><strong>#</strong></td><td class='text-left'><strong>Product Name</strong></td><td class='text-center'><strong>QTY</strong></td><td class='text-right'><strong>RATE</strong></td><td class='text-right'><strong>SUBTOTAL</strong></td></tr></thead d><tbody>";
            try (FileWriter myWriter = new FileWriter("hi.html")) {
                myWriter.write(x);
                for (int i = 0; i < orderedtable.getRowCount(); i++) {
                    myWriter.write("<tr><td>");
                    myWriter.write(String.valueOf(i + 1));
                    myWriter.write("</td><td><strong>");
                    myWriter.write(orderedtable.getValueAt(i, 1).toString());
                    myWriter.write("</strong><br></td><td class='text-center'>");
                    myWriter.write(orderedtable.getValueAt(i, 3).toString());
                    myWriter.write("</td><td class='text-right'>");
                    myWriter.write(orderedtable.getValueAt(i, 5).toString());
                    myWriter.write("</td><td class='text-right'>");
                    myWriter.write(orderedtable.getValueAt(i, 4).toString());
                    myWriter.write("</td></tr>");
                }

                myWriter.write(
                        "<tr><td colspan='3'></td><td class='text-right'><strong>Total</strong></td><td class='text-right'><strong>");
                myWriter.write(String.valueOf(totalprice));
                myWriter.write("</strong></td></tr>");
                myWriter.write(
                        "</tbody></table></div></div><div class='row'><div class='col-md-12 text-right identity'><p>Designer identity<br><strong>Osama Sahil and More</strong></p></div></div></div></div></div><!-- END INVOICE --></div></div></body></html>");
                myWriter.close();
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            Desktop desktop = Desktop.getDesktop();

            try {
                desktop.open(new File("hi.html"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            this.dispose();
        }
    }

    public void ReadTheStockFile(int x, String X) {
        String file = "stock.csv";
        String delimiter = ",";
        String line;
        String[] lines;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            cartpage cp = new cartpage(cName);

            while ((line = br.readLine()) != null) {
                lines = line.split(delimiter, 5);
                // sl.AddTableAfterRead();
                if (x != 3) {
                    if (X.equalsIgnoreCase(lines[x]))
                        cp.AddTableAfterRead(lines[0], lines[1], lines[2], lines[4]);
                    // ` + lines[0] + ",---" + lines[1] + ",--" + lines[2] + ",--" + lines[3] +
                    // ",--" + lines[4]);
                } else {
                    if (Integer.parseInt(X) == Integer.parseInt(lines[4])) {
                        cp.AddTableAfterRead(lines[0], lines[1], lines[2], lines[4]);
                    }
                }

            }
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
