

// CSC 205 Class # 14182
// GUI
// Author : Nadir Babiker - NAD2153321


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankGUI extends JFrame {

    private BankAccount currentAccount;

    // UI Components
    private JComboBox<String> accountTypeCombo;
    private JTextField accountNumberField, amountField, interestRateField, extraField;
    private JTextArea outputArea;
    private JButton createBtn, creditBtn, debitBtn, interestBtn, infoBtn;

    public BankGUI() {
        super("MyBank GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        // === TOP PANEL (account setup) ===
        JPanel topPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        topPanel.add(new JLabel("Account Type:"));
        accountTypeCombo = new JComboBox<>(new String[]{"Savings", "Checking", "Creditcard"});
        topPanel.add(accountTypeCombo);

        topPanel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField("0000-0000-0000-0000");
        topPanel.add(accountNumberField);

        topPanel.add(new JLabel("Interest Rate (e.g. 0.05 for 5%):"));
        interestRateField = new JTextField("0.02");
        topPanel.add(interestRateField);

        topPanel.add(new JLabel("Overdraft/Credit Limit (pennies):"));
        extraField = new JTextField("0");
        topPanel.add(extraField);

        createBtn = new JButton("Create Account");
        topPanel.add(createBtn);

        add(topPanel, BorderLayout.NORTH);

        // === MIDDLE PANEL (actions) ===
        JPanel middlePanel = new JPanel(new FlowLayout());
        amountField = new JTextField(10);
        middlePanel.add(new JLabel("Amount (pennies):"));
        middlePanel.add(amountField);

        creditBtn = new JButton("Credit (+)");
        debitBtn = new JButton("Debit (-)");
        interestBtn = new JButton("Apply Interest");
        infoBtn = new JButton("Show Info");

        middlePanel.add(creditBtn);
        middlePanel.add(debitBtn);
        middlePanel.add(interestBtn);
        middlePanel.add(infoBtn);

        add(middlePanel, BorderLayout.CENTER);

        // === OUTPUT AREA ===
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // === EVENT HANDLERS ===
        createBtn.addActionListener(e -> createAccount());
        creditBtn.addActionListener(e -> creditAccount());
        debitBtn.addActionListener(e -> debitAccount());
        interestBtn.addActionListener(e -> applyInterest());
        infoBtn.addActionListener(e -> showInfo());
    }

    private void createAccount() {
        String type = (String) accountTypeCombo.getSelectedItem();
        String acctNum = accountNumberField.getText();
        double rate = Double.parseDouble(interestRateField.getText());
        int extra = Integer.parseInt(extraField.getText());

        switch (type) {
            case "Savings":
                currentAccount = new SavingsAccount();
                break;
            case "Checking":
                CheckingAccount chk = new CheckingAccount();
                chk.setOverdraftFee(extra);
                currentAccount = chk;
                break;
            case "Creditcard":
                CreditcardAccount cc = new CreditcardAccount();
                cc.setCreditLimit(extra);
                currentAccount = cc;
                break;
        }

        currentAccount.setAccountNumber(acctNum);
        currentAccount.setInterestRate(rate);
        outputArea.setText("✅ Created " + type + " account!\n");
    }

    private void creditAccount() {
        if (currentAccount == null) return;
        int amount = Integer.parseInt(amountField.getText());
        currentAccount.credit(amount);
        outputArea.append("Credited " + amount + " pennies.\n");
    }

    private void debitAccount() {
        if (currentAccount == null) return;
        int amount = Integer.parseInt(amountField.getText());
        boolean success = currentAccount.debit(amount);
        outputArea.append(success ? "Debited " + amount + " pennies.\n" : "❌ Debit failed.\n");
    }

    private void applyInterest() {
        if (currentAccount == null) return;
        currentAccount.applyInterest();
        outputArea.append("Applied interest.\n");
    }

    private void showInfo() {
        if (currentAccount == null) return;
        outputArea.append("\n" + currentAccount.getAccountInfo() + "\n");
    }

    // === MAIN METHOD ===
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankGUI app = new BankGUI();
            app.setVisible(true);
        });
    }
}

