
package missingpersonproject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TrackingDashboard extends JFrame {

    private JTextField idField, nameField, ageField, cityField, markField, reporterField;
    private JTextArea outputArea;

    private SystemManager manager;

    public TrackingDashboard() {

        manager = new SystemManager();

        setTitle("Missing Person Tracking System");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(20,20));
        mainPanel.setBackground(new Color(8,18,45));
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        // Title
        JLabel title = new JLabel(
                "MISSING PERSON TRACKING SYSTEM",
                SwingConstants.CENTER
        );

        title.setForeground(new Color(120,190,255));
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));

        mainPanel.add(title, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(6,2,10,10));
        formPanel.setBackground(new Color(15,35,75));
        formPanel.setBorder(new EmptyBorder(20,20,20,20));

        idField = createField();
        nameField = createField();
        ageField = createField();
        cityField = createField();
        markField = createField();
        reporterField = createField();

        addField(formPanel,"ID",idField);
        addField(formPanel,"Name",nameField);
        addField(formPanel,"Age",ageField);
        addField(formPanel,"City",cityField);
        addField(formPanel,"Mark",markField);
        addField(formPanel,"Reporter",reporterField);

        // Output Panel
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(12,28,60));
        outputArea.setForeground(Color.WHITE);
        outputArea.setFont(new Font("Consolas", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel centerPanel = new JPanel(new GridLayout(1,2,20,20));
        centerPanel.setBackground(new Color(8,18,45));

        centerPanel.add(formPanel);
        centerPanel.add(scrollPane);

        // Buttons
        JButton addButton = createButton("ADD REPORT");
        JButton networkButton = createButton("SHOW NETWORK");
        JButton clearButton = createButton("CLEAR");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(8,18,45));

        buttonPanel.add(addButton);
        buttonPanel.add(networkButton);
        buttonPanel.add(clearButton);

        // Add Report Button
        addButton.addActionListener(e -> {

            try {

                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();
                String city = cityField.getText().trim();
                String mark = markField.getText().trim();
                String reporter = reporterField.getText().trim();

                if(id.isEmpty() || name.isEmpty() || ageText.isEmpty()
                        || city.isEmpty() || mark.isEmpty() || reporter.isEmpty()){

                    JOptionPane.showMessageDialog(
                            null,
                            "Please fill all fields"
                    );

                    return;
                }

                int age = Integer.parseInt(ageText);

                Person person = new Person(
                        id,
                        name,
                        age,
                        city,
                        mark
                );

                Report report = new Report(
                        person,
                        reporter
                );

                manager.getDatabase().addReport(report);

                outputArea.append(
                        "\nReport Added Successfully\n"
                );

                MatchResult result =
                        manager.getSearchService().findMatch(
                                person,
                                manager.getDatabase()
                        );

                if(result != null){

                    outputArea.append(
                            "MATCH FOUND!\n"
                    );

                    outputArea.append(
                            "Found In: "
                            + result.getFoundPerson().getCity()
                            + "\n"
                    );

                    String route =
        manager.getCityGraph().findRoute(
                person.getCity(),
                result.getFoundPerson().getCity()
        );

outputArea.append(
        "Tracking Route: "
        + route
        + "\n"
);

                } else {

                    outputArea.append(
                            "No Match Found\n"
                    );
                }

                outputArea.append(
                        "-------------------------\n"
                );

            }
            catch(NumberFormatException ex){

                JOptionPane.showMessageDialog(
                        null,
                        "Age must be a number"
                );
            }
        });

        // Network Button
        networkButton.addActionListener(e -> {

            outputArea.append(
                    "\nCITY NETWORK:\n"
            );

            outputArea.append(
                    "Lahore -> Islamabad -> Peshawar\n"
            );

            outputArea.append(
                    "Lahore -> Karachi\n"
            );

            outputArea.append(
                    "-------------------------\n"
            );
        });

        // Clear Button
        clearButton.addActionListener(
                e -> outputArea.setText("")
        );

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private JTextField createField(){

        JTextField field = new JTextField();

        field.setBackground(
                new Color(25,55,110)
        );

        field.setForeground(
                Color.WHITE
        );

        field.setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        return field;
    }

    private void addField(
            JPanel panel,
            String text,
            JTextField field
    ){

        JLabel label = new JLabel(text);

        label.setForeground(
                new Color(180,220,255)
        );

        label.setFont(
                new Font("Segoe UI", Font.BOLD, 16)
        );

        panel.add(label);

        panel.add(field);
    }

    private JButton createButton(String text){

        JButton button = new JButton(text);

        button.setBackground(
                new Color(0,102,204)
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFont(
                new Font("Segoe UI", Font.BOLD, 16)
        );

        return button;
    }
}